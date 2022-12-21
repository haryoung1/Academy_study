package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_printwriter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, birthStr, address;
		int year, month, day;
		Date birthday;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		ArrayList<Member> members = new ArrayList<Member>();

		do {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? Y / ����: n ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է� ���ּ���.");
				name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է� ���ּ���.");
				phone = sc.next();
				System.out.println("������ �Է� ���ּ���.ex: 2000-11-11");
				birthStr = sc.next();
				StringTokenizer token = new StringTokenizer(birthStr, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken());
					day = Integer.parseInt(token.nextToken());
					birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
				} else {
					System.out.println("���� ������ Ʋ�Ⱦ��");
					continue;
				}
				if (today.equals(birthStr.substring(birthStr.indexOf("-") + 1))) {
					System.out.println(name + "�� ���� �����̽ñ���. ���� �帳�ϴ� !");
				}
				System.out.println("�ּҸ� �Է� �ϼ���");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name, phone, birthday, address));
			}
		} while (true);
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("D:\\webPro1\\source\\01_Java\\ch17_io\\src\\com\\lec\\quiz\\member.txt");
			for (Member member : members) {
				System.out.print(member);
				printWriter.print(member.toString());
				String msg = String.format("\n\t\t\t.....���� %d�� ����", members.size());
				System.out.println(msg);
				printWriter.print(msg);
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��" + e.getMessage());
		} finally {
			printWriter.close();
		}

	}
}