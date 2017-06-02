package main.book;

import main.book.Book;

import java.util.*;

public class BookController {
	
	
	public BookController() {
		
		Book test1 = new Book("test1");
		test1.setAttribut("Genre", "Krimi");
		test1.setAttribut("Read", "true");
		test1.setAttribut("ISBN", "222");
		test1.setAttribut("Publisher", "Vertrieb");
		test1.setAttribut("Rating", "4");
		test1.setAttribut("author", "Bob");
		
		this.addBook(test1);
		
		Book test2 = new Book("test2");
		test2.setAttribut("Genre", "Krimi");
		test2.setAttribut("Read", "true");
		test2.setAttribut("ISBN", "222");
		test2.setAttribut("Publisher", "Vertrieb");
		test2.setAttribut("Rating", "4");
		test2.setAttribut("author", "Bob");
		
		this.addBook(test2);
	}

	private static BookController instance;
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
	
	/*
	 * Uses Input to create a new Book Entry for the bookCollection,
	 * data stores the wanted attributes of the book and needs to be in the following order:
	 * Author,ISBN, Genre, Read, Publisher, Rating
	 * if one attribute is not used in the current variant, it gets skipped
	 */
//	public void fillBook(String title, Vector<String> data){
//		
//		Book book= new Book(title);
//
//	
//			book.setAuthor(data.get(0));
//			data.remove(0);
//		
//			book.setIsbn(Integer.valueOf(data.get(0)));
//			data.remove(0);
//		
//			book.setGenre(data.get(0));
//			data.remove(0);
//		
//			book.setRead(Boolean.valueOf(data.get(0)));
//			data.remove(0);
//		
//			book.setPublisher(data.get(0));
//			data.remove(0);
//		
//			book.setRating(Float.valueOf(data.get(0)));
//			data.remove(0);
//	
//		
//		addBook(book); 
//	}
	
	
	
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
