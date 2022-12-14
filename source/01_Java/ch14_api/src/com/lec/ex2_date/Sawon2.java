package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Sawon2 {
	
	private String no; 	 // ���
	private String name; // �̸�
	private Dept part; // �μ�
	private Date date; 	 // �Ի���

	public Sawon2() {
	}

	public Sawon2(String no, String name, Dept part) {
		this.no = no;
		this.name = name;
		this.part = part;
		date = new Date();
	}

	public Sawon2(String no, String name, Dept part, int y, int m, int d) {
		this.no = no;
		this.name = name;
		this.part = part;
		date = new Date (new GregorianCalendar(y,m-1,d).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd(E)");
//		if((dept+"").length() >8 ) {
			return "[���]" + no + " \t[�̸�]" + name + "\t[�μ�]" + part + "\t[�Ի���]" + sdf1.format(date);
//		}else {
//			return "[���]" + no + " \t[�̸�]" + name + "\t[�μ�]" + part + "\t\t[�Ի���]" + sdf1.format(date);
		}	
	}
//}