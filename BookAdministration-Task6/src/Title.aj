import java.awt.Color;

public aspect Title {
	private String Book.title;
	
	public String Book.getTitle() {
		return title;
	}
	
	public void Book.setTitle(String title) {
		this.title = title;
	}
	
	before(): execution(public void GuiMain.createColumnNames() ) {
		GuiMain.getInstance().colNames.add("Title");
		GuiMain.getInstance().attributsNumber++;
		System.out.println("Title added");
	}
	
	
}