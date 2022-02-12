package com.rumenz.lession8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/8
 **/
@Controller
@RequestMapping("/rumenz")
public class RumenzController {

    @Value("${com.rumenz.idname}")
    private String comRumenzIdName;


    //application.properties中配置项的优先级
    @Value("${com.rumenz.level}")
    private String comRumenzLevel;


    //读取系统环境变量
    @Value("${PATH}")
    private String path;


    //VM arguments 配置
    @Value("${spring.test.env}")
    private String springTestEnv;




    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return comRumenzIdName;
    }

    @RequestMapping("/index1")
    @ResponseBody
    public String index1(){
        return comRumenzLevel;
    }

    @RequestMapping("/index2")
    @ResponseBody
    public String index2(){
        return path;
    }

    @RequestMapping("/index3")
    @ResponseBody
    public String index3(){
        return springTestEnv;
    }

}
