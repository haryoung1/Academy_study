package com.lec.ex4_shape;

public abstract class Shape { // 추상클래스 : abstract 
	public void draw() {
		System.out.println("도형을 그려요");
	}
	public abstract double area(); // 추상메소드가 한개 이상 있으면 클래스도 추상클래스로 바꿔야함.
}
