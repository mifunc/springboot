package com.rumenz.lession5.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: AnnotationConfiguration
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/

@Configuration
public class AnnotationConfiguration {
    @Bean
    public String index12(){
        return "@Bean注解返回";
    }
}
