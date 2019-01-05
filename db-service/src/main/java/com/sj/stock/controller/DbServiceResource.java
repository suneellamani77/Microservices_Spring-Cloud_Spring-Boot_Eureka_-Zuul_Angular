package com.sj.stock.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.stock.model.Quote;
import com.sj.stock.model.Quotes;
import com.sj.stock.repository.QuoteRepository;

@RestController
@RequestMapping("/rest/db")
@CrossOrigin(origins="*", allowedHeaders="*" )
public class DbServiceResource {
	
	@Autowired
	private QuoteRepository quoteRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		 return quoteRepository.getByUserName(username)
					.stream()
					.map(Quote :: getQuote)
					.collect(Collectors.toList());
	}
	
	
	@PostMapping("/addUser")
	public List<String> addUser(@RequestBody Quotes quotes){
		
		System.out.println(quotes.getQuote()+"---");
		
		quotes.getQuote()
		.stream()
		.map(quote -> new Quote(quotes.getUserName(),quote))
		.forEach(quote->quoteRepository.save(quote));
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@DeleteMapping("deleteUser/{username}")
	public List<String> deleteUser(@PathVariable ("username") final String username){
		List<Quote> quotes=quoteRepository.getByUserName(username);
		quoteRepository.deleteAll(quotes);
		return getQuotesByUserName(username);
	}

	private List<String> getQuotesByUserName(String username){
		 return quoteRepository.getByUserName(username)
					.stream()
					.map(Quote :: getQuote)
					.collect(Collectors.toList());
	}
	
}
