package com.lec.loop;
//짝수를 입력 받아 출력
import java.util.Scanner;

public class Ex10dowhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do{
			System.out.print("짝수를 입력하시오");
			num = scanner.nextInt();
		}while(num%2!=0);
		System.out.println("입력한 짝수는 " + num);
		scanner.close();
	}
}
