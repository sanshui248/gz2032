package org.gecedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.gecedu.bean.PageInfo;
import org.gecedu.dao.UserDao;
import org.gecedu.model.User;
import org.gecedu.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
//			// 娉ㄥ唽椹卞姩
//			Class.forName("com.mysql.jdbc.Driver");
//			//瀹氫箟杩炴帴鍙傛暟
//			String url = "jdbc:mysql://localhost:3306/wuyi";
//			String username = "root";
//			String password = "123456";
//			//鑾峰彇杩炴帴
//			connection = DriverManager.getConnection(url, username, password);
			
			
			connection = JdbcUtils.getConnection();
			//閫氳繃杩炴帴鑾峰彇prepareStatement
			String sql = "insert into user (id,name,age,register_time,account,password) value(?,?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			//缁欏崰浣嶇璁惧��
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setDate(4,new java.sql.Date(System.currentTimeMillis()));
			prepareStatement.setString(5, user.getAccount());
			prepareStatement.setString(6, user.getPassword());
			//鎵цsql
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		
	}

	@Override
	public void update(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "update user set name=?,age=?,account=?,password=? where id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setInt(2, user.getAge());
			prepareStatement.setString(3, user.getAccount());
			prepareStatement.setString(4, user.getPassword());
			prepareStatement.setInt(5, user.getId());
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
	}

	@Override
	public void deleteById(Integer id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "delete  from user where id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
	}

	@Override
	public User queryById(Integer id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user where id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultset = prepareStatement.executeQuery();

			if(resultset.next()) {
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				Date date = resultset.getDate("register_time");
				String account = resultset.getString("account");
				String password = resultset.getString("password");
				return new User(id, name, age,date,account,password);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user";
			prepareStatement = connection.prepareStatement(sql);
			ResultSet resultset = prepareStatement.executeQuery();

			while(resultset.next()) {
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				int id = resultset.getInt("id");
				Time time = resultset.getTime("register_time");
				String account = resultset.getString("account");
				String password = resultset.getString("password");
				User user = new User(id, name, age,new Date(time.getTime()),account,password);
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return list;
	}

	@Override
	public PageInfo queryByPages(Integer currentPage) {
		
		List<User> list = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user LIMIT ?,?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, (currentPage-1)*8);
			prepareStatement.setInt(2,8);
			ResultSet resultset = prepareStatement.executeQuery();

			while(resultset.next()) {
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				int id = resultset.getInt("id");
				Time time = resultset.getTime("register_time");
				String account = resultset.getString("account");
				String password = resultset.getString("password");
				User user = new User(id, name, age,new Date(time.getTime()),account,password);
				list.add(user);
			}
			
			String countSql = "select count(id) as totalRecord from user";
			PreparedStatement preparedStatement2 = connection.prepareStatement(countSql);
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			long total =8L;
			if(resultSet2.next()) {
				total = resultSet2.getLong("totalRecord");
			}
			PageInfo pageInfo = new PageInfo(currentPage,list,total);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

	@Override
	public User queryByAccountAndPwd(String account, String password) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user where account=? and password=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, account);
			prepareStatement.setString(2, password);
			ResultSet resultset = prepareStatement.executeQuery();
			//浠庣粨鏋滈泦閲岄潰鎷挎暟鎹�
			if(resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				Date date = resultset.getDate("register_time");
				//String account1 = resultset.getString("account");
				//String password1 = resultset.getString("password");
				return new User(id, name, age,date,account,password);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

}



