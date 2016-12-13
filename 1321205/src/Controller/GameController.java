package Controller;

import Model.Player;
import View.AttackView;
import View.ChooserView;
import View.GameMenuBar;
import View.StartView;

/** 
 * Classe "GameController"
 * 
 * Padr�es Utilizados:
 * - Facade;
 * - Singleton;
 * 
 * Descri��o:
 * - Inicializa e cria os controllers e views do jogo e executa as principais a��es do jogo;
 * 
 */

public class GameController {
	
	/** 
	 * Vari�veis de classe de "GameController":
	 * 
	 * - instance: vari�vel est�tica que cont�m a inst�ncia corrente da classe;
	 * 
	 * - menuBar: interface gr�fica da barra de menu;
	 * - startView: interface gr�fica da tela de �nicio;
	 * - chooserView: interface gr�fica da tela de posicionamento de armas;
	 * - attackView: interface gr�fica da tela da fase de ataques;
	 * 
	 * - menuBarController: controlador da barra do menu onde o jogo pode ser salvo ou carregado;
	 * - startController: controlador da tela de inicio de jogo;
	 * - chooserController: controlador da tela de posicionamento de armas;
     * - attackController: controlador da tela da fase de ataques;
	 * 
	 * - player1: modelo onde os dados do primeiro jogador s�o guardados;
	 * - player2: modelo onde os dados do segundo jogador s�o guardados;
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
	 * Descri��o: 
	 * - Inicializa as v�riaveis dos dois jogadores e a barra de menu atrav�s do m�todo "initBar";
	 * 
	 */
	
	private GameController() {
		player1 = new Player();
		player2 = new Player();	
		initBar();
	}
	
	/** 
	 * M�todo "getInstance"
	 * 
	 * Descri��o: 
	 * - Retorna a inst�ncia corrente da classe, cria uma nova inst�ncia se a vari�vel "instance" 
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
	 * M�todo "initBar"
	 * 
	 * Descri��o: 
	 * - Inicializa "menuBar" e "menuBarController", a barra de menu a ser utilizada no jogo;
	 * 
	 */
	
	private void initBar(){
		menuBar = new GameMenuBar();
		menuBarController = new GameMenuBarController(menuBar);
	}
	
	/** 
	 * M�todo "startGame"
	 * 
	 * Descri��o: 
	 * - Inicializa "startView" e "startController", define os jogadores a serem utilizados na tela
	 * de in�cio e apresenta a tela de �nicio ao jogador;
	 * 
	 */
	
	public void startGame() {
		startView = new StartView();
		startController = new StartController(menuBarController, startView, player1, player2);
		startController.setPlayer1(player1);
		startController.setPlayer2(player2);
	}
	
	/** 
	 * M�todo "startWeaponChoose"
	 * 
	 * Descri��o: 
	 * - Inicializa "chooserView" e "chooserController", e apresenta a tela de 
	 * posicionamento de armas ao jogador;
	 * 
	 */
	
	public void startWeaponChoose(){
		chooserView = new ChooserView();
		chooserController = new ChooserController(menuBarController,chooserView, player1, player2);		
	}
	
	/** 
	 * M�todo "startAttack"
	 * 
	 * Descri��o: 
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
	 * M�todo "loadGame"
	 * 
	 * Descri��o: 
	 * - Fecha a tela de in�cio, inicializa "attackView" e "attackController", define os jogadores, o 
	 * n�mero do turno carregados de um estado de jogo pr�vio ao jogo corrente e apresenta a tela 
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
