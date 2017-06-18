
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

	
	
	public GuiMain() {
		
		
	    JButton deleteButton = new JButton("deleteBook");
	    deleteButton.addActionListener(new DeleteBookListener());
	    this.add(deleteButton, BorderLayout.SOUTH);
	    
	}    
	
}


