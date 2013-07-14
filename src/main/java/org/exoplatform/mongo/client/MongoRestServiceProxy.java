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
package org.exoplatform.mongo.client;

import java.util.List;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public interface MongoRestServiceProxy {

	public String createDatabase(org.exoplatform.mongo.entity.request.Database database);

    public org.exoplatform.mongo.entity.response.Database findDatabase(String dbName);

    public org.exoplatform.mongo.entity.response.Database updateDatabase(org.exoplatform.mongo.entity.request.Database database);

    public boolean deleteDatabase(String dbName);

    public List<org.exoplatform.mongo.entity.response.Database> findDatabases();

    public boolean deleteDatabases();

    public String createCollection(String dbName, org.exoplatform.mongo.entity.request.Collection collection);

    public org.exoplatform.mongo.entity.response.Collection findCollection(String dbName, String collName);

    public org.exoplatform.mongo.entity.response.Collection updateCollection(String dbName,
    		org.exoplatform.mongo.entity.request.Collection collection);

    public boolean deleteCollection(String dbName, String collName);

    public List<org.exoplatform.mongo.entity.response.Collection> findCollections(String dbName);

    public boolean deleteCollections(String dbName);

    public String createIndex(String dbName, String collName, org.exoplatform.mongo.entity.request.Index index);

    public org.exoplatform.mongo.entity.response.Index findIndex(String dbName, String collName, String indexName);

    public boolean deleteIndex(String dbName, String collName, String indexName);

    public List<org.exoplatform.mongo.entity.response.Index> findIndexes(String dbName, String collName);

    public boolean deleteIndexes(String dbName, String collName);

    public String createDocument(String dbName, String collName, org.exoplatform.mongo.entity.request.Document document);

    public org.exoplatform.mongo.entity.response.Document findDocument(String dbName, String collName, String documentName);

    public org.exoplatform.mongo.entity.response.Document updateDocument(String dbName, String collName,
    		org.exoplatform.mongo.entity.request.Document document);

    public boolean deleteDocument(String dbName, String collName, String documentName);

    public List<org.exoplatform.mongo.entity.response.Document> findDocuments(String dbName, String collName);

    public boolean deleteDocuments(String dbName, String collName);

    public boolean ping();

    public boolean shutdown();

    public void setServiceUser(String serviceUser);

    public void setServicePassword(String servicePassword);

    public void setServiceUri(String serviceUri);
}
