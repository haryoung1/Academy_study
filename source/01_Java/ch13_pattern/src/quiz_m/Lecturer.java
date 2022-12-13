package quiz_m;

public class Lecturer extends Person {
	
	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}

	public void print() {
		super.print();
		System.out.println("[강의과목]" + subject);
	}
}
