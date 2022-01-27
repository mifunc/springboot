package com.rumenz.lession2;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @className: HelloWorldTestHelloWorld
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/10/31
 **/

@WebMvcTest
public class HelloWorldTest2HelloWorld {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("入门小站")));

    }
}
