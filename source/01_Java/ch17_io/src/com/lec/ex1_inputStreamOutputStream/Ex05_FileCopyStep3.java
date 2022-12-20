package com.lec.ex1_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// D:\webPro1\note/bts.mp4 => D:\webPro1\note/bts_copy.mp4 (8,075,033 바이트)
// JSP나 Spring에서 파일첨부 게시판 작성시 copy 할 로직

public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1 부터 시작지점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("D:\\webPro1\\note\\bts.mp4");
			is = new FileInputStream(file); // 1단계 스트림객체 생성(빨대)
			os = new FileOutputStream("D:\\webPro1\\note\\bts_copy.mp4");
			byte[] bs = new byte[(int) file.length()]; // 1킬로바이트
			int cnt = 0;
			while (true) { // 2번 수행
				cnt++;
				int Count = is.read(bs); // 2단계 read & write : bs에 읽음.
				if (Count == -1)
					break;
				os.write(bs, 0, Count); // bs배열을 0번 index부터 Count 바이트만큼 write
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일이나 폴더 못 찾음 " + e.getMessage()); // 파일명이 없으면 못찾음 (출력)
		} catch (IOException e) {
			System.out.println("read & writer 오류 : " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 3단계 파일 닫기, if문 사용하여 null 값이 아닐때 clsoe 파일 닫기 실행
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		long end = System.currentTimeMillis(); // 1970.1.1 ~ 끝나는 시점의 밀리세컨
		System.out.println(end - start);
	}// main
}