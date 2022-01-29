package com.rumenz.lession6.controller;

import com.rumenz.lession6.controller.config.RumenzConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/

@RestController
@RequestMapping("/rumenz")
public class RumenzController {


     @Value("${rumenz.name}")
     private String rumenzName;

     @Value("${rumenz.url}")
     private String rumenzUrl;

     @Value("${com.rumenz.des}")
     private String rumenzDes;

     @RequestMapping("/index")
     public String index(){
          return rumenzName+":::"+rumenzUrl;
     }

     @Autowired
     RumenzConfig rumenzConfig;


     @RequestMapping("/index1")
     public String index1(){

          return rumenzConfig.getId()+":::"+rumenzConfig.getName();
     }

     @RequestMapping("/index2")
     public String index2(){
          //配置文件参数引用
          //com.rumenz.des=${com.rumenz.name}${com.rumenz.id}
          return rumenzDes;
     }
}
