package com.lec.ex4_test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> members = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		String yesorno, name, phone, address;
		while (true) {
			System.out.println("ȸ�������� ���Ͻø� Y / ����:N");
			yesorno = sc.next();
			if (yesorno.equalsIgnoreCase("n")) {
				break;
			} else if (yesorno.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է� ���ּ���.");
				name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է� ���ּ���.");
				phone = sc.next();
				System.out.println("�ּҸ� �Է� ���ּ���.");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Customer(name, phone, address));
			}
		}
		if (members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("<������ ȸ�� ����Ʈ>");
			for (Customer c : members) {
				System.out.print(c);
			}
		}
		sc.close();
	}
}
