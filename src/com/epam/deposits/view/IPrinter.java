package com.epam.deposits.view;

import com.epam.deposits.model.DepositOffer;

/**
 * Created by victorcrimea on 07.11.15.
 */
public interface IPrinter {
	void printGreeteing();
	void printOffer(DepositOffer offer);
	void printHeader();
}
