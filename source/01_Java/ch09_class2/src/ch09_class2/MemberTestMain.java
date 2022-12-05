package ch09_class2;

public class MemberTestMain {
	public static void main(String[] args) {
		//Member member = new Member("홍길동", "아이디", "2000-12-15", "mail@NAVER.COM", "서울시 서대문구", 1541, 'M');
		//System.out.println(member.infoString());
		Member p1 = new Member("홍씨", "아이리", "2001-12-15", "naver.com", "주소주소", 3432, 'f');
		Member[] member = new Member[2];
		member[0] = p1;
		member[1] = new Member("박씨", "아이비", "1999-12-15", "naver.com", "주소라네", 9999, 'm');
		for(Member p : member) {
			System.out.println(p.infoString());
		}
	}
}
