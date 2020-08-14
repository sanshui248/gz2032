package org.gecedu.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/logout")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//娓呴櫎鐧诲綍鐘舵��
		request.getSession().removeAttribute("loginUser");
		//閲嶅畾鍚戝洖鐧诲綍椤甸潰
		response.sendRedirect(request.getContextPath()+"/login.jsp");
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
