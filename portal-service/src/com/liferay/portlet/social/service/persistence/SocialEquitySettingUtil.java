/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.social.model.SocialEquitySetting;

import java.util.List;

/**
 * <a href="SocialEquitySettingUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialEquitySettingPersistence
 * @see       SocialEquitySettingPersistenceImpl
 * @generated
 */
public class SocialEquitySettingUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(SocialEquitySetting)
	 */
	public static void clearCache(SocialEquitySetting socialEquitySetting) {
		getPersistence().clearCache(socialEquitySetting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialEquitySetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialEquitySetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialEquitySetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static SocialEquitySetting remove(
		SocialEquitySetting socialEquitySetting) throws SystemException {
		return getPersistence().remove(socialEquitySetting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SocialEquitySetting update(
		SocialEquitySetting socialEquitySetting, boolean merge)
		throws SystemException {
		return getPersistence().update(socialEquitySetting, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SocialEquitySetting update(
		SocialEquitySetting socialEquitySetting, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(socialEquitySetting, merge, serviceContext);
	}

	public static void cacheResult(
		com.liferay.portlet.social.model.SocialEquitySetting socialEquitySetting) {
		getPersistence().cacheResult(socialEquitySetting);
	}

	public static void cacheResult(
		java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> socialEquitySettings) {
		getPersistence().cacheResult(socialEquitySettings);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting create(
		long equitySettingId) {
		return getPersistence().create(equitySettingId);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting remove(
		long equitySettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence().remove(equitySettingId);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting updateImpl(
		com.liferay.portlet.social.model.SocialEquitySetting socialEquitySetting,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(socialEquitySetting, merge);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting findByPrimaryKey(
		long equitySettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence().findByPrimaryKey(equitySettingId);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting fetchByPrimaryKey(
		long equitySettingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(equitySettingId);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findByG_C_A(
		long groupId, long classNameId, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_A(groupId, classNameId, actionId);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findByG_C_A(
		long groupId, long classNameId, java.lang.String actionId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_A(groupId, classNameId, actionId, start, end);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findByG_C_A(
		long groupId, long classNameId, java.lang.String actionId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_A(groupId, classNameId, actionId, start, end,
			orderByComparator);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting findByG_C_A_First(
		long groupId, long classNameId, java.lang.String actionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence()
				   .findByG_C_A_First(groupId, classNameId, actionId,
			orderByComparator);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting findByG_C_A_Last(
		long groupId, long classNameId, java.lang.String actionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence()
				   .findByG_C_A_Last(groupId, classNameId, actionId,
			orderByComparator);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting[] findByG_C_A_PrevAndNext(
		long equitySettingId, long groupId, long classNameId,
		java.lang.String actionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence()
				   .findByG_C_A_PrevAndNext(equitySettingId, groupId,
			classNameId, actionId, orderByComparator);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting findByG_C_A_T(
		long groupId, long classNameId, java.lang.String actionId, int type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		return getPersistence()
				   .findByG_C_A_T(groupId, classNameId, actionId, type);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting fetchByG_C_A_T(
		long groupId, long classNameId, java.lang.String actionId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_A_T(groupId, classNameId, actionId, type);
	}

	public static com.liferay.portlet.social.model.SocialEquitySetting fetchByG_C_A_T(
		long groupId, long classNameId, java.lang.String actionId, int type,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_A_T(groupId, classNameId, actionId, type,
			retrieveFromCache);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialEquitySetting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	public static void removeByG_C_A(long groupId, long classNameId,
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_A(groupId, classNameId, actionId);
	}

	public static void removeByG_C_A_T(long groupId, long classNameId,
		java.lang.String actionId, int type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquitySettingException {
		getPersistence().removeByG_C_A_T(groupId, classNameId, actionId, type);
	}

	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	public static int countByG_C_A(long groupId, long classNameId,
		java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_A(groupId, classNameId, actionId);
	}

	public static int countByG_C_A_T(long groupId, long classNameId,
		java.lang.String actionId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_C_A_T(groupId, classNameId, actionId, type);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SocialEquitySettingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SocialEquitySettingPersistence)PortalBeanLocatorUtil.locate(SocialEquitySettingPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(SocialEquitySettingPersistence persistence) {
		_persistence = persistence;
	}

	private static SocialEquitySettingPersistence _persistence;
}