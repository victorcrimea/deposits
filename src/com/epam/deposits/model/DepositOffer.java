package com.epam.deposits.model;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class DepositOffer {
	private int period; // in months
	private double rate;
	private boolean isRefillable;
	private boolean isWithdrawable;
	private Bank bank;

	public DepositOffer(int period, double rate, boolean isRefillable, boolean isWithdrawable, Bank bank) {
		checkRate(rate);
		this.period = period;
		this.rate = rate;
		this.isRefillable = isRefillable;
		this.isWithdrawable = isWithdrawable;
		this.bank = bank;
	}

	private void checkRate(double rate) {
		if (rate < 0.0) {
			throw new IllegalArgumentException("Deposit rate cannot be less than zero");
		}
	}

	private void checkNull(Bank bank) {
		if (bank == null) {
			throw new IllegalArgumentException("Bank cannot be null!");
		}
	}
}
