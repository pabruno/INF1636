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
 * Descricao:
 * - Controller de inicio do jogo, onde os jogadores devem digitar seus nomes e confirmar para comecar 
 * um novo jogo ou carregar um jogo previamente salvo;
 * 
 */

public class StartController implements ActionListener {
	
	/** 
	 * Variaveis de classe de "StartController":
	 * 
	 * - view: parte grafica da tela de inicio, onde todos os componentes graficos são desenhados;
	 * - player1: modelo onde os dados do primeiro jogador sao guardados;
	 * - player2: modelo onde os dados do segundo jogador sao guardados;
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
	 * Parametros:
	 * - menuBarController: Parametro do tipo "GameMenuBarController";
	 * - view: Parametro do tipo "StartView";
	 * - player1: Parametro do tipo "Player";
	 * - player2: Parametro do tipo "Player";
	 * 
	 * Descricao: 
	 * - Inicializa as variaveis da classe;
	 * - Define a barra do menu a ser inserida na tela;
	 * - Define as configurações do menu.
	 * - Adiciona o "Listener" ao botao de "StartView" definindo que a classe corrente deve receber as acoes 
	 * do botao localizado na view.
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
	 * Metodo "setPlayer1"
	 * 
	 * Parametros:
	 * - player: Parametro do tipo "Player";
	 * 
	 * Descricao: 
	 * - Define a variavel "player1" da classe a partir do parametro "player";
	 * 
	 */
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	/** 
	 * Metodo "setPlayer2"
	 * 
	 * Parametros:
	 * - player: Parametro do tipo "Player";
	 * 
	 * Descricao: 
	 * - Define a variavel "player2" da classe a partir do parametro "player";
	 * 
	 */

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	/** 
	 * Metodo "actionPerformed"
	 * 
	 * Parametros:
	 * - e: Parametro do tipo "ActionEvent";
	 * 
	 * Descricao: 
	 * - Este metodo e executado apos o jogador efetuar uma acao no botao "Comecar";
	 * - Define os nomes de cada jogador (player1, player2);
	 * - Executa o metodo "startWeaponChoose" da classe "GameController" para 
	 * apresentar a proxima tela;
	 * 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		player1.setName(view.getFirstName());
		player2.setName(view.getSecondName());
		
		GameController.getInstance().startWeaponChoose();
		view.close();
	}
	
}
