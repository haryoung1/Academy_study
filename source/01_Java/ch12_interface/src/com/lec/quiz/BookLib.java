package com.lec.quiz;
// Book book = new Book ("899��-01-11", "å�̸�", "�����̸�")

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower;     // ������
	private String checkOutDate; // ������
	private byte state;			 // ���Ⱑ�� (0), ������(1)
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo,bookTitle,writer);
	}

	@Override
	public void checkOut(String borrow, String checkOutDate) {
		if(state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + " ������ �������Դϴ�.");
			return;
		}
		// state �� 0 (STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "������ ���·� ��ȯ"
		System.out.println(getBookTitle()+ " ������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrow + "\t������ : "+ checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		// state�� ������ ( 1:STATE_BORROWE)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ� �Ǿ����ϴ�");

	}

	@Override
	public void printState() {
//		if(state==STATE_NORMAL) {
//		System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"��) - ���Ⱑ��");
//		}else if(state ==STATE_BORROWED) {
//		System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"��) - ���� ��");
//		}
		String msg = getBookno() + "\t" + getBookTitle() + "(" + getWriter() +" ��) - ";
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "������";
		System.out.println(msg);
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
}