package com.lec.ex1trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù��° ������?");
		do {
			try {
				i = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("���� ���ڸ� ������");
				scanner.nextLine(); // ��������� �뵵
			}
		} while (true);
		System.out.print("�ι�° ������ ?");
		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i / j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		} catch (InputMismatchException e) {          // ���ܹ߻��� ���� �κ�
			System.out.println(e.getMessage());       // ���ܸ޼��� ���
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("���ܸ޼��� : " + e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��ؼ� 1�� ��ü ��");
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}