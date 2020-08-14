package org.gecedu.controller.department;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.bean.PageInfo2;
import org.gecedu.dao.DepartmentDao;
import org.gecedu.dao.impl.DepartmentDaoImpl;

@WebServlet("/department/list")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*DepartmentDao departmentdao1 = new DepartmentDaoImpl();
        for(int i=1;i<=150;i++) {
        	Department department = new Department();
			department.setId(i);
			department.setParent_id(i-1);
			department.setName("部门"+i);
        	departmentdao1.save(department);
        }  */
		
		Integer currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr != null&& currentPageStr.trim() !="")
		{
			currentPage = Integer.parseInt(currentPageStr);
		}
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		
		//放到HttpServletREquest里面
		PageInfo2 pageInfo2 = departmentDao.queryByPages(currentPage);
		request.setAttribute("pageInfo2", pageInfo2);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/WEB-INF/pages/department/list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
