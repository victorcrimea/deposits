package com.epam.deposits.view;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class ConsolePrinter implements IConsolePrinter {
	@Override
	public void printGreeteing() {
		System.out.println("Депозиты");
	}
}
