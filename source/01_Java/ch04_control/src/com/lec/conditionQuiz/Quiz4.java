package com.le.conditionQuiz;
import java.util.Scanner;
// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
// ��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, 
// ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���������� ���� �Դϴ�.\n");
		System.out.println("����(0), ����(1), ��(2)��  �ϳ��� ���� ���ּ���. : ");
		int user = scanner.nextInt(); // ����
		if (user ==0) {
			System.out.println("user : 0 (����) ");
		}
		if (user ==1) {
			System.out.println("user : 1 (����) ");
		}
		if (user ==2) {
			System.out.println("user : 2 (��)  ");
		}

		int com=(int)(Math.random()*3); // ��ǻ��
		if(com==0) {
			System.out.println("computer : 0 (����)");
		}
		if(com==1) {
			System.out.println("computer : 1 (����)");
		}
		if(com==2) {
			System.out.println("computer : 2 (��)");
		}
		if(com==0)
		{
			if(user==0) {
				System.out.println("�����ϴ�.");
			}
			if(user==1) {
				System.out.println("���� �մϴ�!. �̰���ϴ�.");
			}
			if(user==2) {
				System.out.println("�ƽ��׿� �й� �Ͽ����ϴ� ��.��");
			}
		}
		if(com==1) {
			if(user==0){
				System.out.println("�ƽ��׿�. �й� �Ͽ����ϴ� ��.��");
			}
			if(user==1){
				System.out.println("�����ϴ�.");
			}
			if(user==3)
			{
				System.out.println("�����մϴ�!. �̰���ϴ�.");
			}
		
		}
		if(com==2) {
			if(user==0)
			{
				System.out.println("�����մϴ�!. �̰���ϴ�.");
			}
			if(user==1)
			{
				System.out.println("�ƽ��׿�. �й� �Ͽ����ϴ� ��.��");
			}
			if(user==2)
			{
				System.out.println("�����ϴ�.");
			}
		}
		scanner.close();
	}
	
}
