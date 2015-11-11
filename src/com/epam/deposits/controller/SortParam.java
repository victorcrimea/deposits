/*
* SortParam.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

import com.epam.deposits.model.DepositOffer;

import java.util.Comparator;

/**
 * Sort parameter: field and direction
 *
 * @author Victor Semenov
 * @version 1
 */
public enum SortParam {
	BANK_UP, BANK_DOWN, CURRENCY_UP, CURRENCY_DOWN, RATE_UP, RATE_DOWN, PERIOD_UP, PERIOD_DOWN, REFILLABLE_UP,
	REFILLABLE_DOWN, WITHDRAWABLE_UP, WITHDRAWABLE_DOWN;

	public Comparator<DepositOffer> getComparator() {
		switch (this) {
			case BANK_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return o1.getBank().getName().compareTo(o2.getBank().getName());
					}
				};
			case BANK_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return -(o1.getBank().getName().compareTo(o2.getBank().getName()));
					}
				};
			case CURRENCY_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getCurrency().ordinal() > o2.getCurrency().ordinal()) ? 1 : -1;

					}
				};
			case CURRENCY_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getCurrency().ordinal() < o2.getCurrency().ordinal()) ? 1 : -1;
					}
				};
			case RATE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getRate() > o2.getRate()) ? 1 : -1;
					}
				};
			case RATE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getRate() < o2.getRate()) ? 1 : -1;
					}
				};
			case PERIOD_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getPeriod() > o2.getPeriod()) ? 1 : -1;
					}
				};
			case PERIOD_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (o1.getPeriod() < o2.getPeriod()) ? 1 : -1;
					}
				};
			case REFILLABLE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return (new Boolean(o1.isRefillable()).toString().length() > new Boolean(o2.isRefillable()).toString().length()) ? 1 : -1;
					}
				};
			case REFILLABLE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isRefillable()).toString().length() < new Boolean(o2.isRefillable()).toString().length()) ? 1 : -1;
					}
				};
			case WITHDRAWABLE_UP:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isWithdrawable()).toString().length() > new Boolean(o2.isWithdrawable()).toString().length()) ? 1 : -1;
					}
				};
			case WITHDRAWABLE_DOWN:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {

						return (new Boolean(o1.isWithdrawable()).toString().length() < new Boolean(o2.isWithdrawable()).toString().length()) ? 1 : -1;
					}
				};
			default:
				return new Comparator<DepositOffer>() {
					@Override
					public int compare(DepositOffer o1, DepositOffer o2) {
						return 0;
					}
				};
		}
	}

}
