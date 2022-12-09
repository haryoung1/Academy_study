package com.lec.ex03_speaker;
// �������̽� - static final ����(���)�� �߻�޼ҵ� / ���� : default �޼ҵ�, static �޼ҵ�
// �۾�����
public interface IVolume {
	public void volumeUp(); // ���� ������ 1�� up
	public void volumeUp(int level); // ���� ������ level �� up
	public void volumDown(); // ���� ������ 1�� down
	public void volumDown(int level); // ���� ������ level �� down
	public default void setMute(boolean mute) { // ����Ʈ �޼ҵ�
		if(mute) {
			System.out.println("����");
		}else {
			System.out.println("��������");
		}
	}
	public static void changeBattery() { // static �޼ҵ�
		System.out.println("�������� ��ȯ �մϴ�");
	}
}