
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class GuiMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static GuiMain instance = null;
	JTable table = null;
	Vector<String> colNames;
	HashMap<Number, Book> h;
	int columnCount = 10;
	String[] columnNames = new String[columnCount];
	Book[] tempBooks = new Book[10];
	Object[][] o = new Object[10][columnCount];
	int atrCounter = 0;
	int bookCounter =0;
		
	
	public GuiMain() {
		
		instance = this;
		
		setLayout(new BorderLayout());
		
		this.init();
	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setColorScheme();
	    
	    add(new JScrollPane(table));
	    
	}
	//TODO Teile als refresh auslagern/wiederverwenden für Änderungen in der Collection
	public void init() {
	
		h = BookController.getInstance().getBookCollection();
		colNames = new Vector<String>();
			    
	    this.createColumnNames();
	    String[] correctColumnNames = new String[h.get(1).attributsNumber];
	    
	    //Fix für ein spät aufgertetenes Problem, geht sicherlich ordentlicher
	    for(int i=0; i< correctColumnNames.length; i++) {
	    	correctColumnNames[i] = columnNames[i];
		}
	    
	  
	    
	    //ebenfalls für das Object O hier anpassen
	    
	    
	    
	    //Forschleife zum rüberkopieren
	    
	    this.fillTable();
	    
	    Object[][] o2 = new Object[h.size()][h.get(1).attributsNumber];
	    
	    //BuildAround um einen Konzept/Plannungsfehler meinerseits
	    for(int i = 0;i <h.size(); i++) {
	    	for(int j = 0; j<h.get(1).attributsNumber;j++) {
	    		o2[i][j] = o[i][j];
	    	}
	    }
	    
	    table = new JTable(o2, correctColumnNames); //man kann auch Vectoren übergeben, damit variable?
	    this.add(table, BorderLayout.CENTER);
		
	    
	}

	
	
	public void createColumnNames() {
		
				
		if(h.isEmpty()) {
			System.out.println("Leere Collection");
		}
		
		
		//Title is mandatory, other Attributs are added by the Features
		colNames.add("Title");
		
		original();
		
		for(int i=0; i< colNames.size(); i++) {
			columnNames[i] = colNames.get(i);
		}
	}
	
	public void fillTable() {
			
		for(Number n: h.keySet()) {	
				
			
			tempBooks[bookCounter] = h.get(n);
			System.out.println("n " + n);
			o[bookCounter][atrCounter] = tempBooks[bookCounter].getTitle();
			System.out.println(tempBooks[bookCounter].getTitle());
			atrCounter++;
			original();
			
			bookCounter++;
			atrCounter = 0;	
			
			}    
	}
	
	public void setColorScheme() {
		table.setBackground(Color.GRAY);
	}
	
	public static GuiMain getInstance() {
		
		if(instance == null) {
			instance = new GuiMain();
		}
		return instance;
	}

}


