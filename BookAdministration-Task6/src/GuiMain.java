
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
	
	static Color color;


	JTable table = null;
	Vector<String> colNames;
	HashMap<Number, Book> h;
	int columnCount = 10;
	String[] columnNames = new String[columnCount];
	Book[] tempBooks = new Book[10];
	Object[][] o = new Object[10][columnCount];
	int atrCounter = 0;
	int bookCounter =0;
	int attributsNumber=0;
		
	
	public GuiMain() {
		
		instance = this;
		
		setLayout(new BorderLayout());
		
		this.init();
		
		System.out.println("AttNumb "+this.attributsNumber);
	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    table.setBackground(color);
	    
	    add(new JScrollPane(table));
	    
	}
	//TODO Teile als refresh auslagern/wiederverwenden für Änderungen in der Collection
	public void init() {
	
		h = BookController.getInstance().getBookCollection();
		colNames = new Vector<String>();
			    
	    this.createColumnNames();
	    
	    String[] correctColumnNames = new String[attributsNumber];
	    
	    //Fix für ein spät aufgetretenes Problem, geht sicherlich ordentlicher
	    for(int i=0; i< correctColumnNames.length; i++) {
	    	correctColumnNames[i] = columnNames[i];
		}
	        
	    //ebenfalls für das Object O hier anpassen
	    
	  	    
	    //Forschleife zum rüberkopieren
	    
	    this.fillTable();
	    
	    Object[][] o2 = new Object[h.size()][this.attributsNumber];
	    
	    //BuildAround um einen Konzept/Plannungsfehler meinerseits
	    for(int i = 0;i <h.size(); i++) {
	    	for(int j = 0; j<this.attributsNumber;j++) {
	    		o2[i][j] = o[i][j];
	    	}
	    }
	    
	    table = new JTable(o2, correctColumnNames); //man kann auch Vectoren übergeben, damit variable?
	    this.add(table, BorderLayout.CENTER);
		
	    
	}

	
	
	public void createColumnNames() {
		
				
		if(h.isEmpty()) {
			System.out.println("Empty Collection");
		}
		
		for(int i=0; i< colNames.size(); i++) {
			columnNames[i] = colNames.get(i);
		}
	}
	
	public void fillTable() {
			
		for(Number n: h.keySet()) {	
				
			// Konzept:
			tempBooks[bookCounter] = h.get(n);
			System.out.println("n " + n);
			this.fillBook(atrCounter, bookCounter);
			
			
			o[bookCounter][atrCounter] = tempBooks[bookCounter].getTitle();
			System.out.println(tempBooks[bookCounter].getTitle());
			atrCounter++;
//			original();
			
			bookCounter++;
			atrCounter = 0;	
			
			}    
	}
	
	

	public Color getColorscheme() {
		return color;
	}
	public void setColorScheme(Color colorscheme) {
		color = colorscheme;
	}
	
	
	public static GuiMain getInstance() {
		
		if(instance == null) {
			instance = new GuiMain();
		}
		return instance;
	}
	
	public void fillBook (int atrCounter, int bookCounter){
		//Leere Methode als Jointpoint für die Aspekte
	}

}


