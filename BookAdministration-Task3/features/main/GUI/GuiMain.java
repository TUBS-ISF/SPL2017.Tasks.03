package main.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

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

public class GuiMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int columnCount = 0;
	JTable table = null;
	Vector<String> colNames;
	
	
	public GuiMain() {
		setLayout(new BorderLayout());
		
		
	    JButton button = new JButton("addBook");
	    button.addActionListener(new AddBookListener());
	    colNames = new Vector<String>();
	    table = new JTable(this.fillTable(), this.createColumnNames()); //man kann auch Vectoren übergeben, damit variable?
	    this.add(table, BorderLayout.CENTER);
	    
	    
	    /*if[addBook]*/	
		this.add(button, BorderLayout.EAST);
		/*end[addBook]*/
	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new JScrollPane(table));
	}

	//TODO als init-Methode auslagern
	

	
	
	
	
	public String[] createColumnNames(){
		
		// Title is mandatory
		colNames.add("Title");
		
		/*if[Author]*/	
			colNames.add("Author");
		/*end[Author]*/
		
		/*if[ISBN]*/	
			colNames.add("ISBN");
		/*end[ISBN]*/
		
		/*if[Genre]*/	
			colNames.add("Genre");
		/*end[Genre]*/
		
		/*if[Read]*/	
			colNames.add("Read");
		/*end[Read]*/
		
		/*if[Publisher]*/	
			colNames.add("Publisher");
		/*end[Publisher]*/
		
		/*if[Rating]*/	
			colNames.add("Rating");
		/*end[Rating]*/
		
		
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
		
		
		
			int counter =0;
			for(Number n: h.keySet()) {
				
				o[counter][0] = h.get(n).getTitle();
				
				/*if[Author]*/	
					o[counter][1] = h.get(n).getAuthor();
				/*end[Author]*/
			
				/*if[ISBN]*/	
					o[counter][2] = h.get(n).getIsbn();
				/*end[ISBN]*/
			
				/*if[Genre]*/	
					o[counter][3] = h.get(n).getGenre();
				/*end[Genre]*/
			
				/*if[Read]*/	
					o[counter][4] = h.get(n).isRead();
				/*end[Read]*/
			
				/*if[Publisher]*/	
					o[counter][5] = h.get(n).getPublisher();
				/*end[Publisher]*/
			
				/*if[Rating]*/	
					o[counter][6] = h.get(n).getRating();
				/*end[Rating]*/

				counter++;
				 		
			}
			
		return o;
	}
	

	
}


