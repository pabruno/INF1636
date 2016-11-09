package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShipsChooserWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private int screenX;
	private int screenY;
	
	// Variavel para a classe Map que extende JPanel e vai imprimir o mapa no frame.
	
	Map mapa = new Map();

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
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(screenX - 100, screenY - 100);
		setLocation(screenX / 2 - (screenX - 100) / 2, screenY / 2 - (screenY - 100) / 2);
		setVisible(true);
		setResizable(false);

		player1Screen();
	}

	private void player1Screen() {
		mapa.draw(map1, screenX / 2 + 30, screenY / 10);
		getContentPane().add(mapa);

		mapa.setLayout(null);

		JLabel text = new JLabel(name1 + ", posicione os navios no tabuleiro.");
		mapa.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		mapa.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
	}
	
	private void player2Screen(){
		mapa.removeAll();
		
		mapa.draw(map2, screenX / 2 + 30, screenY / 10);
		getContentPane().add(mapa);

		mapa.setLayout(null);
		
		button = new JButton("Proximo");

		JLabel text = new JLabel(name2 + ", posicione os navios no tabuleiro.");
		mapa.add(text);
		text.setBounds(screenX / 2 - 175, screenY - 200, 350, 40);

		mapa.add(button);
		button.setBounds(screenX / 2 - 150, screenY - 170, 200, 30);
		button.addActionListener(this);
		
		mapa.revalidate();
		mapa.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(cont == 0){
			cont++;
			System.out.println("aaaaa");
			player2Screen();
		}
	}
}
