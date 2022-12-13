package com.lec.ex1_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.append("def"); // abcdef (abc�� def�߰�)
		System.out.println("append �� : " + strBuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.insert(3, "AAA"); // 3��°�� AAA�� �߰��� =  abcAAAdef
		System.out.println("insert �� : " + strBuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.delete(3, 6); // 3��°���� 6��° �ձ���
		System.out.println("delete �� : " +strBuffer);
		int capacitySize = strBuffer.capacity(); // Buffer�� ����ũ��
		System.out.println("Buffer�� ����ũ��  : " + capacitySize);
		strBuffer.append("abcdefghijklmnopqrstuvwxyz01234567454894");
		System.out.println("append ��  " + strBuffer );
		System.out.println("�ؽ��ڵ�  : "+ strBuffer.hashCode());
		System.out.println("���� ���ڸ� �߰��� �� ���� ũ�� :" + strBuffer.capacity());
	}
}
