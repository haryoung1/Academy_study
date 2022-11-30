package com.lec.loopQuiz;
import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¸î´Ü ¿øÇØ?");
		int dansu = scanner.nextInt();
		for(int i=1 ; i<10 ; i++) {
			//System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		scanner.close();
	}
}

