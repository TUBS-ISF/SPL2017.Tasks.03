import interfaces.IAttribut;

public class Author implements IAttribut{

	String author;
	
	@Override
	public void init(String string) {
		this.author = string;
	}
	
	@Override
	public String getValue(){
		return author;
	}
	
	@Override
	public void setValue(String string){
		this.author = string;
	}
	
}
