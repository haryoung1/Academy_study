package com.lec.loopQuiz;
// 1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���
public class Quiz2 {
	public static void main(String[] args) {
		int sum = 0, i;
		for(i = 1; i <= 10 ; i ++) {
			if(i % 2 ==0) {
			sum += i;
			System.out.print("1~10���� ¦���� �� = " + sum);
			}else{
				sum += i;
				System.out.print("1~10���� Ȧ���� �� = " + sum);
			}
		}
	}
}
