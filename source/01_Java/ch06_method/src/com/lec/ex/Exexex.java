package com.lec.ex;

public class Exexex {
	public static void gugudan(int n){

		System.out.println(n + "��");



		for (int i = 1; i <=9 ; i++ ){

			System.out.println(n + "*" + i + "=" + (n*i));

		}

		System.out.println();

	}

		public static void main(String[] args) {

		//������ �߿� 2���� ����ϱ� ���Ͽ� �޼ҵ忡�� ��ó���� �ñ���� �Ѵ�.

		for (int i = 2; i <=9 ; i++ ){

			gugudan(i);

		}

	}

}