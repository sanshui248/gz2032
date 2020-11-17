package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.domain.User;
import com.ibm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(User user) {
		this.userService.saveUser(user);
		return "插入成功";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		this.userService.saveUser(user);
		return "更新成功";
	}
	
	@RequestMapping("/selectUser")
	@ResponseBody
	public List<User> selectUserListByPage(int pageNum,int pageSize) {
		List<User> selectUserListByPage = this.userService.selectUserListByPage(pageNum, pageSize);
		//
		return selectUserListByPage;
	}
	//以上需在user中加一个birthdayString字段
}
