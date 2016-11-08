package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

public class ShipsChooserWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int screenX;
	private int screenY;
	
	// Mapa de cada jogador.
	
	private char[][] map1;
	private char[][] map2;
	
	// Nome de cada jogador.
	
	private String name1;
	private String name2;
	
	// Construtor para inicializar a tela para a coloca��o dos navios do Jogador 1.
	
	public ShipsChooserWindow(char [][] map1, char [][] map2, String name1, String name2){
		this.map1 = map1;
		this.map2 = map2;
		this.name1 = name1;
		this.name2 = name2;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
		
		Map mapa = new Map();
		mapa.draw(map1,screenX/2 + 30,screenY/10);
		getContentPane().add(mapa);
		
		mapa.setLayout(null);
		JLabel text = new JLabel(name1 + ", posicione os navios no tabuleiro.");
		mapa.add(text);
		text.setBounds(screenX/2 - 175,screenY - 200,350,30);
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(screenX - 100,screenY - 100);
		setLocation(screenX/2 - (screenX-100)/2,screenY/2 - (screenY-100)/2);
		setVisible(true);
		setResizable(false);
	}
}
