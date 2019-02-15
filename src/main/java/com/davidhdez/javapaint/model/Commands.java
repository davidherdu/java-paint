package com.davidhdez.javapaint.model;

import java.util.EnumSet;

public enum Commands {

	QUIT("Q"),
	CANVAS("C"),
	LINE("L"),
	RECTANGLE("R"),
	BUCKETFILL("B");
	
	private final String code;
	
	Commands(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static Commands getCommand(String command) {
		return EnumSet.allOf(Commands.class)
						.stream()
						.filter(c -> c.code.equals(command))
						.findFirst()
						.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", command)));
	}
}
