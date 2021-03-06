package main.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import interfaces.IAttribut;
import interfaces.IButton;
import loader.PluginLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import main.book.Book;
import main.book.BookController;

public class GuiMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int columnCount = 0;
	JTable table = null;
	Vector<String> colNames;
	private final HashMap<String, IButton> iButtonHashMap = new HashMap<String,IButton>();
	private final HashMap<String, JButton> buttons = new HashMap<String,JButton>();
	
	
	public GuiMain() {
		setLayout(new BorderLayout());
		
		

	    colNames = new Vector<String>();
	    table = new JTable(this.fillTable(), this.createColumnNames()); //man kann auch Vectoren �bergeben, damit variable?
	    this.add(table, BorderLayout.CENTER);
	    
	    initIButtonHashMap();
	    placeButtons();
	    
	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new JScrollPane(table));
	    

	}

	//TODO als init-Methode auslagern
	

	
	
	
	
	public String[] createColumnNames(){
		
		//TODO sauberer
			
		HashMap<String, IAttribut> attributMap = new HashMap<String,IAttribut >();
		
		List<IAttribut> attributPlugins = PluginLoader.load(IAttribut.class);
		
		
		for(IAttribut att : attributPlugins){
			String key = att.getClass().getName(); 
			attributMap.put(key, att); 
		}
		
		String[] columnNames = new String[attributMap.size()];
		
		

		if(attributMap.containsKey("Read")) {
			colNames.add("Read");
		}
		
		if(attributMap.containsKey("ISBN")) {
			colNames.add("ISBN");
		}
		
		if(attributMap.containsKey("Rating")) {
			colNames.add("Rating");
		}	
	
		if(attributMap.containsKey("Author")) {
			colNames.add("Author");
		}

		//Title is mandatory
		
		if(attributMap.containsKey("Title")) {
			colNames.add("Title");
		}

		
		if(attributMap.containsKey("Genre")) {
			colNames.add("Genre");
		}
	
		
		if(attributMap.containsKey("Publisher")) {
			colNames.add("Publisher");
		}
		

		
			
		for(int i=0; i< colNames.size(); i++) {
			columnNames[i] = colNames.get(i);
		}
		
	
		columnCount = columnNames.length;

		return columnNames;
		
	}
	
	public Object[][] fillTable() {
		
		HashMap<Number, Book> h = BookController.getInstance().getBookCollection();

				
		List<IAttribut> attributPlugins = PluginLoader.load(IAttribut.class);
		
		HashMap<String, IAttribut> attributMap = new HashMap<String,IAttribut >();

		
		for(IAttribut att : attributPlugins){
			String key = att.getClass().getName();
			attributMap.put(key, att); 
		}
		columnCount = attributMap.size();
		//System.out.println("ColumnCount in fillTable" + columnCount);
		
		Object[][] o = new Object[h.size()][columnCount];
		
		
			int bookCounter =0;
			for(Number n: h.keySet()) {	
				
				
				//System.out.println(h.get(n).getAttributMap().keySet());
				int atrCounter = 0;
                for(String key : h.get(n).getAttributMap().keySet()) {
                		
                		
                		IAttribut atr = h.get(n).getAttributMap().get(key);
                		o[bookCounter][atrCounter] = atr.getValue();
                		System.out.println("geschriebenes Value:" + o[bookCounter][atrCounter].toString());
                		//System.out.println(o[bookCounter][atrCounter] = atr.getValue());
                		atrCounter++;
                		//System.out.println(atrCounter);
                	}
				
                bookCounter++;
                System.out.println(bookCounter);
            
			}    
		
			
			
		return o;
	}
	

	private void initIButtonHashMap() {
		List<IButton> buttonPlugins = PluginLoader.load(IButton.class);
		for(IButton button : buttonPlugins) {
			String key = button.getClass().getName(); 
			iButtonHashMap.put(key, button); 
		}
	}
	

	private void placeButtons() {
		for(String key : iButtonHashMap.keySet()) {
			JButton button = iButtonHashMap.get(key).getButton(); 
			
			if(iButtonHashMap.containsKey("AddBook")) {
				button.addActionListener(new AddBookListener());
				this.add(button, BorderLayout.EAST);
			}
			buttons.put(key, button);
		}		
	}
}


