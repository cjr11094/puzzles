import javax.swing.*;
import java.awt.event.*;

public class SwitchAppletFrameListener implements ActionListener {

	private Applet frame;
	private String gameType;
//	private JFrame f;
	
	public SwitchAppletFrameListener(Applet frame,String gameType){
		this.frame=frame;
		this.gameType=gameType;
//		this.f=frame.getFrame();
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("we're here");
		frame.getContentPane().removeAll();
		if(gameType.equals("sudoku")){
			frame.sudokuGUI();
//			f.validate();
//			f.repaint();
			frame.validate();
			frame.repaint();
		}
		if(gameType.equals("kenken")){
			frame.kenkenGUI();
//			f.validate();
//			f.repaint();
			frame.validate();
			frame.repaint();
		}
		if(gameType.equals("abc")){
			frame.abcGUI();
//			f.validate();
//			f.repaint();
			frame.validate();
			frame.repaint();
		}
		if(gameType.equals("welcome")){
			frame.init();
//			f.validate();
//			f.repaint();
			frame.validate();
			frame.repaint();
		}
	}
	
}
