
public aspect ISBN {

	private String Book.isbn;
	
	public String Book.getISBN() {
		return isbn;
	}
	
	public void Book.setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("ISBN");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("ISBN added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getISBN();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill ISBN");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setISBN("123");
		BookController.getInstance().test2.setISBN("456");
		BookController.getInstance().test3.setISBN("789");
	}
}

