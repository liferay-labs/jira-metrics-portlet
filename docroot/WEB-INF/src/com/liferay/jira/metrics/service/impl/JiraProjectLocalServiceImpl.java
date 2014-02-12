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

package com.liferay.jira.metrics.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.jira.metrics.NoSuchJiraProjectException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.base.JiraProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * The implementation of the jira project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraProjectLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil
 */
public class JiraProjectLocalServiceImpl extends JiraProjectLocalServiceBaseImpl {

	public JiraProject addJiraProject(
			User user, long jiraProjectCode, String label, String name)
		throws PortalException, SystemException {

		long id = counterLocalService.increment();

		JiraProject jiraProject = jiraProjectPersistence.create(id);

		Date now = new Date();

		jiraProject.setUserId(user.getUserId());
		jiraProject.setUserName(user.getFullName());
		jiraProject.setCreateDate(now);
		jiraProject.setModifiedDate(now);

		jiraProject.setJiraProjectCode(jiraProjectCode);
		jiraProject.setLabel(label);
		jiraProject.setName(name);

		jiraProjectPersistence.update(jiraProject);

		return jiraProjectPersistence.findByPrimaryKey(
			jiraProject.getPrimaryKey());
	}

	/**
	 * Gets a Jira Project by name
	 *
	 * @param projectCode
	 * @return
	 * @throws NoSuchJiraProjectException
	 * @throws SystemException
	 */
	public JiraProject getJiraProjectByName(String name)
		throws NoSuchJiraProjectException, SystemException {

		return jiraProjectPersistence.findByName(name);
	}

	/**
	 * Gets a Jira Project by projectCode
	 *
	 * @param projectCode
	 * @return
	 * @throws NoSuchJiraProjectException
	 * @throws SystemException
	 */
	public JiraProject getJiraProjectByProjectCode(long projectCode)
		throws NoSuchJiraProjectException, SystemException {

		return jiraProjectPersistence.findByJiraProjectCode(projectCode);
	}

	/**
	 * Gets a Jira Project by label
	 *
	 * @param label 
	 * @return the Jira project
	 * @throws NoSuchJiraProjectException
	 * @throws SystemException
	 */
	public JiraProject getJiraProjectByProjectLabel(String label)
		throws NoSuchJiraProjectException, SystemException {

		return jiraProjectPersistence.findByLabel(label);
	}

	/**
	 * Retrieves all Jira projects
	 * 
	 * @return a list with all Jira projects
	 * @throws SystemException
	 */
	public List<JiraProject> getAllJiraProjects() throws SystemException {
		return jiraProjectPersistence.findAll();
	}

}