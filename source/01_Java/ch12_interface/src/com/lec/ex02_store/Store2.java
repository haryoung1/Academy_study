package com.lec.ex02_store;
// 2È£Á¡ : ºÎ´ëÂî°³ - 5,000 ºñºö¹ä - 5,000 °ø±â¹ä ¹«·á
public class Store2 implements HeadQuarterStore {
	
	private String store;
	public Store2(String store) {
		this.store = store;
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 5,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 5,000¿ø");
	}
	@Override
	public void gongi() {
		System.out.println("°ø±â¹ä : ¹«·á");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 5,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ : 5,000¿ø");
	}
	@Override
	public String getStoreName() {
		return store;
	}
}