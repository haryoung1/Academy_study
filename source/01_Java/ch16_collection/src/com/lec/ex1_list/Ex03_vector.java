package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new A()); // 0번 인덱스
		vec.add(new B()); // 1번 인덱스
		vec.add("Hello, Collection"); // 2번 인덱스
		vec.add(10); // 3번인덱스
		System.out.println(vec);
	}
}
