import interfaces.IAttribut;

public class Rating implements IAttribut{

	//sp�ter auf float zum Sortieren
	String rating;
	
	@Override
	public void init(String string) {
		this.rating = string;
	}
	
	@Override
	public String getValue(){
		return rating;
	}
	
	@Override
	public void setValue(String string){
		this.rating = string;
	}
	
}