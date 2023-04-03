package com.lec.ch02.ex2_bmi;

import lombok.Data;

@Data
public class BMICalculator {
	private double lowWeight; // 저체중 bmi 지수 기준점
	private double normal; // 정상체중 bmi 지수 기준점
	private double overWeight; // 1단계 비만 기준점
	private double obesity; // 2단계 비만 기준점

	public void bmiCalculation(double weight, double height) {
		// 60, 175.5 => 60 / (1.75*1.75)
		double h = height * 0.01;
		double result = weight / (h * h);
		System.out.println("BMI지수는 " + result);
		if (result <= lowWeight) {
			System.out.println("저체중 입니다.");
		} else if (result < normal) {
			System.out.println("정상체중 입니다.");
		} else if (result < overWeight) {
			System.out.println("과체중 입니다.");
		} else if (result > obesity) {
			System.out.println("1단계 비만 입니다.");
		} else {
			System.out.println("2단계 비만 입니다.");
		}
	}
}