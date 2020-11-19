package com.ibm.service;

import java.util.List;

import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;

public interface UserService {
	public User getUserByName(String name);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public List<User> selectUserListByPage(int pageNum,int pageSize);
	
	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int userId);

	public void deleteUser(int userId);

	public List<User> selectUserListByVagueName(String vageName);
}
