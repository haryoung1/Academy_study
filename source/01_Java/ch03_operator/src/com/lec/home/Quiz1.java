package com.lec.home;

import java.util.Scanner;

// 3�� ��� ���� �Ǵ��ϱ� : ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���ڰ� 3�� ������� �ľ�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 3�� ��� ���� �Է���   : ");
		int i = sc.nextInt(); // ����ڰ� �Է��� ����
		System.out.println((i%3)==0 ? "�Է��Ͻ� i�� 3�� ����Դϴ�":"�Է��Ͻ� i�� 3�� ����� �ƴմϴ�");
	}
}
