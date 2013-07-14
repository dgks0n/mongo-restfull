/*
 * Copyright (C) 2003-2013 org exoplatform SAS.
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

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.GenericType;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class MongoRestServiceProxyImpl implements MongoRestServiceProxy {

	private Logger logger = LoggerFactory.getLogger(MongoRestServiceProxyImpl.class);

    // Note: inject-able using Spring
    private String serviceUri = "http://localhost:9002/api/mongo";
    private String serviceUser = "admin";
    private String servicePassword = "r3$tfuLM0ng0";

    @Override
    public String createDatabase(org.exoplatform.mongo.entity.request.Database database) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, database);
        String location = null;
        if (response.getStatus() == Status.CREATED.getStatusCode()) {
            location = response.getLocation().toString();
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return location;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Database findDatabase(String dbName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName;
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        org.exoplatform.mongo.entity.response.Database database = null;
        if (response.getStatus() == Status.OK.getStatusCode()) {
            database = response.getEntity(org.exoplatform.mongo.entity.response.Database.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return database;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Database updateDatabase(org.exoplatform.mongo.entity.request.Database database) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + database.getName();
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class, database);
        org.exoplatform.mongo.entity.response.Database updatedDatabase = null;
        if (response.getStatus() == Status.OK.getStatusCode() || response.getStatus() == Status.CREATED.getStatusCode()) {
            updatedDatabase = response.getEntity(org.exoplatform.mongo.entity.response.Database.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return updatedDatabase;
    }

    @Override
    public boolean deleteDatabase(String dbName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName;
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public List<org.exoplatform.mongo.entity.response.Database> findDatabases() {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases";
        return clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<org.exoplatform.mongo.entity.response.Database>>() {
                });
    }

    @Override
    public boolean deleteDatabases() {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases";
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public String createCollection(String dbName, org.exoplatform.mongo.entity.request.Collection collection) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, collection);
        String location = null;
        if (response.getStatus() == Status.CREATED.getStatusCode()) {
            location = response.getLocation().toString();
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return location;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Collection findCollection(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName;
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        org.exoplatform.mongo.entity.response.Collection collection = null;
        if (response.getStatus() == Status.OK.getStatusCode()) {
            collection = response.getEntity(org.exoplatform.mongo.entity.response.Collection.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return collection;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Collection updateCollection(String dbName,
            org.exoplatform.mongo.entity.request.Collection collection) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collection.getName();
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class, collection);
        org.exoplatform.mongo.entity.response.Collection updatedCollection = null;
        if (response.getStatus() == Status.OK.getStatusCode() || response.getStatus() == Status.CREATED.getStatusCode()) {
            updatedCollection = response.getEntity(org.exoplatform.mongo.entity.response.Collection.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return updatedCollection;
    }

    @Override
    public boolean deleteCollection(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName;
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public List<org.exoplatform.mongo.entity.response.Collection> findCollections(String dbName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections";
        return clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<org.exoplatform.mongo.entity.response.Collection>>() {
                });
    }

    @Override
    public boolean deleteCollections(String dbName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections";
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public String createIndex(String dbName, String collName, org.exoplatform.mongo.entity.request.Index index) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/indexes";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, index);
        String location = null;
        if (response.getStatus() == Status.CREATED.getStatusCode()) {
            location = response.getLocation().toString();
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return location;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Index findIndex(String dbName, String collName, String indexName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/indexes/" + indexName;
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        org.exoplatform.mongo.entity.response.Index index = null;
        if (response.getStatus() == Status.OK.getStatusCode()) {
            index = response.getEntity(org.exoplatform.mongo.entity.response.Index.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return index;
    }

    @Override
    public boolean deleteIndex(String dbName, String collName, String indexName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/indexes/" + indexName;
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public List<org.exoplatform.mongo.entity.response.Index> findIndexes(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/indexes";
        return clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<org.exoplatform.mongo.entity.response.Index>>() {
                });
    }

    @Override
    public boolean deleteIndexes(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/indexes";
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public String createDocument(String dbName, String collName, org.exoplatform.mongo.entity.request.Document document) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, document);
        String location = null;
        if (response.getStatus() == Status.CREATED.getStatusCode()) {
            location = response.getLocation().toString();
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return location;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Document findDocument(String dbName, String collName, String docId) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents/" + docId;
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        org.exoplatform.mongo.entity.response.Document document = null;
        if (response.getStatus() == Status.OK.getStatusCode()) {
            document = response.getEntity(org.exoplatform.mongo.entity.response.Document.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return document;
    }

    @Override
    public org.exoplatform.mongo.entity.response.Document updateDocument(String dbName, String collName,
            org.exoplatform.mongo.entity.request.Document document) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);

        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents/"
                + document.getDocId();
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class, document);
        org.exoplatform.mongo.entity.response.Document updatedDocument = null;
        if (response.getStatus() == Status.OK.getStatusCode() || response.getStatus() == Status.CREATED.getStatusCode()) {
            updatedDocument = response.getEntity(org.exoplatform.mongo.entity.response.Document.class);
        } else {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return updatedDocument;
    }

    @Override
    public boolean deleteDocument(String dbName, String collName, String docId) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents/" + docId;
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public List<org.exoplatform.mongo.entity.response.Document> findDocuments(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents";
        return clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<org.exoplatform.mongo.entity.response.Document>>() {
                });
    }

    @Override
    public boolean deleteDocuments(String dbName, String collName) {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/databases/" + dbName + "/collections/" + collName + "/documents";
        ClientResponse response = clientHandle.resource(uri).delete(ClientResponse.class);
        boolean deleted = response.getStatus() == Status.OK.getStatusCode();
        if (!deleted) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return deleted;
    }

    @Override
    public boolean ping() {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/ping";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        boolean alive = response.getStatus() == Status.OK.getStatusCode();
        if (!alive) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return alive;
    }

    @Override
    public boolean shutdown() {
        Client clientHandle = MongoServiceConnection.getClientHandle(serviceUser, servicePassword, 0, 0);
        String uri = serviceUri + "/shutdown";
        ClientResponse response = clientHandle.resource(uri).type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        boolean shutdown = response.getStatus() == Status.OK.getStatusCode();
        if (!shutdown) {
            logger.error("uri=" + uri + ", status=" + response.getStatus());
        }
        return shutdown;
    }

    @Override
    public void setServiceUser(String serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Override
    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword;
    }

    @Override
    public void setServiceUri(String serviceUri) {
        this.serviceUri = serviceUri;
    }
}
