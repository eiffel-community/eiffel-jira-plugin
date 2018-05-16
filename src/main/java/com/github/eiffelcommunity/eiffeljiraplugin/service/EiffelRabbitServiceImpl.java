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

import com.github.eiffelcommunity.eiffeljiraplugin.config.RabbitProperties;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EiffelRabbitServiceImpl implements EiffelRabbitService {
    private final static Logger LOG = LoggerFactory.getLogger(EiffelRabbitServiceImpl.class);

    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties rabbitProperties;

    @Autowired
    public EiffelRabbitServiceImpl(RabbitTemplate rabbitTemplate, RabbitProperties rabbitProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitProperties = rabbitProperties;
    }

    /**
     * Publishes an Eiffel event as json to a preconfigured RabbitMQ exchange. Uses
     * internally defined routing keys.
     *
     * @param eiffelEvent Event to publish.
     * @throws UnsupportedOperationException when the service does not know a routing key for the given event.
     */
    @Override
    public void publish(Event eiffelEvent) {
        Optional<String> routingKey = getRoutingKey(eiffelEvent);
        if (!routingKey.isPresent()) {
            LOG.error("No routing key found for " + eiffelEvent.meta().type());
            throw new UnsupportedOperationException("Don't have a routing key for " + eiffelEvent.meta().type());
        }
        LOG.info("Publishing " + eiffelEvent.meta().type() + " to RabbitMQ with routing key: " + routingKey.get());
        publish(routingKey.get(), eiffelEvent);
    }

    /**
     * Publishes an Eiffel event as json to a preconfigured RabbitMQ exchange.
     *
     * @param eiffelEvent Event to publish.
     * @param routingKey  Routing key to use.
     */
    @Override
    public void publish(String routingKey, Event eiffelEvent) {
        publish(rabbitProperties.getExchangeName(), routingKey, eiffelEvent);
    }

    /**
     * Publishes an Eiffel event as json to the given exchange with the given routing key.
     *
     * @param exchangeName name of exchange to publish to
     * @param routingKey   routing key to use when publishing
     * @param eiffelEvent  Event to publish
     */
    @Override
    public void publish(String exchangeName, String routingKey, Event eiffelEvent) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, eiffelEvent);
    }

    /**
     * Looks up a routing key corresponding to the given Eiffel event type for use with
     * a RabbitMQ topic exchange.
     *
     * @param event Eiffel event
     * @return routing key if known, otherwise empty.
     */
    private Optional<String> getRoutingKey(Event event) {
        String type = event.meta().type();
        switch (type) {
            case "EiffelIssueDefinedEvent": {
                return Optional.of("eiffel.issue.created");
            }
            case "EiffelIssueStatusModifiedEvent": {
                return Optional.of("eiffel.issue.updated");
            }
            case "EiffelIssueAssignedEvent": {
                return Optional.of("eiffel.issue.assigned");
            }
            default:
                return Optional.empty();
        }
    }
}
