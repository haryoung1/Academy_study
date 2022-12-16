package com.lec.ex7_tirmer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("~ ~ ~작업2 : 1초후 0.5초마다 실행 될 예정인 Timer Task");
	}
}