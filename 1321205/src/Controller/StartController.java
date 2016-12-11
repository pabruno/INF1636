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
	private GameMenuBarController menuBarController;
	
	public StartController(GameMenuBarController menuBarController, StartView view, Player player1, Player player2) {
		this.menuBarController = menuBarController;
		this.view = view;
		this.player1 = player1;
		this.player2 = player2;
		
		view.setMenuBar(this.menuBarController.getView());
		this.menuBarController.setChooserEnabled();
		view.addStartButtonListener(this);
		view.presentWindow();
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		player1.setName(view.getFirstName());
		player2.setName(view.getSecondName());
		
		GameController.getInstance().startWeaponChoose();
		view.close();
	}
	
}
