package com.lec.ex09_customer.copy;

import cons.Constant;

// name, tel, infoString
public class Customer extends Person {
	private String address;
	private int sum; // ���űݾ� ����
	private int point; // ����Ʈ(0.5%)
	private String date; // String�� �����ֺ��ʹ� Date��
	private boolean vip; 
	// Customer c = new Customer("ȫ�浿", "010-9999-9999", "����", "12-12")
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name+"�� ���� �����մϴ�. ����Ʈ 1000���� ��Ƚ��ϴ�.");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price; // ���űݾ׿� ����
		// int tempPoint = (int)(price * 0.05);
		int tempPoint = (int)(price * Constant.RATE);
		point += tempPoint; // ����Ʈ����
		System.out.println(getName()+"�� ����. �ݹ� ����Ʈ : " + tempPoint);
		System.out.println("���űݾ� : " + price);
		System.out.println("���� ����Ʈ : " + point);
		if(vip==false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName()+"�� VIP �������� ���׷��̵� �Ǽ̽��ϴ�. ���� �˰ڽ��ϴ�");
		}// if
	}// buy
	@Override
	public String infoString() {
		return super.infoString() + " [�ּ�]"+address + " [����Ʈ]"+point + " [�������űݾ�]" + sum + " [vip]" + vip;
	}
}









