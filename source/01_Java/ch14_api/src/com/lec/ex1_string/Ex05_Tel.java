package com.lec.ex1_string;

// ��ȭ��ȣ �ް�, �Է¹��� ��ȭ��ȣ, ¦����ȣ����, �Ųٷ�, ���� ���ڸ�, ���� ���ڸ� ���
//��ȭ��ȣ �ް�, �Է¹��� ��ȭ��ȣ, ¦����ȣ����, �Ųٷ�, ���� ���ڸ�, ���� ���ڸ� ���

import java.util.Scanner;

public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		while (true) {
			System.out.println("��ȭ��ȣ�� �Է��ϼ���.(010-xxxx-xxxx)");
			System.out.println("���Ḧ ���Ѵٸ� (X)�� �Է� �ϼ���.");
			tel = scanner.next();
		if (tel.equalsIgnoreCase("x"))
				break;
			System.out.println ("�Է��� ��ȭ��ȣ�� : " + tel);
			System.out.print ("�Է��� ��ȭ��ȣ�� ¦�� : ");
		for (int i = 0; i < tel.length(); i++) {
			if (i% 2==0) {
			System.out.print (tel.charAt(i));
			}else {
				System.out.print (' ');
			}
		}
		System.out.println();
		System.out.print("��ȣ �Ųٷ� : ");
		for (int i = tel.length() -1; i >= 0; i--) {
			System.out.print(tel.charAt(i));
		}
		System.out.println();
		String first = tel.substring(0, tel.indexOf('-'));
		String last = tel.substring(tel.lastIndexOf('-')+1);
		System.out.println("��ȣ ���ڸ� : " +  first);
		System.out.println("��ȣ ���ڸ� : " + last);
		}
	}
}