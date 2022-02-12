package com.rumenz.lession9.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: Swagger2Config
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/10
 **/

@Configuration
//@EnableSwagger2 //Swagger2 3.0以下版本需要开启的注解,Swagger2 3.0以上版本不用这个注解
public class Swagger2Config {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要扫描的Controller包全路径
                .apis(RequestHandlerSelectors.basePackage("com.rumenz.lession9.controller"))
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo(){
        Contact contact=new Contact("入门小站", "https://rumenz.com", "xenry@163.com");
        return new ApiInfoBuilder()
                .title("入门小站接口文档")
                .description("https://rumenz.com")
                .contact(contact).build();
    }
}
