package com.kdyzm.struts2.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.ProcessInstanceQuery;
import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kdyzm.domain.Form;
import com.kdyzm.domain.TaskView;
import com.kdyzm.service.ApproveService;
import com.kdyzm.service.FormService;
import com.kdyzm.service.PDManagementService;
import com.kdyzm.utils.FormState;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 该类是审批处理类
 * @author kdyzm
 *
 */
@SuppressWarnings("serial")
@Controller("approveAction")
@Scope("prototype")
public class ApproveAction extends ActionSupport{
	@Resource(name="pdManagementService")
	private PDManagementService pdManagementService;
	@Resource(name="approveService")
	private ApproveService approveService;
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	@Resource(name="formService")
	private FormService formService;
	private String message;
	private String fid;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//这两个方法写在这里并不合适
	public String toIndex() throws Exception{
		Set<ProcessDefinition> processDefinitions= pdManagementService.listAllPDs();
		ActionContext.getContext().put("processDefinitions", processDefinitions);
		return "index";
	}
	//这个方法写在这里也不合适
	public String createNewUI() throws Exception{
		return "addUI";
	}
	//显示所有的申请信息
	public String listAllApprvements() throws Exception{
		Collection<TaskView>taskViews=approveService.getAllTaskViews();
		ActionContext.getContext().put("taskViews", taskViews);
		return "listAllApprovements";
	}
	
	public String approveUI() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String taskId=request.getParameter("taskId");
		String fid=request.getParameter("fid");
		Task task=this.processEngine.getTaskService()
				.getTask(taskId);
		Form form=formService.getFormByFormId(fid);
		ActionContext.getContext().put("form", form);
		ActionContext.getContext().put("task", task);
		return "approveUI";
	}
	//完成任务的时候进行的动作
	/**
	 * 难点是怎么判断是否还有后续任务
	 * @return
	 * @throws Exception
	 */
	public String confirm() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String fid=request.getParameter("fid");
		String taskId=request.getParameter("taskId");
		String comment=request.getParameter("comment");
		Form form=formService.getFormByFormId(fid);
		Task task=processEngine.getTaskService().getTask(taskId);
		
		Map<String,String> variables=new HashMap<String,String>();
		variables.put("comment_"+task.getAssignee(), comment);
		processEngine.getTaskService().setVariables(taskId, variables);
		processEngine.getTaskService().completeTask(taskId);
		this.message="1";
		//怎么判断是否还有后续任务
		ExecutionService executionService=processEngine.getExecutionService();
		ProcessInstanceQuery processInstanceQuery=executionService.createProcessInstanceQuery();
		//这里根据form的processId来判断比较好
		ProcessInstanceQuery processInstanceQuery2=processInstanceQuery.processInstanceId(form.getProcessId());
		List<ProcessInstance> processInstances=processInstanceQuery2.list();
		System.out.println("得到的流程数量："+processInstances.size());
		if(this.processEngine.getExecutionService().createProcessInstanceQuery().processInstanceId(form.getProcessId()).uniqueResult()==null){
			form.setState(FormState.WANCHENGSHENQING);
			formService.updateForm(form);
		}
		return "ajax";
	}
	
	public String unConfirm() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String fid=request.getParameter("fid");
		String taskId=request.getParameter("taskId");
		String comment=request.getParameter("comment");
		Form form=formService.getFormByFormId(fid);
		Task task=processEngine.getTaskService().getTask(taskId);
		
		Map<String,String> variables=new HashMap<String,String>();
		variables.put("comment_"+task.getAssignee(), comment);
		processEngine.getExecutionService().endProcessInstance(task.getExecutionId(),comment);
		this.message="1";
		
		if(this.processEngine.getTaskService().getTask(taskId)==null){
			form.setState(FormState.JUJUESHENQING);
			formService.updateForm(form);
		}
		return "ajax";
	}
}
