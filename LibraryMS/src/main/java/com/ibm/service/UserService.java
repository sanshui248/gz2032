package com.ibm.service;

import java.util.List;

import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.vo.MyBookShelves;

public interface UserService {
	public User getUserByName(String name);

	public void saveUser(User user);

	public void updateUser(User user);

	public List<User> selectUserListByPage(int pageNum, int pageSize);

	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int userId);

	public void deleteUser(int userId);

	public List<User> selectUserListByVagueName(String vageName);

	public List<User> selectAllUser();

	public User getUserById(int id);

	public void updatePasswordByUserId(String password, int userId);

	public List<MyBookShelves> selectShelves(int userId);
	
	public int getUserId();
}
