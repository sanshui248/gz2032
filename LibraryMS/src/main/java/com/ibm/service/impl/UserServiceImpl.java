package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.mapper.UserMapper;
import com.ibm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserByName(String name) {
		User user = this.userMapper.getUserByName(name);
		if (user!=null) {
			return user;
		}
		return null;
	}
	
	@Override
	public void saveUser(User user) {
		this.userMapper.saveUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}

	@Override
	public List<User> selectUserListByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> selectUserByPage = this.userMapper.selectAllUser();
		return selectUserByPage;
	}
	
	@Override
	public List<BorrowingDetails> selectBorrowingDetailsByUserId(int userId) {
		List<BorrowingDetails> borrowHistory = this.userMapper.selectBorrowingDetailsByUserId(userId);
		return borrowHistory;
	}

	@Override
	public void deleteUser(int userId) {
		this.userMapper.deleteUser(userId);
		
	}

	@Override
	public List<User> selectUserListByVagueName(String vageName) {
		List<User> selectUserListByVagueName = this.userMapper.selectUserListByVagueName(vageName);
		return selectUserListByVagueName;
	}

	@Override
	public List<User> selectAllUser() {
		List<User> selectAllUser = this.userMapper.selectAllUser();
		return selectAllUser;
	}

}
