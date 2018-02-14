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

package io.github.eiffelcommunity.eiffeljiraplugin.model.jira;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImmutableJiraIssueRelatedEventTest {
    private static String jiraIssueCreatedEventString;
    private static String jiraissueCreatedeventFilePath = "src/test/resources/input/jira-issue-created.json";

    private ObjectMapper mapper;

    @BeforeClass
    public static void initCache() throws Exception {
        jiraIssueCreatedEventString = new String(Files.readAllBytes(Paths.get(jiraissueCreatedeventFilePath)));
    }

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void jsonParsingContainsOnlyDesiredFields() throws Exception {
        ImmutableJiraIssueRelatedEvent expected = ImmutableJiraIssueRelatedEvent.builder()
                .eventType("issue_created")
                .issue(ImmutableJiraIssue.builder()
                        .id("10032")
                        .self(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10032"))
                        .fields(ImmutableJiraIssueFields.builder()
                                .issueType(ImmutableJiraFieldsIssueType.builder()
                                        .issueType(JiraIssueType.EPIC)
                                        .build())
                                .build())
                        .build())
                .build();

        ImmutableJiraIssueRelatedEvent actual = mapper.readValue(jiraIssueCreatedEventString, ImmutableJiraIssueRelatedEvent.class);

        Assert.assertEquals(expected, actual);
    }
}
