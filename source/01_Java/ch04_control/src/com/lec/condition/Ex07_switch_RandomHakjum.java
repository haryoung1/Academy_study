package com.lec.condition;
// �����Ҷ����� ��ǻ�Ͱ� ����(Random)���� �߻��Ͽ� ���� ���
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
		// 0 < = Math.random() < 1
		// 0 < = Mats.random()*101 < 100 : �Ǽ�
		// 0 < = (int)Mats.random()*101 < 101 : ����
		//System.out.println(int)(Math.random()*101));
		int score = (int)(Math.random()*101);
		int temp = (score==100) ? score-1 : score;
		switch(temp/10) {
		case 9:
			System.out.println(score + ", A����"); break;
		case 8:
			System.out.println(score + ", B����"); break;
		case 7:
			System.out.println(score + ", C����"); break;
		case 6:
			System.out.println(score + ", D����"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println(score + ", F����"); break;
		default:
			System.out.println("��ȿ���� ���� ���� �Դϴ�.");
		}
		}
	}
