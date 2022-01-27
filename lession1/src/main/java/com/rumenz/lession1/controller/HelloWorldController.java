package com.rumenz.lession1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloWorldController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/10/31
 **/
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String index(){
        return "Hello World 入门小站";
    }

}