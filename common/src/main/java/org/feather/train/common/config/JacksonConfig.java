/*
package org.feather.train.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
*/
/**
 * @projectName: train
 * @package: org.feather.train.common.config
 * @className: JacksonConfig
 * @author: feather
 * @description: TODO
 * @since: 2023-07-08 9:52
 * @version: 1.0
 *//*


public class JacksonConfig {
    @Bean
     public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
         ObjectMapper objectMapper = builder.createXmlMapper(false).build();
         SimpleModule simpleModule = new SimpleModule();
         simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
         objectMapper.registerModule(simpleModule);
         return objectMapper;
     }
}
*/
