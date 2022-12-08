package com.lec.ex12_account;

public class ChekingAccount extends Account {
	
	private String cardNo;

	public ChekingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public ChekingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNO, int amount) {
		if(this.cardNo.equals(cardNO)) { // �ùٸ� ī���ȣ �Է�
			if(getBalance() >= amount) { // ���Ұ���
				// balance = balance - amount;
				setBalance(getBalance()-amount); // �ܾ��� amount ��ŭ ����
				System.out.printf("%s�� %d�� �����Ͽ� ����(%s)�� �ܾ� %d��\n", getOwnerName(), amount, getAccountNo(), getBalance());
			}else { // �ܾ׺������� ���ҺҰ�
				System.out.printf("%s�� �ܾ��� �����Ͽ� ���� �Ұ� �մϴ�\n", getOwnerName());
			}
		}else { // Ʋ�� ī���ȣ �Է�
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
} // class
