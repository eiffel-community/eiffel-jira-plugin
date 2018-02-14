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

import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100Data;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent100Meta;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.LinkImpl;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssue;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JiraEiffelMappingServiceImpl implements JiraEiffelMappingService {
    private static final String JIRA_TRACKER = "JIRA";

    @Override
    public EiffelIssueDefinedEvent100 toEiffelIssueDefinedEvent100(JiraIssue jiraIssue) {
        EiffelIssueDefinedEvent100Meta meta = new EiffelIssueDefinedEvent100Meta.Builder().build();

        EiffelIssueDefinedEvent100Data data = new EiffelIssueDefinedEvent100Data.Builder()
                .setId(jiraIssue.getId())
                .setUri(jiraIssue.getSelf())
                .setTracker(JIRA_TRACKER)
                .setType(toEiffelIssueType(jiraIssue.getFields().getFieldsIssueType().getIssueType()))
                .build();

        Set<LinkImpl> links = new HashSet<>();

        return new EiffelIssueDefinedEvent100.Builder()
                .setMeta(meta)
                .setData(data)
                .setLinks(links)
                .build();
    }

    @Override
    public EiffelIssueType toEiffelIssueType(JiraIssueType jiraType) {
        switch (jiraType) {
            case TASK:
            case SUB_TASK: // fall through
                return EiffelIssueType.WORK_ITEM;
            case STORY:
                return EiffelIssueType.REQUIREMENT;
            case BUG:
                return EiffelIssueType.BUG;
            case FEATURE:
                return EiffelIssueType.FEATURE;
            case IMPROVEMENT:
                return EiffelIssueType.IMPROVEMENT;
            case EPIC:
                return EiffelIssueType.OTHER;
            default:
                return EiffelIssueType.OTHER;
        }
    }
}
