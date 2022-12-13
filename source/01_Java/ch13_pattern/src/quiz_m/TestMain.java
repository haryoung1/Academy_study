package quiz_m;

import quiz_I.JobLec;

public class TestMain {
	public static void main(String[] args) {
		Student st1 = new Student ("ABC","강길동", " 국비자바");
		Student st2 = new Student ("CBA","강길순", " 자바단기");
		Lecturer l1 = new Lecturer("BBB","유길동", " 빅데이터");
		Lecturer l2 = new Lecturer("CCC","홍길동", " 웹프로그래밍");
		Staff s1= new Staff("SSS", "유용현", " 관리");
		Person[] person = {st1, st2, l1, l2, s1};
		System.out.println("업무시간이니 일 합시다.");
		for(Person p : person) {
			p.job();
		}
		System.out.println("지급 받아요");
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