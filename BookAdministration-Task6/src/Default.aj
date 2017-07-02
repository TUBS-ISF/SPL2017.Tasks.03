import java.awt.Color;

public aspect Default {

	before(): execution(public void GuiMain.init()) {
		GuiMain.getInstance().setColorScheme(Color.GRAY);
	}
}
	