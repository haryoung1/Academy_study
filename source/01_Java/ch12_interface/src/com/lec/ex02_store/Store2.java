package com.lec.ex02_store;
// 2ȣ�� : �δ�� - 5,000 ����� - 5,000 ����� ����
public class Store2 implements HeadQuarterStore {
	
	private String store;
	public Store2(String store) {
		this.store = store;
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
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 : 5,000��");
	}
	@Override
	public String getStoreName() {
		return store;
	}
}