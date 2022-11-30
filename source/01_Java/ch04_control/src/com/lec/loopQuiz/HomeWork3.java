package com.lec.loopQuiz;
import java.util.Scanner;

// 
public class HomeWork3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, com;
		while(true) {
			System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요(종료:-1) ");
			you = scanner.nextInt();
			if(you==-1) break;
			com = (int)(Math.random()*3);
			String comstr = (com==0) ? "가위" : (com==1)?"바위":"보자기";
			String youStr = (you==0) ? "가위" : (you==1)?"바위":"보자기";
			if(you<-1 || you>2) {
				System.out.println("가위(0),바위(1),보(2) 중 하나");
			}else {
				if( (you+2)%3 == com) {
					System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요 ^.^\n", youStr, comstr);
				}else if((you+1)%3 == com)
					System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요 ㅠ.ㅠ\n", youStr, comstr);
			}else {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요\n",  youStr, comstr);
			}
			scanner.close();
			System.out.println("BYE");
	}
}