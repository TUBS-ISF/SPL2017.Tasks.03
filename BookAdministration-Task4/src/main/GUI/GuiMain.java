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
	HashMap<Number, Book> h;
	
	public GuiMain() {
		setLayout(new BorderLayout());
		
		

	    colNames = new Vector<String>();
	    table = new JTable(this.fillTable(), this.createColumnNames()); //man kann auch Vectoren übergeben, damit variable?
	    this.add(table, BorderLayout.CENTER);
	    
//	    JButton addButton = new JButton("addBook");
//	    addButton.addActionListener(new AddBookListener());
//		this.add(button, BorderLayout.EAST);
	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new JScrollPane(table));
	    
		h = BookController.getInstance().getBookCollection();

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
		
		
		//
		
		// Title is mandatory
		colNames.add("Title");
		
		if(attributMap.containsKey("Author")) {
			colNames.add("Author");
		}

		if(attributMap.containsKey("ISBN")) {
			colNames.add("ISBN");
		}
		
		if(attributMap.containsKey("Genre")) {
			colNames.add("Read");
		}
	
		if(attributMap.containsKey("Read")) {
			colNames.add("Read");
		}
		
		if(attributMap.containsKey("Publisher")) {
			colNames.add("Publisher");
		}
		
		if(attributMap.containsKey("Rating")) {
			colNames.add("Rating");
		}	
		
			
		for(int i=0; i< colNames.size(); i++) {
			columnNames[i] = colNames.get(i);
		}
		
	
		columnCount = columnNames.length;
		return columnNames;
		
	}
	
	public Object[][] fillTable() {
		
		
		Object[][] o = new Object[h.size()][columnCount]; //TODO columnCount als 2. Dimension
		
		
			int counter =0;
			for(Number n: h.keySet()) {
				
				o[counter][0] = h.get(n).getAttributMap().get("Title").getValue();
				
				/*if[Author]*/	
					o[counter][1] = h.get(n).getAttributMap().get("Author").getValue();
				/*end[Author]*/
			
				/*if[ISBN]*/	
					o[counter][2] = h.get(n).getAttributMap().get("ISBN").getValue();
				/*end[ISBN]*/
			
				/*if[Genre]*/	
					o[counter][3] = h.get(n).getAttributMap().get("Genre").getValue();
				/*end[Genre]*/
			
				/*if[Read]*/	
					o[counter][4] = h.get(n).getAttributMap().get("Read").getValue();
				/*end[Read]*/
			
				/*if[Publisher]*/	
					o[counter][5] = h.get(n).getAttributMap().get("Publisher").getValue();
				/*end[Publisher]*/
			
				/*if[Rating]*/	
					o[counter][6] = h.get(n).getAttributMap().get("Rating").getValue();
				/*end[Rating]*/

				counter++;
				 		
			}
			
		return o;
	}
	

	
}


