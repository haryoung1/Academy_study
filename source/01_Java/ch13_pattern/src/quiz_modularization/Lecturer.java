package quiz_modularization;

import quiz_Interfaces.GetSalary;
import quiz_Interfaces.JobMng;

public class Lecturer extends Person {
	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	public void print() {
		super.print();
		System.out.println("\t [강의과목] "+ subject);
	}

}
