package com.unilib.service;

import java.util.List;

import com.unilib.dao.Book;
import com.unilib.dao.BookHome;
import com.unilib.model.Validation;
import com.unilib.util.Constants;

public class BookInventoryServiceImpl implements BookInventoryService {

	private BookHome bookHome = new BookHome();
	
	@Override
	public Validation saveBook(Book book) {
		
		Validation validation = new Validation();
		
		validation.status = 200;
		
		try {
			this.bookHome.attachDirty(book);
		} catch(Exception e) {
			validation.status = 400;
			validation.statusMessage = "Unable to save into database";
		}
		
		return validation;
	}

	@Override
	public Validation validateBook(Book book) {
		
		Validation validation = new Validation();
		validation.status = 400;
		
		if (book == null || book.getIsbn() == null) {
			validation.statusMessage = "Book or isbn is null";
		} 
		
		List<Book> books = this.bookHome.findByExample(book);

		if (books == null || Boolean.TRUE.equals(books.isEmpty()) || Boolean.FALSE.equals(books.get(0).getIsbn().equals(book.getIsbn()))) {
			validation.statusMessage = "Book not found";
		} else if (books.get(0).getInlib()) {
			validation.statusMessage = "Book already in library";
		} else {
			
			Book newBook = new Book();
			
			newBook.setIsbn(book.getIsbn());
			newBook.setStatus(Constants.STATUS_BACK_ORDER);
			
			books = this.bookHome.findByExample(newBook);
			
			if (books == null || Boolean.TRUE.equals(books.isEmpty()) || Boolean.FALSE.equals(books.get(0).getIsbn().equals(book.getIsbn()))) {
				validation.statusMessage = "Book order already placed";
			} else {
				validation.statusMessage = "Book is ready for order place";
				validation.status = 200;
			}
			
		}
		
		return validation;
	}

}
