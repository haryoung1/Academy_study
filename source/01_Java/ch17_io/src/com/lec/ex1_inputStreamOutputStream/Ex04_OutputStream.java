package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt"); // (1) ������ ����.
			String msg = "Hello, Java \n ���� ��׿�. ������ �Ͱ� �ǽʼ�!";
			byte[] bs = msg.getBytes(); // String�� byte �迭�� �ٲٴ� �Լ�.
			try {
				os.write(bs);
				System.out.println("���� ��� ����");
			} catch (FileNotFoundException e) {
				System.out.println("���� ���� : " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // (3) �ݴ´�
			} catch (IOException ignore) { }
		}
	}
}