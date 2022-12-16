package com.lec.ex7_tirmer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {

	@Override
	public void run() { // 작업정의
		System.out.println("작업 1 : 2초 후에 한번 수행 될 예정인 Timer Task ★★★");
	}
}