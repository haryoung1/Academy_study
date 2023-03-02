package com.le.conditionQuiz;
import java.util.Scanner;
// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
// 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 
// 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위바위보 게임 입니다.\n");
		System.out.println("가위(0), 바위(1), 보(2)중  하나를 선택 해주세요. : ");
		int user = scanner.nextInt(); // 유저
		if (user ==0) {
			System.out.println("user : 0 (가위) ");
		}
		if (user ==1) {
			System.out.println("user : 1 (바위) ");
		}
		if (user ==2) {
			System.out.println("user : 2 (보)  ");
		}

		int com=(int)(Math.random()*3); // 컴퓨터
		if(com==0) {
			System.out.println("computer : 0 (가위)");
		}
		if(com==1) {
			System.out.println("computer : 1 (바위)");
		}
		if(com==2) {
			System.out.println("computer : 2 (보)");
		}
		if(com==0)
		{
			if(user==0) {
				System.out.println("비겼습니다.");
			}
			if(user==1) {
				System.out.println("축하 합니다!. 이겼습니다.");
			}
			if(user==2) {
				System.out.println("아쉽네요 패배 하였습니다 ㅠ.ㅠ");
			}
		}
		if(com==1) {
			if(user==0){
				System.out.println("아쉽네요. 패배 하였습니다 ㅠ.ㅠ");
			}
			if(user==1){
				System.out.println("비겼습니다.");
			}
			if(user==3)
			{
				System.out.println("축하합니다!. 이겼습니다.");
			}
		
		}
		if(com==2) {
			if(user==0)
			{
				System.out.println("축하합니다!. 이겼습니다.");
			}
			if(user==1)
			{
				System.out.println("아쉽네요. 패배 하였습니다 ㅠ.ㅠ");
			}
			if(user==2)
			{
				System.out.println("비겼습니다.");
			}
		}
		scanner.close();
	}
	
}
