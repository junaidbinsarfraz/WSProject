package com.unilib.service;

import java.util.List;

import com.unilib.dao.Book;
import com.unilib.dao.BookHome;

public class BookInformationServiceImpl implements BookInformationService {

	private BookHome bookHome = new BookHome();
	
	@Override
	public Book getBookFromMarket(Book book) {

		if (book == null || book.getIsbn() == null) {
			return null;
		}

		List<Book> books = this.bookHome.findByExample(book);

		if (books == null || Boolean.TRUE.equals(books.isEmpty()) || Boolean.FALSE.equals(books.get(0).getIsbn().equals(book.getIsbn()))) {
			return null;
		}
		
		if(Boolean.FALSE.equals(isQualityWithinRange(book))) {
			return null;
		}

		return books.get(0);
	}

	@Override
	public Boolean isQualityWithinRange(Book book) {

		if (book == null || book.getIsbn() == null) {
			return null;
		}

		List<Book> books = this.bookHome.findByExample(book);

		if (books == null || Boolean.TRUE.equals(books.isEmpty()) || Boolean.FALSE.equals(books.get(0).getIsbn().equals(book.getIsbn()))) {
			return null;
		}

		Book newBook = books.get(0);

		if (newBook.getRating() > 3) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
