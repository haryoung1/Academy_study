package ch09_class2;

public class MemberTestMain {
	public static void main(String[] args) {
		//Member member = new Member("홍길동", "아이디", "2000-12-15", "mail@NAVER.COM", "서울시 서대문구", 1541, 'M');
		//System.out.println(member.infoString());
		Member member1 = new Member("홍", "아이리", "2001-12-15", "naver.com", "주소주소", 3432, 'f');
		Member member2 = new Member("박", "아이비", "1999-12-15", "naver.com", "주소라네", 9999, 'm');
		Member[] members = {member1, member2};
		for(Member member : members) {
			System.out.println(member.infoString());
		}
	}
}