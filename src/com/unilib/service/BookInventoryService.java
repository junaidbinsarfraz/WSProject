package com.unilib.service;

import com.unilib.dao.Book;
import com.unilib.model.Validation;

public interface BookInventoryService {
	
	public Validation saveBook(Book book);
	
	public Validation validateBook(Book book);
	
}
