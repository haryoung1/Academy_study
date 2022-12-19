package com.lec.ex3_set;

public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + "학년 " + name;
	}

	@Override
	public int hashCode() {
		return toString().hashCode(); // 같은 grade 와 같은 name일 경우 toString() 결과가 같아 같은 hashCode 반환
	}

	@Override
	public boolean equals(Object obj) { // s1.equals(s2) : s1은 this, s2는 obj
		if (obj != null && obj instanceof Student) {
			return grade == ((Student) obj).grade;
		} else {
			return false;
		}
	}
}