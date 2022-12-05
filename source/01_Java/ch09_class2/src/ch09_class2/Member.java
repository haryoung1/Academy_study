package ch09_class2;

public class Member {
	private String name; 		// 이름
	private String id;			// 아이디
	private String bh;			// 생일
	private String mail; 		// 이메일
	private String add; 		// 주소
	private int pw;				// 비밀번호
	private char gender;		// 성별
	public Member() {}
	public Member(String name, String id, String bh, String mail, String add, int pw, char gender) {
		this.name = name;
		this.id = id;
		this.bh = bh;
		this.mail = mail;
		this.add = add;
		this.pw = pw;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + (gender=='m'?"남자": (gender=='f'? "여자":"무")));
	}
	public String infoString() {
		String result = "이름 : " + name;
		result += "\n성별 : " + (gender=='m' ? "남자" : (gender=='f' ? "여자" : "무"));
		result += "\n주소 : " + add;
		result += "\nID : " + id;
		result += "\nPW : " + pw;
		result += "\n이메일 : " + mail;
		result += "\n생일 : " + bh;
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
