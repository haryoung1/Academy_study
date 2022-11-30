package com.lec.loopQuiz;
// 1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Quiz2 {
	public static void main(String[] args) {
		int sum = 0, i;
		for(i = 1; i <= 10 ; i ++) {
			if(i % 2 ==0) {
			sum += i;
			System.out.print("1~10까지 짝수의 합 = " + sum);
			}else{
				sum += i;
				System.out.print("1~10까지 홀수의 합 = " + sum);
			}
		}
	}
}
