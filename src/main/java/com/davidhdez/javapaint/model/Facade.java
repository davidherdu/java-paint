package com.davidhdez.javapaint.model;

public class Facade {

	private String[][] matrix;
	private Canvas canvas;
	
	public Canvas executeShape(String... params) {
		String command = params[0];
		Commands c = Commands.getCommand(command);
		
		if (c != null) {
			Shape shape = null;
			if(command.equals(Commands.CANVAS.getCode())) {
				int width = Integer.parseInt(params[1]);
				int height = Integer.parseInt(params[2]);
				canvas = new Canvas(width, height);
				matrix = new String[width + 2][height + 2];
				shape = canvas;
			}
			if(command.equals(Commands.LINE.getCode())) {
				shape = new Line(new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2])), 
						new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4])),
						canvas);
			}
			if(command.equals(Commands.RECTANGLE.getCode())) {
				shape = new Rectangle(new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2])), 
						new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4])),
						canvas);
			}
			if(command.equals(Commands.BUCKETFILL.getCode())) {
				shape = new BucketFill(new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2])), params[3], canvas);
			}
			execute(shape);
		}
		return canvas;
	}
	
	private void execute(Shape shape) {
		shape.create(matrix);
		shape.draw(matrix);
	}
}
