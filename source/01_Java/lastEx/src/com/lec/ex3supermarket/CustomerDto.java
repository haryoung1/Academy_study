package com.lec.ex3supermarket;

public class CustomerDto {
	private int cno; // 고객번호
	private String cname; // 고객 이름
	private String phone; // 고객 전화
	private int point; // 고객 포인트
	private int amount; // 누적 금액
	private String levelname; // 등급이름
	private int forLevelUp;
	private int levelno; // 고객번호

	public CustomerDto() {
	}

	public CustomerDto(int cno, String cname, String phone, int point, int amount, String levelname, int forLevelUp) {
		this.cno = cno;
		this.cname = cname;
		this.phone = phone;
		this.point = point;
		this.amount = amount;
		this.levelname = levelname;
		this.forLevelUp = forLevelUp;
	}

	@Override
	public String toString() {
		return cno + "\t" + cname + "\t " + phone + "\t" + point + "\t" + amount + "\t" + levelname + "\t" + forLevelUp;
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

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getForLevelUp() {
		return forLevelUp;
	}

	public void setForLevelUp(int forLevelUp) {
		this.forLevelUp = forLevelUp;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
}