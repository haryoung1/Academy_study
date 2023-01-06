package com.lec.ex3supermarket;

public class CustomerDto {
	private int cno;
	private String cname;
	private String phone;
	private int point;
	private int amount;
	private int levelno;

	public CustomerDto() {
	}

	public CustomerDto(int cno, String cname, String phone, int point, int amount, int levelno) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.phone = phone;
		this.point = point;
		this.amount = amount;
		this.levelno = levelno;
	}

	@Override
	public String toString() {
		return cno + "\t" + cname + "\t" + phone + "\t" + point + "\t" + amount + "\t" + levelno + "\t";
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
}
