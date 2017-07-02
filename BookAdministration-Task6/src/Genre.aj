
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
}
