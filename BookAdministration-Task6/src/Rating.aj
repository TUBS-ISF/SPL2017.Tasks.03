
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
}
