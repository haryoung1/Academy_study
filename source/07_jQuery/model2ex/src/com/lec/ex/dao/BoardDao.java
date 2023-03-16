package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
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

	// (1) 글목록 (startRow ~ endRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM (SELECT ROWNUM RN, A.*" + 
				"        FROM (SELECT MNAME, F.*" + 
				"               FROM FILEBOARD F, MVC_MEMBER M" + 
				"        WHERE F.MID = M.MID" + 
				"        ORDER BY fGROUP DESC, fSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Timestamp frdate = rs.getTimestamp("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dtos.add(new BoardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep,
						findent, fip));

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
		return dtos;
	}

	// 2. 등록 된 글 갯수
	public int getFileboardCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
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
		return totCnt;
	}

	// 3. 원글쓰기
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)"
				+ "VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfileName());
			pstmt.setString(5, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글 쓰기 실패 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
		return result;
	}

	// 4. 조회수 올리기
	public void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE FID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " 조회수 up 실패");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// (5) 글번호 (fid)로 글 전체 내용(BoardDto) 가져오기
	public BoardDto content(int fid) {
		BoardDto dto = null;
		hitUp(fid);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, MNAME" + "  FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID AND FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Timestamp frdate = rs.getTimestamp("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dto = new BoardDto(fid, mid, mname, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent,
						fip);

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
		return dto;
	}

	// (6) 글번호(fid)로 글전체 내용(BoardDto) 가져오기 - 글수정VIEW, 답변글VIEW 용
	public BoardDto modifyView_replyView(int fid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, MNAME" + "  FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID AND FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffileName = rs.getString("ffileName");
				Timestamp frdate = rs.getTimestamp("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dto = new BoardDto(fid, mid, mname, ftitle, fcontent, ffileName, frdate, fhit, fgroup, fstep, findent,
						fip);
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
		return dto;
	}

	// (7) 글 수정하기 (fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
	public int modify(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET" + 
				"                    FTITLE = ?," + 
				"                    FCONTENT = ?," + 
				"                    fFILENAME = ?," + 
				"                    FIP = ?," + 
				"                    FRDATE = SYSDATE" + 
				"            WHERE FID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfileName());
			pstmt.setString(4, dto.getFip());
			pstmt.setInt(5, dto.getFid());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정 성공" : "글번호(fid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 수정 실패 ");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

	// (8) 글 삭제하기 (fid로)
	public int delete(int fid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제 성공" : "글번호(fid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패 ");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// (9) 답변글 쓰기 전 단계 (원글의 fgroup과 같고, 원글의 fstep 보다 크면 fstep을 하나 증가)
	private void preReplyStep(int fgroup, int fstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + "    SET fSTEP = fSTEP + 1" + "    WHERE FGROUP = ? AND FSTEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " preReplyStep에서 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// (10) 답변글 쓰기
	public int reply(BoardDto dto) {
		int result = FAIL;
		preReplyStep(dto.getFgroup(), dto.getFstep());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)"
				+ "VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfileName());
			pstmt.setInt(5, dto.getFgroup());
			pstmt.setInt(6, dto.getFstep() + 1);
			pstmt.setInt(7, dto.getFindent() + 1);
			pstmt.setString(8, dto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " 답변글쓰기 실패 ");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// (101 회원탈퇴시 탈퇴하는 회원 (mid)이 쓴 글 모두 삭제하기
	public int preWithdrawalMemberStep(String mid) {
		int cntBoard = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE mID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			cntBoard = pstmt.executeUpdate();
			System.out.println(cntBoard+"개글 삭제 성공(회원탈퇴전)");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "탈퇴 전 글 삭제 실패 ");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
		}
		return cntBoard;
	}
}