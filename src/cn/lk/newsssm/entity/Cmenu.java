package cn.lk.newsssm.entity;


import java.io.Serializable;



public class Cmenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer pid;
	private String name;
	private String url;
	private String permission;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
