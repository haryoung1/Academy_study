package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // ������ �Լ� 1�� ����
//		A aObj - new A();
		S aObj = new A(); // ������ �Լ� 2�� ���� (�θ��+�ڽĴ�)
//		B bObj = new B();
		S bObj = new B(); // ������ �Լ� 2�� ���� (�θ��+�ڽĴ�)
//		B bObj = new B();
		C cObj = new C(); // ������ �Լ� 2�� ���� (�θ��+�ڽĴ�)
//		B bObj = new B();
//		S cObj = new C();
//		S[] arr = {new S(), new A(), new B(), new C() };
		S[] arr = {sObj, aObj, bObj, cObj};
		for(S a : arr) {
			System.out.println("s=" + a.s);
		}
	}
}