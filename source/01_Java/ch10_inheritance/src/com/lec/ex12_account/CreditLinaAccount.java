package com.lec.ex12_account;

public class CreditLinaAccount extends ChekingAccount {
	private long creditLine;

	public CreditLinaAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLinaAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
		public void pay(String cardNO, int amount) {
			if(getCardNo().equals(cardNO)) { // 올바른 카드번호 입력
				if(creditLine >= amount) { // 지불가능
					// creditLine = creditLine - amount;
					creditLine -= amount;
					System.out.printf("%님 %d원 지불하여 한도 %d원\n", getOwnerName(), amount, creditLine);
				}else { // 한도부족
					System.out.printf("%님 한도부족 지불 불가 합니다\n", getOwnerName());
				}
			}else { // 틀린 카드번호 입력
				System.out.println("유효한 카드 번호가 아닙니다");
			}
	}
}