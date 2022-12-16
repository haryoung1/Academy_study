package com.lec.ex4_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;

	public Point3D() {
	}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return String.format("X=%.1f, Y=%.1f, Z=%.1f", x, y, z);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Point3D other = (Point3D) obj;
			boolean xChk = x == other.x;
			boolean yChk = y == other.y;
			boolean zChk = z == other.z;
			return xChk && yChk && zChk;

		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}