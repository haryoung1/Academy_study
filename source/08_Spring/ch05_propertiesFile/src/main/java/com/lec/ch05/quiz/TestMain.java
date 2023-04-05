package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("DEV? RUN(인수테스트) ? : ");
		String answer = sc.next(); // dev or run or ???

		if (answer.equalsIgnoreCase("DEV")) {
			config = "dev";
		} else if (answer.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.. 확인요망 !");
			System.exit(0); // 정상상태에서 강제종료
		}
		sc.close();

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/quiz/dev.xml";
		String loc2 = "classpath:META-INF/quiz/run.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		EnvInfo info = ctx.getBean("EnvInfo", EnvInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("PORT : " + info.getPortNum());
		System.out.println("user ID : " + info.getUserId());
		System.out.println("user PW : " + info.getUserPw());
		ctx.close();
	}
}
