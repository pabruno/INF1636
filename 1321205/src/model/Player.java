package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/** 
 * Classe "Player"
 * 
 * Descri��o:
 * - Modelo para cada jogador da Batalha Naval.
 * 
 */

public class Player {
	
	
	/** 
	 * Vari�veis de classe de "Player":
	 * 
	 * - name: cadeia de caracteres representando o nome de um jogador;
	 * - myMap: matriz de caracteres representando o mapa das armas de um jogador;
	 * - attackMap: matriz de caracteres representando o mapa de ataques de um jogador;
	 * - position: vari�vel que cont�m a posi��o das armas no mapa e o tipo da arma de um jogador;
	 * 
	 */
	
	private String name;
	private char[][] myMap;
	private char[][] attackMap;
	private LinkedHashMap<LinkedList<int[]>, String> position = null;
	
	
	/** 
	 * Construtor de "Player"
	 * 
	 * Descri��o: 
	 * - Inicializa os mapas utilizando os m�todos "setMap", "setAttackMap" e iterando nas duas matrizes;
	 * 
	 */
	
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
	
	/** 
	 * M�todo "setName"
	 * 
	 * Par�metros:
	 * - name: Par�metro do tipo "String";
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "name" da classe a partir do par�metro "name";
	 * 
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * M�todo "setMap"
	 * 
	 * Par�metros:
	 * - map: Par�metro do tipo matriz de caracteres;
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "myMap" da classe a partir do par�metro "map";
	 * 
	 */
	
	public void setMap(char[][] map){
		myMap = map;
	}
	
	/** 
	 * M�todo "setAttackMap"
	 * 
	 * Par�metros:
	 * - map: Par�metro do tipo matriz de caracteres;
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "attackMap" da classe a partir do par�metro "map";
	 * 
	 */
	
	public void setAttackMap(char[][] map){
		attackMap = map;
	}
	
	/** 
	 * M�todo "setPosition"
	 * 
	 * Par�metros:
	 * - position: Par�metro do tipo "LinkedHashMap<LinkedList<int[]>, String>";
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "position" da classe a partir do par�metro "position";
	 * 
	 */
	
	public void setPosition(LinkedHashMap<LinkedList<int[]>, String> position){
		this.position = position;
	}
	
	/** 
	 * M�todo "getName"
	 * 
	 * Descri��o: 
	 * - Retorna a vari�vel name que cont�m o nome do jogador;
	 * 
	 */
	
	public String getName(){
		return name;
	}
	
	/** 
	 * M�todo "getMyMap"
	 * 
	 * Descri��o: 
	 * - Retorna a vari�vel myMap que cont�m o mapa das armas do jogador;
	 * 
	 */
	
	public char[][] getMyMap(){
		return myMap;
	}
	
	/** 
	 * M�todo "getAttackMap"
	 * 
	 * Descri��o: 
	 * - Retorna a vari�vel attackMap que cont�m o mapa dos ataques do jogador;
	 * 
	 */
	
	public char[][] getAttackMap(){
		return attackMap;
	}
	
	/** 
	 * M�todo "getPositionMap"
	 * 
	 * Descri��o: 
	 * - Retorna a vari�vel position que cont�m a posi��o das armas no mapa e o tipo delas;
	 * 
	 */
	
	public LinkedHashMap<LinkedList<int[]>, String> getPosition(){
		return position;
	}
}
