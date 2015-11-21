package com.kdyzm.service;

import com.kdyzm.domain.Form;

/**
 * 管理流程控制
 * @author kdyzm
 *
 */
public interface JBPMProcessManagementService {

	void startProcessByKey(String processKey, Form form);

}
