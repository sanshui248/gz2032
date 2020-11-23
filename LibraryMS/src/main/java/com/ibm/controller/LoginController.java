package com.ibm.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.User;
import com.ibm.service.UserService;

/**
 * 
 * @author 吕守淼
 *
 * @date   2020-11-19 8:28:39
 * @Version 1.0
 */
@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	/**
	 *        登录
	 * @param id 登录账号
	 * @param password  登录名
	 * @param session
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/login")
	public User login(int id,String password,HttpSession session) {
		System.out.println(session.getId());
		//根据用户id获取用户
		User user = this.userService.getUserById(id);
		if (user!=null) {
			Md5Hash md5Hash = new Md5Hash(password,"salt");
			if (md5Hash.toString().equals(user.getPassword())) {
				user.setPassword(password);
				session.setAttribute("user", user);
			}
		}
        return user;
        
	}
	
	/**
	 * 	用户退出
	 * @param session
	 */
	@RequestMapping("/logout")
    public void logout(HttpSession session) {
    	session.invalidate();
    }
}
