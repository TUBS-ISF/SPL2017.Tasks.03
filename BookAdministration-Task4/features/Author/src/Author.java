import interfaces.IAttribut;

public class Author implements IAttribut{

	String author;
	
	@Override
	public void init(String string) {
		this.author = string;
	}
	
	public String getValue(){
		return author;
	}
	
	public void setValue(String string){
		this.author = string;
	}
	
}
