/*
* ConsolePrinter.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.view;

import com.epam.deposits.controller.Action;
import com.epam.deposits.controller.SortParam;
import com.epam.deposits.model.DepositOffer;

/**
 * Class for output to the console
 *
 * @author Victor Semenov
 * @version 1
 */
public class ConsolePrinter implements IPrinter {
	@Override
	public void printGreeting() {
		System.out.println("Депозиты");
	}

	@Override
	public void printOffer(DepositOffer offer, int id) {
		System.out.printf("| %2d |    %26s |     %4s  |    %5.1f%% |   %3d мес.|   %7s     |         %9s   | %n", id, offer.getBank().getName(), offer.getCurrency().toString(), offer.getRate(), offer.getPeriod(), new Boolean(offer.isRefillable()), new Boolean(offer.isWithdrawable()));
		//System.out.println();
	}


	@Override
	public void printHeader(SortParam param) {
		String bank = "[1]Банк";
		String currency = "[2]Валюта";
		String rate = "[3]Ставка";
		String period = "[4]Период";
		String refillable = "[5]Пополнение";
		String withdrawable = "[6]Досрочное снятие";
		char up = '↑';
		char down = '↓';
		switch (param) {
			case BANK_UP:
				bank = bank.replace('1', up);
				break;
			case BANK_DOWN:
				bank = bank.replace('1', down);
				break;
			case CURRENCY_UP:
				currency = currency.replace('2', up);
				break;
			case CURRENCY_DOWN:
				currency = currency.replace('2', down);
				break;
			case RATE_UP:
				rate = rate.replace('3', up);
				break;
			case RATE_DOWN:
				rate = rate.replace('3', down);
				break;
			case PERIOD_UP:
				period = period.replace('4', up);
				break;
			case PERIOD_DOWN:
				period = period.replace('4', down);
				break;
			case REFILLABLE_UP:
				refillable = refillable.replace('5', up);
				break;
			case REFILLABLE_DOWN:
				refillable = refillable.replace('5', down);
				break;
			case WITHDRAWABLE_UP:
				withdrawable = withdrawable.replace('6', up);
				break;
			case WITHDRAWABLE_DOWN:
				withdrawable = withdrawable.replace('6', down);
				break;
		}
		System.out.printf("|  № |            %s            | %s | %s | %s | %s | %s |%n", bank, currency, rate, period, refillable, withdrawable);
	}

	@Override
	public void printAskForAction() {
		System.out.println("Список доступных действий:");
		for (Action act : Action.values()) {
			System.out.println(act.ordinal() + " - " + act.getRusName());
		}
		System.out.print("Выберите необходимую операцию: ");
	}

	@Override
	public void numberFormatException() {
		System.out.println("Неверный ввод, повторите.");
	}

	@Override
	public void printAskForSort() {
		System.out.println("Для выхода нажмите: q" +
				"");
		System.out.print("Для сортировки нажмите цифру-номер колонки 1-6: ");
	}
}
