package com.lec.quiz;
// ���̿� ���� ��ο��, �Ϲ� ���
import java.util.Scanner;
public class Quiz4 {
	public static void main(String[] args) {
		System.out.println("���̸� �Է� ���ּ���");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		System.out.println((age>=65)? "��ο�� �Դϴ�.": "�Ϲ� �Դϴ�.");
		sc.close();
	}
}
