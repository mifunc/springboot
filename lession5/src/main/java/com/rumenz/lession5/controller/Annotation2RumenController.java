package com.rumenz.lession5.controller;

import com.rumenz.lession5.controller.component.AnnotationComponent;
import com.rumenz.lession5.controller.entity.Rumenz;
import com.rumenz.lession5.controller.repository.RumenzRepository;
import com.rumenz.lession5.controller.service.AnnotationRumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @className: AnnotationRumenController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/2
 **/

@RestController
@RequestMapping("/rumenz")
public class Annotation2RumenController {


    @GetMapping("/index15")
    //等价于
    //@RequestMapping(value = "index15",method = RequestMethod.GET)
    //@ResponseBody
    public String index15(){
        return "GetMapping注解";
    }

    @PostMapping("/index16")
    //等价于
    //@RequestMapping(value = "index16",method = RequestMethod.POST)
    //@ResponseBody
    public String index16(){
        return "PostMapping注解";
    }



}
