package com.hs.request;

import com.hs.util.Constants;

public class GetUserListRequest extends BaseRequest {

	private static final long serialVersionUID = -4104200949995035014L;

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

	@Override
	public String toString() {
		return "GetUserListRequest [page=" + page + ", limit=" + limit + "]";
	}

}
