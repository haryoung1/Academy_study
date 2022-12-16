package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Book implements ILendable {

	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	private String borrower; // ������
	private byte state; // ���Ⱑ�� (0), ������(1)
	private Date checkOutDate; // ������

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if (state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "������ �������Դϴ�.");
			return;
		}
		// state �� 0 (STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		checkOutDate = new Date(); // now
		state = STATE_BORROWED; // "������ ���·� ��ȯ"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
		System.out.println(bookTitle + " ������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t������ : " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + "������ �������� �ƴմϴ�.");
		}
		// checkOutDate�� ����������� ��¥���
		// ��ü�� ��� -> ��ü�� �´��� ���ο� ����
		// state�� ������ ( 1:STATE_BORROWE)�̶� �ݳ� ó��
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		if (day > 14) {
			System.out.println("��ü�� ���� 100�� �߻�. ������ ��ü�� :" + ((day - 14)) * 100);
			Scanner scanner = new Scanner(System.in);
			System.out.println("��ü�Ḧ ���̳���? (y/n)");
			if (!scanner.next().equalsIgnoreCase("y")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó�� �˴ϴ�.");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ� �Ǿ����ϴ�");

	}

	@Override
	public String toString() {
		String msg = "å��ȣ : " + bookNo + "\tå�̸� : " + bookTitle + " ���� : " + writer;
		msg += (state == STATE_NORMAL) ? "���Ⱑ��" : "������ : ";
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