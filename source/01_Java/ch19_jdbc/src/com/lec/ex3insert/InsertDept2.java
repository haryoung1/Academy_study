package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호 중복체크 후 부서명, 근무지를 입력 받아 insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력할 부서번호는 : ?");
		int deptno = sc.nextInt();
		String selsql = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(selsql); // (4)+(5)
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("중복된 부서번호 입력 불가능");
			} else {
				System.out.print("입력 할 부서명은 ?");
				String dname = sc.next();
				System.out.println("입력할 부서 위치는 ?");
				String loc = sc.next();
//				String insql = "INSERT INTO DEPT VALUES (" + deptno + ", '" + dname + "', '" + loc + "')";
				String insql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insql); // insert, update, delet문 전송
				System.out.println(result > 0 ? "입력성공" : "입력실패");

			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage());
		} finally {
			try { // (7)
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}