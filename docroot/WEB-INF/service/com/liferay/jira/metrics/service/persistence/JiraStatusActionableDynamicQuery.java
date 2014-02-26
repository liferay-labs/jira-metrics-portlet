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

package com.liferay.jira.metrics.service.persistence;

import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Manuel de la Peña
 * @generated
 */
public abstract class JiraStatusActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public JiraStatusActionableDynamicQuery() throws SystemException {
		setBaseLocalService(JiraStatusLocalServiceUtil.getService());
		setClass(JiraStatus.class);

		setClassLoader(com.liferay.jira.metrics.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("jiraStatusId");
	}
}