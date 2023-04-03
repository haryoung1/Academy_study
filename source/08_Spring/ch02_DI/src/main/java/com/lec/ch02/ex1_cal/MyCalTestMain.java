package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalTestMain {
	public static void main(String[] args) {
//		기존방식
//		Calculator cal = new Calculator();
//		MyCalculator myCal = new MyCalculator();
//		myCal.setCalculator(cal);
//		myCal.setNum1(10);
//		myCal.setNum1(5);
		
		String resoruceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resoruceLocation);
		// MyCalculator myCal = (MyCalculator) ctx.getBean("myCal");
		MyCalculator mycal = ctx.getBean("mycal", MyCalculator.class);
		mycal.add();
		mycal.sub();
		mycal.mul();
		mycal.div();
		ctx.close(); // 마지막에는 close
	}
}
