package game;

import display.GameWindow;

public class Game {
	public static void main(String[] args){
		GameWindow teste = new GameWindow();
		Player jogador1 = new Player();
		Player jogador2 = new Player();
		
		while(jogador1.name == null || jogador2.name == null) {
			jogador1.name = teste.getName1();
			jogador2.name = teste.getName2();
		}
		
		System.out.println(jogador1.name);
		System.out.println(jogador2.name);
	}
}
