import java.awt.Color;

public aspect Green {
	before(): execution(public void GuiMain.init()) {
		GuiMain.getInstance().setColorScheme(Color.GREEN);
	}
}