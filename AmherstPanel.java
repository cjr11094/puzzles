import java.awt.*;

import javax.swing.ImageIcon;

public class AmherstPanel extends AnimationPanel {
	
	private Image amherst;
	private Image focusImage;

	
	public AmherstPanel(){
//		loadpics();
	}
	
	public void loadpics(){
		amherst = new ImageIcon(url+"AmherstLogo.png").getImage();
		focusImage = amherst;
	}
	
	public void changeImage(){
		focusImage=amherst;
	}
	
/*	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(focusImage,0,0,null);
	}*/

}
