package com.epam.deposits.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class Bank {
	private final String name;
	private List<DepositOffer> depositOffers;

	public Bank(String name) {
		this.name = name;
		this.depositOffers = new ArrayList<>();
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((Bank)o).name);
	}

	public void addOffer(Currency currency, double rate, int period, boolean isRefillable, boolean isWithdrawable){
		DepositOffer offer = new DepositOffer(period,rate,isRefillable, isWithdrawable, currency, this);
		depositOffers.add(offer);
	}
}
