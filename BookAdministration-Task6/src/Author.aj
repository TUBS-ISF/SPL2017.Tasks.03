
public aspect Author {
	
	declare precedence: Title, Author, Genre, Publisher, ISBN, Rating, Read;

	private String Book.author;
	
	
	public String Book.getAuthor() {
		return author;
	}
	
	public void Book.setAuthor(String author) {
		this.author = author;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Author");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Author added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getAuthor();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Author");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setAuthor("Bob");
		BookController.getInstance().test2.setAuthor("Paul");
		BookController.getInstance().test3.setAuthor("Steve");
	}
}