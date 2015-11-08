package com.epam.deposits.view;

import com.epam.deposits.controller.Action;
import com.epam.deposits.model.DepositOffer;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class ConsolePrinter implements IPrinter {
	@Override
	public void printGreeteing() {
		System.out.println("Депозиты");

	}

	@Override
	public void printOffer(DepositOffer offer) {
		System.out.println();
	}

	@Override
	public void printHeader() {
		System.out.println("====Банк====|===Ставка===|=Досрочное снятие=|=Возможность пополнения=|");
	}

	@Override
	public void printAskForAction() {
		System.out.println("Список доступных действий:");
		for(Action act : Action.values()) {
			System.out.println(act.ordinal() +" - "+ act.getRusName());
		}

		System.out.println("Выберите необъодимую операцию: ");
	}
}
