package com.le.conditionQuiz;
import java.util.Scanner;
// ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է� �ϼ��� : ");
		int su = scanner.nextInt();
		if (su>=0) {
			System.out.printf("�Է��Ͻ� ���� ���� ���� %d\n", su);
		}else {
			System.out.printf("�Է��Ͻ� ���� ���밪 : %d\n", -su);
		}
		scanner.close();
	}
}
