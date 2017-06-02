import interfaces.IAttribut;

public class Read implements IAttribut{

	//später auf boolean, zum Sortieren
	String read;
	
	@Override
	public void init(String string) {
		this.read = string;
	}
	
	public String getValue(){
		return read;
	}
	
	public void setValue(String string){
		this.read = string;
	}
	
}