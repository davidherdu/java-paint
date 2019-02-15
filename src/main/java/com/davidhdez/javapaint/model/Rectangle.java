package com.davidhdez.javapaint.model;

public class Rectangle extends ShapeDecorator {
	
	private final Point point1;
	private final Point point2;

	public Rectangle(Point point1, Point point2, Shape decoratedShape) {
		super(decoratedShape);
		this.point1 = point1;
		this.point2 = point2;
	}

	public void create(String[][] matrix) {
		for (int i = point1.getX(); i <= point2.getX(); i++) {
			matrix[i][point1.getY()] = "X";
			matrix[i][point2.getY()] = "X";
		}
		for (int i = point1.getY(); i <= point2.getY(); i++) {
			matrix[point1.getX()][i] = "X";
			matrix[point2.getX()][i] = "X";
		}
	}

	public void draw(String[][] matrix) {
		super.draw(matrix);
	}
}
