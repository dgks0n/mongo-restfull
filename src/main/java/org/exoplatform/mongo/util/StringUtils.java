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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public final class StringUtils {
	
	public static final String GENERIC_URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	public static final String HTTPS_URL_PATTERN = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	
	public static final String DATE_FORMAT_PARTTERN = "EEE, dd MMM yyyy HH:mm:ss Z";
	

	public final static boolean isNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.trim().length() == 0;
    }
	
	public final static boolean validUrl(final String url, final boolean nonHttpOkay) {
        boolean valid = false;
        if (!isNullOrEmpty(url)) {
            String pattern = nonHttpOkay ? GENERIC_URL_PATTERN : HTTPS_URL_PATTERN;
            valid = Pattern.compile(pattern).matcher(url).matches();
        }
        return valid;
    }
	
	public static Date parseRfc2822DateFromString(final String rfcDate) throws ParseException {
        Date date = null;
        if (!StringUtils.isNullOrEmpty(rfcDate)) {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PARTTERN, Locale.US);
            date = formatter.parse(rfcDate);
        }
        return date;
    }

    public static String parseRfc2822DateToString(final Date rfcDate) {
        String date = null;
        if (rfcDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PARTTERN, Locale.US);
            date = formatter.format(rfcDate);
        }
        return date;
    }
}
