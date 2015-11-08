package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;

import java.util.ArrayList;

/**
 * Created by victorcrimea on 08.11.15.
 */
public interface IDepositsProvider {
	ArrayList<Bank> getDepositOffers();
}
