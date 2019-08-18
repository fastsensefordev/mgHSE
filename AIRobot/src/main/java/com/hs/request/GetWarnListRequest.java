package com.hs.request;

import com.hs.util.Constants;

public class GetWarnListRequest {

	private Integer page;
	private Integer limit = Constants.PAGE_SIZE;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}

	