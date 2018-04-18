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
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.service.JiraEiffelMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraWebhookController {
    private static final Logger LOG = LoggerFactory.getLogger(JiraWebhookController.class);
    private JiraEiffelMappingService mappingService;
    private ObjectMapper mapper;

    @Autowired
    public JiraWebhookController(JiraEiffelMappingService mappingService, ObjectMapper mapper) {
        this.mappingService = mappingService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/webhooks/jira", method = {RequestMethod.POST})
    public ResponseEntity<?> jiraWebhookEvent(@RequestBody ImmutableJiraIssueRelatedEvent jiraEvent) {

        // Right now we're only interested in issue_created events, as we're only
        // defining EiffelIssueDefinedEvent.
        switch (jiraEvent.webhookEventType()) {
            case CREATED:
                ImmutableEiffelIssueDefinedEvent eiffelEvent = mappingService.toEiffelIssueDefinedEvent(jiraEvent);
                // TODO: Send Eiffel event to Rabbit
                try {
                    String json = mapper.writeValueAsString(eiffelEvent);
                    LOG.info("Parsed event to json: " + json);
                    return ResponseEntity.ok().build();
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            default:
                // Jira sent us a perfectly valid issue representation, but it was for
                // an issue being updated/deleted, and we aren't handling that right now.
                // Tell JIRA we caught the event so it doesn't retry.
                return ResponseEntity.ok().build();
        }
    }
}
