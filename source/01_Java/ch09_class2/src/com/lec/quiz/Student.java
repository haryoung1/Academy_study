package com.lec.quiz;
// 객체 생성 : new Student("정우성", 90,80,100); -> 번호, 총점, 평균도 같이 초기화 해야함.

public class Student {
	private int number;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public static int count;
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		number = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
	}
	
	public String infoString( ) {
		return String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%.1f\n",number,name, kor, eng, mat, tot, avg);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}