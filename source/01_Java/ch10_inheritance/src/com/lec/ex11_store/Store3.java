package com.lec.ex11_store;
// 3È£Á¡ : ±èÄ¡Âî°³-6,000 ºÎ´ëÂî°³-7,000 ºñºö¹ä-7,000 ¾óÅ« ¼ø´ë±¹-6,000
public class Store3 extends HeadQuaterStore {

	public Store3(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 6,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 7,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 7,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¾óÅ« ¼ø´ë±¹ : 6,000¿ø");
	}
}