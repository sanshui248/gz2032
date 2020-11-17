package com.ibm.service;

import java.util.List;

import com.ibm.domain.User;

public interface UserService {
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public List<User> selectUserListByPage(int pageNum,int pageSize);
}
