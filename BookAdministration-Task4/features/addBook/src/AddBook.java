import interfaces.IButton;
import javax.swing.JButton;


public class AddBook implements IButton{

	@Override
	public JButton getButton() {
		JButton button = new JButton("Add Book");
		return button;
	}
}
