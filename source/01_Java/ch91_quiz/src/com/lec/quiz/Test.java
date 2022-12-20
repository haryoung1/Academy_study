package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) { // 16,17 = 서울
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-1234", "서울시 용산구", "05-22"));
		friends.add(new Friend("신길동", "010-9999-9999", "서울시 마포구", "04-05"));
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean searchOk = false;
			System.out.println("검색할 주소 앞 글자 2자리 (종료를 원하시면 x를 입력하시오)");
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
				System.out.println("해당 지역의 친구는 없습니다.");
			}
		}
	}
}
