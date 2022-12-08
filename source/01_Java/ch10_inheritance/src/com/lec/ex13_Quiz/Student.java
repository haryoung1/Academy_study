package com.lec.ex13_Quiz;

public class Student extends Person {
	
	private String ban;
	private static int count=0;
	public Student(String id,String name, String ban) {
		super(id, name);
		this.ban = ban;
		++count;
		setNo("student" + count);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(¹Ý)" + ban;
	}
}