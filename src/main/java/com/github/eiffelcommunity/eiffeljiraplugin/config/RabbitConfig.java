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

package com.github.eiffelcommunity.eiffeljiraplugin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * Taking the ObjectMapper as a parameter because Jackson2JsonMessageConverter uses
     * its own internal ObjectMapper by default, NOT the one configured by spring boot.
     * Since adding @JsonInclude(Include = NON_ABSENT) gets ignored because of some unknown
     * quirks of the Immutables library, we rely on setting configuration of the global
     * default ObjectMapper that spring boot uses.
     */
    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, final ObjectMapper objectMapper) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
        rabbitTemplate.setConnectionFactory(connectionFactory);
        return rabbitTemplate;
    }
}
