package com.sj.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sj.stock.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer>{

	List<Quote> getByUserName(String username);

}
