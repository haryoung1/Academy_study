package com.lec.ex2_date;


public class Main2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("A01", "ȫ�浿", Dept.COMPUTER),
						  new Sawon2("A02", "��浿", Dept.PLANNING),
						  new Sawon2("B01", "���ͼ�", Dept.DESIGN,2022,01,14),
						  new Sawon2("B02", "���ﱹ", Dept.HUMANRESOURCES,2022,12,12),};
		for (Sawon2 sawon : sawons) {
		System.out.println(sawon);
		}
	}
}
