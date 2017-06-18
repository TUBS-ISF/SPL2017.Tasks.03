
import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;


/*
 * Book Entity with several attributs
 */
public class Book {
	
	
	
	String read;
	
	
	public String getRead() {
		return read;
	}
	
	public void setRead(String read) {
		this.read = read;
	}

	
	private void generateAttributsNumber() {
		
		original();
		attributsNumber++;
		
	}
}
