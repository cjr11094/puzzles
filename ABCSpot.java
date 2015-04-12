
public class ABCSpot implements Spot{

	    private int value;
	    private int row;
	    private int rowLetterTypeLeft;
	    private int rowOrderTypeLeft;
	    private int rowLetterTypeRight;
	    private int rowOrderTypeRight;
	    private int column;
	    private int columnLetterTypeUp;
	    private int columnOrderTypeUp;
	    private int columnLetterTypeDown;
	    private int columnOrderTypeDown;


	    public ABCSpot (){
			this.value=0;
	    }

	    public boolean getCantBeChanged(){
	    	return false;
	    }
	    
	    public int getRightOrder(){
	    	return this.rowOrderTypeRight;
	    }
	    
	    public void setROTR(int i){
	    	this.rowOrderTypeRight=i;
	    }

	    
	    public int getLeftOrder(){
	    	return this.rowOrderTypeLeft;
	    }
	    
	    public void setROTL(int i){
	    	this.rowOrderTypeLeft=i;
	    }

	    public int getDownOrder(){
	    	return this.columnOrderTypeDown;
	    }
	    
	    public void setCOTD(int i){
	    	this.columnOrderTypeDown=i;
	    }

	    public int getUpOrder(){
	    	return this.columnOrderTypeUp;
	    }
	    
	    public void setCOTU(int i){
	    	this.columnOrderTypeUp=i;
	    }

	    public int getRightLetter(){
	    	return this.rowLetterTypeRight;
	    }
	    
	    public void setRLTR(int i){
	    	this.rowLetterTypeRight=i;
	    }

	    public int getLeftLetter(){
	    	return this.rowLetterTypeLeft;
	    }
	    
	    public void setRLTL(int i){
	    	this.rowLetterTypeLeft=i;
	    }

	    public int getDownLetter(){
	    	return this.columnLetterTypeDown;
	    }
	    
	    public void setCLTD(int i){
	    	this.columnLetterTypeDown=i;
	    }

	    public int getUpLetter(){
	    	return this.columnLetterTypeUp;
	    }
	    
	    public void setCLTU(int i){
	    	this.columnLetterTypeUp=i;
	    }


	    public void setValue(int c,int orig){
	    	this.value=c;
	    }


	    public int getValue() {
	    	return this.value;
	    }

	    public int getRow () {
	    	return this.row;
	    }
	    
	    public void setRow(int row){
	    	this.row=row;
	    }

	    public int getColumn () {
	    	return this.column;
	    }
	    
	    public void setColumn(int column){
	    	this.column=column;
	    }


	    public String toString (){
	    	return "THIS IS IN BLANKSPOT";
	    }
	    
	    public void setValue(int value){
	    	this.value=value;
	    }
	    


	    
}
