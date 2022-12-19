package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birthday;

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birthday) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		// sout = > 홍 717-7777
		if (birthday != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
			return "[이름] = " + name + " [번호] = " + tel + " [생일] = " + sdf.format(birthday);
		} else {
			return "[이름] = " + name + " [번호] = " + tel;
		}

	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public Date getBirthday() {
		return birthday;
	}
}