package com.davidhdez.javapaint.model;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decoratedShape) {
        super();
        this.decoratedShape = decoratedShape;
	}
	
	public void create(String[][] matrix) {
	}

	public void draw(String[][] matrix) {
		decoratedShape.draw(matrix);
	}
}
