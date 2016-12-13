package view;

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
 * - Tela de início do jogo, essa classe contém os componentes gráficos a ser 
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
	 * - startButton: componente JButton com o texto "Comecar";
	 * - player1Label: componente JLabel com o texto "Jogador1: ";
	 * - player2Label: componente JLabel com o texto "Jogador2: ";
	 * - player1TextField: componente JTextField para o nome do primeiro jogador";
	 * - player2TextField: componente JTextField para o nome do segundo jogador";
	 * - screenX: inteiro representando a posição horizontal onde a interface vai ser desenhada;
	 * - screenY: inteiro representando a posição vertical onde a interface vai ser desenhada;
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

	/** 
	 * Construtor de "StartView"
	 * 
	 * Descrição: 
	 * - Calcula tamanho responsivo da janela a ser desenhada;
	 * - Cria tela de início se baseando no cálculo do tamanho responsivo;
	 * 
	 */
	
	public StartView() {
		responsiveWindow();
		createWindow();
	}
	
	/** 
	 * Método "responsiveWindow"
	 * 
	 * Descrição: 
	 * - Calcula e define o tamanho da janela de forma em reponsiva;
	 * 
	 */
	
	private void responsiveWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size = kit.getScreenSize();
		screenX = size.width;
		screenY = size.height;
	}
	
	/** 
	 * Método "createWindow"
	 * 
	 * Descrição: 
	 * - Cria a janela e inicializa os componentes graficos a serem desenhados;
	 * 
	 */

	private void createWindow() {
		panel = new JPanel();
		panel.setLayout(null);

		player1TextField = new JTextField("Jogador 1");
		player2TextField = new JTextField("Jogador 2");
		
		startButton = new JButton("Comecar");
		player1Label = new JLabel("Jogador 1:");
		player2Label = new JLabel("Jogador 2:");
		
		getContentPane().add(panel);

		panel.add(startButton);
		panel.add(player1TextField);
		panel.add(player2TextField);
		panel.add(player1Label);
		panel.add(player2Label);
		
		startButton.setBounds(150, 200, 100, 25);
		player1TextField.setBounds(150, 80, 200, 20);
		player2TextField.setBounds(150, 110, 200, 20);
		player1Label.setBounds(70, 80, 100, 20);
		player2Label.setBounds(70, 110, 100, 20);

	}
	
	/** 
	 * Método "presentWindow"
	 * 
	 * Descrição:  
	 * - Apresenta a janela e define a barra de menu a ser utilizada;
	 * 
	 */
	
	public void presentWindow(){
		this.setJMenuBar(menuBar);
		
		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(screenX / 2 - 200, screenY / 2 - 150);
		setVisible(true);
		setResizable(false);
	}
	
	/** 
	 * Método "addStartButtonListener"
	 * 
	 * Parâmetros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descrição: 
	 * - Adiciona o parametro aL como o "Listener" de acoes do startButton;
	 * 
	 */
	
	public void addStartButtonListener(ActionListener aL){
		startButton.addActionListener(aL);
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
	
	/** 
	 * Método "getFirstName"
	 *
	 * Descrição: 
	 * - Retorna o nome do primeiro jogador;
	 * 
	 */
	
	public String getFirstName(){
		return player1TextField.getText();
		
	}
	
	/** 
	 * Método "getSecondName"
	 *
	 * Descrição: 
	 * - Retorna o nome do segundo jogador;
	 * 
	 */
	
	public String getSecondName(){
		return player2TextField.getText();
	}
	
	/** 
	 * Método "close"
	 *
	 * Descrição: 
	 * - Remove os componentes graficos da janela e a torna invisivel;
	 * 
	 */
	
	public void close() {
		setVisible(false);
		removeAll();
	}
	
}
