package com.lec.ex11_store;
// 2ȣ�� : �δ�� - 5,000 ����� - 5,000 ����� ����
public class Store2 extends HeadQuaterStore {

	public Store2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� : 5,000��");
	}
	@Override
	public void gongi() {
		System.out.println("����� : ����");
	}
}