package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExamPrintImpl2 implements ExamPrint {
	private Exam exam2;

	public void print() {
		System.out.println("-------------------------");
		System.out.println("이름 : " + exam2.getName());
		System.out.println("-------------------------");
		System.out.println("총점 : " + exam2.getTotal());
		System.out.printf("평균 :%5.1f\n", exam2.getAvg());
		System.out.println("-------------------------");
	}

}
