/*
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General public static License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General public static License for more
 * details.
 */

package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.Date;
import java.util.Properties;

/**
 * @author Daniel Song
 */

@Component(immediate = true)
public class LDAPHelperUtil {

    public static Object getAttributeObject(
            Attributes attributes, Properties properties, String key)
            throws NamingException {

        return getInstance().getAttributeObject(attributes, properties, key);
    }

    public static Object getAttributeObject(
            Attributes attributes, Properties properties, String key,
            Object defaultValue)
            throws NamingException {

        return getInstance().getAttributeObject(attributes, properties, key);
    }

    public static Object getAttributeObject(Attributes attributes, String id)
            throws NamingException {

        return getInstance().getAttributeObject(attributes, id);
    }

    public static Object getAttributeObject(
            Attributes attributes, String id, Object defaultValue)
            throws NamingException {

        return getInstance().getAttributeObject(attributes, id, defaultValue);
    }

    public static String getAttributeString(
            Attributes attributes, Properties properties, String key)
            throws NamingException {

        return getInstance().getAttributeString(attributes, properties, key);
    }

    public static String getAttributeString(
            Attributes attributes, Properties properties, String key,
            String defaultValue)
            throws NamingException {

        return getInstance().getAttributeString(attributes, properties, key
        , defaultValue);
    }

    public static String getAttributeString(Attributes attributes, String id)
            throws NamingException {

        return getInstance().getAttributeString(attributes, id);
    }

    public static String getAttributeString(
            Attributes attributes, String id, String defaultValue)
            throws NamingException {

        return getInstance().getAttributeString(attributes, id, defaultValue);
    }

    public static String[] getAttributeStringArray(
            Attributes attributes, Properties properties, String key)
            throws NamingException {

        return getInstance().getAttributeStringArray(attributes, properties, key);
    }

    public static String[] getAttributeStringArray(
            Attributes attributes, String id)
            throws NamingException {

        return getInstance().getAttributeStringArray(attributes, id);
    }

    public static String getFullProviderURL(String baseURL, String baseDN) {

        return getInstance().getFullProviderURL(baseURL, baseDN);
    }

    public static boolean isValidFilter(String filter) {

        return getInstance().isValidFilter(filter);
    }

    public static Date parseDate(String date) throws Exception {

        return getInstance().parseDate(date);
    }

    public static void validateFilter(String filter) throws PortalException {

        getInstance().validateFilter(filter);
    }

    public static void validateFilter(String filter, String filterPropertyName)
            throws PortalException {

        getInstance().validateFilter(filter, filterPropertyName);
    }

    protected static LDAPHelper getInstance() { return _ldapHelper; }

    @Reference
    private static LDAPHelper _ldapHelper;

}
