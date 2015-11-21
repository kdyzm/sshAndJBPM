package com.kdyzm.domain;

import org.jbpm.api.task.Task;
/**
 * 该类使用于进行查询所有当前任务列表信息的类
 * @author kdyzm
 *
 */
public class TaskView {
	private Task task;
	private Form form;
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	
}
