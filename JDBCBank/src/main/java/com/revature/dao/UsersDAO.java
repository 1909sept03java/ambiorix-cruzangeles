package com.revature.dao;

import java.util.List;

import com.revature.beans.Users;

public interface UsersDAO {

	public List<Users> getUsers();
	public void deposit();
	public void withdraw();
	
}
