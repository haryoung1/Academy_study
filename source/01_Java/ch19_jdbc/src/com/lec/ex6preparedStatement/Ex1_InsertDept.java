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
		System.out.print("추가 할 부서번호는 ? : ");
		int deptno = sc.nextInt();
		System.out.print("추가 할 부서명은 ? : ");
		String dname = sc.next();
		System.out.print("추가 할 부서위치는 ? ");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // SQL 전송객체
			pstmt.setInt(1, deptno); // deptno가 int라서 setInt함수 (1번, 데이터값)
			pstmt.setString(2, dname); // (2번, 데이터 값)
			pstmt.setString(3, loc); // 쿼리에 있는 필드 순서대로 데이터를 추가 해야함.
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "번 부서 입력 성공" : deptno + "번 부서 입력 실패");
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