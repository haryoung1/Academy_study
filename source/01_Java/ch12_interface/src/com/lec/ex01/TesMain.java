package com.lec.ex01;

public class TesMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1();
		InterfaceClass obj = new InterfaceClass();
		obj.method1();
		System.out.println(obj.method2());
		InterfaceEx1 obj1 = new InterfaceClass();
		obj1.method1();
//		obj1.method2(); // obj1 - interfaceClass > ex1���� �޼ҵ�1�� �ֱ� ������ 2�� ȣ�� �Ұ���.
		InterfaceEx2 obj2 = new InterfaceClass();
//		obj2.method1(); // obj2 - interfaceClass > ex2���� �޼ҵ�2�� �ֱ� ������ 1�� ȣ�� �Ұ���.
		obj2.method2();
		System.out.println("��� CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM);
		System.out.println("��� CONSTANT_NUM : " + InterfaceClass.CONSTANT_NUM);
		System.out.println("��� CONSTANT_NUM : " + obj.CONSTANT_NUM); // static�� class ���� ��õ
		System.out.println("��� CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRING);
		System.out.println("��� CONSTANT_STRING : " + InterfaceClass.CONSTANT_STRING);
	}
}