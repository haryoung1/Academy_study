package com.lec.ex12_account;
/* 데이터(속성) : accountNo(String), ownerName(String), balance(long) // 계좌번호, 예금주, 잔액
 * 기능(메소드) : deposit(예금), withdraw(인출), infoPrint 정보출력  */
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance = 0;
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : " + balance);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : " + balance);
	}
	public void deposite(long money) { // 예금하기
		balance += money; 
		System.out.println(money +"원 예금하여 현재 잔액 : "+ balance);
	}
	public void withdraw(long money) { // 잔액이 있을 경우만 인출하기. 잔애부족시 없다고 메세지 출력
		if(balance>=money) {
			balance -= money;
			System.out.println(money + "원 인출하여 현재 잔액 : "+ balance);
		}else {
			// ch 15장에서는 강제예외 발생
			System.out.println("잔액이 부족합니다.");
		}
	}
	public void infoPrint() {
		System.out.printf("\" %s \" %s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
	public String infoString() {
		//return "\""+accountNo+"\""+ownerName+"님 잔액 : " + balance + "원";
		return String.format("\" %s \" %s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
	// setter : ownername 
	// getter : accountNo, owenerName, balance
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}















