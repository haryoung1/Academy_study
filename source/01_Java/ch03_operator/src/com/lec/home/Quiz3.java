package com.lec.home;

import java.util.Scanner;

// 두수를 입력받아  수가 같은지 결과를 O나 X로 출력. 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수를 입력해봐");
		int su1 = sc.nextInt();
		System.out.println("두번째 수를 입력해봐");
		int su2 = sc.nextInt();
		System.out.println("두수가 같은지 결과는 " + ((su1==su2)? "O" : "X"));
		System.out.println("첫번째 수가 더 큰지 여부 " + ((su1>su2)? "O" : "X"));
	}

}
