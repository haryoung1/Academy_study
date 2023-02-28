package com.lec.home;

import java.util.Scanner;

// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력 하세용 : ");
		int age = sc.nextInt();
		if (age > 65) {
			System.out.println("경로우대 입니다. 어르신");
		}else {
			System.out.println("65세 미만은 일반 이예요.");
		}
	}
}
