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
package org.exoplatform.mongo.entity.response;

import java.util.List;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Collection {

	private String name;
    private String dbName;
    private List<Document> documents;
    private List<Index> indexes;
    private WriteConcern writeConcern;
    private String locationUri;

	
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * @param documents
	 *            the documents to set
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	/**
	 * @return the indexes
	 */
	public List<Index> getIndexes() {
		return indexes;
	}

	/**
	 * @param indexes
	 *            the indexes to set
	 */
	public void setIndexes(List<Index> indexes) {
		this.indexes = indexes;
	}

	/**
	 * @return the writeConcern
	 */
	public WriteConcern getWriteConcern() {
		return writeConcern;
	}

	/**
	 * @param writeConcern
	 *            the writeConcern to set
	 */
	public void setWriteConcern(WriteConcern writeConcern) {
		this.writeConcern = writeConcern;
	}

	/**
	 * @return the locationUri
	 */
	public String getLocationUri() {
		return locationUri;
	}

	/**
	 * @param locationUri
	 *            the locationUri to set
	 */
	public void setLocationUri(String locationUri) {
		this.locationUri = locationUri;
	}
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        builder.append("Collection [name=").append(name).append(", dbName=").append(dbName).append(", documents=")
                .append(documents).append(", indexes=").append(indexes).append(", writeConcern=").append(writeConcern)
                .append(", locationUri=").append(locationUri).append("]");
        return builder.toString();
    }
}
