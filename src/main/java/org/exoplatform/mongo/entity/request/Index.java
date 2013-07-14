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
package org.exoplatform.mongo.entity.request;

import java.util.List;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Index {

	private String name;
    private List<String> keys;
    private boolean unique;

	
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
	 * @return the keys
	 */
	public List<String> getKeys() {
		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(List<String> keys) {
		this.keys = keys;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Index [name=").append(name).append(", keys=")
				.append(keys).append(", unique=").append(unique).append("]");
		return builder.toString();
	}
}
