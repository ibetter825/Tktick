package com.tktick.controller.web;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tktick.Application;
import com.tktick.bean.entity.TkArticle;
import com.tktick.service.TkArticleService;
import com.tktick.utils.DateUtil;

/**
 * 文章类
 * @author user
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = Application.class) // 指定SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestArticleController{
	
	private MockMvc mvc;
	@Autowired  
    private WebApplicationContext webApplicationConnect;
	@Autowired
	private TkArticleService articleService;
	@Before  
    public void setUp() throws JsonProcessingException {  
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }  
	
	@Test
	public void testSave() throws Exception {
		String expectedResult = "hello world!";  
        String uri = "/art/save.json";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))  
                .andReturn();  
        int status = mvcResult.getResponse().getStatus();  
        String content = mvcResult.getResponse().getContentAsString();  
  
        Assert.assertTrue("错误，正确的返回值为200", status == 200);  
        Assert.assertFalse("错误，正确的返回值为200", status != 200);  
        Assert.assertTrue("数据一致", expectedResult.equals(content));  
        Assert.assertFalse("数据不一致", !expectedResult.equals(content));
	}
}
