/*
* DepositOffer.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.model;

/**
 * Reprents deposit offer
 *
 * @author Victor Semenov
 * @version 1
 */
public class DepositOffer {
	private int period; // in months
	private double rate;
	private boolean isRefillable;
	private boolean isWithdrawable;
	private Currency currency;
	/**
	 * Serving bank
	 */
	private Bank bank;

	public DepositOffer(int period, double rate, boolean isRefillable, boolean isWithdrawable, Currency currency, Bank bank) {
		checkRate(rate);
		checkNull(bank);
		this.period = period;
		this.rate = rate;
		this.isRefillable = isRefillable;
		this.isWithdrawable = isWithdrawable;
		this.bank = bank;
		this.currency = currency;
	}

	/**
	 * Checks interest rate for negative values
	 *
	 * @param rate - interest rate to be checked
	 */
	private void checkRate(double rate) {
		if (rate < 0.0) {
			throw new IllegalArgumentException("Deposit rate cannot be less than zero");
		}
	}

	/**
	 * Checks bank to be not null
	 *
	 * @param bank - bank link to be checked
	 */
	private void checkNull(Bank bank) {
		if (bank == null) {
			throw new IllegalArgumentException("Bank cannot be null!");
		}
	}

	/**
	 * Returns period of the deposit offer in months
	 *
	 * @return period in month
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * Returns interest rate of the deposit offer in percents
	 *
	 * @return rate in percents
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Returns true if deposit can be refilled during the term
	 *
	 * @return ability to be refilled
	 */
	public boolean isRefillable() {
		return isRefillable;
	}

	/**
	 * Returns true if money can be withdrawn from the deposit during the term
	 *
	 * @return ability to withdraw money
	 */
	public boolean isWithdrawable() {
		return isWithdrawable;
	}

	/**
	 * Returns deposit offer currency
	 *
	 * @return curency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Returns the link to the serving bank
	 *
	 * @return bank link
	 */
	public Bank getBank() {
		return bank;
	}
}
