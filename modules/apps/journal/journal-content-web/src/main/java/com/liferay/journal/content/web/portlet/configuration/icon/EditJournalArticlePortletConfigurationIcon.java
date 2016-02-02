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

package com.liferay.journal.content.web.portlet.configuration.icon;

import com.liferay.journal.content.web.constants.JournalContentPortletKeys;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

/**
 * @author Pavel Savinov
 */
public class EditJournalArticlePortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	public EditJournalArticlePortletConfigurationIcon(
		PortletRequest portletRequest) {

		super(portletRequest);
	}

	@Override
	public String getMessage() {
		return "edit-web-content";
	}

	@Override
	public String getOnClick() {
		StringBundler sb = new StringBundler(14);

		JournalArticle article = null;

		try {
			article = getArticle();
		}
		catch (Exception e) {
			_log.error("Unable to get current article", e);
		}

		if (article == null) {
			return "";
		}

		sb.append("Liferay.Util.openWindow({bodyCssClass: ");
		sb.append("'dialog-with-footer', destroyOnHide: true, id: '");
		sb.append(HtmlUtil.escape(portletDisplay.getNamespace()));
		sb.append("editAsset', namespace: '");
		sb.append(portletDisplay.getNamespace());
		sb.append("', portlet: '#p_p_id_");
		sb.append(portletDisplay.getId());
		sb.append("_', portletId: '");
		sb.append(portletDisplay.getId());
		sb.append("', title: '");
		sb.append(article.getTitle(themeDisplay.getLocale()));
		sb.append("', uri: '");
		sb.append(HtmlUtil.escapeJS(getURL()));
		sb.append("'}); return false;");

		return sb.toString();
	}

	@Override
	public String getURL() {
		AssetRendererFactory<JournalArticle> assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClass(
				JournalArticle.class);

		PortletURL redirectURL = PortletURLFactoryUtil.create(
			portletRequest, JournalContentPortletKeys.JOURNAL_CONTENT,
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		redirectURL.setParameter(
			"mvcPath", "/update_journal_article_redirect.jsp");
		redirectURL.setParameter(
			"referringPortletResource", portletDisplay.getId());

		PortletURL portletURL = null;
		JournalArticle article = null;

		try {
			article = getArticle();

			AssetRenderer<JournalArticle> latestArticleAssetRenderer =
				assetRendererFactory.getAssetRenderer(
					article.getResourcePrimKey());

			portletURL = latestArticleAssetRenderer.getURLEdit(
				(LiferayPortletRequest)portletRequest, null,
				LiferayWindowState.POP_UP, redirectURL);
		}
		catch (Exception e) {
			_log.error("Unable to generate URL to edit article", e);

			return StringPool.BLANK;
		}

		try {
			portletURL.setWindowState(LiferayWindowState.POP_UP);
			redirectURL.setWindowState(LiferayWindowState.POP_UP);
		}
		catch (WindowStateException e) {
			_log.error("Unable to set window state", e);
		}

		portletURL.setParameter(
			"hideDefaultSuccessMessage", Boolean.TRUE.toString());
		portletURL.setParameter("showBackURL", Boolean.FALSE.toString());
		portletURL.setParameter("showHeader", Boolean.FALSE.toString());

		portletURL.setParameter("mvcPath", "/edit_article.jsp");
		portletURL.setParameter("redirect", redirectURL.toString());
		portletURL.setParameter(
			"groupId", String.valueOf(article.getGroupId()));
		portletURL.setParameter("articleId", article.getArticleId());
		portletURL.setParameter(
			"refererPortletName", JournalContentPortletKeys.JOURNAL_CONTENT);

		Portlet portlet = PortletLocalServiceUtil.getPortletById(
			portletDisplay.getId());

		portletURL.setParameter(
			"refererWebDAVToken", WebDAVUtil.getStorageToken(portlet));

		return portletURL.toString();
	}

	@Override
	public boolean isShow() {
		try {
			JournalArticle article = getArticle();

			if ((article != null) && !article.isNew()) {
				return true;
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean isToolTip() {
		return false;
	}

	protected JournalArticle getArticle() throws Exception {
		long groupId = ParamUtil.getLong(
			portletRequest, "groupId", themeDisplay.getScopeGroupId());
		String articleId = portletRequest.getPreferences().getValue(
			"articleId", null);
		int status = ParamUtil.getInteger(
			portletRequest, "status", WorkflowConstants.STATUS_ANY);

		JournalArticle article = null;

		if (Validator.isNotNull(articleId)) {
			article = JournalArticleServiceUtil.getLatestArticle(
				groupId, articleId, status);
		}

		return article;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditJournalArticlePortletConfigurationIcon.class);

}