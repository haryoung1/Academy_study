package com.lec.ex4_object; //��, ��,  ��, ��

import java.util.Random;

public class Ex03_CardMain {
	public static void main(String[] args) {

		Card[] cards = { new Card('��', 1),  new Card('��', 2),
						 new Card('��', 3),  new Card('��', 4), 
						 new Card('��', 5),  new Card('��', 6), 
						 new Card('��', 7),  new Card('��', 8), 
						 new Card('��', 9),  new Card('��', 10),
						 new Card('��', 11), new Card('��', 12), 
						 new Card('��', 13), new Card('��', 10), };
		for (Card card : cards) {
			System.out.println(card);
		}// for
		 // ���Ƿ� ���� ī��� �迭���� ī�带 ��
		Random ran = new Random();
		char[] kinds = { '��', '��', '��', '��'};
		Card randomCard = new Card(kinds[ran.nextInt(4)], ran.nextInt(13)+1);
										  //  0~3���� ��������
		System.out.println("���Ƿ� ����  " + randomCard);
		int idx;
		for (idx= 0 ; idx<cards.length ; idx++) {
			if(cards[idx].equals(randomCard)) {
				System.out.println("�ѢѢ� " +idx+ "��° ī��� ��ġ �ТТ� \n��������");
				break;
			}
		}// for
		 // idx == cards.length : ��ġ�ϴ� ī�尡 ���°�.
		//  idx != cards.length : ��ġ�ϴ� ī�尡 ���°�.
		if(idx== cards.length) {
			System.out.println("=================");
			System.out.println("��ġ�ϴ� ī�尡 �����ϴ�");
		}
	}// main
}