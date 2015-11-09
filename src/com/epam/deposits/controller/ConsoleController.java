/*
* ConsoleController.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;
import com.epam.deposits.model.DepositOffer;
import com.epam.deposits.view.ConsolePrinter;
import com.epam.deposits.view.IPrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides control of overall workflow of the program via console
 *
 * @author Victor Semenov
 * @version 1
 */
public class ConsoleController implements IController {
	private Scanner scanner;
	private IPrinter printer;
	private List<Bank> banks;
	private IDepositsProvider depositsProvider;
	private Action action;
	private SortParam sort;

	public ConsoleController() {
		this.scanner = new Scanner(System.in);
		this.printer = new ConsolePrinter();
		this.depositsProvider = new DepositsFileReader();
		banks = this.depositsProvider.getDepositOffers();
		sort = SortParam.BANK_UP;
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
		int actionNum;
		try {
			actionNum = Integer.parseInt(strAction);
		} catch (NumberFormatException ex) {
			printer.numberFormatException();
			askForAction();
			return;
		}
		for (Action act : Action.values()) {
			if (act.ordinal() == actionNum) {
				action = act;
			}
		}
		serveAction();
	}

	@Override
	public void serveAction() {
		if (action == Action.LIST) {
			listOffers();
		} else if (action == Action.EXIT) {
			return;
		}
		askForSort();
	}

	private void listOffers() {
		listOffers(sort);
	}

	/**
	 * Forces printer to output all deposit offers
	 *
	 * @param param - sort field
	 */
	private void listOffers(SortParam param) {
		List<DepositOffer> offers = new ArrayList<>();
		printer.printHeader(param);
		int id = 0;
		for (Bank bank : banks) {
			for (DepositOffer offer : bank.getOffers()) {
				offers.add(offer);
			}
		}

		offers.sort(getComparator(param));

		for (DepositOffer offer : offers) {
			printer.printOffer(offer, id++);
		}
	}

	/**
	 * Returns comparator to be user in list sort depend on sor field
	 *
	 * @param param - sort field
	 * @return comparator object
	 */
	private Comparator<DepositOffer> getComparator(SortParam param) {
		switch (param) {
			case BANK_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return o1.getBank().getName().compareTo(o2.getBank().getName());
					}
				};
			case BANK_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return -(o1.getBank().getName().compareTo(o2.getBank().getName()));
					}
				};
			case CURRENCY_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getCurrency().ordinal() > o2.getCurrency().ordinal()) ? 1 : -1;

					}
				};
			case CURRENCY_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getCurrency().ordinal() < o2.getCurrency().ordinal()) ? 1 : -1;

					}
				};
			case RATE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getRate() > o2.getRate()) ? 1 : -1;
					}
				};
			case RATE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getRate() < o2.getRate()) ? 1 : -1;
					}
				};
			case PERIOD_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getPeriod() > o2.getPeriod()) ? 1 : -1;
					}
				};
			case PERIOD_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getPeriod() < o2.getPeriod()) ? 1 : -1;
					}
				};
			case REFILLABLE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (new Boolean(o1.isRefillable()).toString().length() > new Boolean(o2.isRefillable()).toString().length()) ? 1 : -1;
					}
				};
			case REFILLABLE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isRefillable()).toString().length() < new Boolean(o2.isRefillable()).toString().length()) ? 1 : -1;
					}
				};
			case WITHDRAWABLE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isWithdrawable()).toString().length() > new Boolean(o2.isWithdrawable()).toString().length()) ? 1 : -1;
					}
				};
			case WITHDRAWABLE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isWithdrawable()).toString().length() < new Boolean(o2.isWithdrawable()).toString().length()) ? 1 : -1;
					}
				};
			default:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return 0;
					}
				};
		}
	}

	@Override
	public void askForSort() {
		printer.printAskForSort();
		String strSort = scanner.nextLine();

		if (strSort.equals("q")) return;

		int sortNum = 0;
		try {
			sortNum = Integer.parseInt(strSort);
		} catch (NumberFormatException ex) {
			printer.numberFormatException();
			askForSort();
			return;
		}
		if (sortNum > 6 || sortNum < 1) {
			printer.numberFormatException();
			askForSort();
			return;
		}
		switch (sortNum) {
			case 1:
				if (sort == SortParam.BANK_DOWN) sort = SortParam.BANK_UP;
				else sort = SortParam.BANK_DOWN;
				break;
			case 2:
				if (sort == SortParam.CURRENCY_DOWN) sort = SortParam.CURRENCY_UP;
				else sort = SortParam.CURRENCY_DOWN;
				break;
			case 3:
				if (sort == SortParam.RATE_DOWN) sort = SortParam.RATE_UP;
				else sort = SortParam.RATE_DOWN;
				break;
			case 4:
				if (sort == SortParam.PERIOD_DOWN) sort = SortParam.PERIOD_UP;
				else sort = SortParam.PERIOD_DOWN;
				break;
			case 5:
				if (sort == SortParam.REFILLABLE_DOWN) sort = SortParam.REFILLABLE_UP;
				else sort = SortParam.REFILLABLE_DOWN;
				break;
			case 6:
				if (sort == SortParam.WITHDRAWABLE_DOWN) sort = SortParam.WITHDRAWABLE_UP;
				else sort = SortParam.WITHDRAWABLE_DOWN;
				break;
			default:
				sort = SortParam.BANK_UP;
		}
		serveAction();
	}
}
