package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import View.ChooserView;

public class ChooserController implements ActionListener {

	private ChooserView view;
	private Player player1;
	private Player player2;
	private int counter;
	
	public ChooserController(ChooserView chooserView, Player player1, Player player2) {
		this.view = chooserView;
		this.player1 = player1;
		this.player2 = player2;
		this.counter = 0;
		
		view.addStartButtonListener(this);
		view.presentFirstScreen();
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameController game = new GameController();
		
		if (counter == 0){
			counter++;
			player1.setMap(view.getFirstMap());
			player1.setPosition(view.getFirstMapPosition());
			view.presentSecondScreen();
		} else {
			player2.setMap(view.getSecondMap());
			player2.setPosition(view.getSecondMapPosition());
			game.startAttack();
			view.close();
		}
		
	}
	
}
