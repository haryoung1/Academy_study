package com.lec.ex7_tirmer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true);    // ���α׷� ����� timer�� �޸� �������� X
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);      // 2�� �� �ѹ�
		timer.schedule(task2, 1000, 500); // 1���ĺ��� 0.5�ʸ��� run()����
		Thread.sleep(11000);
		System.out.println("��");
	}
}