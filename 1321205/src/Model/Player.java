package Model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

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
	private char[][] attackMap;
	private LinkedHashMap<LinkedList<int[]>, String> position = null;
	
	public Player(){
		setMap (new char[15][15]);
		setAttackMap (new char[15][15]);
		
		for(int i=0; i < myMap.length; i++){
			for(int j=0; j < myMap[0].length; j++){
				myMap[i][j] = 'V';
			}
		}
		
		for(int i=0; i < attackMap.length; i++){
			for(int j=0; j < attackMap[0].length; j++){
				attackMap[i][j] = 'V';
			}
		}
	}
	
	public void setMap(char[][] map){
		myMap = map;
	}
	
	public void setAttackMap(char[][] map){
		attackMap = map;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(LinkedHashMap<LinkedList<int[]>, String> position){
		this.position = position;
	}
	
	public String getName(){
		return name;
	}
	
	public char[][] getMyMap(){
		return myMap;
	}
	
	public char[][] getAttackMap(){
		return attackMap;
	}
	
	public LinkedHashMap<LinkedList<int[]>, String> getPosition(){
		return position;
	}
}
