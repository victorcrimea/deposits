package com.epam.deposits;

import com.epam.deposits.controller.*;
import com.epam.deposits.view.ConsolePrinter;

public class Main {
	public static void main(String[] args) {
		IController controller = new ConsoleController();

		controller.askForAction();
		//System.out.println("hello");
	}
}
