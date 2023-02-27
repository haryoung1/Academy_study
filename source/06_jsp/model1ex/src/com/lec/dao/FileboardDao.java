package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.FileboardDto;

public class FileboardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static FileboardDao instance = new FileboardDao();

	public static FileboardDao getInstance() {
		return instance;
	}

	private FileboardDao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 글목록
	public ArrayList<FileboardDto> listBoard() {
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, CNAME, CEMAIL" + 
					 "FROM FILEBOARD F, CUSTOMER C" + 
					 "WHERE F.CID = C.CID" + 
					 "ORDER BY FREF DESC, FRE_STEP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int fnum	    	= rs.getInt("fnum");
				 String cid			= rs.getString("cid");
				 String fsubject	= rs.getString("fsubject");
				 String fcontent	= rs.getString("fcontent");
				 String ffilename	= rs.getString("ffilename");
				 String fpw			= rs.getString("fpw");
				 int fhit			= rs.getInt("fhit");
				 int fref			= rs.getInt("fref");
				 int fre_step		= rs.getInt("fre_step");
				 int fre_level		= rs.getInt("fre_level");
				 String fip			= rs.getString("fip");
				 Date frdate		= rs.getDate("frdate");
				 String cname		= rs.getString("cname");
				 String cemail		= rs.getString("cemail");
				 dtos.add(new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 1. 글목록
		public ArrayList<FileboardDto> listBoard(int startRow, int endRow) {
			ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT *" + 
					"    FROM (SELECT ROWNUM RN, A.*" + 
					"        FROM (SELECT F.*, CNAME, CEMAIL" + 
					"                FROM FILEBOARD F, CUSTOMER C" + 
					"                WHERE F.CID = C.CID\r\n" + 
					"                ORDER BY FREF DESC, FRE_STEP) A)" + 
					"    WHERE RN BETWEEN ? AND ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 int fnum	    	= rs.getInt("fnum");
					 String cid			= rs.getString("cid");
					 String fsubject	= rs.getString("fsubject");
					 String fcontent	= rs.getString("fcontent");
					 String ffilename	= rs.getString("ffilename");
					 String fpw			= rs.getString("fpw");
					 int fhit			= rs.getInt("fhit");
					 int fref			= rs.getInt("fref");
					 int fre_step		= rs.getInt("fre_step");
					 int fre_level		= rs.getInt("fre_level");
					 String fip			= rs.getString("fip");
					 Date frdate		= rs.getDate("frdate");
					 String cname		= rs.getString("cname");
					 String cemail		= rs.getString("cemail");
					 dtos.add(new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return dtos;
		}
	// 2. 글 갯수
		public int getBoardtotcnt() {
			int totcnt = 0;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT COUNT(*) FROM FILEBOARD";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				totcnt = rs.getInt(1); // 1열의 데이터를 int값으로 받아옴
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return totcnt;
		}
	// 3. 원글쓰기
		public int insertBoard (FileboardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)" + 
					"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?," + 
					"            FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return result;
		}
}

















