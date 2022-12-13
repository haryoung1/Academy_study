package com.lec.ex1_string;

// 전화번호 받고, 입력받은 전화번호, 짝수번호문자, 거꾸로, 전번 앞자리, 전번 뒷자리 출력
import java.util.Scanner;

// 010-9876-5432
public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		while (true) {
			System.out.println("전화번호를 입력하세요(010-1234-1234) 형식");
			System.out.println("종료를 원한다면 (X)를 입력하세요.");
			tel = scanner.next();
			if (tel.equalsIgnoreCase("x"))
				break;
			System.out.println("입력한 전화번호는 : " + tel);
			System.out.print("입력한 전화번호의 짝수는 : ");
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i));
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
			System.out.println("입력한 번호 거꾸로 :");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			String num = tel.substring(0, 3);
			String num1 = tel.substring(9);
			System.out.println("전번 앞자리 : " + num);
			System.out.println("전번 뒷자리 : " + num1);
		}
	}
}