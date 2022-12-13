package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va   ";
		System.out.println("1. " + str1.concat(str2));   // 1. abcXabcabcXabc
		System.out.println("2. " + str1.substring(3));   // 2. 글자의 3번째부터 끝까지 출력  = Xabc
		System.out.println("3. " + str1.substring(3,5)); // 3. 글자의 3번째부터 5번째 앞까지 출력  = Xa
		System.out.println("4. " + str1.length());		 // 4. 문자열 길이출력 : 7글자
		System.out.println("5. " + str1.toUpperCase());  // 5. 대문자로 출력
		System.out.println("6. " + str1.toLowerCase());  // 6. 소문자로 출력
		System.out.println("7. " + str1.charAt(3));      // 7. 3번째 문자출력 : "X"3
		System.out.println("8. " + str1.indexOf('b'));	 // 8. 첫번째 b가 나오는 인덱스 : "1"
		System.out.println("9. " + str1.lastIndexOf("b")); // 9. 마지막 b가 나오는 인덱스
		String str4 = "abcXabcXabcXabc@";
		System.out.println("10. " + str4.indexOf("b", 3));  // 10. 3번째 인덱스부터 나오는 첫 b "5"
		System.out.println("11. " + str4.indexOf("cXa"));   // 11. 처음 나오는 cXa의 인덱스  "2"
		System.out.println("12. " + str4.indexOf("cXa",9)); // 12. 9번째부터 나오는 cXa "10"
		System.out.println("13. " + str4.indexOf("@"));	    // 13. 리턴된 문자가 없으면 "-1"
		System.out.println("14. " + str1.equals(str2));		// 14. 같은 스트링은 true "true"
		System.out.println("15. " + str1.equalsIgnoreCase("abcxabc")); // 15. 대소문자 없이 비교
		System.out.println("16. " + str3.trim()); // 16. 앞뒤 space 제거 "ja va"
		System.out.println("17. " + str4.replace("abc", "바꿔")); // 17. 문자를 바꾸는기능.
		System.out.println("str1= " + str1);
		System.out.println("str3= " + str3);
		System.out.println("str4= " + str4);
	}
}