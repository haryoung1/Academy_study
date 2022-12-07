package com.lec.ex03_point.copy;
// x,y / infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���)
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x,y);
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x,y,z �� �ʱ�ȭ");
		this.z = z;
	}
	@Override
	public String infoPrint() {
		return super.infoPrint() + ", z=" +z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}