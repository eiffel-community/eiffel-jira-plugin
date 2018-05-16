/*
 * Copyright 2018 Jaden Young
 * For a full list of individual contributors, please see the commit history.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.eiffelcommunity.eiffeljiraplugin.service;

import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.*;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraAssignee;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueStatusCategoryName;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;

/*
    Service for mapping JIRA events to Eiffel events.
 */
public interface JiraEiffelMappingService {
    ImmutableEiffelIssueDefinedEvent toEiffelIssueDefinedEvent(ImmutableJiraIssueRelatedEvent jiraEvent);

    ImmutableEiffelIssueAssignedEvent toEiffelIssueAssignedEvent(ImmutableJiraIssueRelatedEvent jiraEvent);

    ImmutableEiffelIssueStatusModifiedEvent toEiffelIssueStatusModifiedEvent(ImmutableJiraIssueRelatedEvent jiraEvent);

    EiffelIssueType toEiffelIssueType(JiraIssueType jiraType);

    ImmutableEiffelAssignee toEiffelAssignee(ImmutableJiraAssignee jiraAssignee);

    EiffelIssueStatusCategory toEiffelIssueStatusCategory(JiraIssueStatusCategoryName jiraCategoryName);
}
