
public aspect Publisher {

	private String Book.publisher;
	
	public String Book.getPublisher() {
		return publisher;
	}
	
	public void Book.setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Publisher");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Publisher added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getPublisher();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Publisher");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setPublisher("Holz-Vertrieb");
		BookController.getInstance().test2.setPublisher("Berg-Vertrieb");
		BookController.getInstance().test3.setPublisher("Fluss-Vertrieb");
	}
}
