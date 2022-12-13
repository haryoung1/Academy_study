package com.lec.ex1_string;

import java.util.Scanner;
// "920225-2012121"
public class Ex06_jumin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주민번호를 입력하시오");
		String juminNo = scanner.next();
		// 방법 1 char로 추출
		char gender = juminNo.charAt(7);
		if(gender=='1' || gender=='3') {
			System.out.println("남성입니다");
		}else if(gender=='2' || gender=='4') {
			System.out.println("여성 입니다");
		}else {
			System.out.println("유효하지 않은 주민번호 입니다");
		}
		// 방법 2 String 으로 추출
		String genderStr = juminNo.substring(7,8); // "2"
		if(genderStr.equals("1") || genderStr.equals("3")) {
			System.out.println("남성이시군요");
		}else if(genderStr.equals("2") || genderStr.equals("4")) {
			System.out.println("여성이시군요");
		}else {
			System.out.println("유효하지 않은 주민번호입니다");
		}
		//방법 3. genderStr을 정수로 전환
		int genderInt = Integer.parseInt(genderStr); // 정수스트링을 정수로("2"을 2로)
		if(genderInt==1 || genderInt ==3) {
			System.out.println("남성입니다.");
		}else if (genderInt ==2 || genderInt==4) {
			System.out.println("여성입니다");
		}else {
			System.out.println("유효하지 않은 주민 번호 입니다.");
		}
	}
}
