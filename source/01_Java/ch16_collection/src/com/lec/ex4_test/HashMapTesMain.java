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
			System.out.println("ȸ�������� ���Ͻø� Y / ����: N");
			yesorno = sc.next();
			if (yesorno.equalsIgnoreCase("n")) {
				break;
			} else if (yesorno.equalsIgnoreCase("y")) {
				System.out.println("[�̸��� �Է� ���ּ���]");
				name = sc.next();
				System.out.println("[��ȭ��ȣ�� �Է� ���ּ���]");
				phone = sc.next();
				if (members.get(phone) != null) {
					System.out.println("[�ߺ��� ��ȭ��ȣ �Դϴ�] �ٽ� ���� ���ּ���");
					continue;
				}
				System.out.println("[�ּҸ� �Է� ���ּ���]");
				sc.nextLine();
				address = sc.nextLine();
				members.put(phone, new Customer(name, phone, address));
			}
		} while (true);
		if (members.isEmpty()) {
			System.out.println("[������ ȸ���� �����ϴ�]");
		} else {
			System.out.println("[������ ȸ�� ����Ʈ]");
			Iterator<String> iterator = members.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(members.get(key));
			}
		}
		sc.close();
	}
}