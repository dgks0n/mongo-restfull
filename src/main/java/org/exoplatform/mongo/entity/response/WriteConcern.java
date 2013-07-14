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
public enum WriteConcern {

	NONE(com.mongodb.WriteConcern.NONE), 
	NORMAL(com.mongodb.WriteConcern.NORMAL), 
	SAFE(com.mongodb.WriteConcern.SAFE), 
	FSYNC_SAFE(com.mongodb.WriteConcern.FSYNC_SAFE), 
	REPLICAS_SAFE(com.mongodb.WriteConcern.REPLICAS_SAFE);

	private com.mongodb.WriteConcern mongoWriteConcern;

	private WriteConcern(com.mongodb.WriteConcern mongoWriteConcern) {
		this.mongoWriteConcern = mongoWriteConcern;
	}

	public com.mongodb.WriteConcern getMongoWriteConcern() {
		return mongoWriteConcern;
	}

	public static WriteConcern fromMongoWriteConcern(com.mongodb.WriteConcern mongoWriteConcern) {
		WriteConcern found = null;
		for (WriteConcern writeConcern : values()) {
			if (writeConcern.mongoWriteConcern == mongoWriteConcern) {
				found = writeConcern;
				break;
			}
		}
		return found;
	}
}
