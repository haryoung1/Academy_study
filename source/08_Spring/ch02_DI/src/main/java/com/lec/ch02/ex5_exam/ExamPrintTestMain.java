package com.lec.ch02.ex5_exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamPrintTestMain {
	public static void main(String[] args) {
//		-- 기존의 방식 -- 
//		Exam exam = new ExamImpl("홍길동", 100,99,98,95);
//		ExamPrint examPrint = new ExamPrintImpl(exam);
		String location = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		ExamPrint examPrint = ctx.getBean("examPrint", ExamPrint.class);
		examPrint.print();
		ctx.close();
	}
}
