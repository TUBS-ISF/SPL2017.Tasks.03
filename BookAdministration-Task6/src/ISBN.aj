
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
}

