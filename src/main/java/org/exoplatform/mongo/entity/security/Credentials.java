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
package org.exoplatform.mongo.entity.security;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class Credentials {

	private final String domain;
    private final String applicationId;
    private final String userName;
    private final String userPassword;
    private final String userIP;
    private final String userAgent;
    private final String requestedURL;
    

	public Credentials(String domain, String applicationId, String userName,
			String userPassword, String userIP, String userAgent,
			String requestedURL) {
		this.domain = domain;
		this.applicationId = applicationId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIP = userIP;
		this.userAgent = userAgent;
		this.requestedURL = requestedURL;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @return the userIP
	 */
	public String getUserIP() {
		return userIP;
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @return the requestedURL
	 */
	public String getRequestedURL() {
		return requestedURL;
	}

	@Override
	public String toString() {
		return "Credentials: domain=" + domain + ", applicationId="
				+ applicationId + ", userName=" + userName + ", userIP="
				+ userIP + ", userAgent=" + userAgent + " requestedURL="
				+ requestedURL;
	}
}
