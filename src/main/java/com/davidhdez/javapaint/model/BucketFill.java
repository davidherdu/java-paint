package com.davidhdez.javapaint.model;

public class BucketFill extends ShapeDecorator {
	
	private final Point point;
	private final String colour;

	public BucketFill(Point point, String colour, Shape decoratedShape) {
		super(decoratedShape);
		this.point = point;
		this.colour = colour;
	}

	public void create(String[][] matrix) {
		createBucketFill(matrix, point, colour);
	}

	public void draw(String[][] matrix) {
		super.draw(matrix);
	}
	
	private void createBucketFill(String[][] matrix, Point point, String colour) {
		if (matrix[point.getX()][point.getY()] != null) {
			return;
		} else {
			matrix[point.getX()][point.getY()] = colour;

			// I see the top row
			createBucketFill(matrix, new Point(point.getX() - 1, point.getY() - 1), colour);
			createBucketFill(matrix, new Point(point.getX(), point.getY() - 1), colour);
			createBucketFill(matrix, new Point(point.getX() + 1, point.getY() - 1), colour);

			// I see the same row where I am
			createBucketFill(matrix, new Point(point.getX() - 1, point.getY()), colour);
			createBucketFill(matrix, new Point(point.getX() + 1, point.getY()), colour);

			// I see the down row
			createBucketFill(matrix, new Point(point.getX() - 1, point.getY() + 1), colour);
			createBucketFill(matrix, new Point(point.getX(), point.getY() + 1), colour);
			createBucketFill(matrix, new Point(point.getX() - 1, point.getY() + 1), colour);
		}
	}
}
