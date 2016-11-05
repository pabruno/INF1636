package game;

import display.*;

public class Game {
	public static void main(String[] args){
		StartGameWindow teste = new StartGameWindow();
		Player jogador1 = new Player();
		Player jogador2 = new Player();
		
		while(jogador1.getName() == null || jogador2.getName() == null || jogador1.getName().trim().isEmpty() || jogador2.getName().trim().isEmpty()) {
			jogador1.setName(teste.getName1());
			jogador2.setName(teste.getName2());
		}
		
		System.out.println(jogador1.getName());
		System.out.println(jogador2.getName());
	}
}
