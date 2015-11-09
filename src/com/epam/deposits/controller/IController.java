/*
* IController.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

/**
 * Inteface for control program workflow
 *
 * @author Victor Semenov
 * @version 1
 */
public interface IController {
	/**
	 * Method enforces obtaining of deposit offers from deposit provider
	 */
	void getDepositOffers();

	/**
	 * Asks user for action input and handles it into action enum
	 */
	void askForAction();

	/**
	 * Perfoms desired action that was set before
	 */
	void serveAction();

	/**
	 * Asks user for input and interprets it as sort option
	 */
	void askForSort();
}
