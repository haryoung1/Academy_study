package com.lec.ex2;
// ctrl + shift + o : ���ʿ��� import ����
import com.lec.ex2_human.*; // ���� ��Ű���� �ִ� ��� Ŭ������ ����Ѵٴ� �� = " * "
import com.lec.ex2_human.kid.*;
public class HumanMain {
	public static void main(String[] args) {
		Woman woman1    =    new Woman();
		Woman woman2    =    new Woman();
	// ===============     =================
	// ���۷�������(��ü����)����      ��ü����(�ν��Ͻ� ����)
		System.out.println("woman1�� woman2�� ������ : " + (woman1 == woman2));
		System.out.println("woman1�� woman2�� ������ : " + (woman1.equals(woman2)));
		Man man = new Man();
		Kid kid1 = new Kid("ȫ�Ʊ�");
		// kid kid2 = new kid(); �����ڰ� ������ �Լ��� ����� ����Ʈ ������ �Լ��� �ڵ����� ����.
		Man hong = new Man("ȫ�浿");
		Man kim = new Man("��浿", 22, 180, 67);
		Man kim2 = kim;
		
		kim2.setHeight(185); kim2.setWeight(300);
		System.out.println("kim�� kim2�� ���� ��ü�� : " + kim.equals(kim2));
		double bmi = kim.calculateBMI();
		System.out.println(kim2.getName()+"�� bmi������" + bmi);
	}
}










