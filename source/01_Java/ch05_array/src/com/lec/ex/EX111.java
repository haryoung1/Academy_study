package com.lec.ex;
import java.util.Scanner;
public class EX111 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("세개중에 골라요.");
		System.out.println("잘생겼다, 못생겼다 , 잔생겼다");
		String sungbin = "잘생겼다";
		String sungbin1 = scanner.next();
		// if는 만약에 라는 뜻으로
		// 만약에 sungbin에 잘생겼다가 들어가 있으면 출력
		if(sungbin =="못생겼다") { // 못생겼다 = 출력 X
			System.out.println("ㅠㅠ");
		}
		else if(sungbin == "잘생겼다") { // 맞으니까 출력
			System.out.println("ㅇㅈ 드립니다");
		}
		else if(sungbin == "잔생겼다") { // 오타 = 출력 X
			System.out.println("오타죠");
		}
	}//m
}//c
