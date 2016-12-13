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
 * Descricao:
 * - Tela de inicio do jogo, essa classe contem os componentes graficos a ser 
 * desenhados e os metodos que os desenham;
 * 
 */

@SuppressWarnings("serial")
public class StartView extends JFrame {
	
	/** 
	 * Variaveis de classe de "StartView":
	 * 
	 * - panel: componente JPanel onde os componentes sao desenhados;
	 * - gameMenuBar: componente GameMenuBar com o menu Batalha Naval;
	 * - startButton: componente JButton com o texto "Comecar";
	 * - player1Label: componente JLabel com o texto "Jogador1: ";
	 * - player2Label: componente JLabel com o texto "Jogador2: ";
	 * - player1TextField: componente JTextField para o nome do primeiro jogador";
	 * - player2TextField: componente JTextField para o nome do segundo jogador";
	 * - screenX: inteiro representando a posicao horizontal onde a interface vai ser desenhada;
	 * - screenY: inteiro representando a posicao vertical onde a interface vai ser desenhada;
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
	 * Descricao: 
	 * - Calcula tamanho responsivo da janela a ser desenhada;
	 * - Cria tela de inicio se baseando no calculo do tamanho responsivo;
	 * 
	 */
	
	public StartView() {
		responsiveWindow();
		createWindow();
	}
	
	/** 
	 * Metodo "responsiveWindow"
	 * 
	 * Descricao: 
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
	 * Metodo "createWindow"
	 * 
	 * Descricao: 
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
	 * Metodo "presentWindow"
	 * 
	 * Descricao: 
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
	 * Metodo "addStartButtonListener"
	 * 
	 * Parametros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descricao: 
	 * - Adiciona o parametro aL como o "Listener" de acoes do startButton;
	 * 
	 */
	
	public void addStartButtonListener(ActionListener aL){
		startButton.addActionListener(aL);
	}
	
	/** 
	 * Metodo "setMenuBar"
	 * 
	 * Parametros:
	 * - menuBar: Parametro do tipo "GameMenuBar";
	 *
	 * Descricao: 
	 * - Define a barra de menu a ser utilizada na classe corrente;
	 * 
	 */
	
	public void setMenuBar(GameMenuBar menuBar){
		this.menuBar = menuBar;
	}
	
	/** 
	 * Metodo "getFirstName"
	 *
	 * Descricao: 
	 * - Retorna o nome do primeiro jogador;
	 * 
	 */
	
	public String getFirstName(){
		return player1TextField.getText();
		
	}
	
	/** 
	 * Metodo "getSecondName"
	 *
	 * Descricao: 
	 * - Retorna o nome do segundo jogador;
	 * 
	 */
	
	public String getSecondName(){
		return player2TextField.getText();
	}
	
	/** 
	 * Metodo "close"
	 *
	 * Descricao: 
	 * - Remove os componentes graficos da janela e a torna invisivel;
	 * 
	 */
	
	public void close() {
		setVisible(false);
		removeAll();
	}
	
}
