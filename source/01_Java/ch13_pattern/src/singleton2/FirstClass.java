package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass ������ ������");
		SingletonClass SingleObject = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i �� :" + SingleObject.getI());
		SingleObject.setI(999);
		System.out.println("�̱��� ��ü�� i �� ���� �� : " +SingleObject.getI());
	}
}
