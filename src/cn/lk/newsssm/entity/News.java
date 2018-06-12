package cn.lk.newsssm.entity;

import java.util.Date;

public class News {
	private Integer id;
	private String title;
	private String content;
	private Date tjdate;
	private String cruser;
	private Integer hitnum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getTjdate() {
		return tjdate;
	}
	public void setTjdate(Date tjdate) {
		this.tjdate = tjdate;
	}
	public String getCruser() {
		return cruser;
	}
	public void setCruser(String cruser) {
		this.cruser = cruser;
	}
	public Integer getHitnum() {
		return hitnum;
	}
	public void setHitnum(Integer hitnum) {
		this.hitnum = hitnum;
	}
	
	
	
}
