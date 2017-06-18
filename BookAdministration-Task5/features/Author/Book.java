
import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;


/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	
	String author;
	
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}


	private void generateAttributsNumber() {
		
		attributsNumber++;
		
	}
}
