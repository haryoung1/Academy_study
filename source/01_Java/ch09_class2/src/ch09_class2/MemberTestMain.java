package ch09_class2;

public class MemberTestMain {
	public static void main(String[] args) {
		//Member member = new Member("ȫ�浿", "���̵�", "2000-12-15", "mail@NAVER.COM", "����� ���빮��", 1541, 'M');
		//System.out.println(member.infoString());
		Member p1 = new Member("ȫ��", "���̸�", "2001-12-15", "naver.com", "�ּ��ּ�", 3432, 'f');
		Member[] member = new Member[2];
		member[0] = p1;
		member[1] = new Member("�ھ�", "���̺�", "1999-12-15", "naver.com", "�ּҶ��", 9999, 'm');
		for(Member p : member) {
			System.out.println(p.infoString());
		}
	}
}
