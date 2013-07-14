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
package org.exoplatform.mongo.service.impl;

import org.exoplatform.mongo.service.CryptDe;
import org.exoplatform.mongo.util.EncodingUtils;
import org.exoplatform.mongo.util.StringUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class MongoBase64CryptDe implements CryptDe {

	private Mongo mongo;
	
	/* (non-Javadoc)
	 * @see org.exoplatform.mongo.service.CryptDe#validate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validate(String user, String password) {
		boolean isValid = false;
        if (!StringUtils.isNullOrEmpty(user) && !StringUtils.isNullOrEmpty(password)) {
            DB db = mongo.getDB("credentials");
            DBCollection collection = db.getCollection("data_service");
            DBObject credentials = new BasicDBObject();
            credentials.put("user", user.toLowerCase());
            credentials.put("password", EncodingUtils.encodeBase64(password));
            
            if (collection.findOne(credentials) != null) {
                isValid = true;
            }
        }
        return isValid;
	}

	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}
}
