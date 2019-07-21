package com.hs.request;

import com.hs.model.User;

public class AddUserRequest extends BaseRequest {

	private static final long serialVersionUID = -1589261307930377176L;
	private User user;//用户

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AddUserRequest [user=" + user + "]";
	}

}
