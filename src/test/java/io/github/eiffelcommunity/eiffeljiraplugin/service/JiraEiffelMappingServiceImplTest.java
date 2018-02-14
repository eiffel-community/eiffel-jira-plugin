/*
 * Copyright 2018 Jaden Young
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.eiffelcommunity.eiffeljiraplugin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEvent;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventData;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssue;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.URI;

public class JiraEiffelMappingServiceImplTest {
    private static ImmutableJiraIssue jiraIssue;
    private static String jiraIssueCreatedEventFilePath = "src/test/resources/input/jira-issue-created.json";
    private JiraEiffelMappingService mappingService;

    @BeforeClass
    public static void initCache() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jiraIssueCreatedEventFilePath);
        ImmutableJiraIssueRelatedEvent event = mapper.readValue(file, ImmutableJiraIssueRelatedEvent.class);
        jiraIssue = event.issue();
    }

    @Before
    public void setUp() {
        mappingService = new JiraEiffelMappingServiceImpl();
    }

    @Test
    public void toEiffelIssueDefinedEventParsesCorrecetData() {
        ImmutableEiffelIssueDefinedEventData expectedData = ImmutableEiffelIssueDefinedEventData.builder()
                .id("10032")
                .tracker("JIRA")
                .type(EiffelIssueType.OTHER)
                .uri(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10032"))
                .build();
        ImmutableEiffelIssueDefinedEvent event = mappingService.toEiffelIssueDefinedEvent(jiraIssue);
        ImmutableEiffelIssueDefinedEventData actualData = event.data();
        Assert.assertEquals(expectedData, actualData);
    }
}
