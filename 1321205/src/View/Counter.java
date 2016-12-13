package view;

import java.util.Observable;

/** 
 * Classe "Counter"
 * 
 * Padrões Utilizados:
 * - Observer (Observable);
 * 
 * Descrição:
 * - Contador utilizado na Classe "ShipMap" número de armas posicionadas;
 * 
 */

public class Counter extends Observable {
	
	/** 
	 * Variáveis de classe de "GameController":
	 * 
	 * - counter: variável que contém o valor inteiro que representa o número de armas posicionadas;
	 * 
	 */
	
	private int counter = 0;
	
	
	/** 
	 * Método "sumCounter"
	 * 
	 * Descrição: 
	 * - Incrementa o contador e notifica os observers;
	 * 
	 */
	
	public void sumCounter(){
		this.counter++;
		setChanged();
		notifyObservers();
	}
	
	/** 
	 * Método "getCounter"
	 * 
	 * Descrição: 
	 * - Retorna um valor inteiro do contador;
	 * 
	 */
	
	public int getCounter(){
		return this.counter;
	}
}
