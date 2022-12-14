package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-1", "���� ���빮"),
							 new Friend("��浿", "010-8888-9999", "12-1", "���� ����"),
							 new Friend("�ű浿", "010-9999-7777", "12-1", "���� ���"),
							 new Friend("���浿", "010-6666-6666", "12-1", "��õ �۵�"), };
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) +1;    // 12
		int day   = now.get(Calendar.DAY_OF_MONTH); // 12
		String monthStr = month<10 ? "0"+ month : "" + month; // ""+ 12 => "12"
//		String monthStr = month<10 ? "0"+ month : String.valueOf(month); // "12
		String dayStr = day <10 ? "0"+day : ""+day;
		String today = monthStr + "-" + dayStr;
		System.out.println(today); // 3-3
		boolean none = true;
		System.out.println();
		System.out.println("���� ������ ģ�� ����� �˻� �մϴ�");
		System.out.println();
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // �Ѹ��̻� ��½� none�� false
			}// if
		}// for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}// main
}// class
