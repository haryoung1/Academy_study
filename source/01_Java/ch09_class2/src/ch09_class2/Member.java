package ch09_class2;

public class Member {
	private String name; 		// �̸�
	private String id;			// ���̵�
	private String bh;			// ����
	private String mail; 		// �̸���
	private String add; 		// �ּ�
	private int pw;				// ��й�ȣ
	private char gender;		// ����
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
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + (gender=='m'?"����": (gender=='f'? "����":"��")));
	}
	public String infoString() {
		String result = "�̸� : " + name;
		result += "\n���� : " + (gender=='m' ? "����" : (gender=='f' ? "����" : "��"));
		result += "\n�ּ� : " + add;
		result += "\nID : " + id;
		result += "\nPW : " + pw;
		result += "\n�̸��� : " + mail;
		result += "\n���� : " + bh;
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
