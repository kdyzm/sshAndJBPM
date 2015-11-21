package com.kdyzm.domain;

import java.util.Set;

/**
 * 对应着岗位表
 * @author kdyzm
 *
 */
public class Post {
	private String pid;			//岗位的标识id
	private String pname;		//岗位名称
	private Set<User> users;	//对应着的员工
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
