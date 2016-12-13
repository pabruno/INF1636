package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Player;

public class AttackView {
	
	private Player p1;
	private Player p2;

	private GameMenuBar menuBar;

	private JFrame window1;
	private JFrame window2;

	private boolean firstWindow1;
	private boolean firstWindow2;

	private int screenX;
	private int screenY;

	private int marginXAttack;
	private int marginXShip;
	private int marginY;

	private AttackMap map1Panel;
	private AttackMap map2Panel;

	private JButton button1;
	private JButton button2;

	private JLabel text1;
	private JLabel text2;

	public AttackView() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;

		this.marginXShip = 30;
		this.marginY = screenY / 10;
		this.marginXAttack = screenX / 2 + 100;
		
		button1 = new JButton("Proximo");
		button2 = new JButton("Proximo");
		
		window1 = new JFrame();
		window2 = new JFrame();

		firstWindow1 = true;
		firstWindow2 = true;

		createWindow();
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

	}
	
	public void presentFirstScreen() {
		System.out.println("AttackView:presentFirstScreen()");
		window1.setJMenuBar(menuBar);
		
		if (firstWindow1 == true) {
			text1 = new JLabel(p1.getName() + ", realize seu ataque.");
			map1Panel.draw(p1.getMyMap(), p1.getAttackMap(), marginXShip, marginXAttack, marginY);
			window1.add(map1Panel);

			map1Panel.setLayout(null);

			map1Panel.add(text1);
			text1.setBounds(screenX / 2 - 132, screenY - 230, 350, 40);

			map1Panel.add(button1);
			button1.setBounds(screenX / 2 - 150, screenY - 200, 200, 30);

		}

		window1.repaint();
		window1.setVisible(true);
		window2.setVisible(false);
		firstWindow1 = false;
	}

	public void presentSecondScreen() {
		System.out.println("AttackView:presentSecondScreen()");
		window2.setJMenuBar(menuBar);
		if (firstWindow2 == true) {
			text2 = new JLabel(p2.getName() + ", realize seu ataque.");
			map2Panel.draw(p2.getMyMap(), p2.getAttackMap(), marginXShip, marginXAttack, marginY);
			window2.add(map2Panel);

			map2Panel.setLayout(null);

			map2Panel.add(text2);
			text2.setBounds(screenX / 2 - 132, screenY - 230, 350, 40);

			map2Panel.add(button2);
			button2.setBounds(screenX / 2 - 150, screenY - 200, 200, 30);
		}

		window2.repaint();
		window2.setVisible(true);
		window1.setVisible(false);
		firstWindow2 = false;
	}
	
	/** 
	 * Método "setMenuBar"
	 * 
	 * Parametros:
	 * - menuBar: Parametro do tipo "GameMenuBar";
	 *
	 * Descrição: 
	 * - Define a barra de menu a ser utilizada na classe corrente;
	 * 
	 */
	
	public void setMenuBar(GameMenuBar menuBar){
		this.menuBar = menuBar;
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
	
	/** 
	 * Método "setPlayer1"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "p1" da classe a partir do parâmetro "p";
	 * 
	 */
	
	public void setPlayer1(Player p) {
		p1 = p;
	}
	
	/** 
	 * Método "setPlayer2"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "p2" da classe a partir do parâmetro "p";
	 * 
	 */

	public void setPlayer2(Player p) {
		p2 = p;
	}
	
	public void setFirstMapPanel(AttackMap aM){
		this.map1Panel = aM;
	}
	
	public void setSecondMapPanel(AttackMap aM){
		this.map2Panel = aM;
	}
	
	public void addFirstActionListener(ActionListener aL){
		button1.addActionListener(aL);
	}
	
	public void addSecondActionListener(ActionListener aL){
		button2.addActionListener(aL);
	}
}
