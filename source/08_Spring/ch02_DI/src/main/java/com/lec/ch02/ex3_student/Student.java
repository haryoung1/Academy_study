package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student { 
	// xml에 파싱할때 꼭 순서를 지켜서 넣어야 함
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
}
