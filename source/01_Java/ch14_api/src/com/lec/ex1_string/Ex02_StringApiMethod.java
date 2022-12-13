package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va   ";
		System.out.println("1. " + str1.concat(str2));   // 1. abcXabcabcXabc
		System.out.println("2. " + str1.substring(3));   // 2. ������ 3��°���� ������ ���  = Xabc
		System.out.println("3. " + str1.substring(3,5)); // 3. ������ 3��°���� 5��° �ձ��� ���  = Xa
		System.out.println("4. " + str1.length());		 // 4. ���ڿ� ������� : 7����
		System.out.println("5. " + str1.toUpperCase());  // 5. �빮�ڷ� ���
		System.out.println("6. " + str1.toLowerCase());  // 6. �ҹ��ڷ� ���
		System.out.println("7. " + str1.charAt(3));      // 7. 3��° ������� : "X"3
		System.out.println("8. " + str1.indexOf('b'));	 // 8. ù��° b�� ������ �ε��� : "1"
		System.out.println("9. " + str1.lastIndexOf("b")); // 9. ������ b�� ������ �ε���
		String str4 = "abcXabcXabcXabc@";
		System.out.println("10. " + str4.indexOf("b", 3));  // 10. 3��° �ε������� ������ ù b "5"
		System.out.println("11. " + str4.indexOf("cXa"));   // 11. ó�� ������ cXa�� �ε���  "2"
		System.out.println("12. " + str4.indexOf("cXa",9)); // 12. 9��°���� ������ cXa "10"
		System.out.println("13. " + str4.indexOf("@"));	    // 13. ���ϵ� ���ڰ� ������ "-1"
		System.out.println("14. " + str1.equals(str2));		// 14. ���� ��Ʈ���� true "true"
		System.out.println("15. " + str1.equalsIgnoreCase("abcxabc")); // 15. ��ҹ��� ���� ��
		System.out.println("16. " + str3.trim()); // 16. �յ� space ���� "ja va"
		System.out.println("17. " + str4.replace("abc", "�ٲ�")); // 17. ���ڸ� �ٲٴ±��.
		System.out.println("str1= " + str1);
		System.out.println("str3= " + str3);
		System.out.println("str4= " + str4);
	}
}