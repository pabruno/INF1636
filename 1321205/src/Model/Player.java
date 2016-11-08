package Model;

public class Player {
	
	/* ------------ Player Class ------------
	 * 
	 * Description: Model Class for the Player of the game.
	 * 
	 * ------------ Constructor ------------
	 * Player(): Constructor that uses the method setMap to initialize the Player Class.
	 * 
	 * ------------ Variables ------------
	 * name: Name of the player.
	 * myMap: Map of the ships of the player.
	 *
	 * ------------  Methods  ------------
	 * setMap(char [][] map): Set myMap of the instance with the value of the paremeter map.
	 * setName(String name): Set the name of the instance with the value of the paremeter name.
	 * getName(): Get a String from the name variable of the instance.
	 * getMyMap(): Get a Char matrix from the myMap variable of the instance.
	 * 
	 */
	
	private String name;
	private char[][] myMap;
	
	public Player(){
		setMap (new char[15][15]);
	}
	
	public void setMap(char[][] map){
		myMap = map;
		
		for(int i=0; i < myMap.length; i++){
			for(int j=0; j < myMap[0].length; j++){
				myMap[i][j] = 'V';
			}
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public char[][] getMyMap(){
		return myMap;
	}
}
