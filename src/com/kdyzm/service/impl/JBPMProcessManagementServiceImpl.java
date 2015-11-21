package com.kdyzm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.kdyzm.dao.FormDao;
import com.kdyzm.domain.Form;
import com.kdyzm.domain.User;
import com.kdyzm.service.JBPMProcessManagementService;
@Service("jbpmProcessManagementService")
public class JBPMProcessManagementServiceImpl implements JBPMProcessManagementService{
	//根据key值开启流程实例
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	@Resource(name="formDao")
	private FormDao<Form> formDao;
	/**
	 * 完成开启流程实例的关键的地方就是将form变量绑定到流程实例
	 */
	@Override
	public void startProcessByKey(String processKey,Form form) {
		//在开启流程实例的时候将form对象绑定到流程实例上
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("form", form);
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		variables.put("shenqingren", user.getUserName());
		ProcessInstance processInstance=processEngine.getExecutionService()
		.startProcessInstanceByKey(processKey,variables);
		
		//下一步完成任务，也就是说自己批准自己申请的那一步骤
		Task task=this.processEngine
		.getTaskService()
		.createTaskQuery()
		.executionId(processInstance.getId())		//根据流程实例id获取为一个的一个Task对象
		.uniqueResult();
		
		form.setProcessId(processInstance.getId());			//将form对象和p流程实例对象绑定在一起
		formDao.updateEntry(form);
		//完成任务
		this.processEngine.getTaskService()
		.completeTask(task.getId());
	}
}
