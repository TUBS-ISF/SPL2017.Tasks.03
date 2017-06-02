import interfaces.IAttribut;

public class ISBN implements IAttribut{

	//später auf int, zum sortieren
	String isbn;
	
	@Override
	public void init(String string) {
		this.isbn = string;
	}
	
	public String getValue(){
		return isbn;
	}
	
	public void setValue(String string){
		this.isbn = string;
	}
	
}