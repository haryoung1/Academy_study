package com.lec.ex;
// 1~10까지 정수의 합과 그 결과가 짝수인지 홀수인지 출력
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0; // 누적 값 변수
		for(int i=from ; i<=to ; i++) {
			sum += i;
		}
		return sum;
	}
	private static String evenOdd(int value) {                 // private(내 파일 호출), static (내 파일, 외부파일 호출)
		String result = value%2==0 ? "짝수 입니다." : "홀수 입니다.";
		return result;
	}
	public static void main(String[] args) {
	int tot = sum(1, 11);
	System.out.println("1 ~ 11까지 정수합은? "+tot);
	System.out.println( evenOdd (tot) );
	// -------------------------------------------------------
	tot = sum (10,100);
	System.out.println("10 ~ 100까지 정수합은? "+tot);
	System.out.println( evenOdd (tot) );
  }
}
