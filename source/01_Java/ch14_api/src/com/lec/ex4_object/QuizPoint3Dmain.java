package com.lec.ex4_object;

public class QuizPoint3Dmain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
//		p1.setX(15);
//		p1.setY(20);
//		p1.setZ(30);
		Point3D p2 = (Point3D)p1.clone();
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		if (p1.equals(p2)) {
			System.out.println("���� ������ ����Ʈ ��ü");
		} else {
			System.out.println("�ٸ� ������ �簢�� ��ü");
		}
		if (p1 == p2) {
			System.out.println("���� �� ���� ������");
		} else {
			System.out.println("�ٸ� �ּ�");
		}
		if (p1 != p2 && p1.equals(p2)) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
}
