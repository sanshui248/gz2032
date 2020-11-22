package com.ibm.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/login")
	public User login(int id,String password,HttpSession session) {
		//根据用户id获取用户
		User user = this.userService.getUserById(id);
		if (user!=null) {
			Md5Hash md5Hash = new Md5Hash(password,"salt");
			if (md5Hash.toString().equals(user.getPassword())) {
				user.setPassword(password);
			}
			session.setAttribute("user", user);
		}
        return user;
        
	}
	
	@RequestMapping("/logout")
    public void logout(HttpSession session) {
    	session.invalidate();
    }
}
