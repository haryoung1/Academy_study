package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO DEPT VALUES (?, ?, ?)";
		System.out.print("�߰� �� �μ���ȣ�� ? : ");
		int deptno = sc.nextInt();
		System.out.print("�߰� �� �μ����� ? : ");
		String dname = sc.next();
		System.out.print("�߰� �� �μ���ġ�� ? ");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // SQL ���۰�ü
			pstmt.setInt(1, deptno); // deptno�� int�� setInt�Լ� (1��, �����Ͱ�)
			pstmt.setString(2, dname); // (2��, ������ ��)
			pstmt.setString(3, loc); // ������ �ִ� �ʵ� ������� �����͸� �߰� �ؾ���.
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "�� �μ� �Է� ����" : deptno + "�� �μ� �Է� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}