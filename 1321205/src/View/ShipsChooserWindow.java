package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.swing.*;

import Model.Player;

public class ShipsChooserWindow implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JFrame window = new JFrame();

	private int screenX;
	private int screenY;
	
	// Variavel para a classe Map que extende JPanel e vai imprimir o mapa no frame.
	
	private ShipMap map1Panel = new ShipMap();
	private ShipMap map2Panel = new ShipMap();

	// Jogadores
	
	private Player p1;
	private Player p2;

	// Botao para troca de tela

	private JButton button = new JButton("Proximo");

	/*
	 * Variavel para ver quando o botao esta sendo clicado
	 * 
	 * Para ir do Jogador 1 para o Jogador 2: cont = 0
	 * 
	 * Para ir do Jogador 2 para o inicio do jogo: cont = 1
	 * 
	 */

	private int cont = 0;

	// Construtor para inicializar a tela para a colocacao dos navios do Jogador 1.

	public ShipsChooserWindow(Player p1, Player p2) {
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
		map1Panel.draw(p1.getMyMap(), screenX / 2 + 30, screenY / 10);
		window.add(map1Panel);

		map1Panel.setLayout(null);

		JLabel text = new JLabel(p1.getName() + ", posicione os navios no tabuleiro.");
		map1Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map1Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}
	
	private void player2Screen(){
		window.setVisible(false);
		window.removeAll();
		
		window = new JFrame();
		
		window.setTitle("Batalha Naval");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(screenX - 100, screenY - 100);
		window.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window.setVisible(true);
		window.setResizable(false);
		
		map2Panel.draw(p2.getMyMap(), screenX / 2 + 30, screenY / 10);
		window.add(map2Panel);

		map2Panel.setLayout(null);
		
		button = new JButton("Proximo");

		JLabel text = new JLabel(p2.getName() + ", posicione os navios no tabuleiro.");
		map2Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map2Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(cont == 0){
			cont++;
			p1.setMap(map1Panel.getMap());
			p1.setPosition(map1Panel.getPosition());
			player2Screen();
		}
		else {
			p2.setMap(map2Panel.getMap());
			p2.setPosition(map2Panel.getPosition());
			window.setVisible(false);
			window.removeAll();
			
			AttackWindow attack = new AttackWindow(p1,p2);
		}
	}
}
