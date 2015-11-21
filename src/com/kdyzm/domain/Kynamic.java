package com.kdyzm.domain;

import java.util.Set;

/**
 * 对应着流程实例表
 * @author kdyzm
 *
 */
public class Kynamic {
	private String kid;		//唯一的标识号
	private String pid;		//流程实例标识号
	private String name;	//流程名称
	private Boolean isParent;	//是否是最终版本
	private Set<Version> versions;//对应着不同的版本
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Set<Version> getVersions() {
		return versions;
	}
	public void setVersions(Set<Version> versions) {
		this.versions = versions;
	}
}
