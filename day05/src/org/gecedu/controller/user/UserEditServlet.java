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

@WebServlet("/user/edit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//更具ID获取对应记录
		UserDao userDao = new UserDaoImpl();
		User user =  userDao.queryById(Integer.parseInt(id));
		
		//把查询出来的数据放到请求域里面
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/pages/user/edit.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
