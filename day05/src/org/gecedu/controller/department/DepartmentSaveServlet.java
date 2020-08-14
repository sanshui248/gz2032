package org.gecedu.controller.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.DepartmentDao;
import org.gecedu.dao.impl.DepartmentDaoImpl;
import org.gecedu.model.Department;

@WebServlet("/department/save")
public class DepartmentSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取参数前进行转码来解决乱码问题
		request.setCharacterEncoding("UTF-8");
		
			//获取用户参数
			String id = request.getParameter("id");
			String parent_id = request.getParameter("parent_id");
			String name = request.getParameter("name");
			String order_num = request.getParameter("order_num");
			
			//保存到数据库里面
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			Department department =  new Department(Integer.getInteger(id),Integer.parseInt(parent_id),name,Integer.parseInt(order_num));
			departmentDao.save(department);
		
	
		response.sendRedirect(request.getContextPath()+"/department/list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
