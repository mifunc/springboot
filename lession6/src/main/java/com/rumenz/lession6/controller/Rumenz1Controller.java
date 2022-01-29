package com.rumenz.lession6.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: Rumenz1Controller
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/5
 **/
@RestController
@RequestMapping("/rumenz")
@PropertySource(value="classpath:rumenz.properties",encoding = "utf-8")
//加载多个自定义配置文件
/*
@PropertySource(value = {
        "classpath:rumenz.properties",
        "classpath:rumenz2.properties",
}, encoding = "utf-8")
**/
public class Rumenz1Controller {

    @Value("${com.rumenz.tag}")
    private String rumenzTag;

    @Value("${com.rumenz.txt}")
    private String rumenzTxt;

    @RequestMapping("/index3")
    public String index3(){
        //这是自定义配置中配置的属性
        return rumenzTag+rumenzTxt;
    }
}
