package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.219.104:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver); // 1. 드라이버 로드
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2.DB연결 객체
			System.out.println("Oracle 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패: " + e.getMessage());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (conn != null) // 7.연결 객체 해제
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}