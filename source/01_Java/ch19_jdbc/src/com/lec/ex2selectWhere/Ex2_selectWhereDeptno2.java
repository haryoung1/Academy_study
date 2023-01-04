package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 사용자에게 원하는 부서번호를 받아 부서정보를 뿌리고, 해당 부서의 사원정보도 출력
// 1. 해당 부서번호가 없는 경우 : 존재하지 않는 부서 입니다.
// 2. 해당 부서번호가 있는 경우 : 부서정보를 출력
// 2-1. 해당부서 사원이 있는 경우 : 해당부서 사원 (사번,이름,급여,상사이름)
// 2-2. 해당부서 사원이 없는 경우 : 해당 부서의 사원이 없습니다
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서번호 입력 : ");
		int deptno = scanner.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER "
				+ "FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				System.out.println("원하는 부서번호 : " + deptno + "번");
				System.out.println("원하는 부서이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("사번\t이름\t급여\t상사명");
					do {
						String empno = rs.getString(1);
						String ename = rs.getString(2);
						String sal = rs.getString(3);
						String manager = rs.getString(4);
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "번 부서의 사원은 없습니다.");
				}
			} else {
				System.out.println(deptno + "번 부서는 없는 부서 입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}