/*
* IDepositsProvider.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;

import java.util.List;

/**
 * Inteface for deposit offers obtaining
 *
 * @author Victor Semenov
 * @version 1
 */
public interface IDepositsProvider {
	/**
	 * Obtains deposit offer from CSV file
	 *
	 * @return list of Banks with offers included
	 */
	List<Bank> getDepositOffers();
}
