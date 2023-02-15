package com.lec.ex;

public class Student {
	private String hakno;
	private String name;
	private int grade;
	private char class1;
	private int score;

	public Student() {
	}

	public Student(String hakno, String name, int grade, char class1, int score) {
		this.hakno = hakno;
		this.name = name;
		this.grade = grade;
		this.class1 = class1;
		this.score = score;
	}

	public String getHakno() {
		return hakno;
	}

	public void setHakno(String hakno) {
		this.hakno = hakno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public char getClass1() {
		return class1;
	}

	public void setClass1(char class1) {
		this.class1 = class1;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}