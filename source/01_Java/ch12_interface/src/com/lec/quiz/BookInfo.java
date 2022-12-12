package com.lec.quiz;

public class BookInfo {
	private String bookno;
	private String bookTitle;
	private String writer;

	public BookInfo(String bookno, String bookTitle, String writer) {
		this.bookno = bookno;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	public String getBookno() {
		return bookno;
	}

	public void setBookno(String bookno) {
		this.bookno = bookno;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}