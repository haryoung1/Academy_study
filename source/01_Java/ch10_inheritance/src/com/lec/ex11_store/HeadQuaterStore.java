package com.lec.ex11_store;
// ���� : ��ġ� -5,000     �δ��-6,000     �����-6,000     ���뱹-5,000      �����-1,000
// HeadQuaterStore head = new HeadQuarterStore("= = ���� = = "
public class HeadQuaterStore {
	private String storeName;
	public HeadQuaterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");
	}
	public void bude() {
		System.out.println("�δ�� : 6,000��");
	}
	public void bibim() {
		System.out.println("����� : 6,000��");
	}
	public void sunde() {
		System.out.println("���뱹 : 5,000��");
	}
	public void gongi() {
		System.out.println("����� : 1,000��");
	}
	public String getStoreName() {
		return storeName;
	}
}