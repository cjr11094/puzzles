import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class KenAppletButtonToMenuListener implements ActionListener {

    private JButton myButton;
    private int index;
    JPopupMenu  menu;
    private Applet frame;
	
    public KenAppletButtonToMenuListener(JButton clicker,int index,Applet frame) {
	this.index=index;
	myButton = clicker;
	this.frame=frame;


	menu = new JPopupMenu("Menu");
	KenAppletElementChangeListener ecl = new KenAppletElementChangeListener(myButton,index,frame);
		
	JMenuItem one = new JMenuItem("1");
	menu.add(one);
	one.addActionListener(ecl);

	JMenuItem two = new JMenuItem("2");
	menu.add(two);
	two.addActionListener(ecl);
	
	JMenuItem three = new JMenuItem("3");
	menu.add(three);
	three.addActionListener(ecl);
	
	JMenuItem four = new JMenuItem("4");
	menu.add(four);
	four.addActionListener(ecl);
	
	
        menu.add(new JMenuItem("Never Mind"));        
    }
    
    public void actionPerformed(ActionEvent e) {
	
	menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
    }
    
    
}
