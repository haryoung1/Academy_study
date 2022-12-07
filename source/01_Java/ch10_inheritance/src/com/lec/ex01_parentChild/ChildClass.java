package com.lec.ex01_parentChild;
// pStr, getPapaName(), getMamiName();
public class ChildClass extends ParentClass{ // extends (클래스) 추가하면 동일하게 사용가능.
	String cStr = "자식클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
}