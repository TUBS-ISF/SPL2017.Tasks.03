
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
}
