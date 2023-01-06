package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		ArrayList<String> jobs = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null; // 1,2번 기능
		Statement stmt = null; // 3번 기능
		ResultSet rs = null;
		String fn, sql;
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		do {
			System.out.println("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = sc.next(); // 1,2,3,a
			switch (fn) {
			case "1": // 이름, 직업명, 국, 영, 수 입력받아 insert
				// 2~7단계
				sql = "INSERT INTO Person VALUES (PERSON_NO_SQ.NEXTVAL, ?,"
						+ "(SELECT JNO FROM JOB WHERE JNAME =?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2db연결
					pstmt = conn.prepareStatement(sql); // 3. sql전송 객체
					System.out.print("입력할 이름은? : ");
					pstmt.setString(1, sc.next());
					System.out.print("직업"+jobs+"은?");
					pstmt.setString(2, sc.next());
					System.out.print("국어점수는? : ");
					pstmt.setInt(3, sc.nextInt());
					System.out.print("영어점수는? : ");
					pstmt.setInt(4, sc.nextInt());
					System.out.print("수학점수는? : ");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate(); // 4+5단계
					System.out.println(result > 0 ? "입력성공" : "입력실패"); // 6단계
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
			case "2": // 직업명을 입력 받아 해당 직업별 조회 출력
				sql = "SELECT ROWNUM RANK, A.*"
						+ " FROM (SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ " FROM Person P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("직업은(배우, 가수, 엠씨)?");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(
							rank + "등\t" + pname + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "3":
				sql = "SELECT ROWNUM RANK, A.*"
						+ " FROM (SELECT PNAME || '('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ " FROM Person P, JOB J WHERE P.JNO=J.JNO ORDER BY SUM DESC)A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(
									rank + "등\t" + pname + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다");
					}

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
			} // switch
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	} // main
}