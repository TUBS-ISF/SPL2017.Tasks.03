
public aspect Genre {

private String Book.genre;
	
	public String Book.getGenre() {
		return genre;
	}
	
	public void Book.setGenre(String genre) {
		this.genre = genre;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Genre");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Genre added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getGenre();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Genre");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setGenre("Krimi");
		BookController.getInstance().test2.setGenre("Roman");
		BookController.getInstance().test3.setGenre("SciFi");
	}
}
