package com.lec.home;

import java.util.Scanner;

// �μ��� �Է¹޾�  ���� ������ ����� O�� X�� ���. ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ���� �Է��غ�");
		int su1 = sc.nextInt();
		System.out.println("�ι�° ���� �Է��غ�");
		int su2 = sc.nextInt();
		System.out.println("�μ��� ������ ����� " + ((su1==su2)? "O" : "X"));
		System.out.println("ù��° ���� �� ū�� ���� " + ((su1>su2)? "O" : "X"));
	}

}
