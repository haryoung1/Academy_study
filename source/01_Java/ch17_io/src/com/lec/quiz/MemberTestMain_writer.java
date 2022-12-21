package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_writer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, birthStr, address;
		int year, month, day;
		Date birthday;
		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);

		do {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? Y / ����: n ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է� ���ּ���.");
				name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է� ���ּ���");
				phone = sc.next();
				System.out.println("������ �Է� ���ּ���.");// 1994 08 25
				birthStr = sc.next();
				StringTokenizer token = new StringTokenizer(birthStr, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken());
					day = Integer.parseInt(token.nextToken());
					birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
				} else {
					System.out.println("���������� Ʋ�Ƚ��ϴ�.");
					continue;
				}
				if (today.equals(birthStr.substring(birthStr.indexOf("-") + 1))) {
					System.out.println(name + "�� �����̽ó׿�. ���� ���� �帳�ϴ�");
				}
				System.out.println("�ּҸ� �Է� ���ּ���");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name, phone, birthday, address));
			}

		} while (true);
		Writer writer = null;
		try {
			writer = new FileWriter("D:\\webPro1\\source\\01_Java\\ch17_io\\src\\com\\lec\\quiz\\member.txt");
			for (Member member : members) {
				System.out.print(member);
				writer.write(member.toString());
				String msg = String.format("\n\t\t\t.....���� %d�� ����", members.size());
				System.out.println(msg);
				writer.write(msg);
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}