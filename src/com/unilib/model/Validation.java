package com.unilib.model;

import java.io.Serializable;

import com.unilib.dao.Book;

public class Validation implements Serializable {

	public Integer status; // 400 - error, 200 - Ok
	public String statusMessage;
	public String bookTitle;
	public String bookAuthor;
	public String publisher;

	@Override
	public String toString() {
		return this.status == 200 ? ("Title : " + this.bookTitle + ", Author : " + this.bookAuthor + ", Publisher : " + this.publisher)
				: ("Error : " + this.statusMessage);
	}

}
