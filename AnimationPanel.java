import javax.swing.JPanel;

import java.applet.*;

public abstract class AnimationPanel extends JPanel {
	
	public String url = "";
	
	public abstract void changeImage();
	
	public abstract void loadpics();
	
}
