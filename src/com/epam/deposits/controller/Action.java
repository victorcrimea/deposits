/*
* Action.java
* Version: 1
* Date: 08.11.2015
* Copyright (c) Victor Semenov
*/
package com.epam.deposits.controller;

/**
 * Enum provides list of actions that user can choose at startup
 *
 * @author Victor Semenov
 * @version 1
 */
public enum Action {
	LIST("Список предложений"), EXIT("Выход");

	private String rusName;

	Action(String rusName) {
		this.rusName = rusName;
	}

	/**
	 * Method returns russian representation of the enum entity
	 *
	 * @return russian string
	 */
	public String getRusName() {
		return rusName;
	}
}
