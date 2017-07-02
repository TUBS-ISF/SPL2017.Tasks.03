import java.io.IOException;




/**
 * Main Method to start the Application
 * @author Niklas
 * 
 */
public class BookAdministrationSPL {

	public BookAdministrationSPL(){
		super();
		BookController.getInstance();
			
		GuiMain gm = new GuiMain();
		
		
	}
	
	
	public static void main(String args0[]) throws IOException{
		BookAdministrationSPL application = new BookAdministrationSPL(); 
	}
	
	
}
