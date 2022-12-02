package com.lec.ex;

import java.util.Scanner;

public class Ex999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gu;
		do {
			System.out.println("원하는 구구단을 입력하세요.");
			System.out.println("(2단~9단까지만 가능)");
			gu = sc.nextInt();
		}while (gu < 2 || gu >9);
		guPrint(gu);
	}
	private static void guPrint(int gu) {
		for(int i =1 ; i<10 ; i++) {
			System.out.println(gu + "X" +i+" = "+(i*gu));
		}
	}
}
// System.out.println(gugudan+ " x "+i+" = "+(i*gugudan));