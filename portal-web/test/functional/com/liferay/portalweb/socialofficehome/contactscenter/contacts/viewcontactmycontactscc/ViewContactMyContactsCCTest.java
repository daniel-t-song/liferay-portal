/**
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

package com.liferay.portalweb.socialofficehome.contactscenter.contacts.viewcontactmycontactscc;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewContactMyContactsCCTest extends BaseTestCase {
	public void testViewContactMyContactsCC() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/user/joebloggs/so/dashboard/");
		selenium.waitForVisible(
			"//nav/ul/li[contains(.,'Contacts Center')]/a/span");
		selenium.clickAt("//nav/ul/li[contains(.,'Contacts Center')]/a/span",
			RuntimeVariables.replace("Contacts Center"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible(
				"//input[@id='_1_WAR_contactsportlet_name']"));
		assertTrue(selenium.isVisible(
				"//select[@id='_1_WAR_contactsportlet_filterBy']"));
		selenium.select("//select[@id='_1_WAR_contactsportlet_filterBy']",
			RuntimeVariables.replace("My Contacts"));
		Thread.sleep(1000);
		selenium.waitForText("//div[contains(@class, 'lfr-contact-name')]/a",
			"Social01 Office01 Contact01");
		assertEquals(RuntimeVariables.replace("Social01 Office01 Contact01"),
			selenium.getText("//div[contains(@class, 'lfr-contact-name')]/a"));
		assertEquals(RuntimeVariables.replace(
				"socialofficecontact01@liferay.com"),
			selenium.getText("//div[contains(@class, 'lfr-contact-extra')]"));
		assertEquals(RuntimeVariables.replace("View my 1 contacts."),
			selenium.getText("link=View my 1 contacts."));
	}
}