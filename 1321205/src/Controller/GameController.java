package Controller;

import Model.Player;
import View.AttackView;
import View.ChooserView;
import View.StartView;

public class GameController {
	
	private static GameController instance = null;
	
	private StartView startView;
	private ChooserView chooserView;
	private AttackView attackView;
	
	private StartController startController;
	private ChooserController chooserController;
	private AttackController attackController;
	
	private Player player1;
	private Player player2;
	
	private GameController() {
		player1 = new Player();
		player2 = new Player();	
	}
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
	    }
		return instance;
	}
	
	private void startGame() {
		System.out.println("Game:StartGame");
		startView = new StartView();
		startController = new StartController(startView, player1, player2);
		startController.setPlayer1(player1);
		startController.setPlayer2(player2);
	}
	
	public void startWeaponChoose(){
		System.out.println("Game:StartWeaponChoose");
		chooserView = new ChooserView();
		chooserController = new ChooserController(chooserView, player1, player2);		
	}
	
	public void startAttack(){
		System.out.println("Game:StartAttack");
		attackView = new AttackView(player1, player2);
		attackController = new AttackController(attackView, player1, player2);
	}
	
	public static void main(String[] args){
		GameController.getInstance().startGame();
	}
}
