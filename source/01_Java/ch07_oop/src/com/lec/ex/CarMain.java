package com.lec.ex;
public class CarMain {
	public static void main(String[] args) {
		Car myPorseche = new Car();
		myPorseche.setColor("����");
		System.out.println(myPorseche.getColor()+"�� ���� ��ⷮ : " + myPorseche.getCc());
		myPorseche.drive();
		myPorseche.park();
		myPorseche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("��ȸ��");
		yourPorsche.drive();
		System.out.println("���� �ӵ� : " + myPorseche.getSpeed());
	}
}
