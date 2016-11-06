package display;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartGameWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	
	// Campos de texto para armazenar o nome dos jogadores na tela inicial.
	
	private JTextField player1 = new JTextField("Jogador 1");
	private JTextField player2 = new JTextField("Jogador 2");
	
	// Nomes dos jogadores.
	
	private String name1;
	private String name2;
	
	// Tamanho da tela do computador.
	
	private int screenX;
	private int screenY;
	
	// Construtor default para carregar a tela inicial, para inserção dos nomes dos jogadores.
	
	public StartGameWindow() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
		
		panel.setLayout(null);
		
		JButton startButton = new JButton("Começar");
		JLabel player1Label = new JLabel("Jogador 1:");
		JLabel player2Label = new JLabel("Jogador 2:");
		startButton.addActionListener(this);
		getContentPane().add(panel);
		
		panel.add(startButton);
		panel.add(player1);
		panel.add(player2);
		panel.add(player1Label);
		panel.add(player2Label);
		startButton.setBounds(150, 225, 100, 25);
		player1.setBounds(150, 80, 200, 20);
		player2.setBounds(150, 110, 200, 20);
		player1Label.setBounds(70, 80, 100, 20);
		player2Label.setBounds(70, 110, 100, 20);
		
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setLocation(screenX/2 - 200,screenY/2 - 150);
		setVisible(true);
		setResizable(false);
	}
	
	public String getName1(){
		return name1;
	}
	
	public String getName2(){
		return name2;
	}
	
	public void close(){
		setVisible(false);
		removeAll();
	}
	
	public void actionPerformed(ActionEvent e){
		name1 = player1.getText();
		name2 = player2.getText();
	}
}
