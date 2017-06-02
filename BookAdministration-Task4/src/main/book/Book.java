package main.book;

import java.util.List;

import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import java.util.HashMap;

import interfaces.IAttribut;
import loader.PluginLoader;

/*
 * Book Entity with several attributs
 */
public class Book {
	
	//HashMap mit allen angewählten AttributsPlugins
	private final HashMap<String, IAttribut> attributMap = new HashMap<String,IAttribut >();
	
	int bookKey;
	
	//TODO HashMap mit 7 Attributswerten, Key als String mit Namen des Attributs, zum späteren Erkennen welche Attribute angewählt sind. (if(attribut=null))
	


	
	public Book(String title) {
		List<IAttribut> attributPlugins = PluginLoader.load(IAttribut.class);
		System.out.println(attributPlugins.size());
		for(IAttribut att : attributPlugins){
			String key = att.getClass().getName(); 
			System.out.println(key);
			attributMap.put(key, att); 
		}
		
	//attributMap.get("Title").setValue(title);

	}

	public HashMap<String, IAttribut> getAttributMap() {
		return attributMap;
	}
	
	public void setAttribut(String key, String value) {
		attributMap.get(key).setValue(value);
	}
		
	
	
	
	public int getBookKey() {
		return bookKey;
	}

	public void setBookKey(int bookKey) {
		this.bookKey = bookKey;
	}
	

}
