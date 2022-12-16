package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이는 : " +age+"살");
		System.out.println("이름 : ");
		String name = scanner.next();
		System.out.println("입력한 이름은 : " + name);
		System.out.println("주소는 : ");
		// 버퍼에 남아있는 "\n" 을 지우기
		scanner.nextLine();
		String address = scanner.nextLine(); // "\n" 앞의 값을 return 하고  "\n" 뒤는 지운다.
		System.out.println("입력한 주소는 : " + address);
		System.out.println("끝");
		scanner.close();
	}
}
