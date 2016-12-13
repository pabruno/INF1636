package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;

/** 
 * Classe "StartView"
 * 
 * Extende de:
 * - JFrame;
 * 
 * Descrição:
 * - Tela de inicio do jogo, essa classe contém os componentes gráficos a ser 
 * desenhados e os métodos que os desenham;
 * 
 */

@SuppressWarnings("serial")
public class StartView extends JFrame {
	
	/** 
	 * Variáveis de classe de "StartView":
	 * 
	 * - panel: componente JPanel onde os componentes são desenhados;
	 * - gameMenuBar: componente GameMenuBar com o menu Batalha Naval;
	 * - startButton: componente JButton com o texto "Começar ";
	 * - player1Label: componente JLabel com o texto "Jogador1: ";
	 * - player2Label: componente JLabel com o texto "Jogador2: ";
	 * - player1TextField: componente JTextField para o nome do primeiro jogador";
	 * - player2TextField: componente JTextField para o nome do segundo jogador";
	 * - screenX: inteiro representando a margem horizontal da interface;
	 * - screenY: inteiro representando a margem vertical da interface;
	 * 
	 */

	private JPanel panel;
	private GameMenuBar menuBar;

	private JButton startButton;
	private JLabel player1Label;
	private JLabel player2Label;
	private JTextField player1TextField;
	private JTextField player2TextField;

	private int screenX;
	private int screenY;

	public StartView() {
		responsiveWindow();
		createWindow();
	}
	
	private void responsiveWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
	}

	private void createWindow() {
		panel = new JPanel();
		panel.setLayout(null);

		player1TextField = new JTextField("Jogador 1");
		player2TextField = new JTextField("Jogador 2");
		
		startButton = new JButton("Começar");
		player1Label = new JLabel("Jogador 1:");
		player2Label = new JLabel("Jogador 2:");
		
		getContentPane().add(panel);

		panel.add(startButton);
		panel.add(player1TextField);
		panel.add(player2TextField);
		panel.add(player1Label);
		panel.add(player2Label);
		
		startButton.setBounds(150, 225, 100, 25);
		player1TextField.setBounds(150, 80, 200, 20);
		player2TextField.setBounds(150, 110, 200, 20);
		player1Label.setBounds(70, 80, 100, 20);
		player2Label.setBounds(70, 110, 100, 20);

	}
	
	public void presentWindow(){
		this.setJMenuBar(menuBar);
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(screenX / 2 - 200, screenY / 2 - 150);
		setVisible(true);
		setResizable(false);
	}
	
	public void setMenuBar(GameMenuBar menuBar){
		this.menuBar = menuBar;
	}
	
	public void addStartButtonListener(ActionListener aL){
		startButton.addActionListener(aL);
	}
	
	public String getFirstName(){
		return player1TextField.getText();
		
	}
	
	public String getSecondName(){
		return player2TextField.getText();
	}
	
	public void close() {
		setVisible(false);
		removeAll();
	}
	
}
