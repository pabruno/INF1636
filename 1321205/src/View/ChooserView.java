package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.swing.*;

import Model.Player;

public class ChooserView extends JFrame {

	private int screenX;
	private int screenY;

	private ShipMap map1Panel;
	private ShipMap map2Panel;

	private Player p1;
	private Player p2;

	private JButton button;

	public ChooserView(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;

		responsiveWindow();
		createWindow();
	}
	
	private void responsiveWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
	}
	
	private void createWindow(){
		button = new JButton("Próximo");
		map1Panel = new ShipMap();
		map2Panel = new ShipMap();
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenX - 100, screenY - 100);
		setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		setVisible(true);
		setResizable(false);
	}

	public void presentFirstScreen() {
		map1Panel.draw(p1.getMyMap(), screenX / 2 + 30, screenY / 10);
		add(map1Panel);
		map1Panel.setLayout(null);

		JLabel text = new JLabel(p1.getName() + ", posicione os navios no tabuleiro.");
		map1Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map1Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
	}
	
	public void presentSecondScreen(){
		close();
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(screenX - 100, screenY - 100);
		setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
	    setVisible(true);
		setResizable(false);
		
		map2Panel.draw(p2.getMyMap(), screenX / 2 + 30, screenY / 10);
		add(map2Panel);

		map2Panel.setLayout(null);
		
		button = new JButton("Proximo");

		JLabel text = new JLabel(p2.getName() + ", posicione os navios no tabuleiro.");
		map2Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map2Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
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
		button.addActionListener(aL);
	}
	
	public void close() {
		setVisible(false);
		removeAll();
	}

}
