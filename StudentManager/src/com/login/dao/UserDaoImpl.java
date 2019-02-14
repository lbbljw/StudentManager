package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.login.bean.User;
import com.login.utils.ConnetctionUtils;


public class UserDaoImpl  implements UserDao{

	public User getUserByUsernameAndPassword(String username, String password) {
		User u = null ;
		//JDBC: 闔ｷ蜿冶ｿ樊磁  郛門�儡QL 鬚�郛冶ｯ全QL 隶ｾ鄂ｮ蜿よ焚  謇ｧ陦郡QL 蟆∬｣�扈捺棡  蜈ｳ髣ｭ霑樊磁
		// 闔ｷ蜿冶ｿ樊磁
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bigdata_0308";
			String user="root";
			String pawd="1234";
			Connection conn = DriverManager.getConnection(url, user, pawd);*/
			Connection conn = ConnetctionUtils.getConn();

			String sql ="select id, username,password from admin where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet  rs = ps.executeQuery();

			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}

			return u ;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnetctionUtils.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
