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
package org.exoplatform.mongo.entity;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Configuration {

	private String dataStoreName;
    private String dataStoreReplicas;
    private String dataStoreUsername;
    private String dataStorePassword;
    private long startupBreather;
    private int maxDocsPerCollection;

    
	/**
	 * @return the dataStoreName
	 */
	public String getDataStoreName() {
		return dataStoreName;
	}

	/**
	 * @param dataStoreName
	 *            the dataStoreName to set
	 */
	public void setDataStoreName(String dataStoreName) {
		this.dataStoreName = dataStoreName;
	}

	/**
	 * @return the dataStoreReplicas
	 */
	public String getDataStoreReplicas() {
		return dataStoreReplicas;
	}

	/**
	 * @param dataStoreReplicas
	 *            the dataStoreReplicas to set
	 */
	public void setDataStoreReplicas(String dataStoreReplicas) {
		this.dataStoreReplicas = dataStoreReplicas;
	}

	/**
	 * @return the dataStoreUsername
	 */
	public String getDataStoreUsername() {
		return dataStoreUsername;
	}

	/**
	 * @param dataStoreUsername
	 *            the dataStoreUsername to set
	 */
	public void setDataStoreUsername(String dataStoreUsername) {
		this.dataStoreUsername = dataStoreUsername;
	}

	/**
	 * @return the dataStorePassword
	 */
	public String getDataStorePassword() {
		return dataStorePassword;
	}

	/**
	 * @param dataStorePassword
	 *            the dataStorePassword to set
	 */
	public void setDataStorePassword(String dataStorePassword) {
		this.dataStorePassword = dataStorePassword;
	}

	/**
	 * @return the startupBreather
	 */
	public long getStartupBreather() {
		return startupBreather;
	}

	/**
	 * @param startupBreather
	 *            the startupBreather to set
	 */
	public void setStartupBreather(long startupBreather) {
		this.startupBreather = startupBreather;
	}

	/**
	 * @return the maxDocsPerCollection
	 */
	public int getMaxDocsPerCollection() {
		return maxDocsPerCollection;
	}

	/**
	 * @param maxDocsPerCollection
	 *            the maxDocsPerCollection to set
	 */
	public void setMaxDocsPerCollection(int maxDocsPerCollection) {
		this.maxDocsPerCollection = maxDocsPerCollection;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Configuration [dataStoreName=").append(dataStoreName).append(", dataStoreReplicas=")
                .append(dataStoreReplicas).append(", dataStoreUsername=").append(dataStoreUsername)
                .append(", dataStorePassword=").append(dataStorePassword).append(", startupBreather=")
                .append(startupBreather).append(", maxDocsPerCollection=").append(maxDocsPerCollection).append("]");
        return builder.toString();
    }
}
