package com.lec.quiz;
import java.util.Scanner;
// �Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int su = sc.nextInt();
		if(su%2 == 0) {
			System.out.println("¦�� �Դϴ�.");
		}else {
			System.out.println("Ȧ�� �Դϴ�.");
		}
	}
}