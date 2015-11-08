package com.epam.deposits.view;

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
}
