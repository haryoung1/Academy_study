package com.lec.ex;
// ���׿����� (����)? (������ ���� ��� ���� ��) : (������ ������ ��� ���� �� )
public class EX05 {
	public static void main(String[] args) {
		int h = 100;
		String result = (h%2==0)? "¦���Դϴ�":"Ȧ���Դϴ�";
//		String result; // ¦Ȧ���� ���
//		if(h%2 ==0) {
//			result = "¦���Դϴ�";
//		}else {
//			result = "Ȧ���Դϴ�";
//		}
		System.out.println("����� "+result);
	}
}
