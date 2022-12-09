package com.lec.ex01;
// static final 변수(상수)와 추상메소드만 존재
public interface InterfaceEx1 {
//	public static final int CONSTANT_NUM = 10;
	public int CONSTANT_NUM = 10; // 인터페이스 내의 변수는 "static final" 생략 가능.
//	public abstract void method1(); // 일반메소드 사용 X, 추상메소드만 사용가능
	public void method1(); // 인터페이스 내 메소드는 "absract" 생략 가능
}
