package main.book;

/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	String title;
	String author;
	int isbn;
	String genre;
	boolean read;
	String publisher;
	float rating;
	int bookKey;
	
	
	
	public Book(String title) {
		this.title = title;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}



	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}



	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}


	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	public int getBookKey() {
		return bookKey;
	}

	public void setBookKeyg(int bookKey) {
		this.bookKey = bookKey;
	}
	
	
	
	

}
