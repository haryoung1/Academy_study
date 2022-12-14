package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Sawon {
	
	public static final String COMPUTER       = "COMPUTER";
	public static final String PLANNING       = "PLANNING";
	public static final String DESIGN         = "DESIGN";
	public static final String ACCOUNTING     = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	private String no; 	 // 사번
	private String name; // 이름
	private String part; // 부서
	private Date date; 	 // 입사일

	public Sawon() {
	}

	public Sawon(String no, String name, String part) {
		this.no = no;
		this.name = name;
		this.part = part;
		date = new Date();
	}

	public Sawon(String no, String name, String part, int y, int m, int d) {
		this.no = no;
		this.name = name;
		this.part = part;
		date = new Date (new GregorianCalendar(y,m-1,d).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd (E)");
		if(part.length() >8 ) {
			return "[사번]" + no + " \t[이름]" + name + "\t[부서]" + part + "\t[입사일]" + sdf1.format(date);
		}else {
			return "[사번]" + no + " \t[이름]" + name + "\t[부서]" + part + "\t\t[입사일]" + sdf1.format(date);
		}	
	}
}