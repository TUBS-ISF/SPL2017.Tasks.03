
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
	
	
	JTable table = null;
	Vector<String> colNames;
	HashMap<Number, Book> h;
	int columnCount = 10;
	String[] columnNames = new String[columnCount];
	Book[] tempBooks = new Book[10];
	Object[][] o = new Object[10][columnCount]; // benötigt?
	int atrCounter = 0;
	int bookCounter =0;
	

	//private final HashMap<String, IButton> iButtonHashMap = new HashMap<String,IButton>();
	
	//private final HashMap<String, JButton> buttons = new HashMap<String,JButton>();
	
	
	public GuiMain() {
		
		setLayout(new BorderLayout());
		
		this.init();
//	    initIButtonHashMap();
//	    placeButtons();

	  
	    this.setSize(new Dimension (800,800));
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setColorScheme();
	    
	    add(new JScrollPane(table));
	    
	}
	
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
	    Object[][] o2 = new Object[h.size()][h.get(1).attributsNumber];
	    
	    
	    //Forschleife zum rüberkopieren
	    
	    this.fillTable();
	    table = new JTable(o, correctColumnNames); //man kann auch Vectoren übergeben, damit variable?
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
	
//	private void initIButtonHashMap() {
//		List<IButton> buttonPlugins = PluginLoader.load(IButton.class);
//		for(IButton button : buttonPlugins) {
//			String key = button.getClass().getName(); 
//			iButtonHashMap.put(key, button); 
//		}
//	}
//	
//
//	private void placeButtons() {
//		for(String key : iButtonHashMap.keySet()) {
//			JButton button = iButtonHashMap.get(key).getButton(); 
//			
//			if(iButtonHashMap.containsKey("AddBook")) {
//				button.addActionListener(new AddBookListener());
//				this.add(button, BorderLayout.EAST);
//			}
//			buttons.put(key, button);
//		}		
//	}
}


