package com.lec.quiz;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.ExceptionList;

public class MemberTesMain {
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
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? (����: n) ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")){
				break;
			}else if (answer.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է� ���ּ���.");
				name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է� ���ּ���");
				phone = sc.next();
				System.out.println("������ �Է� ���ּ���.");
				sc.nextLine();
				address = sc.nextLine();
			}
			
		}while (true);
	}
}
