package org.gecedu.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.bean.PageInfo;
import org.gecedu.dao.UserDao;
import org.gecedu.dao.impl.UserDaoImpl;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*UserDao userdao1 = new UserDaoImpl();
        for(int i=8;i<=250;i++) {
        	User user = new User();
        	user.setId(i);
        	user.setName("老王"+i);
        	user.setAge(i+10);
        	user.setRegisterTime(new Date(System.currentTimeMillis()));
        	user.setAccount("admin"+i);
        	user.setPassword("123456");
        	userdao1.save(user);
        }*/
		
		Integer currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr != null&& currentPageStr.trim() !="")
		{
			currentPage = Integer.parseInt(currentPageStr);
		}
		UserDao userDao = new UserDaoImpl();
		
		//放到HttpServletREquest里面
		PageInfo pageInfo = userDao.queryByPages(currentPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/WEB-INF/pages/user/list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
