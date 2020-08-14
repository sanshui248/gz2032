package org.gecedu.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.UserDao;
import org.gecedu.dao.impl.UserDaoImpl;
import org.gecedu.model.User;

@WebServlet("/user/save")
public class UserSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数前进行转码来解决乱码问题
		request.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-Type", "text/html;charset = utf-8");
	    //response.setContentType("text/html;charset = utf-8");
		//获取用户参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//保存到数据库里面
		UserDao userDao = new UserDaoImpl();
		User user =  new User(Integer.parseInt(id),name,Integer.parseInt(age),null,account,password);
		userDao.update(user);
		
		//回到用户裂变页面
		//1、需不需要带数据到这个页面
		//2、需不需要地址栏变化(转发地址栏不变）
		response.sendRedirect(request.getContextPath()+"/user/list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
