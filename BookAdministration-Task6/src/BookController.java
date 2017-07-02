
//import Book;

import java.util.*;

public class BookController {
	
	private static BookController instance;
	
	Book test1 = new Book();
	Book test2 = new Book();
	Book test3 = new Book();
		
	public BookController() {
		
		instance = this;	
		
		this.addTestdata();
		
		this.addBook(test1);
		this.addBook(test2);
		this.addBook(test3);
		
		System.out.println("Testdaten: Author1" +test1.getAuthor());
		
	}

	
	static int bookKey = 0;
	HashMap<Number, Book> bookCollection = new HashMap<Number, Book>();
	
	/*
	 * adds a Book to the collection and generates a key for it
	 */
	public void addBook (Book book) {
		bookKey++;
		book.setBookKey(bookKey);
		bookCollection.put(bookKey, book);
	
	}
	
	public void deleteBook(int bookKey) {
		
		bookCollection.remove(bookKey);
	}
	
	public void addTestdata() {
		//Point for Aspects to fill the test objects
		System.out.println("TestData");
	}
	
	
	public HashMap<Number, Book> getBookCollection() {
		return bookCollection;
	}

	public static BookController getInstance () {

	    if (BookController.instance == null) {
	    	
	    	BookController.instance = new BookController ();
	    }
	    return BookController.instance;
	  }
	
}
