package org.tartea.study.controller;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class RibbonControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    private void setUp() {
        //使用上下文构建MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void restByIp() throws Exception {

        //执行请求（使用GET请求，RESTful接口）
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/restByIp").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //获取返回编码
        int status = mvcResult.getResponse().getStatus();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回编码是否正确
        Assert.assertEquals("this is IP Access   this is a rest server", content);


    }

    @Test
    void restByLoadBalancing() throws Exception {

         //执行请求（使用GET请求，RESTful接口）
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/restByLoadBalancing").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //获取返回编码
        int status = mvcResult.getResponse().getStatus();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回编码是否正确
        Assert.assertEquals("this is load balancing   this is a rest server", content);

    }
}