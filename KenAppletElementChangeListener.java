import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class KenAppletElementChangeListener implements ActionListener {

    JButton clicker;
    private int index;
    private Applet frame;
	
    public KenAppletElementChangeListener(JButton clicker,int index,Applet frame) {
	this.clicker=clicker;
	this.index=index;
	this.frame=frame;
    }

	
    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
	if (action.equals("1")){
	    clicker.setText("1");
	    frame.setKen(index,1);
	}
	if(action.equals("2")){
	    clicker.setText("2");
	    frame.setKen(index,2);
	}
	if (action.equals("3")){
	    clicker.setText("3");
	    frame.setKen(index,3);
	}
	if(action.equals("4")){
	    clicker.setText("4");
	    frame.setKen(index,4);
	}

    }

		
}
