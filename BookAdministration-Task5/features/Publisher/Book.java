
import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;


/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	
	String publisher;
	
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	private void generateAttributsNumber() {
		
		original();
		attributsNumber++;
		
	}
}
