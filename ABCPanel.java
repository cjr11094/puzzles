import java.awt.*;

import javax.swing.ImageIcon;

public class ABCPanel extends AnimationPanel {
	
	private Image a2down;
	private Image c2down;
	private Image a1down;
	private Image c1right;
	private Image d2right;
	private Image a2right;
	private Image b1right;
	private Image a1up;
	private Image d1up;
	private Image b2left;
	private Image d1left;
	private Image focusImage;
	
	public ABCPanel(){
		loadpics();
	}
	
	public void loadpics(){
		a2down = new ImageIcon("/Users/connerreilly/Documents/Java Images/A2Down.png").getImage();
		c2down = new ImageIcon("/Users/connerreilly/Documents/Java Images/C2Down.png").getImage();
		a1down = new ImageIcon("/Users/connerreilly/Documents/Java Images/A1Down.png").getImage();
		c1right = new ImageIcon("/Users/connerreilly/Documents/Java Images/C1Right.png").getImage();
		d2right =new ImageIcon("/Users/connerreilly/Documents/Java Images/D2Right.png").getImage();
		a2right = new ImageIcon("/Users/connerreilly/Documents/Java Images/A2Right.png").getImage();
		b1right = new ImageIcon("/Users/connerreilly/Documents/Java Images/B1Right.png").getImage();
		a1up = new ImageIcon("/Users/connerreilly/Documents/Java Images/A1Up.png").getImage();
		d1up = new ImageIcon("/Users/connerreilly/Documents/Java Images/D1Up.png").getImage();
		b2left = new ImageIcon("/Users/connerreilly/Documents/Java Images/B2Left.png").getImage();
		d1left = new ImageIcon("/Users/connerreilly/Documents/Java Images/D1Left.png").getImage();
		
		
		
		focusImage = a2down;
	}
	
	public void changeImage(){
		focusImage=a2down;
	}
	
	public void changeImage(String name){
		if(name.equals("A2Down")){
			focusImage=a2down;
			repaint();
		} else if (name.equals("C2Down")){
			focusImage = c2down;
			repaint();
		} else if (name.equals("A1Down")){
			focusImage = a1down;
			repaint();
		}  else if (name.equals("C1Right")){
			focusImage = c1right;
			repaint();
		}  else if (name.equals("D2Right")){
			focusImage = d2right;
			repaint();
		}  else if (name.equals("A2Right")){
			focusImage = a2right;
			repaint();
		}  else if (name.equals("B1Right")){
			focusImage = b1right;
			repaint();
		}  else if (name.equals("A1Up")){
			focusImage = a1up;
			repaint();
		}  else if (name.equals("D1Up")){
			focusImage = d1up;
			repaint();
		}  else if (name.equals("B2Left")){
			focusImage = b2left;
			repaint();
		} else if (name.equals("D1Left")){
			focusImage = d1left;
			repaint();
		} else {
			focusImage = null;
			repaint();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(focusImage,0,0,null);
	}

}
