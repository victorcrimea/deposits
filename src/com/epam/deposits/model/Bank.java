/*
* Bank.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used as wrapper for deposit offer
 * to represent a serving bank name.
 *
 * @author Victor Semenov
 * @version 1
 */
public class Bank {
	private final String name;

	/**
	 * List of all available deposit offers
	 */
	private List<DepositOffer> depositOffers;

	public Bank(String name) {
		this.name = name;
		this.depositOffers = new ArrayList<>();
	}

	/**
	 * Getter for bank name
	 *
	 * @return bank name
	 */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((Bank) o).name);
	}

	/**
	 * Creates and adds deposit offer to list of offers
	 *
	 * @param currency       - deposit currency
	 * @param rate           - interest rate
	 * @param period         - period in months
	 * @param isRefillable   - ability to refill the deposit during the term
	 * @param isWithdrawable - ability to withdraw money from the deposit during the term
	 */
	public void addOffer(Currency currency, double rate, int period, boolean isRefillable, boolean isWithdrawable) {
		DepositOffer offer = new DepositOffer(period, rate, isRefillable, isWithdrawable, currency, this);
		depositOffers.add(offer);
	}

	/**
	 * Returns list of all deposit offers from this bank
	 *
	 * @return - list of offerrs
	 */
	public List<DepositOffer> getOffers() {
		return depositOffers;
	}
}
