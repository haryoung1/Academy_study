package com.lec.quiz;
import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수는?");
		int n1 = sc.nextInt();
		System.out.println("두번째 수는?");
		int n2 = sc.nextInt();
		System.out.println("두수가 같은지 결과는"+((n1==n2)? "O":"X"));
		System.out.println("첫번째 수가 더 큰지 여부"+((n1>n2)? "O":"X"));
		sc.close();
	}
}
