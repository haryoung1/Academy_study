package com.lec.ex;
<<<<<<< HEAD

//빈태그 사용하려면 : 매개변수 없는 생성자, setter, getter
=======
// 빈 태그 사용 하려면 ? : 매개변수 없는 생성자, setter, getter 필수
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
public class Person {
	private String name;
	private int age;
	private char gender; // 'm' 'f'
	private String address;

	public Person() {
	}

	public Person(String name, int age, char gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
