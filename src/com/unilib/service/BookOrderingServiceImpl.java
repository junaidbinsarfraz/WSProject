package com.unilib.service;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.databinding.ADBException;

import com.unilib.model.Validation;
import com.unilib.service.client.BookInventoryServiceImplStub;
import com.unilib.service.client.BookInventoryServiceImplStub.Book;
import com.unilib.service.client.BookInventoryServiceImplStub.SaveBook;
import com.unilib.service.client.BookInventoryServiceImplStub.ValidateBook;
import com.unilib.service.client.BookInventoryServiceImplStub.ValidateBookResponse;
import com.unilib.service.client.StudentServiceImplStub;
import com.unilib.service.client.StudentServiceImplStub.Student;
import com.unilib.service.client.StudentServiceImplStub.ValidateStudent;
import com.unilib.service.client.StudentServiceImplStub.ValidateStudentResponse;
import com.unilib.service.test.BookInformationServiceImplStub;
import com.unilib.service.test.BookInformationServiceImplStub.GetBookFromMarket;
import com.unilib.service.test.BookInformationServiceImplStub.GetBookFromMarketResponse;
import com.unilib.util.Constants;

public class BookOrderingServiceImpl implements BookOrderingService {

	/*
	 * @Override public String orderBook(Integer studentId, String studentPin,
	 * String bookIsbn) {
	 * 
	 * Validation validation = new Validation();
	 * 
	 * 
	 * 
	 * return "Chill"; }
	 */

	private BookInformationServiceImplStub bookInfoStub = null;
	private BookInventoryServiceImplStub bookInventStub = null;
	private StudentServiceImplStub studentStub = null;

	public String orderBook(Integer studentId, String studentPin, String bookIsbn) {

		Validation validation = new Validation();

		validation.status = 400;

		Student st = new Student();

		st.setId(studentId);
		st.setPin(studentPin);

		ValidateStudent validateStudent0 = new ValidateStudent();

		validateStudent0.setStudent(st);

		ValidateStudentResponse validateStudentResponse = null;

		try {
			validateStudentResponse = getStudentStub().validateStudent(validateStudent0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (validateStudentResponse == null) {
			validation.statusMessage = "Unable to validate student";
		} else {

			Boolean isStudentValid = validateStudentResponse.get_return();

			if (isStudentValid) {
				System.out.println("good");

				// Validate if book is already in library

				Book book = new Book();

				book.setIsbn(bookIsbn);

				ValidateBook validateBook2 = new ValidateBook();

				validateBook2.setBook(book);

				ValidateBookResponse validateBookResponse = null;

				try {
					validateBookResponse = getBookInventStub().validateBook(validateBook2);
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				if (validateBookResponse == null) {
					validation.statusMessage = "Unable to validate book";
				} else {
					
					// Validate if book is in market
					com.unilib.service.test.BookInformationServiceImplStub.Book newBook = new 
							com.unilib.service.test.BookInformationServiceImplStub.Book();
					
					newBook.setIsbn(bookIsbn);
					
					GetBookFromMarket getBookFromMarket2 = new GetBookFromMarket();
					
					getBookFromMarket2.setBook(newBook);
					
					GetBookFromMarketResponse getBookFromMarketResponse = null;
					
					try {
						getBookFromMarketResponse = getBookInfoStub().getBookFromMarket(getBookFromMarket2);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(getBookFromMarketResponse == null) {
						validation.statusMessage = "No book found in market of good quality";
					} else {
						
						SaveBook saveBook0 = new SaveBook();
						
						book.setStatus(Constants.STATUS_BACK_ORDER);
						
						saveBook0.setBook(book);
						
						try {
							getBookInventStub().saveBook(saveBook0);
						} catch (RemoteException e) {
							validation.statusMessage = "Unable to place book order";
						}
						
					}
					
					// Assess book quality
					
					// Save book
				}


			} else {
				System.out.println("bad");
				validation.statusMessage = "Student is invalid";
			}
		}

		// Validate Student
		// getStudentStub().

		return validation.toString();
	}

	private BookInformationServiceImplStub getBookInfoStub() {

		if (bookInfoStub == null) {
			try {
				bookInfoStub = new BookInformationServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage());
			}
		}

		return bookInfoStub;
	}

	private BookInventoryServiceImplStub getBookInventStub() {

		if (bookInventStub == null) {
			try {
				bookInventStub = new BookInventoryServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage());
			}
		}

		return bookInventStub;
	}

	private StudentServiceImplStub getStudentStub() {

		if (studentStub == null) {
			try {
				studentStub = new StudentServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage());
			}
		}

		return studentStub;
	}

}
