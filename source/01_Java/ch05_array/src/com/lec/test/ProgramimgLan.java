package com.lec.test;

// {76,45,34,89,100,50,90,93}  8개의 값을 1차원 배열로 초기화 하고 
//  값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int tot = 0;
		float average = 0f;
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		average = tot / (float) arr.length;
		System.out.println("합계 =" + tot);
		System.out.println("평균 =" + average);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				System.out.println("최대값 =" + max);
			} else if (arr[i] < min) {
				System.out.println("최소값 =" + min);
			}
		}
	}

}
