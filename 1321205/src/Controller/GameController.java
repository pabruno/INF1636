package Controller;

import Model.Player;
import View.ChooserView;
import View.StartView;

public class GameController {
	
	private StartView startView;
	private ChooserView chooserView;
	
	private StartController startController;
	private ChooserController chooserController;
	
	private Player player1;
	private Player player2;
	
	public GameController(){
		player1 = new Player();
		player2 = new Player();	

	}
	
	private void startGame(){
		startView = new StartView();
		startController = new StartController(startView, player1, player2);
		this.setPlayers();
	}
	
	private void setPlayers(){
		startController.setPlayer1(player1);
		startController.setPlayer2(player2);
	}
	
	public void startWeaponChoose(){
		chooserView = new ChooserView(player1, player2);
		chooserController = new ChooserController(chooserView, player1, player2);
	}
	
	public void startAttack(){
		
	}
	
	public static void main(String[] args){
		GameController game = new GameController();
		game.startGame();
	}
}
