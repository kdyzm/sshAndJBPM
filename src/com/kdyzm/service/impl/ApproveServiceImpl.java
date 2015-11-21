package com.kdyzm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.kdyzm.domain.Form;
import com.kdyzm.domain.TaskView;
import com.kdyzm.domain.User;
import com.kdyzm.service.ApproveService;
@Service("approveService")
public class ApproveServiceImpl implements ApproveService{
	
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	//查询当前所有任务列表的方法
	@Override
	public Collection<TaskView> getAllTaskViews() {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//首先查找到当前用户的的所有任务列表
		List<Task> tasks=this.processEngine
		.getTaskService()
		.createTaskQuery()
		.assignee(user.getUserName())
		.list();
		List<TaskView>taskViews=new ArrayList<TaskView>();
		//根据任务列表信息
		for(Task task:tasks){
			TaskView taskView=new TaskView();
			Form form=(Form) this.processEngine.getExecutionService().getVariable(task.getExecutionId(), "form");
			taskView.setForm(form);
			taskView.setTask(task);
			taskViews.add(taskView);
		}
		return taskViews;
	}

}
