package quiz_m;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
	}
	public void print() {
		super.print();
		System.out.println("[ºÎ¼­]" + part);
	}
}
