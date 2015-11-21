package com.kdyzm.test;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.api.ProcessEngine;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JbpmTest {
	private static ApplicationContext applicationContext;
	static{
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	@Test
	public void testDeploy(){
		ProcessEngine processEngine=(ProcessEngine) applicationContext.getBean("processEngine");
		processEngine.getRepositoryService()
		.createDeployment()
		.addResourceFromClasspath("qingjia.jpdl.xml")
		.addResourceFromClasspath("qingjia.png")
		.deploy();
	}
	@Test
	public void testStart(){
		ProcessEngine processEngine=(ProcessEngine) applicationContext.getBean("processEngine");
		Map<String,String>variables=new HashMap<String,String>();
		variables.put("shenqingren", "张三");
		processEngine.getExecutionService()
		.startProcessInstanceByKey("qingjia",variables);
	}
	
	@Test
	public void testCompleteTask(){
		ProcessEngine processEngine=(ProcessEngine) applicationContext.getBean("processEngine");
		processEngine.getTaskService()
		.completeTask("60001");
	}
}
