package com.nhn.user;

public class UserService {

	private UserAdmin admin;
	
	public void add(String userName) {
	    admin.addUser(userName);
	}
}
