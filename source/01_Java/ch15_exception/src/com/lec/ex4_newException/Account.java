package com.lec.ex4_newException;

/* ������(�Ӽ�) : accountNo(String), ownerName(String), balance(long) // ���¹�ȣ, ������, �ܾ�
 * ���(�޼ҵ�) : deposit(����), withdraw(����), infoPrint �������  */
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;

	public Account() {
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance = 0;
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. �ܾ� : " + balance);
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. �ܾ� : " + balance);
	}

	public void deposite(long money) { // �����ϱ�
		balance += money;
		System.out.println(money + "�� �����Ͽ� ���� �ܾ� : " + balance);
	}

	public void withdraw(long money) throws Exception { // �ܾ��� ���� ��츸 �����ϱ�. �ֺܾ����� ���ٰ� �޼��� ���
		if (balance >= money) {
			balance -= money;
			System.out.println(money + "�� �����Ͽ� ���� �ܾ� : " + balance);
		} else {
			// ch 15�忡���� �������� �߻�
			throw new Exception("�ܾ��� �����Ͽ� ���� �Ұ� !!!");
		}
	}

	public void infoPrint() {
		System.out.printf("\" %s \" %s�� �ܾ� : %d��\n", accountNo, ownerName, balance);
	}

	public String infoString() {
		// return "\""+accountNo+"\""+ownerName+"�� �ܾ� : " + balance + "��";
		return String.format("\" %s \" %s�� �ܾ� : %d��\n", accountNo, ownerName, balance);
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