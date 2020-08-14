package org.gecedu.controller.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.DepartmentDao;
import org.gecedu.dao.impl.DepartmentDaoImpl;
import org.gecedu.model.Department;

@WebServlet("/department/edit")
public class DepartmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		List<Department> list = departmentDao.queryAll();
		Department department = departmentDao.queryById(Integer.parseInt(id));
		
		//把查询出来的数据放到请求域里面
		
		request.setAttribute("list",list);
		request.setAttribute("department", department);
		request.getRequestDispatcher("/WEB-INF/pages/department/edit.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
