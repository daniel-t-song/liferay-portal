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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.RepositoryEntry;
import com.liferay.portal.model.RepositoryEntryModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RepositoryEntry service. Represents a row in the &quot;RepositoryEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RepositoryEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RepositoryEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RepositoryEntryImpl
 * @see RepositoryEntry
 * @see RepositoryEntryModel
 * @generated
 */
@ProviderType
public class RepositoryEntryModelImpl extends BaseModelImpl<RepositoryEntry>
	implements RepositoryEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a repository entry model instance should use the {@link RepositoryEntry} interface instead.
	 */
	public static final String TABLE_NAME = "RepositoryEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "uuid_", Types.VARCHAR },
			{ "repositoryEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "repositoryId", Types.BIGINT },
			{ "mappedId", Types.VARCHAR },
			{ "manualCheckInRequired", Types.BOOLEAN },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("repositoryEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("repositoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mappedId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("manualCheckInRequired", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table RepositoryEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,repositoryEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,repositoryId LONG,mappedId VARCHAR(255) null,manualCheckInRequired BOOLEAN,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table RepositoryEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY repositoryEntry.repositoryEntryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY RepositoryEntry.repositoryEntryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.RepositoryEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.RepositoryEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.RepositoryEntry"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long MAPPEDID_COLUMN_BITMASK = 4L;
	public static final long REPOSITORYID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long REPOSITORYENTRYID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.RepositoryEntry"));

	public RepositoryEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _repositoryEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRepositoryEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _repositoryEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RepositoryEntry.class;
	}

	@Override
	public String getModelClassName() {
		return RepositoryEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("repositoryEntryId", getRepositoryEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("mappedId", getMappedId());
		attributes.put("manualCheckInRequired", getManualCheckInRequired());
		attributes.put("lastPublishDate", getLastPublishDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long repositoryEntryId = (Long)attributes.get("repositoryEntryId");

		if (repositoryEntryId != null) {
			setRepositoryEntryId(repositoryEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		String mappedId = (String)attributes.get("mappedId");

		if (mappedId != null) {
			setMappedId(mappedId);
		}

		Boolean manualCheckInRequired = (Boolean)attributes.get(
				"manualCheckInRequired");

		if (manualCheckInRequired != null) {
			setManualCheckInRequired(manualCheckInRequired);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getRepositoryEntryId() {
		return _repositoryEntryId;
	}

	@Override
	public void setRepositoryEntryId(long repositoryEntryId) {
		_repositoryEntryId = repositoryEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getRepositoryId() {
		return _repositoryId;
	}

	@Override
	public void setRepositoryId(long repositoryId) {
		_columnBitmask |= REPOSITORYID_COLUMN_BITMASK;

		if (!_setOriginalRepositoryId) {
			_setOriginalRepositoryId = true;

			_originalRepositoryId = _repositoryId;
		}

		_repositoryId = repositoryId;
	}

	public long getOriginalRepositoryId() {
		return _originalRepositoryId;
	}

	@Override
	public String getMappedId() {
		if (_mappedId == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappedId;
		}
	}

	@Override
	public void setMappedId(String mappedId) {
		_columnBitmask |= MAPPEDID_COLUMN_BITMASK;

		if (_originalMappedId == null) {
			_originalMappedId = _mappedId;
		}

		_mappedId = mappedId;
	}

	public String getOriginalMappedId() {
		return GetterUtil.getString(_originalMappedId);
	}

	@Override
	public boolean getManualCheckInRequired() {
		return _manualCheckInRequired;
	}

	@Override
	public boolean isManualCheckInRequired() {
		return _manualCheckInRequired;
	}

	@Override
	public void setManualCheckInRequired(boolean manualCheckInRequired) {
		_manualCheckInRequired = manualCheckInRequired;
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RepositoryEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			RepositoryEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RepositoryEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RepositoryEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RepositoryEntryImpl repositoryEntryImpl = new RepositoryEntryImpl();

		repositoryEntryImpl.setMvccVersion(getMvccVersion());
		repositoryEntryImpl.setUuid(getUuid());
		repositoryEntryImpl.setRepositoryEntryId(getRepositoryEntryId());
		repositoryEntryImpl.setGroupId(getGroupId());
		repositoryEntryImpl.setCompanyId(getCompanyId());
		repositoryEntryImpl.setUserId(getUserId());
		repositoryEntryImpl.setUserName(getUserName());
		repositoryEntryImpl.setCreateDate(getCreateDate());
		repositoryEntryImpl.setModifiedDate(getModifiedDate());
		repositoryEntryImpl.setRepositoryId(getRepositoryId());
		repositoryEntryImpl.setMappedId(getMappedId());
		repositoryEntryImpl.setManualCheckInRequired(getManualCheckInRequired());
		repositoryEntryImpl.setLastPublishDate(getLastPublishDate());

		repositoryEntryImpl.resetOriginalValues();

		return repositoryEntryImpl;
	}

	@Override
	public int compareTo(RepositoryEntry repositoryEntry) {
		long primaryKey = repositoryEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RepositoryEntry)) {
			return false;
		}

		RepositoryEntry repositoryEntry = (RepositoryEntry)obj;

		long primaryKey = repositoryEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		RepositoryEntryModelImpl repositoryEntryModelImpl = this;

		repositoryEntryModelImpl._originalUuid = repositoryEntryModelImpl._uuid;

		repositoryEntryModelImpl._originalGroupId = repositoryEntryModelImpl._groupId;

		repositoryEntryModelImpl._setOriginalGroupId = false;

		repositoryEntryModelImpl._originalCompanyId = repositoryEntryModelImpl._companyId;

		repositoryEntryModelImpl._setOriginalCompanyId = false;

		repositoryEntryModelImpl._setModifiedDate = false;

		repositoryEntryModelImpl._originalRepositoryId = repositoryEntryModelImpl._repositoryId;

		repositoryEntryModelImpl._setOriginalRepositoryId = false;

		repositoryEntryModelImpl._originalMappedId = repositoryEntryModelImpl._mappedId;

		repositoryEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RepositoryEntry> toCacheModel() {
		RepositoryEntryCacheModel repositoryEntryCacheModel = new RepositoryEntryCacheModel();

		repositoryEntryCacheModel.mvccVersion = getMvccVersion();

		repositoryEntryCacheModel.uuid = getUuid();

		String uuid = repositoryEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			repositoryEntryCacheModel.uuid = null;
		}

		repositoryEntryCacheModel.repositoryEntryId = getRepositoryEntryId();

		repositoryEntryCacheModel.groupId = getGroupId();

		repositoryEntryCacheModel.companyId = getCompanyId();

		repositoryEntryCacheModel.userId = getUserId();

		repositoryEntryCacheModel.userName = getUserName();

		String userName = repositoryEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			repositoryEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			repositoryEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			repositoryEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			repositoryEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			repositoryEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		repositoryEntryCacheModel.repositoryId = getRepositoryId();

		repositoryEntryCacheModel.mappedId = getMappedId();

		String mappedId = repositoryEntryCacheModel.mappedId;

		if ((mappedId != null) && (mappedId.length() == 0)) {
			repositoryEntryCacheModel.mappedId = null;
		}

		repositoryEntryCacheModel.manualCheckInRequired = getManualCheckInRequired();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			repositoryEntryCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			repositoryEntryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return repositoryEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", repositoryEntryId=");
		sb.append(getRepositoryEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", mappedId=");
		sb.append(getMappedId());
		sb.append(", manualCheckInRequired=");
		sb.append(getManualCheckInRequired());
		sb.append(", lastPublishDate=");
		sb.append(getLastPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.RepositoryEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryEntryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappedId</column-name><column-value><![CDATA[");
		sb.append(getMappedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manualCheckInRequired</column-name><column-value><![CDATA[");
		sb.append(getManualCheckInRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RepositoryEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RepositoryEntry.class
		};
	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _repositoryEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _repositoryId;
	private long _originalRepositoryId;
	private boolean _setOriginalRepositoryId;
	private String _mappedId;
	private String _originalMappedId;
	private boolean _manualCheckInRequired;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private RepositoryEntry _escapedModel;
}