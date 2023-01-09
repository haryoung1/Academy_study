package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// dao�� �̱������� ���� / private �����ڿ��� driver �ε�
// 1. ȸ������ : public int insertCustomer(String phone, String cname)
// public int insertCustomer (CustomerDto dto)
// 2. ����4�ڸ�(FULL) �˻�
// public ArrayList<CustomerDto> phoneGetCustomers(String searchTel)
// 3. ��ǰ���� public int buy(int cno, int price)
// 3�� ��ǰ ���� �� ������ ���� ��� : public CustomerDto getCustomer(int cid)
// 4�� �� levelname�� ���� ���� : public ArrayList<String> getLevelNames()
// 4. ��޺� �� ��� : public ArrayList<CustomerDto> levelNameGetCustomers (String levelName)
// 5. ��ü ��� : pulbic ArrayList<CustomerDto> getCustomers();
// 6. ȸ�� Ż�� : pulbic int deleteCustomer (String phone)

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private int cno;
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private static CustomerDao INSTANCE = new CustomerDao();

	public static CustomerDao getInstance() {
		return INSTANCE;
	}

	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. ȸ������
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CNO,PHONE,CNAME) VALUES (CUS_NO_SQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ":" + dto);
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

	public int insertCustomer(String phone, String cname) {
		int result = FAIL;

		return result;
	}

	// 2�ܰ�
	public ArrayList<CustomerDto> phoneGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME,"
				+ "  (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) ForLevelUp"
				+ "  FROM CUSTOMER C, CUS_LEVEL L" + "  WHERE C.LEVELNO=L.LEVELNO AND PHONE LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cno = rs.getInt("cno");
//				 String cname = rs.getString("cname");
//				 String phone = rs.getString("phone");
//				 int point = rs.getInt("point");
//				 int amount = rs.getInt("amount");
//				 String levelname = rs.getString("levelname");
//				 int forLevelUp = rs.getInt("NextLevelUp");
				CustomerDto dto = new CustomerDto();
				dto.setCno(rs.getInt("cno"));
				dto.setCname(rs.getString("cname"));
				dto.setPhone(rs.getString("phone"));
				dto.setPoint(rs.getInt("point"));
				dto.setAmount(rs.getInt("amount"));
				dto.setLevelname(rs.getString("levelname"));
				dto.setForLevelUp(rs.getInt("ForLevelUp"));
				dtos.add(dto);
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

	// 3. ��ǰ���� public int buy(int cno, int price)
	public int buy(int cno, int price) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER " + "    SET POINT = POINT + (?*0.05)," + "    AMOUNT = AMOUNT + ?,"
				+ "    LEVELNO = (SELECT L.LEVELNO " + "                    FROM CUSTOMER C, CUS_LEVEL L "
				+ "                    WHERE AMOUNT+? BETWEEN MONEY AND MONEY2 "
				+ "                          AND CNO=?) " + "    WHERE CNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cno);
			pstmt.setInt(5, cno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("��ǰ���� ���� : " + e.getMessage());
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

	// 3�� ��ǰ���� �� ������ ���� ��� :
	public CustomerDto getCustomer(int cno) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, "
				+ "    (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) NextLevelUp"
				+ "    FROM CUSTOMER C, CUS_LEVEL L" + "    WHERE C.LEVELNO=L.LEVELNO AND CNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			if (rs.next()) { // �˻������ ���� ���(cno�� ���� ���), dto�� CustomerDto��ü �����Ͽ� �Ҵ�
//				int cno = rs.getInt("cno");
				String phone = rs.getString("phone");
				String cname = rs.getString("cname");
				int point = rs.getInt("point");
				int amount = rs.getInt("amount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("NEXTLevelUp");
				dto = new CustomerDto(cno, phone, cname, point, amount, levelName, forLevelUp);
			}
		} catch (SQLException e) {
			System.out.println("GET ����" + e.getMessage());
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
			} // close
		} // try��
		return dto;
	}

	// 4�� �� levelName�� ���� ����
	public ArrayList<String> getlevelname() {
		ArrayList<String> levelname = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				levelname.add(rs.getString("levelname"));
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
			} // close
		} // try��
		return levelname;
	}

	// 4. ��޺� �� ���
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, "
				+ "  (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO) forLevelUp"
				+ "  FROM CUSTOMER C, CUS_LEVEL L" + "  WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?"
				+ "  ORDER BY AMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				int    cid       = rs.getInt("cid");
//				String ctel      = rs.getString("ctel");
//				String cname     = rs.getString("cname");
//				int    cpoint    = rs.getInt("cpoint");
//				int    camount   = rs.getInt("camount");
//				String levelName = rs.getString("levelName");
//				int    forLevelUp= rs.getInt("forLevelUp");
//				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
				CustomerDto dto = new CustomerDto();
				dto.setCno(rs.getInt("cno"));
				dto.setPhone(rs.getString("phone"));
				dto.setCname(rs.getString("cname"));
				dto.setPoint(rs.getInt("point"));
				dto.setAmount(rs.getInt("amount"));
				dto.setLevelname(rs.getString("levelname"));
				dto.setForLevelUp(rs.getInt("forLevelUp"));
				dtos.add(dto);
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
			} // close
		} // try��
		return dtos;
	}

	// 5. ��ü ��� :
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, PHONE, CNAME, POINT, AMOUNT, LEVELNAME, "
				+ "  (SELECT MONEY2+1-AMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CNO=C.CNO)  forLevelUp"
				+ "  FROM CUSTOMER C, CUS_LEVEL L" + " WHERE C.LEVELNO = L.LEVELNO " + "ORDER BY AMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String phone = rs.getString("phone");
				String cname = rs.getString("cname");
				int point = rs.getInt("point");
				int amount = rs.getInt("amount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cno, phone, cname, point, amount, levelName, forLevelUp));
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
			} // close
		} // try��
		return dtos;
	}

	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE PHONE=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
}