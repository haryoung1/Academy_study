package ch09_class2;

public class MemberTestMain {
	public static void main(String[] args) {
		//Member member = new Member("ȫ�浿", "���̵�", "2000-12-15", "mail@NAVER.COM", "����� ���빮��", 1541, 'M');
		//System.out.println(member.infoString());
		Member member1 = new Member("ȫ", "���̸�", "2001-12-15", "naver.com", "�ּ��ּ�", 3432, 'f');
		Member member2 = new Member("��", "���̺�", "1999-12-15", "naver.com", "�ּҶ��", 9999, 'm');
		Member[] members = {member1, member2};
		for(Member member : members) {
			System.out.println(member.infoString());
		}
	}
}