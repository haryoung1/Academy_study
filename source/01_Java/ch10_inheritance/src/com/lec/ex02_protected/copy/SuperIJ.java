package com.lec.ex02_protected.copy;
// �θ� Ŭ����
public class SuperIJ {
	 int i;
	protected int j;
	public SuperIJ () { // ��� ���� Ŭ�������� �θ�Ŭ������ ����Ʈ �����ڰ� ȣ��. // �Ű����� ���� ������
		System.out.println("�Ű����� ���� SuperIJ ������ �Լ�");
	}
	public SuperIJ (int i, int j) { // �Ű����� �ִ� ������ (��ȣ �ȿ� ���� ������) // ���� ��������
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ��� i,j �� �ʱ�ȭ");
		this.i =i;
		this.j =j;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}