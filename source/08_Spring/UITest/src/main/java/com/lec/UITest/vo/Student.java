package com.lec.UITest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public int sum() {
		return kor + eng + mat;
	}

	public double avg() {
		return sum() / 3.0;
	}
}
