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
import java.util.Map;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version
 * 
 * @tag
 */
public class Database {

	private String name;
	private WriteConcern writeConcern;
	private List<Collection> collections;
	private Map<String, String> stats;
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
	 * @return the collections
	 */
	public List<Collection> getCollections() {
		return collections;
	}

	/**
	 * @param collections
	 *            the collections to set
	 */
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	/**
	 * @return the stats
	 */
	public Map<String, String> getStats() {
		return stats;
	}

	/**
	 * @param stats
	 *            the stats to set
	 */
	public void setStats(Map<String, String> stats) {
		this.stats = stats;
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
		builder.append("Database [name=").append(name)
				.append(", writeConcern=").append(writeConcern)
				.append(", collections=").append(collections)
				.append(", stats=").append(stats).append(", locationUri=")
				.append(locationUri).append("]");
		return builder.toString();
	}
}
