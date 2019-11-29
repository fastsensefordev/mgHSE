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
	/**
	 * 模板名称
	 */
	private String templateName;
	/**
	 * 模板链接
	 */
	private String href;
	/**
	 * 框架中心图片地址
	 */
	private String imgUrl;
	/**
	 * 报警的算法id
	 */
	private String alarmId;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 关联tbl_user表主键id
	 */
	private Integer userId;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 父节点id
	 */
	private Integer pid;
	/**
	 * 状态（0未删除,1删除）
	 */
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TemplateModel [id=" + id + ", templateName=" + templateName + ", href=" + href + ", imgUrl=" + imgUrl
				+ ", alarmId=" + alarmId + ", createTime=" + createTime + ", userId=" + userId + ", createUser="
				+ createUser + ", pid=" + pid + ", status=" + status + "]";
	}

}
