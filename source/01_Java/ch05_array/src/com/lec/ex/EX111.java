package com.lec.ex;
public class EX111 {
	public static void main(String[] args) {
		String sungbin = "잘생겼다";
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
	}
}
