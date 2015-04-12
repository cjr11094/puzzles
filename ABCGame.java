
public class ABCGame implements Game{

	
	private int[]rowLetterTypeLeft;
	private int[]rowOrderTypeLeft;
	private int[]rowLetterTypeRight;
	private int[]rowOrderTypeRight;
	private int[]columnLetterTypeDown;
	private int[]columnOrderTypeDown;
	private int[]columnLetterTypeUp;
	private int[]columnOrderTypeUp;
	private int[] possibleValues = {1,2,3,4,0};
	private ABCSpot[] theSpots;
	
	public ABCGame (int width,int height,int[]rowLetterTypeLeft,int[]rowOrderTypeLeft,int[]rowLetterTypeRight,int[]rowOrderTypeRight,int[]columnLetterTypeDown,int[]columnOrderTypeDown,int[]columnLetterTypeUp,int[]columnOrderTypeUp) {
		this.rowLetterTypeLeft=rowLetterTypeLeft;
		this.rowOrderTypeLeft=rowOrderTypeLeft;
		this.rowLetterTypeRight=rowLetterTypeRight;
		this.rowOrderTypeRight=rowOrderTypeRight;
		this.columnLetterTypeDown=columnLetterTypeDown;
		this.columnOrderTypeDown=columnOrderTypeDown;
		this.columnLetterTypeUp=columnLetterTypeUp;
		this.columnOrderTypeUp=columnOrderTypeUp;
		
		theSpots = new ABCSpot[36];
		
		theSpots = new ABCSpot[width*height];
		
		for(int h=0;h<theSpots.length;h++){
			theSpots[h] = new ABCSpot();
		}
		
		for (int i=0;i<rowLetterTypeLeft.length;i++){
			theSpots[i].setRLTL(rowLetterTypeLeft[i]);
		}
		

		for (int j=0;j<rowOrderTypeLeft.length;j++){
			theSpots[j].setROTL(rowOrderTypeLeft[j]);
		}
		
		
		for (int k=0;k<rowLetterTypeRight.length;k++){
			theSpots[k].setRLTR(rowLetterTypeRight[k]);
		}
		
		
		for (int l=0;l<rowOrderTypeRight.length;l++){
			theSpots[l].setROTR(rowOrderTypeRight[l]);
		}
		
		
		for (int m=0;m<columnLetterTypeDown.length;m++){
			theSpots[m].setCLTD(columnLetterTypeDown[m]);
		}
		
		
		for (int n=0;n<columnOrderTypeDown.length;n++){
			theSpots[n].setCOTD(columnOrderTypeDown[n]);
		}
		
		
		for (int o=0;o<columnLetterTypeUp.length;o++){
			theSpots[o].setCLTU(columnLetterTypeUp[o]);
		}
		
		
		for (int p=0;p<columnOrderTypeUp.length;p++){
			theSpots[p].setCOTU(columnOrderTypeUp[p]);
		}
		
		
		int counterB=0;
		int row=0;
		while(counterB<theSpots.length){
			for(int m=0;m<width;m++){
				theSpots[counterB].setRow(row);
				counterB++;
			}
			row++;
		}
		
		int counterA=0;
		while(counterA<theSpots.length){
			for(int n=0;n<width;n++){
				theSpots[counterA].setColumn(n);
				counterA++;
			}	
		}
		
	}

	public ABCSpot[] getSpots(){
		return this.theSpots;
	}

	public int[] getPossibles() {
		return this.possibleValues;
	}

	public boolean checkConstraints(int[] values,int check){
	    	
		ABCGame g = new ABCGame(6,6,this.rowLetterTypeLeft,this.rowOrderTypeLeft,this.rowLetterTypeRight,this.rowOrderTypeRight,this.columnLetterTypeDown,this.columnOrderTypeDown,this.columnLetterTypeUp,this.columnOrderTypeUp);
		ABCSpot[]spot=g.getSpots();
		ABCConstraints chk = new ABCConstraints(values,check,this.rowLetterTypeLeft,this.rowOrderTypeLeft,this.rowLetterTypeRight,this.rowOrderTypeRight,this.columnLetterTypeDown,this.columnOrderTypeDown,this.columnLetterTypeUp,this.columnOrderTypeUp);

		//if the spot we are checking has a first-order left constraint

		if(spot[check].getLeftOrder()==1){
			if(chk.checkLeftOne()==false){
				return false;
			}
		}
		
		// if the spot we are checking has a second-order left constraint
		if(spot[check].getLeftOrder()==2){
			if(chk.checkLeftTwo()==false){
				return false;
			}
		}

		//if the spot we are checking is in a row with a first-order right constraint

		if(spot[check].getRightOrder()==1){
		    if(chk.checkRightOne()==false){
		    	return false;
		    }
		}

		//if the spot we are checking is in a row with a second-order right constraint
		if(spot[check].getRightOrder()==2){
			if(chk.checkRightTwo()==false){
				return false;
			}
		}
		
		if(spot[check].getDownOrder()==1){
		    if(chk.checkDownOne()==false){
		    	if(!chk.checkDownOne())
		    		return false;
		    }
		}
		
		if(spot[check].getDownOrder()==2){
		    if(chk.checkDownTwo()==false){
		    	if(!chk.checkDownTwo())
		    		return false;
			
		    }
		}	    
			
		if(spot[check].getUpOrder()==1){
			if(chk.checkUpOne()==false){
				return false;
			}
		}
		
		if(!chk.checkColumn()){
			return false;
		}

		if(!chk.checkRow()){
			return false;
		}
		
		if(chk.filledRow()){
			if(chk.maxBlankRow()){
				return false;
			}
		}	
		
		if(chk.filledColumn()){
			if(chk.maxBlankColumn()){
				return false;
			}
		}	
		
		return true;
	}
}

