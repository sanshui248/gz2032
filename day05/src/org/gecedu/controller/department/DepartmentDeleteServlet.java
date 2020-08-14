package org.gecedu.controller.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.DepartmentDao;
import org.gecedu.dao.impl.DepartmentDaoImpl;

@WebServlet("/department/delete")
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//调用dao去删除
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		departmentDao.deleteById(Integer.parseInt(id));
		//重定向到用户列表
		response.sendRedirect(request.getContextPath()+"/department/list");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
