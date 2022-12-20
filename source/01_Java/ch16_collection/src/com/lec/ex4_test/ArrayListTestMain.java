package com.lec.ex4_test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> members = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		String yesorno, name, phone, address;
		while (true) {
			System.out.println("회원가입을 원하시면 Y / 종료:N");
			yesorno = sc.next();
			if (yesorno.equalsIgnoreCase("n")) {
				break;
			} else if (yesorno.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력 해주세요.");
				name = sc.next();
				System.out.println("전화번호를 입력 해주세요.");
				phone = sc.next();
				System.out.println("주소를 입력 해주세요.");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Customer(name, phone, address));
			}
		}
		if (members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("<가입한 회원 리스트>");
			for (Customer c : members) {
				System.out.print(c);
			}
		}
		sc.close();
	}
}
