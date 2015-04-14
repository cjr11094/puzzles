import java.awt.*;

import javax.swing.ImageIcon;

public class Conner extends AnimationPanel {
	
	private Image winner1;
	private Image winner2;
	private Image focusImage;

	public void loadpics(){
//		winner1 = new ImageIcon(url+"Winner5.png").getImage();
//		winner2 = new ImageIcon(url+"Winner6.png").getImage();
//		focusImage = winner1;
	}
	
	public void changeImage(){
		if(focusImage==winner1){
			focusImage=winner2;
			repaint();
		} else {
			focusImage = winner1;
			repaint();
		}
	}
	
/*	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(focusImage,0,0,null);
	}*/

}
