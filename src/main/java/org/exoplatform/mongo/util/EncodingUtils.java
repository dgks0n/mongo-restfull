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

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public final class EncodingUtils {

	public static final String UTF_CHARSET_ENCODING = "UTF-8";
	
	public final static String encodeBase64(String toEncode) {
        return encodeBase64(toEncode, false);
    }

    public final static String encodeBase64(String toEncode, boolean urlSafe) {
        String encoded = null;
        try {
            if (!StringUtils.isNullOrEmpty(toEncode)) {
                if (urlSafe) {
                    encoded = Base64.encodeBase64URLSafeString(toEncode.trim().getBytes(UTF_CHARSET_ENCODING));
                } else {
                    encoded = Base64.encodeBase64String(toEncode.trim().getBytes(UTF_CHARSET_ENCODING));
                }
            }
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            // Stupid exception - low likelihood of getting hit by it
            throw new RuntimeException(unsupportedEncodingException);
        }
        return encoded;
    }

    public final static String decodeBase64(final String toDecode) {
        String decoded = null;
        if (!StringUtils.isNullOrEmpty(toDecode)) {
            decoded = new String(Base64.decodeBase64(toDecode));
        }
        return decoded;
    }
}
