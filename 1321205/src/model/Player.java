package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/** 
 * Classe "Player"
 * 
 * Descrição:
 * - Modelo para cada jogador da Batalha Naval.
 * 
 */

public class Player {
	
	
	/** 
	 * Variáveis de classe de "Player":
	 * 
	 * - name: cadeia de caracteres representando o nome de um jogador;
	 * - myMap: matriz de caracteres representando o mapa das armas de um jogador;
	 * - attackMap: matriz de caracteres representando o mapa de ataques de um jogador;
	 * - position: variável que contém a posição das armas no mapa e o tipo da arma de um jogador;
	 * 
	 */
	
	private String name;
	private char[][] myMap;
	private char[][] attackMap;
	private LinkedHashMap<LinkedList<int[]>, String> position = null;
	
	
	/** 
	 * Construtor de "Player"
	 * 
	 * Descrição: 
	 * - Inicializa os mapas utilizando os métodos "setMap", "setAttackMap" e iterando nas duas matrizes;
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
	 * Método "setName"
	 * 
	 * Parâmetros:
	 * - name: Parâmetro do tipo "String";
	 * 
	 * Descrição: 
	 * - Define a variável "name" da classe a partir do parâmetro "name";
	 * 
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Método "setMap"
	 * 
	 * Parâmetros:
	 * - map: Parâmetro do tipo matriz de caracteres;
	 * 
	 * Descrição: 
	 * - Define a variável "myMap" da classe a partir do parâmetro "map";
	 * 
	 */
	
	public void setMap(char[][] map){
		myMap = map;
	}
	
	/** 
	 * Método "setAttackMap"
	 * 
	 * Parâmetros:
	 * - map: Parâmetro do tipo matriz de caracteres;
	 * 
	 * Descrição: 
	 * - Define a variável "attackMap" da classe a partir do parâmetro "map";
	 * 
	 */
	
	public void setAttackMap(char[][] map){
		attackMap = map;
	}
	
	/** 
	 * Método "setPosition"
	 * 
	 * Parâmetros:
	 * - position: Parâmetro do tipo "LinkedHashMap<LinkedList<int[]>, String>";
	 * 
	 * Descrição: 
	 * - Define a variável "position" da classe a partir do parâmetro "position";
	 * 
	 */
	
	public void setPosition(LinkedHashMap<LinkedList<int[]>, String> position){
		this.position = position;
	}
	
	/** 
	 * Método "getName"
	 * 
	 * Descrição: 
	 * - Retorna a variável name que contém o nome do jogador;
	 * 
	 */
	
	public String getName(){
		return name;
	}
	
	/** 
	 * Método "getMyMap"
	 * 
	 * Descrição: 
	 * - Retorna a variável myMap que contém o mapa das armas do jogador;
	 * 
	 */
	
	public char[][] getMyMap(){
		return myMap;
	}
	
	/** 
	 * Método "getAttackMap"
	 * 
	 * Descrição: 
	 * - Retorna a variável attackMap que contém o mapa dos ataques do jogador;
	 * 
	 */
	
	public char[][] getAttackMap(){
		return attackMap;
	}
	
	/** 
	 * Método "getPositionMap"
	 * 
	 * Descrição: 
	 * - Retorna a variável position que contém a posição das armas no mapa e o tipo delas;
	 * 
	 */
	
	public LinkedHashMap<LinkedList<int[]>, String> getPosition(){
		return position;
	}
}
