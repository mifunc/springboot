package com.rumenz.lession6.controller.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @className: RumenzConfig
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/5
 **/
@Component
@ConfigurationProperties(prefix = "com.rumenz")
public class RumenzConfig {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
