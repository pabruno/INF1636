package View;

import java.util.Observable;

public class Cont extends Observable {
	private int cont = 0;
	
	public void sumCont(){
		this.cont++;
		setChanged();
		notifyObservers();
	}
	
	public int getCont(){
		return this.cont;
	}
}
