package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import Controller.GameController;
import View.StartView;

public class StartController implements ActionListener {
	
	private StartView view;
	private Player player1;
	private Player player2;
	
	public StartController(StartView view, Player player1, Player player2) {
		this.view = view;
		this.player1 = player1;
		this.player2 = player2;
		view.addStartButtonListener(this);
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameController game = new GameController();
		
		player1.setName(view.getFirstName());
		player2.setName(view.getSecondName());
		
		game.startWeaponChoose();
		view.close();
	}
	
}
