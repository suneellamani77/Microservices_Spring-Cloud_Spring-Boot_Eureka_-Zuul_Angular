package com.sj.stock.model;

import java.util.List;

public class Quotes {
	
	private String userName;
	
	private List<String> quote;
	
	

	public Quotes() {
	}

	public Quotes(String userName, List<String> quote) {
		this.userName = userName;
		this.quote = quote;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuote() {
		return quote;
	}

	public void setQuote(List<String> quote) {
		this.quote = quote;
	}
	
	

}
