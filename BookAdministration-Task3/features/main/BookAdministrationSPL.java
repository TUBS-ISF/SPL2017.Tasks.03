package main;

import java.io.IOException;

import main.book.BookController;
import main.GUI.*;


/**
 * Main Method to start the Application
 * TODO add decision for GUI or CLI
 * @author Niklas
 * 
 */
public class BookAdministrationSPL {

	public BookAdministrationSPL(){
		super();
		BookController.getInstance();
		/*if[GUI]*/	
		GuiMain gm = new GuiMain();
		/*end[GUI]*/
		
	}
	
	
	public static void main(String args0[]) throws IOException{
		BookAdministrationSPL application = new BookAdministrationSPL(); 
	}
	
	
}
