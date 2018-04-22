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

import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventData;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventMeta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EiffelRabbitServiceImplTest {

    @Autowired
    private EiffelRabbitService rabbitService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void publishSimpleString() {
        rabbitTemplate.convertAndSend("eiffel.issue.created", "straight from rabbit template");
    }

    /**
     * This won't work without a broker running where the EiffelRabbitService points to.
     * This is mostly for manual inspection, so remove the @Ignore to try running against
     * a live broker.
     */
    @Test
    public void publishToLiveBroker() {
        ImmutableEiffelIssueDefinedEventMeta meta = ImmutableEiffelIssueDefinedEventMeta.builder().build();
        ImmutableEiffelIssueDefinedEventData data = ImmutableEiffelIssueDefinedEventData.builder()
                .id("Id")
                .tracker("Tracker")
                .type(EiffelIssueType.OTHER)
                .uri(URI.create("https://www.github.com"))
                .build();
        ImmutableEiffelIssueDefinedEvent event = ImmutableEiffelIssueDefinedEvent.builder()
                .meta(meta)
                .data(data)
                .links(new ArrayList<>())
                .build();
        rabbitService.publish(event);
    }
}
