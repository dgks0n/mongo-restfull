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
package org.exoplatform.mongo.error;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public enum Successful implements BaseStatus {
	
	SERVICE_ALIVE("Service is alive and well", 200), 
	OK("Service successfully completed the operation.", 200);

	private final String message;
    private final int httpStatusCode;

    private Successful(final String message, final int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public String message() {
        return message;
    }

    public int code() {
        return httpStatusCode;
    }
}
