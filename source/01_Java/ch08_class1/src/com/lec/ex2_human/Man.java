package com.lec.ex2_human;
// Man Kim = new Man();
// Man Kim = new Man("홍길동");
// Man Kim = new Man("홍길동", 22, 170, 65);
public class Man { // Man 이라는 클래스를 만듬. = 메인에서 써먹기 위해?
	private String name; // 이름
	private int age;	// 나이
	private int height; // 키
	private double weight; // 더블 사용하는 이유 = 몸무게에 소수점도 있을 수 있어서 실수 사용.
	// 개발자가 생성자 함수를 만들면 컴파일러는 디폴트 생성자 함수를 안 만듬
	public Man() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Man(String name, int age, int height, double weight) {
	this.name = name;
	this.age = age;
	this.height = height;
	this.weight = weight;
	System.out.println("데이터 4개 초기화하는 생성자 함수");
	}
	// Man man = new Man(170);
	public Man(String name) {
		this.name = name;
		System.out.println("이름 초기화 하는 생성자 함수");
	}
	public Man(int height) {
		this.height = height;
		System.out.println("키 초기화 하는 생성자 함수");
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() { // 객체안의 height와  weight로 BMI 지수 return
		double result = weight / ( (height*0.01) * (height*0.01) );
		return result;
	}
	// getter : name, age, height, weight
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	// setter : name, age, height, weight
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
}








