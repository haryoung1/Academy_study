package com.lec.ex12_account;

public class AccountMain {
	public static void main(String[] args) {
		Account acc1 = new Account("111-111", "ȫ�浿");
		ChekingAccount acc2 = new ChekingAccount("222-222", "������", 2000, "1111-2222-3333-4444");
		CreditLinaAccount acc3 = new CreditLinaAccount("333-333", "�̸���", 2000, "5555-666-777-888", 10000);
		acc1.deposite(10000);
		acc1.withdraw(10000);
		acc2.pay("1111-2222-3333-4444", 10000);
		acc3.pay("1111-1111-1111-1111", 2000);
	}
}
