package com.lec.ex2_date;


public class Main2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("A01", "È«±æµ¿", Dept.COMPUTER),
						  new Sawon2("A02", "±è±æµ¿", Dept.PLANNING),
						  new Sawon2("B01", "°­±Í¼ø", Dept.DESIGN,2022,01,14),
						  new Sawon2("B02", "±èÈï±¹", Dept.HUMANRESOURCES,2022,12,12),};
		for (Sawon2 sawon : sawons) {
		System.out.println(sawon);
		}
	}
}
