package com.lec.ex;
public class CarMain {
	public static void main(String[] args) {
		Car myPorseche = new Car();
		myPorseche.setColor("빨강");
		System.out.println(myPorseche.getColor()+"색 차량 배기량 : " + myPorseche.getCc());
		myPorseche.drive();
		myPorseche.park();
		myPorseche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("진회색");
		yourPorsche.drive();
		System.out.println("내차 속도 : " + myPorseche.getSpeed());
	}
}
