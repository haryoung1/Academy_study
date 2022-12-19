package com.lec.ex4_test;

public class Customer {
	private String name;
	private String phone;
	private String address;

	public Customer() {}

	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
}