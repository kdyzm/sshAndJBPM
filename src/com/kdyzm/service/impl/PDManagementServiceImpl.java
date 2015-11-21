package com.kdyzm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.Deployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import com.kdyzm.service.PDManagementService;

@Service("pdManagementService")
public class PDManagementServiceImpl implements PDManagementService{
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	/**
	 * 部署新流程
	 */
	@Override
	public void deploy(File file) throws FileNotFoundException {
		InputStream is=new FileInputStream(file);
		ZipInputStream zipInputStream = new ZipInputStream(is);
		processEngine.getRepositoryService()
		.createDeployment()
		.addResourcesFromZipInputStream(zipInputStream)
		.deploy();
	}
	/**
	 * 这里使用了较之前比较特殊的API
	 */
	//TODO 查找最高版本的方法是亮点
	@Override
	public Set<ProcessDefinition> listAllPDs() {
		List<ProcessDefinition> processDefinitions=processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)	//根据Version进行升序排序
		.list();
		Map<String,ProcessDefinition> map=new HashMap<String,ProcessDefinition>();
		for(ProcessDefinition processDefinition:processDefinitions){
			map.put(processDefinition.getKey(), processDefinition);
			System.out.println(processDefinition.getId());
		}
		Set<ProcessDefinition> processDefinitions2=new HashSet<ProcessDefinition>(map.values());
		return processDefinitions2;
	}
	@Override
	public InputStream getImageInputStreamByPDID(String processId) {
		ProcessDefinition processDefinition=this.processEngine
				.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionId(processId)
				.uniqueResult();
		return processEngine.getRepositoryService().getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getImageResourceName());
	}
	/**
	 * 根据key值删除所有的流程部署
	 * 方法是现根据key值获取所有的流程定义列表
	 * 然后根据流程定义列表找到对应的流程部署并删除之
	 */
	@Override
	public void deleteByProcessKey(String processKey) {
				List<ProcessDefinition> processDefinitions=this.processEngine
				.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionKey(processKey)
				.list();
				
				for(ProcessDefinition processDefinition:processDefinitions){
					processEngine.getRepositoryService()
					.deleteDeploymentCascade(processDefinition.getDeploymentId());
				}
	}
}
