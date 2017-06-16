
import interfaces.IAttribut;

public class Title implements IAttribut{

	//später auf boolean, zum Sortieren
	String title;
	
	@Override
	public void init(String string) {
		this.title = string;
	}
	
	@Override
	public String getValue(){
		return title;
	}
	
	@Override
	public void setValue(String string){
		this.title = string;
	}
	
}