package com.lec.loop;
//¦���� �Է� �޾� ���
import java.util.Scanner;

public class Ex10dowhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do{
			System.out.print("¦���� �Է��Ͻÿ�");
			num = scanner.nextInt();
		}while(num%2!=0);
		System.out.println("�Է��� ¦���� " + num);
		scanner.close();
	}
}
