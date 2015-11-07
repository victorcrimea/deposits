package com.epam.deposits.model;

import java.util.ArrayList;

/**
 * Created by victorcrimea on 07.11.15.
 */
public class Bank {
	private final String name;
	private ArrayList<DepositOffer> depositOffers;

	public Bank(String name) {
		this.name = name;
	}
}
