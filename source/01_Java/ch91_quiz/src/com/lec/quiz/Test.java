package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) { // 16,17 = ����
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-1234", "����� ��걸", "05-22"));
		friends.add(new Friend("�ű浿", "010-9999-9999", "����� ������", "04-05"));
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean searchOk = false;
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ� (���Ḧ ���Ͻø� x�� �Է��Ͻÿ�)");
			String searchAdd = sc.next();
			if (searchAdd.equalsIgnoreCase("x"))
				break;
			for (Friend f : friends) {
				String add = f.getAddress();
				String postAdd = add.substring(0,2);
				if (searchAdd.equals(postAdd)) {
					System.out.println(f);
					searchOk = true;
				}
			}
			if (! searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}
		}
	}
}
