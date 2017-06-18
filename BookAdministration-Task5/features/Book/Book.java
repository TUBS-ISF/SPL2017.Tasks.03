

/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	int bookKey;
	// Title is mandatory
	String title;
	int attributsNumber	=1;
		
	public Book(String title) {
	
	this.title = title;
	generateAttributsNumber();

	}

	
	
	public int getBookKey() {
		return bookKey;
	}

	public void setBookKey(int bookKey) {
		this.bookKey = bookKey;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public int getAttributsNumber(){
		return attributsNumber;
	}
	
	public void generateAttributsNumber() {
		//every Feature rises this Number, usefull for later
		
	}
}
