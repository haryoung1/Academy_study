package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt"); // (1) 파일을 연다.
			String msg = "Hello, Java \n 많이 춥네요. 안전한 귀가 되십쇼!";
			byte[] bs = msg.getBytes(); // String을 byte 배열로 바꾸는 함수.
			try {
				os.write(bs);
				System.out.println("파일 출력 성공");
			} catch (FileNotFoundException e) {
				System.out.println("폴더 예외 : " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("쓰기 예외 : " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // (3) 닫는다
			} catch (IOException ignore) { }
		}
	}
}