
public class KenKenConstraints implements Constraints {

	    private int column;
	    private int row;
	    private int check;
	    private KenKenSpot[][] theSpotMatrix;
	    private KenKenSpot[] theSpots;

	    public KenKenConstraints (int[] theValues,int check, int[]boardOperators,int[]boardOpNumbers,int[]boardGroups) {
	    	KenKenGame g = new KenKenGame(4,4,boardOperators,boardOpNumbers,boardGroups);
	    	theSpots=g.getSpots();
	    	for (int i =0;i<theValues.length; i++){
	    		theSpots[i].setValue(theValues[i]);	
	    	}
	    	theSpotMatrix= new KenKenSpot[4][4];
	    	this.check=check;

	    	this.column=theSpots[check].getColumn();
	    	this.row=theSpots[check].getRow();
	    	int counter=0;
	    	for(int i=0;i<4;i++){
	    		for (int j=0;j<4;j++){
	    			theSpotMatrix[j][i]=theSpots[counter];
	    			counter++;
	    		}
	    	}
	    }
	    

	    public boolean checkRow(){	
	    	for (int i=0;i<4;i++){	    
	    		if(theSpotMatrix[i][row].getValue()==theSpots[check].getValue() && i!=column)
	    			return false;
	    	}
	    	return true;
	    }

	    public boolean checkColumn(){
	    	for (int i=0;i<4;i++){	    
	    		if(theSpotMatrix[column][i].getValue() == theSpots[check].getValue() && i!=row)
	    			return false;
	    	}
	    	return true;
	    }

	    public boolean checkMath() {
	    	if (theSpots[check].getOT().equals("subtraction")){
	    		int numsON = theSpots[check].getON();
	    		for (int i=0;i<theSpots.length;i++){
	    			if(theSpots[check].getGroup()==theSpots[i].getGroup() && i!=check && theSpots[i].getValue()!=0){
	    				if(Math.abs(theSpots[check].getValue()-theSpots[i].getValue())!=numsON){
	    					return false;
	    				}
	    			}
	    		}
	    	}

	    	if (theSpots[check].getOT().equals("division")){
	    		int numsON = theSpots[check].getON();
	    		for (int i=0;i<theSpots.length;i++){
	    			if(theSpots[check].getGroup()==theSpots[i].getGroup() && i!=check && theSpots[i].getValue()!=0){
	    				if(theSpots[check].getValue()/theSpots[i].getValue()!=numsON && theSpots[i].getValue()/theSpots[check].getValue()!=numsON){
	    					return false;
	    				}
	    			}
	    		}
	    	}
		
	    	if (theSpots[check].getOT().equals("multiplication")){
	    		int numsON = theSpots[check].getON();
	    		for (int i=0;i<theSpots.length;i++){
	    			if(theSpots[check].getGroup()==theSpots[i].getGroup() && i!=check && theSpots[i].getValue()!=0){
	    				if(theSpots[check].getValue()*theSpots[i].getValue()!=numsON){
	    					return false;
	    				}
	    			}
	    		}
	    	}

	    	if (theSpots[check].getOT().equals("addition")){
	    		int numsON = theSpots[check].getON();
	    		for (int i=0;i<theSpots.length;i++){
	    			if(theSpots[check].getGroup()==theSpots[i].getGroup() && i!=check && theSpots[i].getValue()!=0){
	    				if(theSpots[check].getValue()+theSpots[i].getValue()!=numsON){
	    					return false;
	    				}
	    			}
	    		}
	    	}
	    	return true;
	    }

}
