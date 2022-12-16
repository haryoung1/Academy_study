package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Book implements ILendable {

	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private byte state; // 대출가능 (0), 대출중(1)
	private Date checkOutDate; // 대출일

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if (state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "도서는 대출중입니다.");
			return;
		}
		// state 가 0 (STATE_NORMAL)이라서 대출 진행
		this.borrower = borrower;
		checkOutDate = new Date(); // now
		state = STATE_BORROWED; // "대출중 상태로 전환"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
		System.out.println(bookTitle + " 도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아닙니다.");
		}
		// checkOutDate와 현재시점간의 날짜계산
		// 연체료 출력 -> 연체료 냈는지 여부에 따라
		// state가 대출중 ( 1:STATE_BORROWE)이라 반납 처리
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		if (day > 14) {
			System.out.println("연체료 일일 100원 발생. 내야할 연체료 :" + ((day - 14)) * 100);
			Scanner scanner = new Scanner(System.in);
			System.out.println("연체료를 내셨나요? (y/n)");
			if (!scanner.next().equalsIgnoreCase("y")) {
				System.out.println("연체료를 내셔야 반납처리 됩니다.");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료 되었습니다");

	}

	@Override
	public String toString() {
		String msg = "책번호 : " + bookNo + "\t책이름 : " + bookTitle + " 저자 : " + writer;
		msg += (state == STATE_NORMAL) ? "대출가능" : "대출중 : ";
		if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
			msg += sdf.format(checkOutDate);
		}
		return msg;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutdate) {
		this.checkOutDate = checkOutdate;
	}
}