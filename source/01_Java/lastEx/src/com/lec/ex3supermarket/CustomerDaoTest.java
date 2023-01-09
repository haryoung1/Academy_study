package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
//		System.out.println("=== 1. ȸ������ ===");
		String phone = "010-1112-1111";
		String cname = "�̼���";
//		result = dao.insertCustomer(new CustomerDto(0, phone, cname, 0, 0, null, 0));
//		System.out.println(result == CustomerDao.SUCCESS ? cname + "�� ȸ������ ����. 1000����Ʈ �߰�" : cname + "�� ȸ������ ����");
//		phone = "010-2222-1111";
//		cname = "������";
//		result = dao.insertCustomer(new CustomerDto(0, phone, cname, 0, 0, null, 0));
//		System.out.println(result == CustomerDao.SUCCESS ? cname + "�� ȸ������ ����. 1000����Ʈ �߰�" : cname + "�� ȸ������ ����");
		System.out.println("=== 2. ��ȭ��ȣ �˻� ===");
		phone = "5555";
		customers = dao.phoneGetCustomers(phone);
		if (customers.isEmpty()) {
			System.out.println(phone + " ��ȭ��ȣ�� �˻��� ���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 3. ��ǰ����  ===");
		result = dao.buy(5, 200000); // 1�� ���� 20���� ����
		if (result == CustomerDao.SUCCESS) { // ��ǰ���Ű� ���� �Ǹ� ���� �޼����� �Բ� �� ���� ���
			CustomerDto customer = dao.getCustomer(5);
			System.out.println("��ǰ���� �����մϴ�. ���� ������ �Ʒ��� ���� ������Ʈ �Ǿ����ϴ�");
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			System.out.println(customer);
		} else {
			System.out.println("�߸� �Է� �ϼ̾��");
		}
		System.out.println("=== 4. ������ ��� ===");
		System.out.println("�������� : " + dao.getlevelname());
		customers = dao.levelNameGetCustomers("BRONZE");
		if (customers.size() == 0) {
			System.out.println("NORMAL ���� ���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 5. ��ü ��� ===");
		customers = dao.getCustomers();
		if (customers.isEmpty()) {
			System.out.println("���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			} // for
		} // if
		System.out.println("=== 6. ȸ��Ż�� ===");
		result = dao.deleteCustomer("010-5555-5555");
		System.out.println(result == CustomerDao.SUCCESS ? "��������" : "��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
		System.out.println("=== 5. ��ü ��� ===");
		customers = dao.getCustomers();
		if (customers.isEmpty()) {
			System.out.println("���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			} // for
		} // if
	}
}
