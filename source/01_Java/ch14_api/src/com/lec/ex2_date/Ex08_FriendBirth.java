package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-04", "���� ���빮"),
							 new Friend("��浿", "010-8888-9999", "12-14", "���� ����"),
							 new Friend("�ű浿", "010-9999-7777", "12-14", "���� ���"),
							 new Friend("���浿", "010-6666-6666", "01-14", "��õ �۵�"), };
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		String today = sdf1.format(now.getTime());
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻� �մϴ�");
		System.out.println();
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false; // �Ѹ��̻� ��½� none�� false
//			}// if
//		}// for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}// main
}// class
