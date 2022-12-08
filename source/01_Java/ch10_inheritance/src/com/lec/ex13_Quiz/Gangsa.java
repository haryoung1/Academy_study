package com.lec.ex13_Quiz;

public class Gangsa extends Person {
	
	private String subject;
	private static int count=0;
	public Gangsa(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
		++count;
		setNo("lecturer" + count);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(°ú¸ñ)"+subject;
	}
}
