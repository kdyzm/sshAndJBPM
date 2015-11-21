package com.kdyzm.domain;
/**
 * 对应着审批意见表
 * @author kdyzm
 *
 */
public class Approve {
	private String approveId;		//标识id
	private String approveName;		//审批人
	private String approveDate;		//审批日期
	private String isApprove;		//是否同意
	private Form form;				//一个申请表单对应着多次审批的过程
/*********************************************************************/
	public String getApproveId() {
		return approveId;
	}
	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}
	public String getApproveName() {
		return approveName;
	}
	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}
	public String getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}
	public String getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
}
