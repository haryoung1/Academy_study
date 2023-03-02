package com.lec.conditionQuizHome;
// 두 수 중 큰 수를 변수 max에 입력하고 변수 max를 출력하는 프로그램
public class Quiz2 {
	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;
		
		if (num1>num2) {
			max = num1;
		}else {
			max = num2;
		}
		System.out.println("최대값 : " + max);
	}
}
