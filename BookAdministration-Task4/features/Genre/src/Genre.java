import interfaces.IAttribut;

public class Genre implements IAttribut{

	String genre;
	
	@Override
	public void init(String string) {
		this.genre = string;
	}
	
	@Override
	public String getValue(){
		return genre;
	}
	
	@Override
	public void setValue(String string){
		this.genre = string;
	}
	
}