
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookListener implements ActionListener {

	@Override
	//work in Progress, does nothing useful
	public void actionPerformed(ActionEvent e) {
		System.out.println("Delete Book: Work in progress");
		
		int chosen = GuiMain.getInstance().table.getSelectedRow();
		int next = GuiMain.getInstance().table.convertRowIndexToModel(chosen);

		
//		selectedBook = booksList.get(table.convertRowIndexToModel(selectedRow));
		
		BookController.getInstance().deleteBook(next);
		
		System.out.println("Delete "+chosen);
		
	}
	
}
