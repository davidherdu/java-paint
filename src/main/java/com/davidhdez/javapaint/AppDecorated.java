package com.davidhdez.javapaint;

import java.util.Scanner;

import com.davidhdez.javapaint.model.Canvas;
import com.davidhdez.javapaint.model.Commands;
import com.davidhdez.javapaint.model.Constants;
import com.davidhdez.javapaint.model.Facade;

public class AppDecorated {
	
	public static void main(String[] args) {	
		String option = "";
		Scanner scanner = new Scanner(System.in);
		// The loop to execute the paint
		Canvas canvas = null;
		Facade facade = new Facade();
		while(!option.equals(Commands.QUIT.getCode())) {
			try {
				System.out.print("enter command: ");
				option = scanner.nextLine();
				String[] splited = option.split("\\s");
				if (!splited[0].equals(Commands.QUIT.getCode())) {
					if((!splited[0].equals(Commands.CANVAS.getCode()) && canvas == null)) {
						System.out.println("First, you have to create a canvas of widht w and height h -> C w h");
					} else {
						canvas = facade.executeShape(splited);
					}						
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please, enter the number of correct parameters");
			} catch (NumberFormatException e) {
				System.out.println("Please, enter a number character");
			} catch (Exception e ) {
				System.out.println(Constants.ERROR_GENERIC);
			}
		}
		scanner.close();
	}
	
}
