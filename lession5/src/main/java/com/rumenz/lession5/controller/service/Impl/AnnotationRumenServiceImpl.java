package com.rumenz.lession5.controller.service.Impl;

import com.rumenz.lession5.controller.service.AnnotationRumenService;
import org.springframework.stereotype.Service;

/**
 * @className: AnnotationRumenServiceImpl
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/
@Service
public class AnnotationRumenServiceImpl implements AnnotationRumenService {
    @Override
    public String index10() {
        return  "这是一个服务器返回的数据";
    }
}
