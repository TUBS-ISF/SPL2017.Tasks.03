import java.awt.Color;

public aspect Red {

	before(): execution(public void GuiMain.init()) {
		GuiMain.getInstance().setColorScheme(Color.RED);
	}
			
}
