package com.hs.request;

import java.util.List;

public class DeptRequest {

	private String title;//节点标题
	private Integer id;//节点索引
	private List<DeptRequest> children;//子节点
	private Boolean spread;//是否展开
	private Boolean checked;//是否选中
	private Boolean disabled;//是否禁用
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<DeptRequest> getChildren() {
		return children;
	}
	public void setChildren(List<DeptRequest> children) {
		this.children = children;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	

}

