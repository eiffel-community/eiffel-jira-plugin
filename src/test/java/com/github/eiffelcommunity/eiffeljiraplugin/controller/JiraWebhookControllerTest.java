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

package com.github.eiffelcommunity.eiffeljiraplugin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEventTest;
import com.github.eiffelcommunity.eiffeljiraplugin.service.JiraEiffelMappingService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;
import java.util.Scanner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(JiraWebhookController.class)
public class JiraWebhookControllerTest {
    private static String jiraIssueCreatedEventString;
    private static String jiraIssueAssignedEventString;
    private static String jiraIssueStatusUpdatedToInProgressEventString;
    private static String jiraIssueStatusUpdatedToCompleteEventString;

    /*
     read in a file under "resources" and return the whole thing as a string
     See https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
     for scanner trick. "\\A" is "beginning of input boundry," so the scanner reads
     the whole file in one go.
    */
    private static String resourceToString(String resourcePath) {
        InputStream inputStream = JiraWebhookControllerTest.class.getClassLoader().getResourceAsStream(resourcePath);
        try (Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            return s.hasNext() ? s.next() : "";
        }
    }

    @BeforeClass
    public static void initCache() {
        // read files only once, not before each test
        jiraIssueCreatedEventString = resourceToString("input/jira-issue-created.json");
        jiraIssueAssignedEventString = resourceToString("input/jira-issue-assigned.json");
        jiraIssueStatusUpdatedToInProgressEventString = resourceToString("input/jira-issue-status-updated-to-in-progress.json");
        jiraIssueStatusUpdatedToCompleteEventString = resourceToString("input/jira-issue-status-updated-to-complete.json");
    }

    @MockBean
    private JiraEiffelMappingService mappingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRequestIsNotAllowed() throws Exception {
        mockMvc.perform(get("/webhooks/jira"))
               .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void malformedJsonIsBadRequest() throws Exception {
        mockMvc.perform(post("/webhooks/jira")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content("{\"bad\": \"data\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void goodInputRespondsOK() throws Exception {
        mockMvc.perform(post("/webhooks/jira")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(jiraIssueCreatedEventString))
                .andExpect(status().isOk());
    }
}
