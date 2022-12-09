package com.lec.ex03_speaker;

public class TV implements IVolume {
	private int volumeLevel;
	private final int MAX_VOLUME = 30;
	private final int MIN_VOLUME = 0;
	public TV() {
		volumeLevel = 5;
	}
	
	@Override
	public void volumeUp() { // ������ 1�� ����
		if(volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1��ŭ �÷� ���� ������ : " + volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ("+MAX_VOLUME+")���� �ø��� ���߽��ϴ�.");
		}
	}
	
	@Override
	public void volumeUp(int level) {
		if(volumeLevel +level < MAX_VOLUME) {
			volumeLevel += level; //volumeLevel = volumeLevel + level;
			System.out.println("TV ������   "+level+ " ��ŭ �÷� ���� ������ : " + volumeLevel);
		}else {
			int tempLevel = MAX_VOLUME - volumeLevel; // 45 + 10 - 50
			volumeLevel = MAX_VOLUME;
			System.out.println("TV ������" + tempLevel + "��ŭ �÷� �ִ�ġ �Դϴ�");
		}
	}

	@Override
	public void volumDown() {
		if(volumeLevel > MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV ������ 1��ŭ ���� ���� ���� : " + volumeLevel);
		}else {
			System.out.println("TV ������ �ּ��Դϴ�");
		}
	}

	@Override
	public void volumDown(int level) {
		if(volumeLevel -level > MIN_VOLUME) { // ���纼���� 5, level 2
			volumeLevel -= level;
			System.out.println("TV ������ " +level+ "��ŭ ���� ���� ���� : " + volumeLevel);
		}else { // ���纼�� 5, level 7
			int tempLevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("TV ������ " + tempLevel + "��ŭ ���� �ּ� �Դϴ�");
		}
	}
}