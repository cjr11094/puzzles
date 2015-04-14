import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckAppletSolved implements ActionListener {

	private String gameType;
	private Applet frame;
	
    public CheckAppletSolved(String gameType,Applet frame) {
    	this.gameType=gameType;
    	this.frame=frame;

    }
    
    public void actionPerformed(ActionEvent e) {
    	if(gameType.equals("sudoku")){
    		frame.checkSudoku();
    	}
    	if(gameType.equals("ken")){
    		frame.checkKen();
    	}
    	if(gameType.equals("abc")){
    		frame.checkABC();
    	}

    }
}
