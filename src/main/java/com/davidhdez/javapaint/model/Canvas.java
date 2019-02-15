package com.davidhdez.javapaint.model;

public class Canvas implements Shape {

	private final int width;
	private final int height;
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void create(String[][] matrix) {
		int totalWidht = this.width + 2;
		int totalHigh = this.height + 2;
		// Borders top and down
		for (int i = 0; i < totalWidht; i++) {
			matrix[i][0] = "-";
			matrix[i][totalHigh - 1] = "-";
		}
		// Borders left and right
		for (int i = 1; i <= this.height; i++) {
			matrix[0][i] = "|";
			matrix[totalWidht - 1][i] = "|";
		}
	}

	public void draw(String[][] matrix) {
		int totalWidht = this.width + 2;
		int totalHigh = this.height + 2;
		StringBuilder stringCanvas = new StringBuilder();
		for (int i = 0; i < totalHigh; i++) {
			for (int j = 0; j < totalWidht; j++) {
				if (matrix[j][i] == null) {
					stringCanvas.append(" ");
				} else {
					stringCanvas.append(matrix[j][i]);
				}
				if (j == totalWidht - 1) {
					// This is the limit so I create a new line
					stringCanvas.append("\n");
				}
			}
		}
		System.out.println(stringCanvas.toString());
	}
}
