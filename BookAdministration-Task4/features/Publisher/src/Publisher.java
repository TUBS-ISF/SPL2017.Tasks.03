
import interfaces.IAttribut;

public class Publisher implements IAttribut{

	String publisher;
	
	@Override
	public void init(String string) {
		this.publisher = string;
	}
	
	public String getValue(){
		return publisher;
	}
	
	public void setValue(String string){
		this.publisher = string;
	}
	
}