/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.cache.CacheKVP;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.cache.CacheRegistryItem;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.util.PropsValues;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <a href="FinderCacheImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class FinderCacheImpl implements CacheRegistryItem, FinderCache {

	public static final String CACHE_NAME = FinderCache.class.getName();

	public void afterPropertiesSet() {
		CacheRegistry.register(this);
	}

	public void clearCache() {
		PortalCache[] portalCaches = _portalCaches.values().toArray(
			new PortalCache[_portalCaches.size()]);

		for (PortalCache portalCache : portalCaches) {
			portalCache.removeAll();
		}
	}

	public void clearCache(String className) {
		PortalCache portalCache = _getPortalCache(className);

		portalCache.removeAll();
	}

	public String getRegistryName() {
		return CACHE_NAME;
	}

	public Object getResult(
		FinderPath finderPath, Object[] args, SessionFactory sessionFactory) {

		if (!PropsValues.VALUE_OBJECT_FINDER_CACHE_ENABLED ||
			!finderPath.isFinderCacheEnabled() || !CacheRegistry.isActive()) {

			return null;
		}

		PortalCache portalCache = _getPortalCache(finderPath.getClassName());

		String key = _encodeKey(
			finderPath.getMethodName(), finderPath.getParams(), args);

		Object primaryKey = _multiVMPool.get(portalCache, key);

		if (primaryKey != null) {
			return _primaryKeyToResult(finderPath, sessionFactory, primaryKey);
		}
		else {
			return null;
		}
	}

	public void invalidate() {
		clearCache();
	}

	public void putResult(FinderPath finderPath, Object[] args, Object result) {
		if (!PropsValues.VALUE_OBJECT_FINDER_CACHE_ENABLED ||
			!finderPath.isFinderCacheEnabled() || !CacheRegistry.isActive() ||
			(result == null)) {

			return;
		}

		PortalCache portalCache = _getPortalCache(finderPath.getClassName());

		String key = _encodeKey(
			finderPath.getMethodName(), finderPath.getParams(), args);

		_multiVMPool.put(portalCache, key, _resultToPrimaryKey(result));
	}

	public void removeResult(FinderPath finderPath, Object[] args) {
		if (!PropsValues.VALUE_OBJECT_FINDER_CACHE_ENABLED ||
			!finderPath.isFinderCacheEnabled() || !CacheRegistry.isActive()) {

			return;
		}

		PortalCache portalCache = _getPortalCache(finderPath.getClassName());

		String key = _encodeKey(
			finderPath.getMethodName(), finderPath.getParams(), args);

		_multiVMPool.remove(portalCache, key);
	}

	public void setMultiVMPool(MultiVMPool multiVMPool) {
		_multiVMPool = multiVMPool;
	}

	private String _encodeGroupKey(String className) {
		StringBuilder sb = new StringBuilder();

		sb.append(CACHE_NAME);
		sb.append(StringPool.PERIOD);
		sb.append(className);

		return sb.toString();
	}

	private String _encodeKey(
		String methodName, String[] params, Object[] args) {

		StringBuilder sb = new StringBuilder();

		sb.append(methodName);
		sb.append(_PARAMS_SEPARATOR);

		for (String param : params) {
			sb.append(StringPool.PERIOD);
			sb.append(param);
		}

		sb.append(_ARGS_SEPARATOR);

		for (Object arg : args) {
			sb.append(StringPool.PERIOD);
			sb.append(String.valueOf(arg));
		}

		return sb.toString();
	}

	private PortalCache _getPortalCache(String className) {
		String groupKey = _encodeGroupKey(className);

		PortalCache portalCache = _portalCaches.get(groupKey);

		if (portalCache == null) {
			portalCache = _multiVMPool.getCache(groupKey);

			_portalCaches.put(groupKey, portalCache);
		}

		return portalCache;
	}

	private Object _primaryKeyToResult(
		FinderPath finderPath, SessionFactory sessionFactory,
		Object primaryKey) {

		if (primaryKey instanceof CacheKVP) {
			CacheKVP cacheKVP = (CacheKVP)primaryKey;

			Class<?> modelClass = cacheKVP.getModelClass();
			Serializable primaryKeyObj = cacheKVP.getPrimaryKeyObj();

			return EntityCacheUtil.loadResult(
				finderPath.isEntityCacheEnabled(), modelClass, primaryKeyObj,
				sessionFactory);
		}
		else if (primaryKey instanceof List) {
			List<Object> cachedList = (List<Object>)primaryKey;

			List<Object> list = new ArrayList<Object>(cachedList.size());

			for (Object curPrimaryKey : cachedList) {
				Object result = _primaryKeyToResult(
					finderPath, sessionFactory, curPrimaryKey);

				list.add(result);
			}

			return list;
		}
		else {
			return primaryKey;
		}
	}

	private Object _resultToPrimaryKey(Object result) {
		if (result instanceof BaseModel) {
			BaseModel<?> model = (BaseModel<?>)result;

			Class<?> modelClass = model.getClass();
			Serializable primaryKeyObj = model.getPrimaryKeyObj();

			return new CacheKVP(modelClass, primaryKeyObj);
		}
		else if (result instanceof List) {
			List<Object> list = (List<Object>)result;

			List<Object> cachedList = new ArrayList<Object>(list.size());

			for (Object curResult : list) {
				Object primaryKey = _resultToPrimaryKey(curResult);

				cachedList.add(primaryKey);
			}

			return cachedList;
		}
		else {
			return result;
		}
	}

	private static final String _ARGS_SEPARATOR = "_A_";

	private static final String _PARAMS_SEPARATOR = "_P_";

	private MultiVMPool _multiVMPool;
	private Map<String, PortalCache> _portalCaches =
		new ConcurrentHashMap<String, PortalCache>();

}