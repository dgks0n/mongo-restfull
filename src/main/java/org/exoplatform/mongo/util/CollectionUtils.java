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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public final class CollectionUtils {

	public final static Map<String, String> multiValuedMapToMap(final MultivaluedMap<String, String> toNormalize) {
        Map<String, String> normalized = null;
        if (toNormalize != null) {
            normalized = new HashMap<String, String>(toNormalize.size());
            String key = null;
            List<String> value = null;
            for (Entry<String, List<String>> entry : toNormalize.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if (!StringUtils.isNullOrEmpty(key)) {
                    normalized.put(key.trim(), listToString(value));
                }
            }
        }
        return normalized;
    }

    public final static void mapToMultiValuedMap(final Map<String, String> toNormalize,
            final MultivaluedMap<String, Object> normalized) {
        if (toNormalize != null && normalized != null) {
            String key = null;
            String value = null;
            for (Entry<String, String> entry : toNormalize.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if (!StringUtils.isNullOrEmpty(key)) {
                    normalized.add(key.trim(), value.trim());
                }
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public final static String listToString(final List list) {
        StringBuilder listToString = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (int iter = 0; iter < list.size(); iter++) {
                Object entry = list.get(iter);
                if (entry != null) {
                    if (!StringUtils.isNullOrEmpty(entry.toString())) {
                        listToString.append(entry.toString());
                        if (iter != list.size() - 1) {
                            listToString.append(",");
                        }
                    }
                }
            }
        }
        return listToString.toString();
    }

    @SuppressWarnings("rawtypes")
    public final static String mapToString(final Map map) {
        StringBuilder mapString = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            Map.Entry entry = null;
            int counter = 0;
            for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
                entry = (Map.Entry) iter.next();
                if (entry != null) {
                    mapString.append(entry.getKey()).append("=").append(entry.getValue());
                    if (counter != map.size() - 1) {
                        mapString.append(",");
                    }
                }
                counter++;
            }
        }
        return mapString.toString();
    }

    public final static Map<String, String> stringifyMapEntries(Map<Object, Object> map) {
        Map<String, String> stringified = new LinkedHashMap<String, String>(map.size());
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                stringified.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return stringified;
    }
}
