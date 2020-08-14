package org.gecedu.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.UserDao;
import org.gecedu.dao.impl.UserDaoImpl;

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//调用dao去删除
		UserDao userDao = new UserDaoImpl();
		userDao.deleteById(Integer.parseInt(id));
		//重定向到用户列表
		response.sendRedirect(request.getContextPath()+"/user/list");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
