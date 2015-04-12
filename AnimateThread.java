
public class AnimateThread extends Thread {

    private AnimationPanel thePanel;
    private boolean animating = true;
    
    public AnimateThread(AnimationPanel cp) {
    	thePanel = cp;
    }

    
    public void run() {
	
    	while (true) {

    		if (animating) thePanel.changeImage();
    		
	    
    		try {
    			Thread.sleep(2000);
    		} 
    		catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public void setState(boolean b) {
    	animating = b;
    }

    
}
