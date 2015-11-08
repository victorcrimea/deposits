package com.epam.deposits.controller;

/**
 * Created by victorcrimea on 08.11.15.
 */
public enum Action {
	LIST("Список действий"), CALC("Рассчёт прибыли по вкладу");

	String rusName;

	Action(String rusName) {
		this.rusName = rusName;
	}

	public String getRusName(){
		return rusName;
	}
}
