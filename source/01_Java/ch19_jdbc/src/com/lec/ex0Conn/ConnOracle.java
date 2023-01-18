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
			Class.forName(driver); // 1. ����̹� �ε�
			System.out.println("����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2.DB���� ��ü
			System.out.println("Oracle ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����: " + e.getMessage());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (conn != null) // 7.���� ��ü ����
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}