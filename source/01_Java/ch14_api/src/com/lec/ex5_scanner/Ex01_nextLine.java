package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� : ");
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴� : " +age+"��");
		System.out.println("�̸� : ");
		String name = scanner.next();
		System.out.println("�Է��� �̸��� : " + name);
		System.out.println("�ּҴ� : ");
		// ���ۿ� �����ִ� "\n" �� �����
		scanner.nextLine();
		String address = scanner.nextLine(); // "\n" ���� ���� return �ϰ�  "\n" �ڴ� �����.
		System.out.println("�Է��� �ּҴ� : " + address);
		System.out.println("��");
		scanner.close();
	}
}
