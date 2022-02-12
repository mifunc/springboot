package com.rumenz.lession10.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/11
 **/


@Slf4j //lombok 提供的注解
@RestController
@RequestMapping("/rumenz")
public class RumenzController {

    //如果不使用lombok就需要用以下代码获取日志操作对象
    //Logger log = LoggerFactory.getLogger(RumenzController.class);

    @GetMapping("/index")
    public String index(){

        log.trace("Trace 日志...");
        log.debug("Debug 日志...");
        log.info("Info 日志...");
        log.warn("Warn 日志...");
        log.error("Error 日志...");

        return "入门小站";
    }
}
