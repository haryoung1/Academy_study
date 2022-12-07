package com.lec.ex02_protected.copy;
// private i, j / public setI(), getI(), setJ(), getJ()
public class Child extends SuperIJ{
	private int total;
	public Child() {
		super();
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) {
		super(i,j);
		System.out.println("매개변수 있는 child 생성자 함수 - i, j 초기화");
		//setI(i); // this는  private 이기 때문에 사용 불가. // this.i = i ; << 사용불가
		//setJ(j); // set로 가져와야함. but, private 대신 protected를 사용하면 상속 받았으니 this도 사용 가능.
//		this.i = i;
//		this.j = j;
	}
	public void sum() {
		total = getI() + getJ(); // total = i + j;
		System.out.println("i = " + getI() + ",  j=" + getJ()+ ", total=" + total);
	}
}
