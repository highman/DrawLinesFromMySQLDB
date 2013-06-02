package org.ossystem.it;

public class Point {
	private int id;
	private String name;
	private int XX;
	private int YY;
	
	public Point() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getXX() {
		return XX;
	}

	public void setXX(int xX) {
		XX = xX;
	}

	public int getYY() {
		return YY;
	}

	public void setYY(int yY) {
		YY = yY;
	}
	
	public String toString() {
		return this.id+" ["+this.XX+", "+this.YY+"]";
	}
}
