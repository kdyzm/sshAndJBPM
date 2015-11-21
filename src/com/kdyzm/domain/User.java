package com.kdyzm.domain;
/**
 * 对应着用户表
 * @author kdyzm
 *	为了方便起见，这里的用户和岗位之间是多对一的关系
 */
public class User {
	private String uid;			//用户唯一标识id		
	private String userName;	//用户名
	private String password;	//密码
	private Post post;			//用户所属岗位
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
