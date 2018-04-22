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

import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.Event;

/**
 * Service to publish Eiffel events to RabbitMQ.
 * Essentially a wrapper over RabbitTemplate to allow externalized configuration
 * of the exchange name.
 */
public interface EiffelRabbitService {
    /**
     * Publishes an Eiffel event as json to a preconfigured RabbitMQ exchange. Uses
     * internally defined routing keys.
     *
     * @param eiffelEvent Event to publish.
     * @throws UnsupportedOperationException when the service does not know a routing key for the given event.
     */
    void publish(Event eiffelEvent) throws UnsupportedOperationException;

    /**
     * Publishes an Eiffel event as json to a preconfigured RabbitMQ exchange.
     *
     * @param routingKey  Routing key to use.
     * @param eiffelEvent Event to publish.
     */
    void publish(String routingKey, Event eiffelEvent);

    /**
     * Publishes an Eiffel event as json to the given exchange with the given routing key.
     *
     * @param exchangeName name of exchange to publish to
     * @param routingKey   routing key to use when publishing
     * @param eiffelEvent  Event to publish
     */
    void publish(String exchangeName, String routingKey, Event eiffelEvent);
}
