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

package io.github.eiffelcommunity.eiffeljiraplugin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueRelatedEvent;
import io.github.eiffelcommunity.eiffeljiraplugin.service.JiraEiffelMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraWebhookController {
    private static final String JIRA_WEBHOOK_EVENT_TYPE_ISSUE_CREATED = "issue_created";
    private Logger LOG = LoggerFactory.getLogger(getClass().getSimpleName());
    private JiraEiffelMappingService mappingService;
    private ObjectMapper mapper;

    public JiraWebhookController(JiraEiffelMappingService mappingService, ObjectMapper mapper) {
        this.mappingService = mappingService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/webhooks/jira", method = {RequestMethod.POST})
    public ResponseEntity<?> jiraWebhookEvent(@RequestBody JiraIssueRelatedEvent jiraEvent) {

        // Right now we're only interested in issue_created events, as we're only
        // defining EiffelIssueDefinedEvent.
        switch (jiraEvent.getEventType()) {
            case JIRA_WEBHOOK_EVENT_TYPE_ISSUE_CREATED:
                EiffelIssueDefinedEvent100 eiffelEvent = mappingService.toEiffelIssueDefinedEvent100(jiraEvent.getIssue());
                // TODO: Send Eiffel event to Rabbit
                try {
                    mapper.findAndRegisterModules();
                    System.out.println(eiffelEvent.toString());
                    System.out.println(mapper.writeValueAsString(eiffelEvent));
                    return ResponseEntity.ok().build();
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            default:
                // Jira sent us a perfectly valid issue representation, but it was for
                // and issue being updated/deleted, and we aren't handling that right now.
                // Tell JIRA we caught the event so it doesn't retry sending it.
                return ResponseEntity.ok().build();
        }
    }
}
