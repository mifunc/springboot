package com.rumenz.lession10.controller.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RumenzConfig
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/14
 **/

@Slf4j
@Configuration
public class RumenzConfig {

    @Bean
    public User user(){
        log.info("这是info级别日志");
        return new User(1, "rumenz.com");
    }

}
@Data
@AllArgsConstructor
class User{
    private Integer id;
    private String  name;

}