package com.le.conditionQuiz;
import java.util.Scanner;
// ���� ��� ������ Ű����κ��� �Է� �޾� ������ ���
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ ����ΰ���? \n���ڸ� �Է��Ͻÿ� : ");
		int you = scanner.nextInt();
		if (you ==1) {
			System.out.println("1���� �ƴմϴ�.");
		}else if (you ==2) {
			System.out.println("2���� �ƴմϴ�.");
		}else if (you ==3) {
			System.out.println("3���� �ƴմϴ�.");
		}else if (you ==4) {
			System.out.println("4���� �ƴմϴ�.");
		}else if (you ==5) {
			System.out.println("5���� �ƴմϴ�.");
		}else if (you ==6) {
			System.out.println("6���� �ƴմϴ�.");
		}else if (you ==7) {
			System.out.println("7���� �ƴմϴ�.");
		}else if (you ==8) {
			System.out.println("8���� �ƴմϴ�.");
		}else if (you ==9) {
			System.out.println("9���� �ƴմϴ�.");
		}else if (you ==10) {
			System.out.println("10���� �ƴմϴ�.");
		}else if (you ==12) {
			System.out.println("12���� �ƴմϴ�.");
		}else if (you ==11) {
			System.out.println("���� �Դϴ�!");
		}else {
			System.out.println("�ٽ� �Է� ���ּ���.");
		}
		scanner.close();
	}
}
