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

package com.github.eiffelcommunity.eiffeljiraplugin.model.jira;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.eiffelcommunity.eiffeljiraplugin.SharedTestConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ImmutableJiraIssueRelatedEventTest {
    private static String jiraIssueCreatedEventString = SharedTestConstants.jiraIssueCreatedEventString;
    private static String jiraIssueAssignedEventString = SharedTestConstants.jiraIssueAssignedEventString;
    private static String jiraIssueStatusUpdatedToInProgressEventString = SharedTestConstants.jiraIssueStatusUpdatedToInProgressEventString;
    private static String jiraIssueStatusUpdatedToCompleteEventString = SharedTestConstants.jiraIssueStatusUpdatedToCompleteEventString;

    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        /*
            Spring automatically registers Jdk 8 types since jackson-datatype-jdk8 is on the class path,
            but we don't want to bring in all of spring just for these tests.
         */
        mapper.registerModule(new Jdk8Module());
    }

    @After
    public void tearDown() {
    }

    /*
        These parse* tests are more for exposing regressions than prescribing behavior.
     */
    @Test
    public void parseJiraIssueCreatedEvent() throws Exception {
        ImmutableJiraIssueRelatedEvent expected = ImmutableJiraIssueRelatedEvent.builder()
                .webhookEventType(JiraWebhookEventType.CREATED)
                .issueEventType(JiraIssueEventType.CREATED)
                .timestamp(1517840805048L)
                .issue(ImmutableJiraIssue.builder()
                        .id("10032")
                        .self(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10032"))
                        .fields(ImmutableJiraIssueFields.builder()
                                .issueType(ImmutableJiraFieldsIssueType.builder()
                                        .issueType(JiraIssueType.EPIC)
                                        .build())
                                .status(ImmutableJiraIssueStatus.builder()
                                        .name("To Do")
                                        .category(ImmutableJiraIssueStatusCategory.builder()
                                                .name(JiraIssueStatusCategoryName.NEW)
                                                .build())
                                        .build())
                                .title("Epic summary")
                                .build())
                        .build())
                .build();

        ImmutableJiraIssueRelatedEvent actual = mapper.readValue(jiraIssueCreatedEventString, ImmutableJiraIssueRelatedEvent.class);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void parseJiraIssueAssignedEvent() throws Exception {
        ImmutableJiraIssueRelatedEvent expected = ImmutableJiraIssueRelatedEvent.builder()
                .webhookEventType(JiraWebhookEventType.UPDATED)
                .issueEventType(JiraIssueEventType.ASSIGNED)
                .timestamp(1520221555849L)
                .issue(ImmutableJiraIssue.builder()
                        .id("10042")
                        .self(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10042"))
                        .fields(ImmutableJiraIssueFields.builder()
                                .issueType(ImmutableJiraFieldsIssueType.builder()
                                        .issueType(JiraIssueType.TASK)
                                        .build())
                                .assignee(ImmutableJiraAssignee.builder()
                                        .username("admin")
                                        .displayName("Bob Barker")
                                        .emailAddress("bob@barker.com")
                                        .build())
                                .status(ImmutableJiraIssueStatus.builder()
                                        .name("To Do")
                                        .category(ImmutableJiraIssueStatusCategory.builder()
                                                .name(JiraIssueStatusCategoryName.NEW)
                                                .build())
                                        .build())
                                .title("Issue summary")
                                .build())
                        .build())
                .build();

        ImmutableJiraIssueRelatedEvent actual = mapper.readValue(jiraIssueAssignedEventString, ImmutableJiraIssueRelatedEvent.class);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseJiraIssueStatusUpdatedToInProgressEvent() throws Exception {
        ImmutableJiraIssueRelatedEvent expected = ImmutableJiraIssueRelatedEvent.builder()
                .webhookEventType(JiraWebhookEventType.UPDATED)
                .issueEventType(JiraIssueEventType.UPDATED)
                .timestamp(1520222583834L)
                .issue(ImmutableJiraIssue.builder()
                        .id("10042")
                        .self(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10042"))
                        .fields(ImmutableJiraIssueFields.builder()
                                .issueType(ImmutableJiraFieldsIssueType.builder()
                                        .issueType(JiraIssueType.TASK)
                                        .build())
                                .assignee(ImmutableJiraAssignee.builder()
                                        .username("admin")
                                        .displayName("Bob Barker")
                                        .emailAddress("bob@barker.com")
                                        .build())
                                .status(ImmutableJiraIssueStatus.builder()
                                        .name("In Progress")
                                        .category(ImmutableJiraIssueStatusCategory.builder()
                                                .name(JiraIssueStatusCategoryName.IN_PROGRESS)
                                                .build())
                                        .build())
                                .title("Issue summary")
                                .build())
                        .build())
                .build();

        ImmutableJiraIssueRelatedEvent actual = mapper.readValue(jiraIssueStatusUpdatedToInProgressEventString, ImmutableJiraIssueRelatedEvent.class);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseJiraIssueStatusUpdatedToComplete() throws Exception {
        ImmutableJiraIssueRelatedEvent expected = ImmutableJiraIssueRelatedEvent.builder()
                .webhookEventType(JiraWebhookEventType.UPDATED)
                .issueEventType(JiraIssueEventType.UPDATED)
                .timestamp(1520270021381L)
                .issue(ImmutableJiraIssue.builder()
                        .id("10042")
                        .self(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10042"))
                        .fields(ImmutableJiraIssueFields.builder()
                                .issueType(ImmutableJiraFieldsIssueType.builder()
                                        .issueType(JiraIssueType.TASK)
                                        .build())
                                .assignee(ImmutableJiraAssignee.builder()
                                        .username("admin")
                                        .displayName("Bob Barker")
                                        .emailAddress("bob@barker.com")
                                        .build())
                                .status(ImmutableJiraIssueStatus.builder()
                                        .name("Done")
                                        .category(ImmutableJiraIssueStatusCategory.builder()
                                                .name(JiraIssueStatusCategoryName.COMPLETE)
                                                .build())
                                        .build())
                                .title("Issue summary")
                                .build())
                        .build())
                .build();

        ImmutableJiraIssueRelatedEvent actual = mapper.readValue(jiraIssueStatusUpdatedToCompleteEventString, ImmutableJiraIssueRelatedEvent.class);

        Assert.assertEquals(expected, actual);
    }
}
