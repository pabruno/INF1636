package View;

import java.awt.Dimension;
import java.awt.Toolkit;

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

	private int marginXAttack;
	private int marginXShip;
	private int marginY;

	private AttackMap map1Panel;
	private AttackMap map2Panel;

	private JButton button1 = new JButton("Proximo");
	private JButton button2 = new JButton("Proximo");

	private JLabel text1;
	private JLabel text2;

	public AttackWindow(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;

		this.marginXShip = 30;
		this.marginY = screenY / 10;
		this.marginXAttack = screenX / 2 + 100;

		controller = new AttackController(this, p1, p2);

		map1Panel = new AttackMap(controller);
		map2Panel = new AttackMap(controller);

		text1 = new JLabel(p1.getName() + ", realize seu ataque.");
		text2 = new JLabel(p2.getName() + ", realize seu ataque.");

		createWindow();
	}

	public int getMarginXAttack() {
		return this.marginXAttack;
	}

	public int getMarginY() {
		return this.marginY;
	}

	public void setText1(String text) {
		this.text1.setText(text);
	}

	public void setText2(String text) {
		this.text2.setText(text);
	}

	public void createWindow() {
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
			map1Panel.draw(p1.getMyMap(), p1.getAttackMap(), marginXShip, marginXAttack, marginY);
			window1.add(map1Panel);

			map1Panel.setLayout(null);

			map1Panel.add(text1);
			text1.setBounds(screenX / 2 - 132, screenY - 200, 350, 40);

			map1Panel.add(button1);
			button1.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
			button1.addActionListener(controller);
		}

		window1.repaint();
		window1.setVisible(true);
		window2.setVisible(false);
		firstWindow1 = false;
	}

	public void player2Screen() {
		if (firstWindow2 == true) {
			map2Panel.draw(p2.getMyMap(), p2.getAttackMap(), marginXShip, marginXAttack, marginY);
			window2.add(map2Panel);

			map2Panel.setLayout(null);

			map2Panel.add(text2);
			text2.setBounds(screenX / 2 - 132, screenY - 200, 350, 40);

			map2Panel.add(button2);
			button2.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
			button2.addActionListener(controller);
		}

		window2.repaint();
		window2.setVisible(true);
		window1.setVisible(false);
		firstWindow2 = false;
	}
}
