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
package org.exoplatform.mongo.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public final class PropertyUtils {
	
	public static final String STRING_FORMAT = "  %s:%s:%s\n    SHA:%s\n    %s@%s\n    %s\n";
	public static final String STRING_NA = "<NA>";
	
	public static final String MAVEN_GROUPID_PROP = "maven.groupId";
	public static final String MAVEN_ARTIFACTID_PROP = "maven.artifactId";
	public static final String MAVEN_VERSION_PROP = "maven.version";
	public static final String MAVEN_BUILTBY_PROP = "builtBy";
	public static final String MAVEN_BUILTON_PROP = "builtOn";
	public static final String MAVEN_BUILTAT_PROP = "builtAt";
	
	public static final String MONGODB_RESOURCE_PROP = "mongo-rest-scm.properties";
	
	public static final String GIT_REVERSION = "gitRevision";
	

	public final static String readArtifactProperties() {
        StringBuilder builder = new StringBuilder("mongo-rest artifact properties:\n");
        try {
            Enumeration<URL> urls = PropertyUtils.class.getClassLoader().getResources(MONGODB_RESOURCE_PROP);
            while (urls.hasMoreElements()) {
                Properties props = new Properties();
                props.load(urls.nextElement().openStream());
                builder.append(String.format(STRING_FORMAT, props.getProperty(MAVEN_GROUPID_PROP, STRING_NA), 
                		props.getProperty(MAVEN_ARTIFACTID_PROP, STRING_NA), props.getProperty(MAVEN_VERSION_PROP, STRING_NA), 
                		props.getProperty(GIT_REVERSION, STRING_NA), props.getProperty(MAVEN_BUILTBY_PROP, STRING_NA), 
                		props.getProperty(MAVEN_BUILTON_PROP, STRING_NA), props.getProperty(MAVEN_BUILTAT_PROP, STRING_NA)));
            }
        } catch (IOException ioe) {
        	ioe.printStackTrace();
        }
        
        return builder.toString();
    }
}
