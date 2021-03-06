/*
* DepositsFileReader.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

import com.epam.deposits.model.Bank;
import com.epam.deposits.model.Currency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class perfoms interpretation of deposit offers stored in CSV file
 *
 * @author Victor Semenov
 * @version 1
 */
public class DepositsFileReader implements IDepositsProvider {
	@Override
	public List<Bank> getDepositOffers() {

		BufferedReader reader = openFile("offers.txt");
		List<String> lines = getLines(reader);
		return parseLines(lines);
	}


	private List<String> getLines(BufferedReader reader) {
		String line;
		List<String> lines = new ArrayList<>();

		try {
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	private BufferedReader openFile(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return reader;
	}

	private List<Bank> parseLines(List<String> lines) {

		List<Bank> bankList = new ArrayList<>();
		for (String entry : lines) {
			String words[] = entry.split(",");
			if (words.length == 6) {
				Bank bank = new Bank(words[0]);
				Currency currency = Currency.valueOf(words[1]);
				double rate = Double.valueOf(words[2]);
				int period = Integer.valueOf(words[3]);
				boolean isRefillable = Boolean.valueOf(words[4]);
				boolean isWithdrawable = Boolean.valueOf(words[5]);
				//System.out.println("isRefillable: " + isRefillable);
				if (bankList.contains(bank)) {
					bankList.get(bankList.indexOf(bank)).addOffer(currency, rate, period, isRefillable, isWithdrawable);
				} else {
					bank.addOffer(currency, rate, period, isRefillable, isWithdrawable);
					bankList.add(bank);
				}
			}
		}
		return bankList;
	}
}
