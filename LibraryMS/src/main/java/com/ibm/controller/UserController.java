package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.service.UserService;

/**
 * 
 * @author 吕守淼
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 保存用户
	 * @param user添加的用户
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(User user) {
		this.userService.saveUser(user);
		return "插入成功";
	}
	
	/**
	 * 更新用户
	 * @param user更新的用户
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		this.userService.updateUser(user);
		return "更新成功";
	}
	
	/**
	 * 查询用户
	 * @param pageNum页面号
	 * @param pageSize页面记录数
	 * @return
	 */
	@RequestMapping("/selectUser")
	@ResponseBody
	public List<User> selectUserListByPage(int pageNum,int pageSize) {
		List<User> selectUserListByPage = this.userService.selectUserListByPage(pageNum, pageSize);
		return selectUserListByPage;
	}
	
	/**
	 * 用户详情
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/selectBorrowHistory")
	@ResponseBody
	public List<BorrowingDetails> selectBorrowHistory(int userId) {
		List<BorrowingDetails> selectBorrowHistory = this.userService.selectBorrowingDetailsByUserId(userId);
		return selectBorrowHistory;
	}
	
	/**
	 * 注销用户
	 * @param userId  用户id
	 * @return
	 */
	@RequestMapping("/deleteUser/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
		return "删除成功";
	} 
}
