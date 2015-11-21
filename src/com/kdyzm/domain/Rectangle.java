package com.kdyzm.domain;
/**
 * 用于封装活跃的节点数据
 * @author kdyzm
 *
 */
public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width
				+ ", height=" + height + "]";
	}
}
