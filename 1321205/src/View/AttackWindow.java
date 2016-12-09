package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.AttackController;
import Model.Player;

public class AttackWindow {

	Player p1;
	Player p2;
	
	private AttackController controller;

	private JFrame window1 = new JFrame();
	private JFrame window2 = new JFrame();
	
	private boolean firstWindow1 = true;
	private boolean firstWindow2 = true;

	private int screenX;
	private int screenY;

	private AttackMap map1Panel = new AttackMap();
	private AttackMap map2Panel = new AttackMap();

	private JButton button1 = new JButton("Proximo");
	private JButton button2 = new JButton("Proximo");

	public AttackWindow(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
		
		controller = new AttackController(this,p1,p2);
		
		createWindow();
	}
	
	public void createWindow(){
		window1.setTitle("Batalha Naval");
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window1.setSize(screenX - 100, screenY - 100);
		window1.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window1.setVisible(false);
		window1.setResizable(false);

		window2.setTitle("Batalha Naval");
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.setSize(screenX - 100, screenY - 100);
		window2.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window2.setVisible(false);
		window2.setResizable(false);

		player1Screen();
	}

	public void player1Screen() {
		if (firstWindow1 == true) {
			map1Panel.draw(p1.getMyMap(), p1.getAttackMap(), screenX / 2 + 30, screenY / 10);
			window1.add(map1Panel);

			map1Panel.setLayout(null);

			JLabel text = new JLabel(p1.getName() + ", realize seu ataque.");
			map1Panel.add(text);
			text.setBounds(screenX / 2 - 132, screenY - 200, 350, 40);

			map1Panel.add(button1);
			button1.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
			button1.addActionListener(controller);
		}

		window1.setVisible(true);
		window2.setVisible(false);
		firstWindow1 = false;
	}

	public void player2Screen() {
		if (firstWindow2 == true) {
			map2Panel.draw(p2.getMyMap(), p2.getAttackMap(), screenX / 2 + 30, screenY / 10);
			window2.add(map2Panel);

			map2Panel.setLayout(null);

			JLabel text = new JLabel(p2.getName() + ", realize seu ataque.");
			map2Panel.add(text);
			text.setBounds(screenX / 2 - 132, screenY - 200, 350, 40);

			map2Panel.add(button2);
			button2.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
			button2.addActionListener(controller);
		}

		window2.setVisible(true);
		window1.setVisible(false);
		firstWindow2 = false;
	}
}
