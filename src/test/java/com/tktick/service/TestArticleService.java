package com.tktick.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.tktick.Application;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.mapper.TkArticleMapper;

/**
 * 文章类
 * @author user
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = Application.class) // 指定SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@Service
public class TestArticleService{
	
	@Autowired
	private TkArticleMapper articleDao;
	
	@Test
	public void saveArticle() {
		TkArticle article = null;
		System.err.println("test service");
	}
}
