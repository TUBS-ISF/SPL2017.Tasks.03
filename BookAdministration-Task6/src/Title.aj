import java.awt.Color;

public aspect Title {
	private String Book.title;
	
	public String Book.getTitle() {
		return title;
	}
	
	public void Book.setTitle(String title) {
		this.title = title;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Title");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Title added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getTitle();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Title");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setTitle("Title1");
		BookController.getInstance().test2.setTitle("Title2");
		BookController.getInstance().test3.setTitle("Title3");
	}
	
}