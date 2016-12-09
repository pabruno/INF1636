package Controller;

import Model.Player;
import View.ShipsChooserWindow;
import View.NameWindow;

public class Game {
	public Game(){
		
		NameWindow nameWindow = new NameWindow();
		Player player1 = new Player();
		Player player2 = new Player();
		
		nameWindow.setPlayer1(player1);
		nameWindow.setPlayer2(player2);
		
//		while(player1.getName() == null || player2.getName() == null || player1.getName().trim().isEmpty() == true || player2.getName().trim().isEmpty() == true) {
//			player1.setName(nameWindow.getName1());
//			player2.setName(nameWindow.getName2());
//		}
//		
//		System.out.println("1: " + player1.getName());
//		System.out.println("2: " + player2.getName());
	}
	
	public static void main(String[] args){
		new Game();
	}
}
