import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.BorderLayout;


public aspect deleteBook {
	
	
	private class AddDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Delete Book: This feature will be implementet");
	
		}
	
	}
	
	    
    after(): execution(public void GuiMain.init()) {
    	
        JButton addButton = new JButton("deleteBook");
    	addButton.addActionListener(new AddDeleteListener());
        GuiMain.getInstance().add(addButton, BorderLayout.SOUTH);
	}
}