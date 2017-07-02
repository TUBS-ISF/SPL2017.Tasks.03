
public aspect Rating {

	private String Book.rating;
	
	
	
	public String Book.getRating() {
		return rating;
	}
	
	public void Book.setRating(String rating) {
		this.rating = rating;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Rating");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Rating added");
	}
	
	before(): execution(public void GuiMain.fillBook()) {
		
		GuiMain.getInstance().o[GuiMain.getInstance().bookCounter][GuiMain.getInstance().atrCounter] = GuiMain.getInstance().tempBooks[GuiMain.getInstance().bookCounter].getRating();
		GuiMain.getInstance().atrCounter++;
//		System.out.println("test fill Rating");
	}
	
	//Testdaten
	
	after(): execution (public void BookController.addTestdata()) {
		BookController.getInstance().test1.setRating("5.0");
		BookController.getInstance().test2.setRating("3.0");
		BookController.getInstance().test3.setRating("1.3");
	}
}
