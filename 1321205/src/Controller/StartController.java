package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Player;
import Controller.GameController;
import View.StartView;

/** 
 * Classe "StartController"
 * 
 * Implementa:
 * - ActionListener;
 * 
 * Descri��o:
 * - Controller de in�cio do jogo, onde os jogadores devem digitar seus nomes e confirmar para come�ar 
 * um novo jogo ou carregar um jogo previamente salvo;
 * 
 */

public class StartController implements ActionListener {
	
	/** 
	 * Vari�veis de classe de "StartController":
	 * 
	 * - view: parte gr�fica da tela de �nicio, onde todos os componentes gr�ficos s�o desenhados;
	 * - player1: modelo onde os dados do primeiro jogador s�o guardados;
	 * - player2: modelo onde os dados do segundo jogador s�o guardados;
	 * - menuBarController: controlador da barra do menu onde o jogo pode ser salvo ou carregado;
	 * 
	 */
	
	private StartView view;
	private Player player1;
	private Player player2;
	private GameMenuBarController menuBarController;
	
	/** 
	 * Construtor de "StartController"
	 * 
	 * Par�metros:
	 * - menuBarController: Par�metro do tipo "GameMenuBarController";
	 * - view: Par�metro do tipo "StartView";
	 * - player1: Par�metro do tipo "Player";
	 * - player2: Par�metro do tipo "Player";
	 * 
	 * Descri��o: 
	 * - Inicializa as vari�veis da classe;
	 * - Define a barra do menu a ser inserida na tela;
	 * - Define as configura��es do menu.
	 * - Adiciona o "Listener" ao bot�o de "StartView" definindo que a classe corrente deve receber as
	 *  a��es do bot�o localizado na view.
	 * - Apresenta ao jogador a tela.
	 * 
	 */
	
	public StartController(GameMenuBarController menuBarController, StartView view, Player player1, Player player2) {
		this.menuBarController = menuBarController;
		this.view = view;
		this.player1 = player1;
		this.player2 = player2;
		
		view.setMenuBar(this.menuBarController.getView());
		this.menuBarController.setChooserEnabled();
		view.addStartButtonListener(this);
		view.presentWindow();
	}
	
	
	/** 
	 * M�todo "setPlayer1"
	 * 
	 * Par�metros:
	 * - player: Par�metro do tipo "Player";
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "player1" da classe a partir do par�metro "player";
	 * 
	 */
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	/** 
	 * M�todo "setPlayer2"
	 * 
	 * Par�metros:
	 * - player: Par�metro do tipo "Player";
	 * 
	 * Descri��o: 
	 * - Define a vari�vel "player2" da classe a partir do par�metro "player";
	 * 
	 */

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	/** 
	 * M�todo "actionPerformed"
	 * 
	 * Par�metros:
	 * - e: Par�metro do tipo "ActionEvent";
	 * 
	 * Descri��o: 
	 * - Este m�todo e executado ap�s o jogador efetuar uma a��o no bot�o "Come�ar";
	 * - Define os nomes de cada jogador (player1, player2);
	 * - Executa o m�todo "startWeaponChoose" da classe "GameController" para 
	 * apresentar a pr�xima tela;
	 * 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		player1.setName(view.getFirstName());
		player2.setName(view.getSecondName());
		
		GameController.getInstance().startWeaponChoose();
		view.close();
	}
	
	/** 
	 * M�todo "dismissView"
	 * 
	 * Descri��o: 
	 * - Torna a tela invisivel e remove os componentes gr�ficos da tela;
	 * 
	 */
	
	public void dismissView(){
		view.close();
	}
	
}
