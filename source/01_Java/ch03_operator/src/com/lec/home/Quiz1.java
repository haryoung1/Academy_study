package com.lec.home;

import java.util.Scanner;

// 3의 배수 숫자 판단하기 : 사용자로부터 숫자를 입력 받고, 입력 받은 숫자가 3의 배수인지 파악
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 3의 배수 숫자 입력해   : ");
		int i = sc.nextInt(); // 사용자가 입력할 숫자
		System.out.println((i%3)==0 ? "입력하신 i는 3의 배수입니다":"입력하신 i는 3의 배수가 아닙니다");
	}
}
