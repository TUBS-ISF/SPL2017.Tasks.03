package main.book;

import main.book.Book;
import properties.PropertyManager;

import java.util.*;

public class BookController {

	 private static BookController instance;
	static int bookKey = 0;
	HashMap<Number, Book> bookCollection = new HashMap<Number, Book>();
	
	/*
	 * adds a Book to the collection and generates a key for it
	 */
	public void addBook (Book book) {
		bookKey++;
		book.setBookKeyg(bookKey);
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
	public void fillBook(String title, Vector<String> data){
		
		Book book= new Book(title);

		if (PropertyManager.getProperty("Author")) {
			book.setAuthor(data.get(0));
			data.remove(0);
		}
		
		if (PropertyManager.getProperty("ISBN")) {
			book.setIsbn(Integer.valueOf(data.get(0)));
			data.remove(0);
		}
		
		if (PropertyManager.getProperty("Genre")) {
			book.setGenre(data.get(0));
			data.remove(0);
		}
		
		if (PropertyManager.getProperty("Read")) {
			book.setRead(Boolean.valueOf(data.get(0)));
			data.remove(0);
		}
		
		if (PropertyManager.getProperty("Publisher")) {
			book.setPublisher(data.get(0));
			data.remove(0);
		}
		
		if (PropertyManager.getProperty("Rating")) {
			book.setRating(Float.valueOf(data.get(0)));
			data.remove(0);
		}
		
		addBook(book); 
	}
	
	public static BookController getInstance () {
	    if (BookController.instance == null) {
	    	BookController.instance = new BookController ();
	    }
	    return BookController.instance;
	  }
	
}
