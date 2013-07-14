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

import java.util.Set;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Index {

	private String name;
    private String collectionName;
    private String dbName;
    private boolean unique;
    private Set<String> keys;
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
	 * @return the collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * @param collectionName
	 *            the collectionName to set
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
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
	 * @return the unique
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * @param unique
	 *            the unique to set
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	/**
	 * @return the keys
	 */
	public Set<String> getKeys() {
		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(Set<String> keys) {
		this.keys = keys;
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
        builder.append("Index [name=").append(name).append(", collectionName=").append(collectionName)
                .append(", dbName=").append(dbName).append(", unique=").append(unique).append(", keys=").append(keys)
                .append(", locationUri=").append(locationUri).append("]");
        return builder.toString();
	}
}
