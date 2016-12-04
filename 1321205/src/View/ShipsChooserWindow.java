package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShipsChooserWindow implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JFrame window = new JFrame();

	private int screenX;
	private int screenY;
	
	// Variavel para a classe Map que extende JPanel e vai imprimir o mapa no frame.
	
	ShipMap map1Panel = new ShipMap();
	ShipMap map2Panel = new ShipMap();

	// Mapa de cada jogador.

	private char[][] map1;
	private char[][] map2;

	// Nome de cada jogador.

	private String name1;
	private String name2;

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

	public ShipsChooserWindow(char[][] map1, char[][] map2, String name1, String name2) {
		this.map1 = map1;
		this.map2 = map2;
		this.name1 = name1;
		this.name2 = name2;

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
		
		window.setTitle("Batalha Naval");
		window.setSize(screenX - 100, screenY - 100);
		window.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window.setVisible(true);
		window.setResizable(false);

		player1Screen();
	}

	private void player1Screen() {
		map1Panel.draw(map1, screenX / 2 + 30, screenY / 10);
		window.add(map1Panel);

		map1Panel.setLayout(null);

		JLabel text = new JLabel(name1 + ", posicione os navios no tabuleiro.");
		map1Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map1Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}
	
	private void player2Screen(){
		window.setVisible(false);
		window.getContentPane().removeAll();
		
		window = new JFrame();
		
		window.setTitle("Batalha Naval");
		window.setSize(screenX - 100, screenY - 100);
		window.setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		window.setVisible(true);
		window.setResizable(false);
		
		map2Panel.draw(map2, screenX / 2 + 30, screenY / 10);
		window.add(map2Panel);

		map2Panel.setLayout(null);
		
		button = new JButton("Proximo");

		JLabel text = new JLabel(name2 + ", posicione os navios no tabuleiro.");
		map2Panel.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		map2Panel.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(cont == 0){
			cont++;
			player2Screen();
		}
	}
}
