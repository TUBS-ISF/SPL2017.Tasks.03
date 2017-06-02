import interfaces.IAttribut;

public class Genre implements IAttribut{

	String genre;
	
	@Override
	public void init(String string) {
		this.genre = string;
	}
	
	public String getValue(){
		return genre;
	}
	
	public void setValue(String string){
		this.genre = string;
	}
	
}