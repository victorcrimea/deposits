package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;

import java.util.List;

/**
 * Created by victorcrimea on 08.11.15.
 */
public interface IDepositsProvider {
	List<Bank> getDepositOffers();
}
