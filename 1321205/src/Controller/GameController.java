package Controller;

import Model.Player;
import View.AttackView;
import View.ChooserView;
import View.GameMenuBar;
import View.StartView;

/** 
 * Classe "GameController"
 * 
 * Padrões Utilizados:
 * - Facade;
 * - Singleton;
 * 
 * Descrição:
 * - Inicializa e cria os controllers e views do jogo e executa as principais ações do jogo;
 * 
 */

public class GameController {
	
	/** 
	 * Variáveis de classe de "GameController":
	 * 
	 * - instance: variável estática que contém a instância corrente da classe;
	 * 
	 * - menuBar: interface gráfica da barra de menu;
	 * - startView: interface gráfica da tela de ínicio;
	 * - chooserView: interface gráfica da tela de posicionamento de armas;
	 * - attackView: interface gráfica da tela da fase de ataques;
	 * 
	 * - menuBarController: controlador da barra do menu onde o jogo pode ser salvo ou carregado;
	 * - startController: controlador da tela de inicio de jogo;
	 * - chooserController: controlador da tela de posicionamento de armas;
     * - attackController: controlador da tela da fase de ataques;
	 * 
	 * - player1: modelo onde os dados do primeiro jogador são guardados;
	 * - player2: modelo onde os dados do segundo jogador são guardados;
	 * 
	 */
	
	private static GameController instance = null;
	
	private StartView startView;
	private ChooserView chooserView;
	private AttackView attackView;
	private GameMenuBar menuBar;
	
	private StartController startController;
	private ChooserController chooserController;
	private AttackController attackController;
	private GameMenuBarController menuBarController;
	
	private Player player1;
	private Player player2;
	
	/** 
	 * Construtor de "GameController"
	 * 
	 * Descrição: 
	 * - Inicializa as váriaveis dos dois jogadores e a barra de menu através do método "initBar";
	 * 
	 */
	
	private GameController() {
		player1 = new Player();
		player2 = new Player();	
		initBar();
	}
	
	/** 
	 * Método "getInstance"
	 * 
	 * Descrição: 
	 * - Retorna a instância corrente da classe, cria uma nova instância se a variável "instance" 
	 * for nula;
	 * 
	 */
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
	    }
		return instance;
	}
	
	/** 
	 * Método "initBar"
	 * 
	 * Descrição: 
	 * - Inicializa "menuBar" e "menuBarController", a barra de menu a ser utilizada no jogo;
	 * 
	 */
	
	private void initBar(){
		menuBar = new GameMenuBar();
		menuBarController = new GameMenuBarController(menuBar);
	}
	
	/** 
	 * Método "startGame"
	 * 
	 * Descrição: 
	 * - Inicializa "startView" e "startController", define os jogadores a serem utilizados na tela
	 * de início e apresenta a tela de ínicio ao jogador;
	 * 
	 */
	
	public void startGame() {
		startView = new StartView();
		startController = new StartController(menuBarController, startView, player1, player2);
		startController.setPlayer1(player1);
		startController.setPlayer2(player2);
	}
	
	/** 
	 * Método "startWeaponChoose"
	 * 
	 * Descrição: 
	 * - Inicializa "chooserView" e "chooserController", e apresenta a tela de 
	 * posicionamento de armas ao jogador;
	 * 
	 */
	
	public void startWeaponChoose(){
		chooserView = new ChooserView();
		chooserController = new ChooserController(menuBarController,chooserView, player1, player2);		
	}
	
	/** 
	 * Método "startAttack"
	 * 
	 * Descrição: 
	 * - Inicializa "attackView" e "attackController", e apresenta a tela da fase de
	 * ataques;
	 * 
	 */
	
	public void startAttack(){
		attackView = new AttackView();
		attackController = new AttackController(menuBarController, attackView, player1, player2);
		attackController.presentCorrectScreen();
	}
	
	/** 
	 * Método "loadGame"
	 * 
	 * Descrição: 
	 * - Fecha a tela de início, inicializa "attackView" e "attackController", define os jogadores, o 
	 * número do turno carregados de um estado de jogo prévio ao jogo corrente e apresenta a tela 
	 * da fase de ataques;
	 * 
	 */
	
	public void loadGame(){
		System.out.println("Game:StartAttack - From Loading");
		startController.dismissView();
		attackView = new AttackView();
		attackController = new AttackController(menuBarController, attackView, menuBarController.getFirstPlayerLoaded(), menuBarController.getSecondPlayerLoaded());
		attackController.setRound(menuBarController.getRound());
		attackController.presentCorrectScreen();
	}

}
