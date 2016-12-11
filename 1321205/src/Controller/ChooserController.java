package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import View.ChooserView;

public class ChooserController implements ActionListener {

	private GameMenuBarController menuBarController;
	private ChooserView view;
	private Player player1;
	private Player player2;
	private int counter;
	
	public ChooserController(GameMenuBarController menuBarController, ChooserView chooserView, Player player1, Player player2) {
		this.menuBarController = menuBarController;
		this.view = chooserView;
		this.player1 = player1;
		this.player2 = player2;
		this.counter = 0;
		
		setPlayers();
		view.setMenuBar(this.menuBarController.getView());
		this.menuBarController.setChooserEnabled();
		view.addStartButtonListener(this);
		view.presentFirstScreen();
	}
	
	public void setPlayers(){
		view.setPlayer1(player1);
		view.setPlayer2(player2);
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (counter == 0){
			counter++;
			player1.setMap(view.getFirstMap());
			player1.setPosition(view.getFirstMapPosition());
			view.presentSecondScreen();
			view.addStartButtonListener(this);
		} else {
			player2.setMap(view.getSecondMap());
			player2.setPosition(view.getSecondMapPosition());
			GameController.getInstance().startAttack();
			view.close();
			
		}
		
	}
	
}
