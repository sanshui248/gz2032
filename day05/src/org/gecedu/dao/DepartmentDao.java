package org.gecedu.dao;

import java.util.List;

import org.gecedu.bean.PageInfo2;
import org.gecedu.model.Department;

public interface DepartmentDao {

	void save(Department department );
	
	void update(Department department );
	
	void deleteById(Integer id );
	
	Department queryById(Integer id);
	
	public List<Department> queryAll();
	
	PageInfo2 queryByPages(Integer currentPage);
	
	Department queryByAccountAndPwd(String account, String password);
}
