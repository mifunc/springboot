package com.rumenz.lession7.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/6
 **/

@Controller
@RequestMapping("/rumenz")
@ConfigurationProperties(prefix = "com.rumenz")
public class RumenzController {

    @Value("${com.rumenz.random}")
    private String random;

    @Value("${com.rumenz.num}")
    private Integer num;

    @Value("${com.rumenz.long.val}")
    private Long longVal;

    @Value("${com.rumenz.uuid}")
    private String uuid;

    @Value("${com.rumenz.range}")
    private Integer range;


    //下标配置的数组值注入
    private List<Integer> id;

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    //逗号分隔
    @Value("#{'${com.rumenz.uid}'.split(',')}")
    private List<Integer> uidList;


    //注入map
    @Value("#{${com.rumenz.map}}")
    private Map<String,String> map;



    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        //配置文件中的随机值
        String res=String.format("random %s num %d longVal %d uuid %s range %d",random,num,longVal,uuid,range);
        return res;
    }

    @RequestMapping("/index1")
    @ResponseBody
    public String index1(){
        //配置文件中的随机值
        return getId().toString();
    }

    @RequestMapping("/index2")
    @ResponseBody
    public String index2(){
        //配置文件中的随机值
        return uidList.toString();
    }

    @RequestMapping("/index3")
    @ResponseBody
    public String index3(){
        //配置文件中的随机值
        return map.toString();
    }

}
