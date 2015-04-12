import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class ABCButtonToMenuListener implements ActionListener {

    private JButton myButton;
    private JPopupMenu menu;
	
    public ABCButtonToMenuListener(JButton clicker,int index,TheFrame frame) {
    	this.myButton = clicker;

	menu = new JPopupMenu("Menu");
	ABCElementChangeListener ecl = new ABCElementChangeListener(myButton,index,frame);
		
	JMenuItem a = new JMenuItem("A");
	menu.add(a);
	a.addActionListener(ecl);

	JMenuItem b = new JMenuItem("B");
	menu.add(b);
	b.addActionListener(ecl);
	
	JMenuItem c = new JMenuItem("C");
	menu.add(c);
	c.addActionListener(ecl);
	
	JMenuItem d = new JMenuItem("D");
	menu.add(d);
	d.addActionListener(ecl);
	
	JMenuItem blank = new JMenuItem("blank");
	menu.add(blank);
	blank.addActionListener(ecl);
	
	
	menu.add(new JMenuItem("Never Mind"));   

     
    }
    
    public void actionPerformed(ActionEvent e) {
	
    	menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
    }
    
    
}
