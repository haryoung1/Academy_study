package com.lec.ex03_point;
// x,y / infoPrint() 
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x,y,z �� �ʱ�ȭ");
		setX(x);
		setY(y);
		this.z = z;
	}
	public void infoPrint3d() {
		System.out.println("��ǥ x=" + getX() + ", y=" + getY() +", z=" +z);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}