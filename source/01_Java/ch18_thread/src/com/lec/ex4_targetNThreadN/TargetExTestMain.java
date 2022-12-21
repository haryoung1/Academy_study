package com.lec.ex4_targetNThreadN;

// target 객체는 1개, 쓰레드는 N개 =  쓰레드 하나가 target 객체를 공유
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable targetA = new TargetEx(); // run 함수에 A면 num 증가, a가 아니면 num
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}

}
