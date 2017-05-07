package main.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.HashMap;
import java.util.Vector;

import main.book.Book;
import main.book.BookController;
import properties.PropertyManager;

public class GuiMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int columnCount = 0;
	JTable table = null;
	Vector<String> colNames;
	
	
	public GuiMain() {
		setLayout(new BorderLayout());
	    JButton button = new JButton("addBook");
	    button.addActionListener(new AddBookListener());
	    table = new JTable(this.fillTable(), this.createColumnNames());
	    colNames = new Vector<String>();
	    this.add(table, BorderLayout.CENTER);
	}

	//TODO als init-Methode auslagern
	

	
	
	
	
	public String[] createColumnNames(){
		
		// Title is mandatory
		colNames.add("Title");
		
		if (PropertyManager.getProperty("Author")) {
			colNames.add("Author");
		}
		
		if (PropertyManager.getProperty("ISBN")) {
			colNames.add("ISBN");
		}
		
		if (PropertyManager.getProperty("Genre")) {
			colNames.add("Genre");
		}
		
		if (PropertyManager.getProperty("Read")) {
			colNames.add("Read");
		}
		
		if (PropertyManager.getProperty("Publisher")) {
			colNames.add("Publisher");
		}
		
		if (PropertyManager.getProperty("Rating")) {
			colNames.add("Rating");
		}
		
		String[] columnNames = new String[colNames.size()];
		
		for(int i=0; i< colNames.size(); i++) {
			columnNames[i] = colNames.get(i);
		}
		
		columnCount = columnNames.length;
		return columnNames;
		
	}
	
	public Object[][] fillTable() {
		
		HashMap<Number, Book> h = BookController.getInstance().getBookCollection();
		
		Object[][] o = new Object[h.size()][7]; //TODO columnCount als 2. Dimension
		
		for(int i = 0; i<h.size(); i++) {
			
			for(Number n: h.keySet()) {
				
				o[i][0] = h.get(n).getTitle();
				
				if (PropertyManager.getProperty("Author")) {
					o[i][1] = h.get(n).getAuthor();
				}
				
				if (PropertyManager.getProperty("ISBN")) {
					o[i][2] = h.get(n).getIsbn();
				}
				
				if (PropertyManager.getProperty("Genre")) {
					o[i][3] = h.get(n).getGenre();
				}
				
				if (PropertyManager.getProperty("Read")) {
					o[i][4] = h.get(n).isRead();
				}
				
				if (PropertyManager.getProperty("Publisher")) {
					o[i][5] = h.get(n).getPublisher();
				}
				
				if (PropertyManager.getProperty("Rating")) {
					o[i][6] = h.get(n).getRating();
				}
				 		
			}
			
			
		}
		
		return o;
	}
	

	
}


