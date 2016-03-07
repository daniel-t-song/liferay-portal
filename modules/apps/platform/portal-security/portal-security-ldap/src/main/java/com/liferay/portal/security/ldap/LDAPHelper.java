package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.Properties;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

/**
 * @author Daniel Song
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

	public String[] getAttributeStringArray(Attributes attributes, String id)
		throws NamingException;

	public String getFullProviderURL(String baseURL, String baseDN);

	public boolean isValidFilter(String filter);

	public Date parseDate(String date) throws Exception;

	public void validateFilter(String filter) throws PortalException;

	public void validateFilter(String filter, String filterPropertyName)
		throws PortalException;

}