package com.lec.loopQuiz;
import java.util.Scanner;

// 
public class HomeWork3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, com;
		while(true) {
			System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ���(����:-1) ");
			you = scanner.nextInt();
			if(you==-1) break;
			com = (int)(Math.random()*3);
			String comstr = (com==0) ? "����" : (com==1)?"����":"���ڱ�";
			String youStr = (you==0) ? "����" : (you==1)?"����":"���ڱ�";
			if(you<-1 || you>2) {
				System.out.println("����(0),����(1),��(2) �� �ϳ�");
			}else {
				if( (you+2)%3 == com) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� ^.^\n", youStr, comstr);
				}else if((you+1)%3 == com)
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� ��.��\n", youStr, comstr);
			}else {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n",  youStr, comstr);
			}
			scanner.close();
			System.out.println("BYE");
	}
}