package com.lec.ex4_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTesMain {
	public static void main(String[] args) {
		HashMap<String, Customer> members = new HashMap<String, Customer>();
		Scanner sc = new Scanner(System.in);
		String yesorno, name, phone, address;
		do {
			System.out.println("회원가입을 원하시면 Y / 종료: N");
			yesorno = sc.next();
			if (yesorno.equalsIgnoreCase("n")) {
				break;
			} else if (yesorno.equalsIgnoreCase("y")) {
				System.out.println("[이름을 입력 해주세요]");
				name = sc.next();
				System.out.println("[전화번호를 입력 해주세요]");
				phone = sc.next();
				if (members.get(phone) != null) {
					System.out.println("[중복된 전화번호 입니다] 다시 가입 해주세요");
					continue;
				}
				System.out.println("[주소를 입력 해주세요]");
				sc.nextLine();
				address = sc.nextLine();
				members.put(phone, new Customer(name, phone, address));
			}
		} while (true);
		if (members.isEmpty()) {
			System.out.println("[가입한 회원이 없습니다]");
		} else {
			System.out.println("[가입한 회원 리스트]");
			Iterator<String> iterator = members.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(members.get(key));
			}
		}
		sc.close();
	}
}