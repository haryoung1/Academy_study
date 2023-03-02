package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.EmpDto;

public class EmpDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
<<<<<<< HEAD
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static EmpDao instance; // 자기 클래스를 참조하는 변수
	public static EmpDao getInstance() {
		if(instance == null) {
=======
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private static EmpDao instance; // 자기 클래스를 참조하는 변수

	public static EmpDao getInstance() {
		if (instance == null) {
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
			instance = new EmpDao();
		}
		return instance;
	}
<<<<<<< HEAD
=======

>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	private EmpDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
<<<<<<< HEAD
	// detpno로 empList를 반환
	public ArrayList<EmpDto> deptnoEmpList(int deptno){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
=======

	// ex3 : deptno로 empList를 반환
	public ArrayList<EmpDto> deptnoEmpList(int deptno) {
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		String query = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
<<<<<<< HEAD
			while(rs.next()) {
				int    empno   = rs.getInt("empno");
				String ename   = rs.getString("ename");
				String job     = rs.getString("job");
				int    mgr     = rs.getInt("mgr");
				Date   hiredate= rs.getDate("hiredate");
				int    sal     = rs.getInt("sal");
				int    comm    = rs.getInt("comm");
				deptno  = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}			
=======
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getNString("ename");
				String job = rs.getNString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				deptno = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));

			}
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
<<<<<<< HEAD
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
=======
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
<<<<<<< HEAD
	// searchName으로 empList를 반환
	public ArrayList<EmpDto> searchNameEmpList(String schName){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String query = "SELECT E.*, DNAME FROM EMP E, DEPT D " + 
				"  WHERE D.DEPTNO=E.DEPTNO and ENAME LIKE '%'||trim(UPPER(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, schName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno   = rs.getInt("empno");
				String ename   = rs.getString("ename");
				String job     = rs.getString("job");
				int    mgr     = rs.getInt("mgr");
				Date   hiredate= rs.getDate("hiredate");
				int    sal     = rs.getInt("sal");
				int    comm    = rs.getInt("comm");
				int    deptno  = rs.getInt("deptno");
				String dname   = rs.getString("dname");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
			
=======

	// searchName으로 empList를 반환
	public ArrayList<EmpDto> searchNameEmpList(String schName) {
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT E.*, DNAME" + " FROM EMP E, DEPT D"
				+ " WHERE D.DEPTNO=E.DEPTNO and ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, schName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getNString("ename");
				String job = rs.getNString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				String dname = rs.getNString("dname");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}

>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
<<<<<<< HEAD
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
=======
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
