
public class ABCConstraints implements Constraints {
	
	private int column;
	private int row;
	private int value;
	private ABCSpot[] theSpots;
	private ABCSpot[][] theSpotMatrix;
	private int dLtr;
	private int uLtr;
	private int rLtr;
	private int lLtr;
	private boolean isEnd;
	
	public ABCConstraints (int[] theValues,int check,int[]rowLetterTypeLeft,int[]rowOrderTypeLeft,int[]rowLetterTypeRight,int[]rowOrderTypeRight,int[]columnLetterTypeDown,int[]columnOrderTypeDown,int[]columnLetterTypeUp,int[]columnOrderTypeUp) {
		ABCGame g = new ABCGame(6,6,rowLetterTypeLeft,rowOrderTypeLeft,rowLetterTypeRight,rowOrderTypeRight,columnLetterTypeDown,columnOrderTypeDown,columnLetterTypeUp,columnOrderTypeUp);
		theSpots=g.getSpots();
		for (int i =0;i<theValues.length; i++){
			theSpots[i].setValue(theValues[i]);
		}
		theSpotMatrix= new ABCSpot[6][6];
		this.column=theSpots[check].getColumn();
		this.row=theSpots[check].getRow();
		this.value=theSpots[check].getValue();
		int counter=0;
		this.dLtr=theSpots[check].getDownLetter();
		this.uLtr=theSpots[check].getUpLetter();
		this.rLtr=theSpots[check].getRightLetter();
		this.lLtr=theSpots[check].getLeftLetter();
		for(int i=0;i<6;i++){
		    for (int j=0;j<6;j++){
			theSpotMatrix[j][i]=theSpots[counter];
			counter++;
		    }
		}
	}


	    public boolean checkRow(){
		for (int i=0;i<6;i++){
			if(value==0)
				return true;
		    if(theSpotMatrix[i][row].getValue()==value && i!=column){
			return false;
		    }	
		}
		return true;
	    }



	    public boolean checkColumn(){
		for (int i=0;i<6;i++){
		    if(value==0)
		    	return true;
		    if(theSpotMatrix[column][i].getValue()==value && i!=row){
		    	return false;
		    }
		}
		return true;
	    }

	    public boolean maxBlankRow() {
		int counter = 0;
		for (int i=0;i<6;i++){
		    if(theSpotMatrix[i][row].getValue()==0){
			counter++;
		    }
		}
		if(counter>2){
		    return true;
		}
		return false;
	    }

	    public boolean maxBlankColumn() {
		int counter = 0;
		for (int i=0;i<6;i++){
		    if(theSpotMatrix[column][i].getValue()==0){
			counter++;
		    }
		}
		if(counter>2){
		    return true;
		}
		return false;
	    }

	    public boolean filledRow() {
		if(column==5){
		    return true;
		}else{
		    return false;
		}
	    }

	    public boolean filledColumn() {
		if(row==5){
		    return true;
		} else {
		    return false;
		}
	    }

	    public boolean filled () {
		if (row==5 && column==5)
		    return true;
		else
		    return false;
	    }
	    
	    public boolean checkLeftOne(){

		//if the first inserted value is not blank and is not lLtr
		if (theSpotMatrix[0][row].getValue()!=0 && theSpotMatrix[0][row].getValue()!=lLtr){
		    return false;
		}

		//if the first value is blank
		if (theSpotMatrix[0][row].getValue()==0 && theSpotMatrix[1][row].getValue()!=0){
		    if(theSpotMatrix[1][row].getValue()!=lLtr){
			System.out.println(row);
			System.out.println(lLtr);
			return false;
		    }
		}
		
		//if the first two values are blank
		if ((theSpotMatrix[0][row].getValue()==0 && theSpotMatrix[1][row].getValue() == 0 && theSpotMatrix[2][row].getValue()!=0)){
		    if(theSpotMatrix[2][row].getValue()!=lLtr){
			return false;
		    }
		}
		return true;
	    }
	    

	    public boolean checkLeftTwo () {
		

		// In the case where the first inserted value is lLtr
		if(theSpotMatrix[0][row].getValue()==lLtr){
		    return false;
		}
		
		//In the case where the first space is blank
		if (theSpotMatrix[0][row].getValue()==0){
		    //for when ltr comes immediately after the first blank
		    if(theSpotMatrix[1][row].getValue()==lLtr){
			return false;
		    }
		}

		
		//In the case where the first two spaces are blank
		if (theSpotMatrix[0][row].getValue()==0 && theSpotMatrix[1][row].getValue()==0){
		    //for when ltr comes after the spaces
		    if(theSpotMatrix[2][row].getValue()==lLtr){
			return false;
		    }
		}

		if(!filledRow()&&!isEnd)
		    return true;


		//In the case where the first space is an inserted letter that is not lLtr
		if (theSpotMatrix[0][row].getValue()!=0){
		    if(theSpotMatrix[1][row].getValue()!=0 && theSpotMatrix[1][row].getValue()!=lLtr){
			return false;
		    }
		}


		//in the case where the first two spaces are blank and the third and fourth spaces are not ltr
		if (theSpotMatrix[0][row].getValue()==0 && theSpotMatrix[1][row].getValue()==0){
		    if(theSpotMatrix[2][row].getValue()!=0 && theSpotMatrix[3][row].getValue()!=0){	    
			if(theSpotMatrix[2][row].getValue()!=lLtr && theSpotMatrix[3][row].getValue()!=lLtr){
			    return false;
			}
		    }
		}

		//for when second spot is not ltr, 3rd spot is a space, and fourth spot is not ltr
		if (theSpotMatrix[0][row].getValue()==0&&theSpotMatrix[1][row].getValue()!=0&&theSpotMatrix[3][row].getValue()!=0){
		    if(theSpotMatrix[1][row].getValue()!=lLtr && theSpotMatrix[2][row].getValue()==0 && theSpotMatrix[3][row].getValue()!=lLtr){
			return false;
		    }
		}
		

		
		//In the case where the first space is blank and where the second space is an inserted letter that is not lLtr
		if (theSpotMatrix[0][row].getValue()==0 && theSpotMatrix[1][row].getValue()!=0){
		    if (theSpotMatrix[1][row].getValue()!=lLtr && theSpotMatrix[2][row].getValue()!=lLtr && theSpotMatrix[2][row].getValue()!=0) {
			return false;
		    }
		}

		//not ltr, space, not ltr
		if (theSpotMatrix[0][row].getValue()!=0 && theSpotMatrix[1][row].getValue()==0 && theSpotMatrix[2][row].getValue()!=0){
		    if (theSpotMatrix[2][row].getValue()!=lLtr){
			return false;
		    }
		}
		//not ltr, space, space, not ltr
		if (theSpotMatrix[0][row].getValue()!=0 && theSpotMatrix[1][row].getValue()==0 && theSpotMatrix[2][row].getValue()==0 && theSpotMatrix[3][row].getValue()!=0){
		    if (theSpotMatrix[3][row].getValue()!=lLtr){
			return false;
		    }
		}
		
		return true;
	    }

	    public boolean checkRightOne() {


		//in the case where the program attempts to put rLtr in one of the first three spots
		if (theSpotMatrix[0][row].getValue()==rLtr){    
		    return false;
		}

		if (theSpotMatrix[1][row].getValue()==rLtr){
		    return false;
		}

		if (theSpotMatrix[2][row].getValue()==rLtr){   
		    return false;
		}


		//in the case where the row has not been filled yet
		if(!filledRow()&&!isEnd)
		    return true;

		//in the case where the first value is neither blank nor rLtr
		if (theSpotMatrix[5][row].getValue()!=0 && theSpotMatrix[5][row].getValue()!=rLtr){
		    return false;
		}

		//in the case where the first value is blank and the second one is not
		if (theSpotMatrix[5][row].getValue()==0 && theSpotMatrix[4][row].getValue()!=0){
		    if(theSpotMatrix[4][row].getValue()!=rLtr){
			return false;
		    }
		}

		//in the case where the first two values are blank
		if (theSpotMatrix[5][row].getValue()==0 && theSpotMatrix[4][row].getValue()==0 && theSpotMatrix[3][row].getValue()!=0){
		    if(theSpotMatrix[3][row].getValue()!=rLtr){
			return false;
		    }
		}
			
		return true;
	    }

	    public boolean checkRightTwo() {

		if(theSpotMatrix[2][row].getValue()==rLtr && column==4){
		    if(theSpotMatrix[3][row].getValue()!=0){
			if(theSpotMatrix[4][row].getValue()!=0){
			    return false;
			}
		    }
		}
		
		
		if(theSpotMatrix[2][row].getValue()==rLtr && column==5){
		    if(theSpotMatrix[3][row].getValue()==0){
			if(theSpotMatrix[4][row].getValue()==0){
			    if(theSpotMatrix[5][row].getValue()==0){
				return false;
			    }
			}
			if(theSpotMatrix[4][row].getValue()!=0){
			    if(theSpotMatrix[5][row].getValue()!=0){
				return false;
			    }
			}
		    }
		    if(theSpotMatrix[3][row].getValue()!=0){
			if(theSpotMatrix[4][row].getValue()!=0){
			    return false;
			}
			if(theSpotMatrix[5][row].getValue()!=0){
			    return false;
			}
		    }
		}
		
		if(theSpotMatrix[3][row].getValue()==rLtr && column==5){
		    if(theSpotMatrix[4][row].getValue()!=0){
			if(theSpotMatrix[5][row].getValue()!=0){
			    return false;
			}
		    }
		    if(theSpotMatrix[4][row].getValue()==0){
			if(theSpotMatrix[5][row].getValue()==0){
			    return false;
			}
		    }
		}
		
		if(theSpotMatrix[4][row].getValue()==rLtr && column==5){
		    if(theSpotMatrix[5][row].getValue()==0){
			return false;
		    }
		}
		
		if(theSpotMatrix[5][row].getValue()==rLtr){
		    return false;
		}
		
		
		//in the case where the program tries to insert values on the left side that are constrained by the right side
		if(theSpotMatrix[0][row].getValue()==rLtr){	   
		    return false;
		}
		if(theSpotMatrix[1][row].getValue()==rLtr){	   
		    return false;
		}
		
		return true;
	    }
	    


	    public boolean checkDownOne(){


		//if the first inserted value is not blank and is not dLtr
		if (theSpotMatrix[column][0].getValue()!=0 && theSpotMatrix[column][0].getValue()!=dLtr){
		    return false;
		}
		
		//if the first value is blank and the second is not
		if (theSpotMatrix[column][0].getValue()==0 && theSpotMatrix[column][1].getValue()!=0){
		    if(theSpotMatrix[column][1].getValue()!=dLtr){
			return false;
		    }
		}
		
		//if the first two values are blank
		if ((theSpotMatrix[column][0].getValue()==0 && theSpotMatrix[column][1].getValue() == 0)){
		    if(theSpotMatrix[column][2].getValue()!=0){
			if(theSpotMatrix[column][2].getValue()!=dLtr){
			    return false;
			}
		    }
		}
		return true;
	    }

	    public boolean checkDownTwo(){

		// In the case where the first inserted value is dLtr
		if(theSpotMatrix[column][0].getValue()==dLtr){
		    return false;
		}

		//In the case where the first space is blank
		if (theSpotMatrix[column][0].getValue()==0){
		    if(theSpotMatrix[column][1].getValue()==dLtr){
			return false;
		    }
		}

		//	if(!filledColumn()&&!isEnd)
		//	    return true;


		//In the case where the first two spaces are blank
		if (theSpotMatrix[column][0].getValue()==0 && theSpotMatrix[column][1].getValue()==0){
		    if(theSpotMatrix[column][2].getValue()==dLtr){
			return false;
		    }
		}


		//for when the first and second spots are not rLtr
		if(theSpotMatrix[column][0].getValue()!=0 && theSpotMatrix[column][1].getValue()!=0){
		    if(theSpotMatrix[column][0].getValue()!=dLtr && theSpotMatrix[column][1].getValue()!=dLtr){    
			return false;
		    }
		}



		//for space,not ltr, not ltr
		if(theSpotMatrix[column][1].getValue()!=0 && theSpotMatrix[column][2].getValue()!=0){
		    if(theSpotMatrix[column][1].getValue()!=dLtr && theSpotMatrix[column][2].getValue()!=dLtr){   
			return false;
		    }
		}
		
		if (theSpotMatrix[column][0].getValue()==0){	
		    //for space, not ltr, space, not ltr
		    if(theSpotMatrix[column][1].getValue()!=0 && theSpotMatrix[column][2].getValue()==0 && theSpotMatrix[column][3].getValue()!=0){
			if(theSpotMatrix[column][1].getValue()!=dLtr && theSpotMatrix[column][3].getValue()!=dLtr){
			    return false;
			}
		    }
		    
		}

		//space,space,not ltr,not ltr
		if (theSpotMatrix[column][0].getValue()==0 && theSpotMatrix[column][1].getValue()==0){
		    if(theSpotMatrix[column][2].getValue()!=0 && theSpotMatrix[column][3].getValue()!=0){
			if(theSpotMatrix[column][2].getValue()!=dLtr && theSpotMatrix[column][3].getValue()!=dLtr){    
			    return false;
			}
		    }
		}
		//not ltr, space, not ltr
		if (theSpotMatrix[column][0].getValue()!=0 && theSpotMatrix[column][1].getValue()==0 && theSpotMatrix[column][2].getValue()!=0){
		    if (theSpotMatrix[column][2].getValue()!=dLtr){    
			return false;
		    }
		}
		//not ltr, space, space, not ltr
		if (theSpotMatrix[column][0].getValue()!=0 && theSpotMatrix[column][1].getValue()==0 && theSpotMatrix[column][2].getValue()==0 && theSpotMatrix[column][3].getValue()!=0){
		    if (theSpotMatrix[column][3].getValue()!=dLtr){ 
			return false;
		    }
		}
		   
		return true;
	    }




	    public boolean checkUpOne(){



		//in the case where the program attempts to put uLtr into one of the upper spots
		if (theSpotMatrix[column][0].getValue()==uLtr){	    
		    return false;
		}

		if (theSpotMatrix[column][1].getValue()==uLtr){    
		    return false;
		}
		
		if (theSpotMatrix[column][2].getValue()==uLtr){    
		    return false;
		}

		if(!filledColumn()&&!isEnd)
		    return true;


		
		//in the case where the first value is neither blank nor rORD
		if (theSpotMatrix[column][5].getValue()!=0 && theSpotMatrix[column][5].getValue()!=uLtr){
		    return false;
		}
		
		//in the case where the first value is blank and the second one is not
		if (theSpotMatrix[column][5].getValue()==0 && theSpotMatrix[column][4].getValue()!=0){
		    if(theSpotMatrix[column][4].getValue()!=uLtr){
			return false;
		    }
		}

		//in the case where the first two values are blank (the third must be rOrd in this case)
		if ((theSpotMatrix[column][5].getValue()==0 && theSpotMatrix[column][4].getValue() == 0)){
		    if(theSpotMatrix[column][3].getValue()!=uLtr && theSpotMatrix[column][3].getValue()!=0){
			return false;
		    }
		}
	  

		return true;
		
		
	    }

}
