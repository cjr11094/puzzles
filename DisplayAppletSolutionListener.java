import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DisplayAppletSolutionListener implements ActionListener {

    private Applet fr;
    private String gameType;
    
    public DisplayAppletSolutionListener( String gameType,Applet fr) {
    	this.fr=fr;
    	this.gameType=gameType;
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(gameType.equals("sudoku")){
    		fr.displaySudoku();
    	}
    	if(gameType.equals("ken")){
    		fr.displayKen();
    	}
    	if(gameType.equals("abc")){
    		fr.displayABC();
    	}
	   
	   
    }
    
}
