/*
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.exception.PortalException;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.Date;
import java.util.Properties;

/**
 * @auther Daniel Song
 */
public interface LDAPHelper {

	public Object getAttributeObject(
			Attributes attributes, Properties properties, String key)
		throws NamingException;

	public Object getAttributeObject(
			Attributes attributes, Properties properties, String key,
			Object defaultValue)
            throws NamingException;

	public Object getAttributeObject(Attributes attributes, String id)
                throws NamingException;

	public Object getAttributeObject(
			Attributes attributes, String id, Object defaultValue)
                    throws NamingException;

	public String getAttributeString(
			Attributes attributes, Properties properties, String key)
                        throws NamingException;

	public String getAttributeString(
			Attributes attributes, Properties properties, String key,
			String defaultValue)
                            throws NamingException;

	public String getAttributeString(Attributes attributes, String id)
                                throws NamingException;

	public String getAttributeString(
			Attributes attributes, String id, String defaultValue)
                                    throws NamingException;

	public String[] getAttributeStringArray(
			Attributes attributes, Properties properties, String key)
                                        throws NamingException;

	public String[] getAttributeStringArray(
			Attributes attributes, String id)
                                            throws NamingException;

	public String getFullProviderURL(String baseURL, String baseDN);

	public boolean isValidFilter(String filter);

	public Date parseDate(String date) throws Exception;

	public void validateFilter(String filter) throws PortalException;

	public void validateFilter(String filter, String filterPropertyName)
                                                throws PortalException;
}
