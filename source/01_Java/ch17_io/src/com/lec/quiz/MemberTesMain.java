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
			System.out.println("회원가입 하시겠습니까? (종료: n) ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")){
				break;
			}else if (answer.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력 해주세요.");
				name = sc.next();
				System.out.println("전화번호를 입력 해주세요");
				phone = sc.next();
				System.out.println("생일을 입력 해주세요.");
				sc.nextLine();
				address = sc.nextLine();
			}
			
		}while (true);
	}
}
