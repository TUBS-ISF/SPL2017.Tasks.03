import java.awt.Color;

public aspect Yellow {
	before(): execution(public void GuiMain.init()) {
		GuiMain.getInstance().setColorScheme(Color.YELLOW);
	}
}