package com.lec.ex1_string;

// 전화번호 받고, 입력받은 전화번호, 짝수번호문자, 거꾸로, 전번 앞자리, 전번 뒷자리 출력
//전화번호 받고, 입력받은 전화번호, 짝수번호문자, 거꾸로, 전번 앞자리, 전번 뒷자리 출력

import java.util.Scanner;

public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		while (true) {
			System.out.println("전화번호를 입력하세요.(010-xxxx-xxxx)");
			System.out.println("종료를 원한다면 (X)를 입력 하세요.");
			tel = scanner.next();
		if (tel.equalsIgnoreCase("x"))
				break;
			System.out.println ("입력한 전화번호는 : " + tel);
			System.out.print ("입력한 전화번호의 짝수 : ");
		for (int i = 0; i < tel.length(); i++) {
			if (i% 2==0) {
			System.out.print (tel.charAt(i));
			}else {
				System.out.print (' ');
			}
		}
		System.out.println();
		System.out.print("번호 거꾸로 : ");
		for (int i = tel.length() -1; i >= 0; i--) {
			System.out.print(tel.charAt(i));
		}
		System.out.println();
		String first = tel.substring(0, tel.indexOf('-'));
		String last = tel.substring(tel.lastIndexOf('-')+1);
		System.out.println("번호 앞자리 : " +  first);
		System.out.println("번호 뒷자리 : " + last);
		}
	}
}