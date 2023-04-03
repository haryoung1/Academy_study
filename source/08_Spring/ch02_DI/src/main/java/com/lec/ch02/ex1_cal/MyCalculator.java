package com.lec.ch02.ex1_cal;
// Main은 MyCalculator를 의존. MyCalculator 는 Calculator를 의존 한다

import lombok.Data;

@Data // setter, getter (생성)

public class MyCalculator {
	private Calculator calculator;
	private int num1;
	private int num2;

	public void add() {
		calculator.addition(num1, num2);
	}

	public void sub() {
		calculator.subtraction(num1, num2);
	}
	
	public void mul() {
		calculator.multiple(num1, num2);
	}
	
	public void div() {
		calculator.division(num1, num2);
	}
}
