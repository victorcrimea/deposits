/*
* IPrinter.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.view;

import com.epam.deposits.controller.SortParam;
import com.epam.deposits.model.DepositOffer;

/**
 * Interface for program output to the screen
 *
 * @author Victor Semenov
 * @version 1
 */
public interface IPrinter {
	void printGreeting();

	void printOffer(DepositOffer offer, int id);

	void printHeader(SortParam param);

	void printAskForAction();

	void numberFormatException();

	void printAskForSort();
}
