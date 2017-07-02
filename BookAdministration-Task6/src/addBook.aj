import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.BorderLayout;


public aspect addBook {
	
	
	private class AddBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Add Book: This feature will be implementet");
	
		}
	
	}
	
	    
    after(): execution(public void GuiMain.init()) {
    	
        JButton addButton = new JButton("addBook");
    	addButton.addActionListener(new AddBookListener());
        GuiMain.getInstance().add(addButton, BorderLayout.EAST);
	}
}