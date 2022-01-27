package com.rumenz.lession4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: FreeMarkerRumenController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/1
 **/

@Controller
@RequestMapping("/")
public class FreeMarkerRumenController {

    @RequestMapping("/index2")
    public String index2(ModelMap m){
        //数据也可以从数据库查询出来返回
        m.addAttribute("name", "入门小站");
        m.addAttribute("url", "https://rumenz.com");
        //返回是一个页码:src/main/resources/templates/freemarker.html
        return "freemarker";

    }
}
