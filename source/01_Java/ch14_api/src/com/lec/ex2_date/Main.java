package com.lec.ex2_date;


public class Main {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("A01", "ȫ�浿", Sawon.COMPUTER),
						  new Sawon("A02", "��浿", Sawon.PLANNING),
						  new Sawon("B01", "���ͼ�", Sawon.DESIGN,2022,01,14),
						  new Sawon("B02", "���ﱹ", Sawon.HUMANRESOURCES,2022,12,12),};
		for (Sawon sawon : sawons) {
		System.out.println(sawon);
		}
	}
}
