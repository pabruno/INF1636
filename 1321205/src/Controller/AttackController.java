package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import View.AttackWindow;

public class AttackController implements ActionListener{
	
	private Player p1;
	private Player p2;
	
	private int player = 2;
	private AttackWindow view;
	
	public AttackController(AttackWindow view, Player p1, Player p2){
		this.view = view;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (player % 2 != 0) {
			player++;
			view.player1Screen();
		} else {
			player++;
			view.player2Screen();
		}
	}
}
