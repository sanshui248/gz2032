package org.gecedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.gecedu.bean.PageInfo2;
import org.gecedu.dao.DepartmentDao;
import org.gecedu.model.Department;
import org.gecedu.utils.JdbcUtils;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void save(Department department) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			//閫氳繃杩炴帴鑾峰彇prepareStatement
			String sql = "insert into user (parent_id,name,order_num) value(?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			//缁欏崰浣嶇璁惧��
			//prepareStatement.setInt(1, department.getId());
			prepareStatement.setInt(1, department.getParent_id());
			prepareStatement.setString(2, department.getName());
			prepareStatement.setInt(3,department.getOrder_num());
			//鎵цsql
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		
	}

	@Override
	public void update(Department department) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "update user set parent_id=?,name=?,order_num=? where id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, department.getParent_id());
			prepareStatement.setString(2, department.getName());
			prepareStatement.setInt(3, department.getOrder_num());
			prepareStatement.setInt(5, department.getId());
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department queryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> queryAll() {
		List<Department> list = new ArrayList<Department>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from department";
			prepareStatement = connection.prepareStatement(sql);
			ResultSet resultset = prepareStatement.executeQuery();
			//浠庣粨鏋滈泦閲岄潰鎷挎暟鎹�
			while(resultset.next()) {
				String name = resultset.getString("name");
				int id = resultset.getInt("id");
				int parent_id = resultset.getInt("parent_id");
				int order_num = resultset.getInt("order_num");
				//String parentName = resultset.getString("parentName");
				Department department = new Department(id, parent_id,name,order_num);
				//department.setParentName(parentName);
				list.add(department);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return list;
	}

	@SuppressWarnings("resource")
	@Override
	public PageInfo2 queryByPages(Integer currentPage) {
		List<Department> list = new ArrayList<Department>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select d1.*,d2.name as parentName from department d1 LEFT JOIN department d2 on d1.parent_id=d2.id LIMIT ?,?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, (currentPage-1)*8);
			prepareStatement.setInt(2,8);
			ResultSet resultset = prepareStatement.executeQuery();
			//浠庣粨鏋滈泦閲岄潰鎷挎暟鎹�
			while(resultset.next()) {
				String name = resultset.getString("name");
				int parent_id = resultset.getInt("parent_id");
				String parentName = resultset.getString("parentName");
				int id = resultset.getInt("id");
				int order_num = resultset.getInt("order_num");
				Department department = new Department(id,parent_id, name,order_num);
				department.setParentName(parentName);
				list.add(department);
			}
			
			
			//鏌ヨ鎬昏褰曟暟
			String countSql = "select count(id) as totalRecord from department";
			prepareStatement = connection.prepareStatement(countSql);
			resultset = prepareStatement.executeQuery();
			long total =8L;
			if(resultset.next()) {
				total = resultset.getLong("totalRecord");
			}
			PageInfo2 pageInfo2 = new PageInfo2(currentPage,list,total);
			return pageInfo2;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

	@Override
	public Department queryByAccountAndPwd(String account, String password) {
		
		return null;
	}

}
