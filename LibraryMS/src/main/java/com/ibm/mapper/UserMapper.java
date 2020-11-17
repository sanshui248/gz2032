package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;

public interface UserMapper {
	public void saveUser(User user);//保存用户
	
	public void updateUser(User user);//更新用户
	
	public List<User> selectAllUser();//查询所有用户
	
	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int id);//查询用户借阅详情
}
