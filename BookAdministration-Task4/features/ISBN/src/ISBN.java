import interfaces.IAttribut;

public class ISBN implements IAttribut{

	//sp�ter auf int, zum sortieren
	String isbn;
	
	@Override
	public void init(String string) {
		this.isbn = string;
	}
	
	@Override
	public String getValue(){
		return isbn;
	}
	
	@Override
	public void setValue(String string){
		this.isbn = string;
	}
	
}