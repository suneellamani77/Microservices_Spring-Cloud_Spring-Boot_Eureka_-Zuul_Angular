package com.sj.stack.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
public class StockController {

	@RequestMapping("")
	public String home(){
		return "Stock Example is Created....";
	}
	
	@GetMapping("/stock")
	public Stock getStockList() throws IOException{
		
		Stock stock = YahooFinance.get("INTC");
		 
		/*BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();*/
		 
		stock.print();
		
		return stock;
		
	}
	
}
