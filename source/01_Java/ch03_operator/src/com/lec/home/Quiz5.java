package com.lec.home;

import java.util.Scanner;

// ����, ����, ���� ������ ����ڿ��� �Է¹޾�, �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ������ ?");
		int kor = sc.nextInt();
		System.out.println("���� ������ ?");
		int mat = sc.nextInt();
		System.out.println("���� ������ ?");
		int eng = sc.nextInt();
		int sum = kor+mat+eng;
		double avg = sum / 3.;
		
		System.out.printf("���� : %d" + "��\t" , kor);
		System.out.printf("���� : %d" + "��\t" , eng);
		System.out.printf("���� : %d" + "��\n" , mat);
		System.out.printf("���� : %d" + "��\n", sum);
		System.out.printf("��� : %.2f" + "��", avg);
		
	}
}
