import interfaces.IAttribut;

public class Rating implements IAttribut{

	//später auf float zum Sortieren
	String rating;
	
	@Override
	public void init(String string) {
		this.rating = string;
	}
	
	public String getValue(){
		return rating;
	}
	
	public void setValue(String string){
		this.rating = string;
	}
	
}