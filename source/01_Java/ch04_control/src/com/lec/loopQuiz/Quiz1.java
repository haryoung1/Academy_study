package com.lec.loopQuiz;
// 1~10까지의 곱의 결과를 출력
public class Quiz1 {
	public static void main(String[] args) {
		int i,j;
		for(j=1,i=1; i<=10; i++) {
		j=j*i;
		System.out.print(i);
		if(i==10)
		{
			System.out.print("=");
			System.out.print(j);
		}
		else
			System.out.print("*");
		}
	}
}
