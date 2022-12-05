package co.lec.ex1_student;
// ������ : name(String), kor(int), eng(int), mat(int), ���� tot(int), ��� avg (doulbe)
// �޼ҵ� : infoString(); infoPrint()  // ����Ұ�
// Student st = new Student();
public class Student {
	private String name;
	private int    kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private double avg;
	public Student() {} // ����Ʈ ������
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
//      avg = (double)tot/3;
	}
	// Student s = new Student("���켺", 100,100,100);
	// soutout. (s.infoString()) => \t���켺\t100\t100\t100\t300\t100.00
	public String infoString() { // �޼ҵ�
//		return "\t" + name + "\t" + kor + "\t" +eng + "\t" + mat + "tot" + "\t" + avg;
		return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, mat, tot, avg);
		
	}
	// s.infoprint();
	public void infoPrint() {
		System.out.printf("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, mat, tot, avg);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}
