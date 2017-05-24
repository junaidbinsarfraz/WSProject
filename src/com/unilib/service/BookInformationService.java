package com.unilib.service;

import com.unilib.dao.Book;

public interface BookInformationService {
	
	public Book getBookFromMarket(Book book);
	
	public Boolean isQualityWithinRange(Book book);
	
}
