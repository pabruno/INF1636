package game;

public class Player {
	private String name;
	
	// Mapa com os navios do jogador.
	
	private char[][] myMap;
	
	public Player(){
		myMap = new char[15][15];
		
		for(int i=0; i < myMap.length; i++){
			for(int j=0; j < myMap[0].length; j++){
				myMap[i][j] = 'V';
			}
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char[][] getMyMap(){
		return myMap;
	}
}
