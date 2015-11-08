package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;
import com.epam.deposits.view.ConsolePrinter;
import com.epam.deposits.view.IPrinter;

import java.util.List;
import java.util.Scanner;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class ConsoleController implements IController {
	private Scanner scanner;
	private IPrinter printer;
	private List<Bank> banks;
	private IDepositsProvider depositsPorvider;
	private Action action;

	public ConsoleController() {
		this.scanner = new Scanner(System.in);
		this.printer = new ConsolePrinter();
		this.depositsPorvider = new DepositsFileReader();
	}

	@Override
	public void getDepositOffers() {
		IDepositsProvider reader = new DepositsFileReader();
		banks = reader.getDepositOffers();
	}

	@Override
	public void askForAction() {
		printer.printAskForAction();
		String strAction = scanner.nextLine();
		if(strAction.equals("list")){
			this.action = Action.LIST;
		}
	}
}
