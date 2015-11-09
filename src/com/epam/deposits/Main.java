package com.epam.deposits;

import com.epam.deposits.controller.ConsoleController;
import com.epam.deposits.controller.IController;

public class Main {
	public static void main(String[] args) {
		IController controller = new ConsoleController();

		controller.askForAction();
	}
}
