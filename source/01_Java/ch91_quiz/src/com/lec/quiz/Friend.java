package com.lec.quiz;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private String birthday;

	public Friend() {
	}

	public Friend(String name, String phone, String address, String birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n핸드폰 : " + phone + "\n주소 : " + address + "\n생일 : " + birthday;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
