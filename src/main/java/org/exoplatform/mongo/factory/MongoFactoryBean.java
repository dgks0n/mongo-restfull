/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.mongo.factory;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.exoplatform.mongo.entity.Configuration;
import org.exoplatform.mongo.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class MongoFactoryBean extends AbstractFactoryBean<Mongo> {

	private Logger logger = LoggerFactory.getLogger(MongoFactoryBean.class);
    private List<ServerAddress> replicaSetSeeds = new ArrayList<ServerAddress>();
    private MongoOptions mongoOptions;
    private Configuration configuration;
    
	
    @Override
    public Class<?> getObjectType() {
        return Mongo.class;
    }

    protected DB createDB() throws Exception {
        DB db = createInstance().getDB(configuration.getDataStoreName());
        if (!StringUtils.isNullOrEmpty(configuration.getDataStoreUsername())
                && !StringUtils.isNullOrEmpty(configuration.getDataStorePassword())) {
            db.authenticate(configuration.getDataStoreUsername(), configuration.getDataStorePassword().toCharArray());
        }
        return db;
    }

    protected Mongo createInstance() throws Exception {
        Mongo mongo = null;
        if (mongoOptions == null) {
            mongoOptions = new MongoOptions();
            mongoOptions.safe = true;
            // mongoOptions.fsync = true;
            // mongoOptions.slaveOk = true;
        }
        setMultiAddress(configuration.getDataStoreReplicas().split(","));
        logger.debug("Created Mongo with MongoOptions: [" + mongoOptions.toString() + "], ReplicaSets: " + replicaSetSeeds);
        
        try {
            if (replicaSetSeeds.size() > 0) {
                if (mongoOptions != null) {
                    mongo = new Mongo(replicaSetSeeds, mongoOptions);
                } else {
                    mongo = new Mongo(replicaSetSeeds);
                }
            } else {
                mongo = new Mongo();
            }
        } catch (MongoException mongoException) {
            logger.error("Problem creating Mongo instance", mongoException);
            throw mongoException;
        }
        return mongo;
    }

    public void setMultiAddress(String[] serverAddresses) {
        replSeeds(serverAddresses);
    }

    private void replSeeds(String... serverAddresses) {
        try {
            replicaSetSeeds.clear();
            for (String addr : serverAddresses) {
                String[] a = addr.split(":");
                String host = a[0].trim();
                if (a.length > 2) {
                    throw new IllegalArgumentException("Invalid Server Address : " + addr);
                }
                if (a.length == 2) {
                    attemptMongoConnection(host, Integer.parseInt(a[1].trim()));
                } else {
                    attemptMongoConnection(host, Integer.MIN_VALUE);
                }
            }
        } catch (Exception e) {
            throw new BeanCreationException("Error while creating replicaSetAddresses", e);
        }
    }

    private void attemptMongoConnection(String host, int port) throws Exception {
        try {
            if (port == Integer.MIN_VALUE) {
                replicaSetSeeds.add(new ServerAddress(host));
            } else {
                replicaSetSeeds.add(new ServerAddress(host, port));
            }
        } catch (UnknownHostException unknownHost) {
            throw unknownHost;
        }
    }

    public void setAddress(String serverAddress) {
        replSeeds(serverAddress);
    }

    @Required
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
