import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ABCElementChangeListener implements ActionListener {

    JButton clicker;
    private int index;
    private TheFrame frame;
	
    public ABCElementChangeListener(JButton clicker,int index,TheFrame frame) {
	this.clicker=clicker;
	this.index=index;
	this.frame=frame;
    }

	
    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
	if (action.equals("A")){
	    clicker.setText("A");
	    frame.setABC(index,1);
	}
	if(action.equals("B")){
	    clicker.setText("B");
	    frame.setABC(index,2);
	}
	if (action.equals("C")){
	    clicker.setText("C");
	    frame.setABC(index,3);
	}
	if(action.equals("D")){
	    clicker.setText("D");
	    frame.setABC(index,4);
	}	

    }

		
}
