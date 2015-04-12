import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Image;

public class ABCButton extends JButton{

	private Image arrow;
	private Image info;
	
	public ABCButton(Image arrow,Image info){
		this.arrow=arrow;
		this.info=info;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(arrow,20,20,null);
		g.drawImage(info,100,100,null);
		repaint();
	}
	
	
}
