package com.rumenz.lession11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/29
 **/

@Slf4j
@RestController
@RequestMapping("/rumenz")
public class RumenzController {

    @GetMapping("/index")
    public String index(){
        log.debug("请求首页");
        return "rumenz.com入门小站";
    }
}
