package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.Counter;
import model.Player;

/** 
 * Classe "ChooserView"
 * 
 * Descrição:
 * - Interface gráfica da tela de posicionamento de armas;
 * 
 */


public class ChooserView implements Observer {

	private JFrame window;
	private GameMenuBar menuBar;
	private int screenX;
	private int screenY;

	private ShipMap map1Panel;
	private ShipMap map2Panel;
	
	private Player player1;
	private Player player2;

	private JButton nextButton;

	public ChooserView() {
		responsiveWindow();
		createWindow();
		map1Panel.getCounter().addObserver(this);
		map2Panel.getCounter().addObserver(this);
	}
	
	private void responsiveWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
	}
	
	private void createWindow(){
		window = new JFrame();
		nextButton = new JButton("Proximo");
		map1Panel = new ShipMap();
		map2Panel = new ShipMap();
		
		setDefaultWindowStyle();
	}
	
	private void setDefaultWindowStyle(){
		window.setTitle("Batalha Naval");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(screenX - 100, screenY - 100);
		window.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window.setVisible(true);
		window.setResizable(false);
	}
	
	/** 
	 * Método "setPlayer1"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player1" da classe a partir do parâmetro "p";
	 * 
	 */
	
	public void setPlayer1(Player p) {
		player1 = p;
	}
	
	/** 
	 * Método "setPlayer2"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player2" da classe a partir do parâmetro "p";
	 * 
	 */

	public void setPlayer2(Player player) {
		player2 = player;
	}

	public void presentFirstScreen() {
		
		window.setJMenuBar(menuBar);
		map1Panel.draw(player1.getMyMap(), screenX / 2 + 30, screenY / 10);
		window.add(map1Panel);
		map1Panel.setLayout(null);

		JLabel text = new JLabel(player1.getName() + ", posicione os navios no tabuleiro.");
		map1Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 230, 350, 40);

		map1Panel.add(nextButton);
		nextButton.setBounds(screenX / 2 - 150, screenY - 200, 200, 30);
		nextButton.setEnabled(false);
	}
	
	public void presentSecondScreen(){
		window.setVisible(false);
		window.removeAll();
		window = new JFrame();
		
		setDefaultWindowStyle();
		
		window.setJMenuBar(menuBar);
		map2Panel.draw(player2.getMyMap(), screenX / 2 + 30, screenY / 10);
		window.add(map2Panel);

		map2Panel.setLayout(null);
		
		nextButton = new JButton("Proximo");

		JLabel text = new JLabel(player2.getName() + ", posicione os navios no tabuleiro.");
		map2Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 230, 350, 40);

		map2Panel.add(nextButton);
		nextButton.setBounds(screenX / 2 - 150, screenY - 200, 200, 30);
		nextButton.setEnabled(false);
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
	
	public char[][] getFirstMap(){
		return map1Panel.getMap();
	}

	public LinkedHashMap<LinkedList<int[]>, String> getFirstMapPosition(){
		return map1Panel.getPosition();
	}
	
	public char[][] getSecondMap(){
		return map2Panel.getMap();
	}

	public LinkedHashMap<LinkedList<int[]>, String> getSecondMapPosition(){
		return map2Panel.getPosition();
	}
	
	public void addStartButtonListener(ActionListener aL){
		nextButton.addActionListener(aL);
	}
	
	/** 
	 * Método "close"
	 * 
	 * Descrição: 
	 * - Torna a tela invisivel e remove os componentes gráficos da tela;
	 * 
	 */
	
	public void close() {
		window.setVisible(false);
		window.removeAll();
	}

	@Override
	public void update(Observable counter, Object arg1) {
		Counter c = (Counter) counter;
		
		menuBar.setLoadActionEnabled(false);
		nextButton.setEnabled(true);
		if(c.getCounter() == 15){
			nextButton.setEnabled(true);		}
		else {
			nextButton.setEnabled(false);
		}
	}

}
