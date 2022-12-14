package com.lec.ex2_date;


public class Main {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("A01", "È«±æµ¿", Sawon.COMPUTER),
						  new Sawon("A02", "±è±æµ¿", Sawon.PLANNING),
						  new Sawon("B01", "°­±Í¼ø", Sawon.DESIGN,2022,01,14),
						  new Sawon("B02", "±èÈï±¹", Sawon.HUMANRESOURCES,2022,12,12),};
		for (Sawon sawon : sawons) {
		System.out.println(sawon);
		}
	}
}
