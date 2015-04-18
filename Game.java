
public interface Game {

	public Spot[] getSpots();
	
	public int[] getPossibles();
	
	public boolean checkConstraints(int[]values,int check);
	
	
}
