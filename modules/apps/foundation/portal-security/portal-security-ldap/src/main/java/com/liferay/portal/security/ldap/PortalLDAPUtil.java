/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import java.util.List;

import javax.naming.Binding;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Edward C. Han
 */
@Component(immediate = true)
public class PortalLDAPUtil {

	public LdapContext getContext(long ldapServerId, long companyId)
		throws Exception {

		return getInstance().getContext(ldapServerId, companyId);
	}

	public LdapContext getContext(
			long companyId, String providerURL, String principal,
			String credentials)
		throws Exception {

		return getInstance().getContext(
			companyId, providerURL, principal, credentials);
	}

	public Binding getGroup(
			long ldapServerId, long companyId, String groupName)
		throws Exception {

		return getInstance().getGroup(ldapServerId, companyId, groupName);
	}

	public Attributes getGroupAttributes(
			long ldapServerId, long companyId, LdapContext ldapContext,
			String fullDistinguishedName)
		throws Exception {

		return getInstance().getGroupAttributes(
			ldapServerId, companyId, ldapContext, fullDistinguishedName);
	}

	public Attributes getGroupAttributes(
			long ldapServerId, long companyId, LdapContext ldapContext,
			String fullDistinguishedName, boolean includeReferenceAttributes)
		throws Exception {

		return getInstance().getGroupAttributes(
			ldapServerId, companyId, ldapContext, fullDistinguishedName,
			includeReferenceAttributes);
	}

	public byte[] getGroups(
			long companyId, LdapContext ldapContext, byte[] cookie,
			int maxResults, String baseDN, String groupFilter,
			List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getGroups(
			companyId, ldapContext, cookie, maxResults, baseDN, groupFilter,
			searchResults);
	}

	public byte[] getGroups(
			long companyId, LdapContext ldapContext, byte[] cookie,
			int maxResults, String baseDN, String groupFilter,
			String[] attributeIds, List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getGroups(
			companyId, ldapContext, cookie, maxResults, baseDN, groupFilter,
			attributeIds, searchResults);
	}

	public byte[] getGroups(
			long ldapServerId, long companyId, LdapContext ldapContext,
			byte[] cookie, int maxResults, List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getGroups(
			ldapServerId, companyId, ldapContext, cookie, maxResults,
			searchResults);
	}

	public byte[] getGroups(
			long ldapServerId, long companyId, LdapContext ldapContext,
			byte[] cookie, int maxResults, String[] attributeIds,
			List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getGroups(
			ldapServerId, companyId, ldapContext, cookie, maxResults,
			attributeIds, searchResults);
	}

	public String getGroupsDN(long ldapServerId, long companyId)
		throws Exception {

		return getInstance().getGroupsDN(ldapServerId, companyId);
	}

	public long getLdapServerId(
			long companyId, String screenName, String emailAddress)
		throws Exception {

		return getInstance().getLdapServerId(
			companyId, screenName, emailAddress);
	}

	public Attribute getMultivaluedAttribute(
			long companyId, LdapContext ldapContext, String baseDN,
			String filter, Attribute attribute)
		throws Exception {

		return getInstance().getMultivaluedAttribute(
			companyId, ldapContext, baseDN, filter, attribute);
	}

	public String getNameInNamespace(
			long ldapServerId, long companyId, Binding binding)
		throws Exception {

		return getInstance().getNameInNamespace(
			ldapServerId, companyId, binding);
	}

	public Binding getUser(
			long ldapServerId, long companyId, String screenName,
			String emailAddress)
		throws Exception {

		return getInstance().getUser(
			ldapServerId, companyId, screenName, emailAddress);
	}

	public Binding getUser(
			long ldapServerId, long companyId, String screenName,
			String emailAddress, boolean checkOriginalEmail)
		throws Exception {

		return getInstance().getUser(
			ldapServerId, companyId, screenName, emailAddress,
			checkOriginalEmail);
	}

	public Attributes getUserAttributes(
			long ldapServerId, long companyId, LdapContext ldapContext,
			String fullDistinguishedName)
		throws Exception {

		return getInstance().getUserAttributes(
			ldapServerId, companyId, ldapContext, fullDistinguishedName);
	}

	public byte[] getUsers(
			long companyId, LdapContext ldapContext, byte[] cookie,
			int maxResults, String baseDN, String userFilter,
			List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getUsers(
			companyId, ldapContext, cookie, maxResults, baseDN, userFilter,
			searchResults);
	}

	public byte[] getUsers(
			long companyId, LdapContext ldapContext, byte[] cookie,
			int maxResults, String baseDN, String userFilter,
			String[] attributeIds, List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getUsers(
			companyId, ldapContext, cookie, maxResults, baseDN, userFilter,
			attributeIds, searchResults);
	}

	public byte[] getUsers(
			long ldapServerId, long companyId, LdapContext ldapContext,
			byte[] cookie, int maxResults, List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getUsers(
			ldapServerId, companyId, ldapContext, cookie, maxResults,
			searchResults);
	}

	public byte[] getUsers(
			long ldapServerId, long companyId, LdapContext ldapContext,
			byte[] cookie, int maxResults, String[] attributeIds,
			List<SearchResult> searchResults)
		throws Exception {

		return getInstance().getUsers(
			ldapServerId, companyId, ldapContext, cookie, maxResults,
			attributeIds, searchResults);
	}

	public String getUsersDN(long ldapServerId, long companyId)
		throws Exception {

		return getInstance().getUsersDN(ldapServerId, companyId);
	}

	public boolean hasUser(
			long ldapServerId, long companyId, String screenName,
			String emailAddress)
		throws Exception {

		return getInstance().hasUser(
			ldapServerId, companyId, screenName, emailAddress);
	}

	public boolean isGroupMember(
			long ldapServerId, long companyId, String groupDN, String userDN)
		throws Exception {

		return getInstance().isGroupMember(
			ldapServerId, companyId, groupDN, userDN);
	}

	public boolean isUserGroupMember(
			long ldapServerId, long companyId, String groupDN, String userDN)
		throws Exception {

		return getInstance().isUserGroupMember(
			ldapServerId, companyId, groupDN, userDN);
	}

	public byte[] searchLDAP(
			long companyId, LdapContext ldapContext, byte[] cookie,
			int maxResults, String baseDN, String filter, String[] attributeIds,
			List<SearchResult> searchResults)
		throws Exception {

		return getInstance().searchLDAP(
			companyId, ldapContext, cookie, maxResults, baseDN, filter,
			attributeIds, searchResults);
	}

	protected PortalLDAP getInstance() {
		return _portalLDAP;
	}

	@Reference
	private PortalLDAP _portalLDAP;

}