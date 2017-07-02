
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
}
