package com.lec.ex;
import java.util.Scanner;
public class EX111 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����߿� ����.");
		System.out.println("�߻����, ������� , �ܻ����");
		String sungbin = "�߻����";
		String sungbin1 = scanner.next();
		// if�� ���࿡ ��� ������
		// ���࿡ sungbin�� �߻���ٰ� �� ������ ���
		if(sungbin =="�������") { // ������� = ��� X
			System.out.println("�Ф�");
		}
		else if(sungbin == "�߻����") { // �����ϱ� ���
			System.out.println("���� �帳�ϴ�");
		}
		else if(sungbin == "�ܻ����") { // ��Ÿ = ��� X
			System.out.println("��Ÿ��");
		}
	}//m
}//c
