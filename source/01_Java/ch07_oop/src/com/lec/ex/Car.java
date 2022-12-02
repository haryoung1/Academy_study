package com.lec.ex;
// 클래스 : 속성(데이터)과 메소드
// Car car = new Car();
public class Car { // 외부에서 접근 가능
	private String color; // 색깔
	private int cc;		  // 배기량
	private int speed;
	public void park() { // 리턴 안할것 (괄호안에 아무것도 없으면 매개 변수가 없는것)
		speed = 0;
		System.out.println(color + "색 차 주차한다. 지금 속도 : "+ speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "색  차 운전한다. 지금 속도 : " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "색 차 레이싱한다. 지금 속도 : " +speed);
	}
	// getter & setter (color : getcolor/setcolor, cc: getCC , SETCc, speed). myCar.SetColor("빨강")
	// Car car = new Car(); car.getColor()
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color; // this.color : 내 객체 안의 color
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}


















