package view;

import java.util.Observable;

/** 
 * Classe "Counter"
 * 
 * Padr�es Utilizados:
 * - Observer (Observable);
 * 
 * Descri��o:
 * - Contador utilizado na Classe "ShipMap" n�mero de armas posicionadas;
 * 
 */

public class Counter extends Observable {
	
	/** 
	 * Vari�veis de classe de "GameController":
	 * 
	 * - counter: vari�vel que cont�m o valor inteiro que representa o n�mero de armas posicionadas;
	 * 
	 */
	
	private int counter = 0;
	
	
	/** 
	 * M�todo "sumCounter"
	 * 
	 * Descri��o: 
	 * - Incrementa o contador e notifica os observers;
	 * 
	 */
	
	public void sumCounter(){
		this.counter++;
		setChanged();
		notifyObservers();
	}
	
	/** 
	 * M�todo "getCounter"
	 * 
	 * Descri��o: 
	 * - Retorna um valor inteiro do contador;
	 * 
	 */
	
	public int getCounter(){
		return this.counter;
	}
}
