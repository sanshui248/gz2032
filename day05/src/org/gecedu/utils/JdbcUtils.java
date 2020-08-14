package org.gecedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * jdbc閫氱敤宸ュ叿绫�
 */
public class JdbcUtils {
	
	//瀹氫箟杩炴帴鍙傛暟
	private static	String url = "jdbc:mysql://localhost:3306/wuyi";
	private static	String username = "root";
	private static	String password = "";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("娉ㄥ唽椹卞姩澶辫触");
		}
	}

	
	
	public static Connection getConnection() throws Exception {
		//鑾峰彇杩炴帴
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	public static void close(Connection connection,PreparedStatement prepareStatement,ResultSet resultSet) {
		//閲婃斁璧勬簮
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(prepareStatement!=null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
