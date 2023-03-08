package com.lec.ex.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao2 {
	private final int SUCCESS = 1;
	private final int FAIL = 0;
	private DataSource ds;

	public BoardDao2() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java/comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}

	}
	// 1. 글목록(startRow ~ endRow까지)
}
