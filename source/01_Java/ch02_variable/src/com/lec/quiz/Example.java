package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		// ����, ����, ���� ���� �Ҵ�
		// ����, ���
		// ������ ���
		int kor = 85; // ����
		int math = 50; // ����
		int eng = 65; // ����
		int tot = kor + math + eng; // ����
		// double avg = tot / 3;
		// double avg = tot / 3.0;
		double avg = (double)tot / 3;
		System.out.println("============����ǥ================================");
		System.out.println("\t ���� \t ���� \t ����");
		System.out.println("\t 85 \t 50 \t 65");
		System.out.printf("\t ���� : %d\t��� : %.2f\n", tot, avg);
		System.out.println("================================================");
		
			
	}
}
