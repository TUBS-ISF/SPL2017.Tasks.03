
import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;


/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	
	String genre;
	
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	} 

	
	private void generateAttributsNumber() {
		
		original();
		attributsNumber++;
		
	}
}
