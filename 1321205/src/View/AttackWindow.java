package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Player;

public class AttackWindow implements ActionListener {
	
	Player p1;
	Player p2;
	
	private JFrame window = new JFrame();
	
	private int screenX;
	private int screenY;
	
	private AttackMap map1Panel = new AttackMap();
	private AttackMap map2Panel = new AttackMap();
	
	private JButton button = new JButton("Proximo");
	
	public AttackWindow(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
		
		window.setTitle("Batalha Naval");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(screenX - 100, screenY - 100);
		window.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window.setVisible(true);
		window.setResizable(false);

		player1Screen();
	}
	
	private void player1Screen() {
		map1Panel.draw(p1.getMyMap(), p1.getAttackMap(),screenX / 2 + 30, screenY / 10);
		window.add(map1Panel);

		map1Panel.setLayout(null);

		JLabel text = new JLabel(p1.getName() + ", realize seu ataque.");
		map1Panel.add(text);
		text.setBounds(screenX / 2 - 132, screenY - 200, 350, 40);

		map1Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
