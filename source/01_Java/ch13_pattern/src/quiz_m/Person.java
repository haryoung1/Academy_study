package quiz_m;

import quiz_Interfaces.GetImpl;
import quiz_Interfaces.JobImpl;

public class Person {
	private String id;
	private String name;
	private GetImpl get;
	private JobImpl job;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void job() {
		this.job = job;
	}
	public void Get() {
		this.get = get;
	}
	public void print() {
		System.out.print("[ID]" +id+ "\t[¿Ã∏ß]" +name);
	}
	public void setJob(JobImpl job) {
		this.job = job;
	}
	public void setGet(GetImpl get) {
		this.get = get;
	}
}