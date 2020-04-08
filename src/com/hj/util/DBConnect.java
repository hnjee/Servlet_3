package com.hj.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static void main(String[] args) {
		Connection con;
		try {
			con = DBConnect.getConnection();
			System.out.println(con);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception {
		//1. 로그인 정보 4가지
		String user = "user02";
		String password = "user02";
			//ERR CASE 1. Logon Deny
			//1) ID/PW 틀렸을 경우
			//2) DB에 해당 유저가 생성되지 않은 경우
			//3) 유저의 권한에 적용되지 않은 경우 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
			//ERR CASE 2. not connect
			//1) ip, port, xe 정보가 틀린경우 
			//2) 물리적으로 연결이 안되거나 
			//3) Listener 문제, DB 재시동 
		
		
		//2. 드라이버를 메모리에 로딩
		Class.forName(driver);
			//ERR CASE 3. not found
			//1) driver명이 틀린경우 
			//2) jdbc(ojdbc6.jar)가 없는 경우 
		
		//3. 로그인 Connection 객체 반환 
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
