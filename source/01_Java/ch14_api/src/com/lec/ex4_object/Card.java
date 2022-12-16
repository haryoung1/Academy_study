package com.lec.ex4_object;
// new Card('��', 5);

public class Card {
	
	private char kind; // ��, ��,  ��, ��
	private int  num;  // 1~13
	
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "ī��  : " + kind + " " + num; // ī�� : �� 5
	}
	@Override
	public boolean equals(Object obj) {
		// card.equals(comCard) => card�� this. ComCard�� obj
		// obj�� null�� �ƴϰ�, obj�� Card Ÿ�� ��ü���� Ȯ����, kind�� num �� ��� return
		if(obj != null && obj instanceof Card) {
			// kind�� num �񱳰�� return
			Card other = (Card)obj;
			boolean kindChk = kind == other.kind; // String = kind.equals(other.kind)
			boolean numChk  = num  == other.num;
			
			return kindChk && numChk;
		}
			return super.equals(obj);
	}
}

