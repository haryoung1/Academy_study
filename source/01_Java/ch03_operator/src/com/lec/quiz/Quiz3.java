package com.lec.quiz;
import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ����?");
		int n1 = sc.nextInt();
		System.out.println("�ι�° ����?");
		int n2 = sc.nextInt();
		System.out.println("�μ��� ������ �����"+((n1==n2)? "O":"X"));
		System.out.println("ù��° ���� �� ū�� ����"+((n1>n2)? "O":"X"));
		sc.close();
	}
}
