package com.mrcode.test;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");


	// 测试事务
	@Test
	public void testTransaction() throws Exception {
		/*TestService testService = (TestService) ac.getBean("testService");
		// testService.saveTwoUsers();
		testService.saveUsers25();*/
		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
	}
}
