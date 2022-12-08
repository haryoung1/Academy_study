package com.lec.ex13_Quiz;

public class Staff extends Person {
	private String department;
	private static int count=0;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++count;
		setNo("staff" + count);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(ºÎ¼­)"+department;
	}
}