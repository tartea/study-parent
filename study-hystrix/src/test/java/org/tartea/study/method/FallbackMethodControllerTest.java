package org.tartea.study.method;

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

@SpringBootTest
@RunWith(SpringRunner.class)
class FallbackMethodControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    private void setUp() {
        //使用上下文构建MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void getUserName() throws Exception {
        //执行请求（使用GET请求，RESTful接口）
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUserName").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //获取返回编码
        int status = mvcResult.getResponse().getStatus();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回编码是否正确
        Assert.assertEquals("this is method", content);

    }

    @Test
    void getUserNameFallBack() throws Exception {

        //请求时间为3秒钟，没有超时
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUserNameFallBack").param("timeout","3000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //获取返回编码
        int status = mvcResult.getResponse().getStatus();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回编码是否正确
        Assert.assertEquals("this is a success method", content);
    }
    @Test
    void getUserNameFallBackTimeOut() throws Exception {

        //请求时间为6秒钟，请求超时，走fall back method
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUserNameFallBack").param("timeout","6000").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //获取返回编码
        int status = mvcResult.getResponse().getStatus();
        //获取返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回编码是否正确
        Assert.assertEquals("this is a fallback method", content);
    }
}