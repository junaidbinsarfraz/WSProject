package com.unilib.service;

public class BookOrderingServiceImpl implements BookOrderingService {

	@Override
	public String orderBook(Integer studentId, String studentPin, String bookIsbn) {
		// TODO Auto-generated method stub
		System.out.println("I am here");
		return "Chill";
	}
	
	/*private BookInformationServiceImplStub bookInfoStub = null;
	private BookInventoryServiceImplStub bookInventStub = null;
	private StudentServiceImplStub studentStub = null;
	
	public Validation orderBook(Integer studentId, String studentPin, String bookIsbn) throws RemoteException {
		
		Validation validation = new Validation();
		
		validation.status = 400;
		
		Student st = new Student();
		
		st.setId(studentId);
		st.setPin(studentPin);
		
		ValidateStudent validateStudent0 = new ValidateStudent();
		
		validateStudent0.setStudent(st);
		
		ValidateStudentResponse validateStudentResponse = getStudentStub().validateStudent(validateStudent0);
		
		Boolean isStudentValid = validateStudentResponse.get_return();
		
		if(isStudentValid) {
			
			System.out.println("good");
			
		} else {
			System.out.println("bad");
			validation.statusMessage = "Student is invalid";
		}
		
		// Validate Student
//		getStudentStub().
		
		// Validate if book is already in library
		
		// Validate if book is in market
		
		// Assess book quality
		
		// Save book
		
		return validation;
	}

	private BookInformationServiceImplStub getBookInfoStub() {
		
		if(bookInfoStub == null) {
			try {
				bookInfoStub = new BookInformationServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage() );
			}
		}
		
		return bookInfoStub;
	}

	private BookInventoryServiceImplStub getBookInventStub() {
		
		if(bookInventStub == null) {
			try {
				bookInventStub = new BookInventoryServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage() );
			}
		}
		
		return bookInventStub;
	}

	private StudentServiceImplStub getStudentStub() {
		
		if(studentStub == null) {
			try {
				studentStub = new StudentServiceImplStub();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to communicate with service: " + e.getMessage() );
			}
		}
		
		return studentStub;
	}*/

}
