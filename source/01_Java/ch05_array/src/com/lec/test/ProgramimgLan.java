package com.lec.test;
// {76,45,34,89,100,50,90,93}  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� 
//  ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ�
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] arr =  {76,45,34,89,100,50,90,93};
		int tot = 0;
		float average = 0f;
		int max = arr[0];
		int min = arr[0];
		for(int i=0 ; i<arr.length ; i++) {
			tot += arr[i];
		}
		average = tot / (float)arr.length;
		System.out.println("�հ� ="+ tot);
		System.out.println("��� ="+ average);
		for(int i= 1; i <arr.length; i++) {
			if(arr[i] > max) {
				System.out.println("�ִ밪 ="+ max);
			}else if(arr[i] < min) {
				System.out.println("�ּҰ� ="+ min);
			}
		}
	}
	
}
