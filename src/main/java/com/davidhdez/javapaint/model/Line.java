package com.davidhdez.javapaint.model;

public class Line extends ShapeDecorator {

	private final Point point1;
	private final Point point2;
	
	public Line(Point point1, Point point2, Shape decoratedShape) {
		super(decoratedShape);
		this.point1 = point1;
		this.point2 = point2;
	}
		
	public void create(String[][] matrix) {
		boolean horizontal = point1.getY() == point2.getY();
		if (horizontal) {
			if(point1.getX() <= point2.getX()) {
				// From left to right
				for (int i = point1.getX(); i <= point2.getX(); i++) {
					matrix[i][point1.getY()] = "X";
				} 					
			} else {
				// From right to left
				for (int i = point2.getX(); i <= point1.getX(); i++) {
					matrix[i][point2.getY()] = "X";
				} 
			}
		} else {
			if(point1.getY() <= point2.getY()) {
				// From up to down
				for (int i = point1.getY(); i <= point2.getY(); i++) {
					matrix[point1.getX()][i] = "X";
				}					
			} else {
				// From down to up
				for (int i = point2.getY(); i <= point1.getY(); i++) {
					matrix[point2.getX()][i] = "X";
				}
			}
		}
	}

	public void draw(String[][] matrix) {
		super.draw(matrix);
	}
}
