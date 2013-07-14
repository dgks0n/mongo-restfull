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
package org.exoplatform.mongo.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public class SecurityManager extends DefaultWebSecurityManager {

	private static Logger logger = LoggerFactory.getLogger(SecurityManager.class);
	
	
	@Override
    protected void onSuccessfulLogin(AuthenticationToken token, AuthenticationInfo info, Subject subject) {
        String username = (String) token.getPrincipal();
        String address = null;

        HttpServletRequest request = (HttpServletRequest) ((WebSubject) subject).getServletRequest();
        if (request != null) {
            address = request.getHeader("X-Real-IP");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Service user=" + username + " successfully logged in from " + address);
        }
        super.onSuccessfulLogin(token, info, subject);
    }
}
