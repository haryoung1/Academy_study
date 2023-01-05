package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null; // 1,2�� ���
		Statement stmt = null; // 3�� ���
		ResultSet rs = null;
		String fn, sql;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.println("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next(); // 1,2,3,a
			switch (fn) {
			case "1": // �̸�, ������, ��, ��, �� �Է¹޾� insert
				// 2~7�ܰ�
				sql = "INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, ?,"
						+ "(SELECT JNO FROM JOB WHERE JNAME =?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("�Է��� �̸���?");
					pstmt.setString(1, sc.next());
					System.out.print("������(���,����,����)?");
					pstmt.setString(2, sc.next());
					System.out.print("����� ?");
					pstmt.setInt(3, sc.nextInt());
					System.out.print("����� ?");
					pstmt.setInt(4, sc.nextInt());
					System.out.print("���д� ?");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate(); // 4+5�ܰ�
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���"); // 6�ܰ�
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (conn != null)
							conn.close();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("bye");

	}
}