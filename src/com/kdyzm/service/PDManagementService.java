package com.kdyzm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Set;

import org.jbpm.api.ProcessDefinition;

public interface PDManagementService {

	void deploy(File file) throws FileNotFoundException;
	/**
	 * 列出所有的流程定义
	 */
	Set<ProcessDefinition> listAllPDs();
	InputStream getImageInputStreamByPDID(String processId);
	void deleteByProcessKey(String processKey);
}
