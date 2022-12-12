package quiz_modularization;

import quiz_Interfaces.GetImpl;
import quiz_Interfaces.JobImpl;

public abstract class Person {
	
	private String id;
	private String name;
	private String ban;
	private GetImpl get;
	private JobImpl job;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void job() {
		
	}
	public void get() {
		
	}
	public void print() {
		System.out.print("[id]" + id + "\t[¿Ã∏ß]" + name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public GetImpl getGet() {
		return get;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}

	public JobImpl getJob() {
		return job;
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}
}
