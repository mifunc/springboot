package com.rumenz.lession5.controller.component;

import org.springframework.stereotype.Component;

/**
 * @className: AnnotationComponent
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/
@Component
public class AnnotationComponent {

    public String index11(){
        return "@Component组件返回";
    }
}
