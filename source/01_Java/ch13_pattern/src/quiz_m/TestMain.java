package quiz_m;

import quiz_I.JobLec;

public class TestMain {
	public static void main(String[] args) {
		Student st1 = new Student ("ABC","���浿", " �����ڹ�");
		Student st2 = new Student ("CBA","�����", " �ڹٴܱ�");
		Lecturer l1 = new Lecturer("BBB","���浿", " ������");
		Lecturer l2 = new Lecturer("CCC","ȫ�浿", " �����α׷���");
		Staff s1= new Staff("SSS", "������", " ����");
		Person[] person = {st1, st2, l1, l2, s1};
		System.out.println("�����ð��̴� �� �սô�.");
		for(Person p : person) {
			p.job();
		}
		System.out.println("���� �޾ƿ�");
		System.out.println("======================================");
		for(int i=0 ; i<person.length ; i++) {
			person[i].Get();
		}
		for(Person p : person) {
			p.print();
		}
		System.out.println("======================================");
		l1.setJob(new JobLec());
		for(Person p : person) {
			p.job();
		}
	}
}