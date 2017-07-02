
public aspect Read {

	private String Book.read;
	
	public String Book.getRead() {
		return read;
	}
	
	public void Book.setRead(String read) {
		this.read = read;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Read");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Read added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getRead();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Read");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setRead("true");
		BookController.getInstance().test2.setRead("false");
		BookController.getInstance().test3.setRead("true");
	}
}
