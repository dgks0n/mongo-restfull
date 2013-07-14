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
package org.exoplatform.mongo.service;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.exoplatform.mongo.context.AppContext;
import org.exoplatform.mongo.factory.ResourceClientFactory;
import org.exoplatform.mongo.util.EncodingUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-local.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class MongoRestServiceTest {

	private static final String baseUri = "http://localhost:9002/api/mongo";
    private static final String baseDbUri = baseUri + "/databases";
    
	private Server server;
    private Client clientHandle;
    
    
    @BeforeClass
    public static void useTestOverrides() {
        System.setProperty("db.name", "test");
        System.setProperty("db.user", "");
        System.setProperty("db.password", "");
        System.setProperty("datastore.replicas", "");
        System.setProperty("domain", "localhost:9002");
    }

    @Before
    public void setUp() throws Exception {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar(getWebappDirectory().getAbsolutePath());

        server = new Server(9002);
        server.setHandler(context);
        server.setStopAtShutdown(true);
        server.start();
        
        WebApplicationContextUtils.getWebApplicationContext(context.getServletContext());

        String testUsername = "junit";
        String testPassword = EncodingUtils.encodeBase64("r3$tfuLM0ng0");
        Mongo mongo = (Mongo) AppContext.getApplicationContext().getBean("mongo");
        DB db = mongo.getDB("credentials");
        DBCollection collection = db.getCollection("data_service");
        DBObject credentials = new BasicDBObject();
        credentials.put("user", testUsername);
        credentials.put("password", testPassword);
        collection.insert(credentials);

        clientHandle = ResourceClientFactory.getClientHandle(testUsername, testPassword, 0, 0);
    }

    // Adjust this if needed
    private File getWebappDirectory() {
        File file = new File("./src/main/webapp/");
        if (!file.exists()) {
            file = new File("~/mongo-restfull/src/main/webapp");
        }
        
        return file;
    }
    
    @After
    public void tearDown() throws Exception {
        try {
            if (server != null) {
                server.stop();
                server.destroy();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        Mongo mongo = (Mongo) AppContext.getApplicationContext().getBean("mongo");
        for (String dbName : mongo.getDatabaseNames()) {
            mongo.dropDatabase(dbName);
        }
    }

    @Test
    public void testCreateDatabase() {
    	org.exoplatform.mongo.entity.request.Database db = new org.exoplatform.mongo.entity.request.Database();
        db.setName("mongo-restfull");
        ClientResponse response = clientHandle.resource(baseDbUri).type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, db);
        System.out.println("-------------------------------------------------------");
        System.out.println("C R E A T E D " + Status.CREATED.getStatusCode() + "/" + response.getStatus());
        System.out.println("-------------------------------------------------------");
        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
    }
}
