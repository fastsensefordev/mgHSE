package com.hs.model;

/**
 * @desc: 模板实体类
 * @author: kpchen
 * @createTime: 2019年7月28日 上午10:05:51
 * @history:
 * @version: v1.0
 */
public class TemplateModel {

	private Integer id;
	private String templateName;
	private String href;
	private String createTime;
	private Integer userId;
	private String createUser;
	private Integer pid;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "TemplateModel [id=" + id + ", templateName=" + templateName + ", href=" + href + ", createTime="
				+ createTime + ", userId=" + userId + ", createUser=" + createUser + ", pid=" + pid + ", status="
				+ status + "]";
	}

}
