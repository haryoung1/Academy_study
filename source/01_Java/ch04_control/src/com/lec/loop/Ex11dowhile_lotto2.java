package com.lec.loop;
import java.util.Scanner;
// 컴퓨터가 발생한 로또 난수를 맞추기
public class Ex11dowhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // (lotto)컴퓨터로또번호 (su) 사용자로 부터 입력받은 수
		int min=1, max=45;
		Scanner scanner = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1); // 로또번호
		do {
			System.out.printf("로또 번호 한개를 맞춰 보세요 (%d~%d) : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("주어진 범위를 참조하세요");
				
			}else if(su>lotto) {
				max = su-1;
				// System.out.println(su+"보다 작은수에 도전하세요. ");
			}else if(su<lotto) {
				min = su+1;
				// System.out.println(su+"보다 높은수에 도전하세요. ");
			}
		}while(su!=lotto);
		System.out.println("축하축하 맞추셨습니다.");
	}
}
