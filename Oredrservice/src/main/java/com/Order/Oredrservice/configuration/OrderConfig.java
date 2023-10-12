package com.Order.Oredrservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class OrderConfig {

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }

}
