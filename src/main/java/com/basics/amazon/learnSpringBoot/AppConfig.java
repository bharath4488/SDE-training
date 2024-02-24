package com.basics.amazon.learnSpringBoot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Logger logger() {
        return LogManager.getLogger();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
