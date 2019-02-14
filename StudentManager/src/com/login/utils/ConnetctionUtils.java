package com.login.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnetctionUtils {
	private static String driver = null;
	private static String url = null ;
	private static String username = null ;
	private static String password = null ;
	private static Properties props = new Properties();

	//ThreadLocal :菫晁ｯ∽ｸ�荳ｪ郤ｿ遞倶ｸｭ蜿ｪ閭ｽ譛我ｸ�荳ｪ霑樊磁.

	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	/**
	 * 髱呎�∫噪莉｣遐∝摎隸ｻ蜿謀b.properties
	 */
	static {
		try {
			//邀ｻ蜉�霓ｽ蝎ｨ隸ｻ蜿匁枚莉ｶ
			InputStream in =
					ConnetctionUtils.class.getClassLoader().getResourceAsStream("db.properties");

			props.load(in);

			driver =props.getProperty("jdbc.driver");
			url = props.getProperty("jdbc.url");
			username= props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * 闔ｷ蜿冶ｿ樊磁逧�譁ｹ豕�
	 */

	public static  Connection  getConn()  throws Exception{
		//蜈亥ｰ晁ｯ穂ｻ師l荳ｭ闔ｷ蜿�
		Connection conn = tl.get();
		if(conn == null ) {
			conn = DriverManager.getConnection(url, username, password);
			tl.set(conn);
		}
		return conn ;
	}


	/**
	 * 蜈ｳ髣ｭ霑樊磁逧�譁ｹ豕�
	 */
	public static void closeConn()  throws Exception{
		//蜈亥ｰ晁ｯ穂ｻ師l荳ｭ闔ｷ蜿�

		Connection conn = tl.get();

		if(conn != null ) {
			conn.close();
		}

		tl.set(null);
	}

	public static void main(String[] args) throws Exception {
		Connection conn = getConn();

		closeConn();

		Connection conn2 = getConn();

		System.out.println(conn == conn2);
	}

}
