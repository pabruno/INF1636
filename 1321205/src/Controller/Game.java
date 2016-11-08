package Controller;

import Model.Player;
import View.ShipsChooserWindow;
import View.NameWindow;

public class Game {
	public Game(){
		
		NameWindow teste = new NameWindow();
		Player jogador1 = new Player();
		Player jogador2 = new Player();
		
		while(jogador1.getName() == null || jogador2.getName() == null || jogador1.getName().trim().isEmpty() || jogador2.getName().trim().isEmpty()) {
			jogador1.setName(teste.getName1());
			jogador2.setName(teste.getName2());
		}
		
		teste.close();
		
		ShipsChooserWindow inicio = new ShipsChooserWindow(jogador1.getMyMap(),jogador2.getMyMap(),jogador1.getName(),jogador2.getName());
	}
	
	public static void main(String[] args){
		new Game();
	}
}
