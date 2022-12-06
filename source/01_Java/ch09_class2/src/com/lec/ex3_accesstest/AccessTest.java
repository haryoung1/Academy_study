package com.lec.ex3_accesstest;

public class AccessTest {
	private int privateMember; // 같은 클래스내에서만 사용
	protected int protectedMember; // 같은 패키지 or 상속 받은 클래스에서 사용
	int defaultMember; // 디폴트 접근제한 : 같은 패키지에서만 사용
	public int publicMember; // 아무곳에서나 사용가능
	private void privateMethod() {
		System.out.println("private 메소드");
	}
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	void defaultMethod() {
		System.out.println("default 메소드");
	}
	public void publicMethod() {
		System.out.println("public 메소드");
	}
}
