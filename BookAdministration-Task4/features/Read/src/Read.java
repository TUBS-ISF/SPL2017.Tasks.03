import interfaces.IAttribut;

public class Read implements IAttribut{

	//sp�ter auf boolean, zum Sortieren
	String read;
	
	@Override
	public void init(String string) {
		this.read = string;
	}
	
	@Override
	public String getValue(){
		return read;
	}
	
	@Override
	public void setValue(String string){
		this.read = string;
	}
	
}