package com.lec.method;
// sum(int, int) - sum(10,100) -> 매개변수 2개가 있어야 호출이 가능함.
// sum(10, 100), sum(10) - 함수의 오버로딩 (똑같은 함수 이름이지만 매개 변수값이 달라서 가능함)
// sum(10,100), sum (10) - 함수의 오버로딩 / evenOdd(55) /  abs(-9)
public class Arithmetic {
	public int sum(int from, int to) {
	int result = 0; // 누적변수
	for(int i=from ; i<=to ; i++) {
		result += i;
	}
	return result;
   }
	public int sum(int to) { // 1~to 까지 정수 누적 값 returm
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
    }
	public String evenOdd(int value) {
		return value%2==0? "짝수 입니다." : "홀수 입니다.";
	}
	public static int abs(int value) { // 절대 값을 return. 접근제한자 생략 할 경우 ?
		int result = value>=0? value : -value;
		return result;
	}
}









