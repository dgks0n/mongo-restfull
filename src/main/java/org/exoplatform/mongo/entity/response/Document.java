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

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Document {

	private String json;
    private String locationUri;

	
    /**
	 * @return the json
	 */
	public String getJson() {
		return json;
	}

	/**
	 * @param json
	 *            the json to set
	 */
	public void setJson(String json) {
		this.json = json;
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
        builder.append("Document [json=").append(json).append(", locationUri=").append(locationUri).append("]");
        return builder.toString();
    }
}
