package com.kdyzm.domain;
/**
 * 对应着版本表
 * @author kdyzm
 *
 */
public class Version {
	private String vid;				//版本表的唯一标识号
	private Long version;			//版本号
	private String updateTime;		//更新时间
	private String title;			//更新主题
	private String content;			//更新说明
	private Kynamic kynamic;		//对应的流程key
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Kynamic getKynamic() {
		return kynamic;
	}
	public void setKynamic(Kynamic kynamic) {
		this.kynamic = kynamic;
	}
}	
