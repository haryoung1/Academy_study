package com.lec.ex;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gugudan;
		do {
			System.out.println("���ϴ� �������� �Է� �ϼ���.");
			gugudan = sc.nextInt();
		}while (gugudan < 2 || gugudan >9);
		guPrint(gugudan);
	}
	private static void guPrint(int gugudan) {
		for(int i=1 ; i<10 ; i++) {
			System.out.println(gugudan+ " x "+i+" = "+(i*gugudan));
		}
	}
}
