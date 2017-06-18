
import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;


/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	
	String isbn;
	
	
	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	
	private void generateAttributsNumber() {
		
		original();
		attributsNumber++;
		
	}
}
