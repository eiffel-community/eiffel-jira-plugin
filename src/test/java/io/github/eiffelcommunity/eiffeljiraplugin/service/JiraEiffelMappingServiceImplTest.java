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
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100Data;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssue;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueRelatedEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.URI;

public class JiraEiffelMappingServiceImplTest {
    private static JiraIssue jiraIssue;
    private static String jiraIssueCreatedEventFilePath = "src/test/resources/input/jira-issue-created.json";
    private JiraEiffelMappingService mappingService;

    @BeforeClass
    public static void initCache() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jiraIssueCreatedEventFilePath);
        JiraIssueRelatedEvent event = mapper.readValue(file, JiraIssueRelatedEvent.class);
        jiraIssue = event.getIssue();
    }

    @Before
    public void setUp() {
        mappingService = new JiraEiffelMappingServiceImpl();
    }

    @Test
    public void toEiffelIssueDefinedEvent100ParsesCorrecetData() {
        EiffelIssueDefinedEvent100Data expectedData = new EiffelIssueDefinedEvent100Data.Builder()
                .setId("10032")
                .setTracker("JIRA")
                .setType(EiffelIssueType.OTHER)
                .setUri(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10032"))
                .build();
        EiffelIssueDefinedEvent100 event = mappingService.toEiffelIssueDefinedEvent100(jiraIssue);
        EiffelIssueDefinedEvent100Data actualData = event.getData();
        Assert.assertEquals(expectedData, actualData);
    }
}
