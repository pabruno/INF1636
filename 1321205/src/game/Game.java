package game;

import display.*;

public class Game {
	public Game(){
		StartGameWindow teste = new StartGameWindow();
		Player jogador1 = new Player();
		Player jogador2 = new Player();
		
		while(jogador1.getName() == null || jogador2.getName() == null || jogador1.getName().trim().isEmpty() || jogador2.getName().trim().isEmpty()) {
			jogador1.setName(teste.getName1());
			jogador2.setName(teste.getName2());
		}
		
		teste.close();
		
		SetShipsWindow inicio = new SetShipsWindow(jogador1.getMyMap(),jogador2.getMyMap(),jogador1.getName(),jogador2.getName());
	}
}
