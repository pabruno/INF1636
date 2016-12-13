package View;

import java.util.Observable;

public class Counter extends Observable {
	private int counter = 0;
	
	public void sumCounter(){
		this.counter++;
		setChanged();
		notifyObservers();
	}
	
	public int getCounter(){
		return this.counter;
	}
}
