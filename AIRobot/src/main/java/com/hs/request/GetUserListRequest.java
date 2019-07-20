package com.hs.request;

import com.hs.util.Constants;

public class GetUserListRequest extends BaseRequest {

	private static final long serialVersionUID = -4104200949995035014L;
	
	private Integer start;
	private Integer pageSize = Constants.PAGE_SIZE;
	
	public Integer getStart() {
	
		return start;
	}
	public void setStart(Integer start) {
	
		this.start = start;
	}
	public Integer getPageSize() {
	
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
	
		this.pageSize = pageSize;
	}
	
}

	