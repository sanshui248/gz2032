package com.ibm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.domain.User;

/**
 * 
 * @author 吕守淼
 *
 * @date   2020-11-19 8:28:39
 * @Version 1.0
 */
@Controller
public class LoginController {
	
	@RequestMapping("/toLogin")
	public String tologin() {
	//System.out.println("123");
		return "login";
	}
	@RequestMapping("/toIndex")
	public String toIndex() {
		System.out.println("index");
		return "index";
	}
	@RequestMapping("/toError")
	public String toError() {
		return "error";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(User user) {
		//用户认证信息
		System.out.println("login");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPassword());
		try {
			//进行验证
			subject.login(usernamePasswordToken);
			
		} catch (UnknownAccountException e) {
           // log.error("用户名不存在！", e);
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            return "没有权限";
        }
        return "login success";
		//return "/login";
        
        
	}
	
	@RequestMapping("/tes")
    @ResponseBody
    public String test() {
    	return "ahahhaha";
    }
}
