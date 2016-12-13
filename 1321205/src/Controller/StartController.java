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
 * Descrição:
 * - Controller de início do jogo, onde os jogadores devem digitar seus nomes e confirmar para começar 
 * um novo jogo ou carregar um jogo previamente salvo;
 * 
 */

public class StartController implements ActionListener {
	
	/** 
	 * Variáveis de classe de "StartController":
	 * 
	 * - view: parte gráfica da tela de ínicio, onde todos os componentes gráficos são desenhados;
	 * - player1: modelo onde os dados do primeiro jogador são guardados;
	 * - player2: modelo onde os dados do segundo jogador são guardados;
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
	 * Parâmetros:
	 * - menuBarController: Parâmetro do tipo "GameMenuBarController";
	 * - view: Parâmetro do tipo "StartView";
	 * - player1: Parâmetro do tipo "Player";
	 * - player2: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Inicializa as variáveis da classe;
	 * - Define a barra do menu a ser inserida na tela;
	 * - Define as configurações do menu.
	 * - Adiciona o "Listener" ao botão de "StartView" definindo que a classe corrente deve receber as
	 *  ações do botão localizado na view.
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
	 * Método "setPlayer1"
	 * 
	 * Parâmetros:
	 * - player: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player1" da classe a partir do parâmetro "player";
	 * 
	 */
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	/** 
	 * Método "setPlayer2"
	 * 
	 * Parâmetros:
	 * - player: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player2" da classe a partir do parâmetro "player";
	 * 
	 */

	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	/** 
	 * Método "actionPerformed"
	 * 
	 * Parâmetros:
	 * - e: Parâmetro do tipo "ActionEvent";
	 * 
	 * Descrição: 
	 * - Este método e executado após o jogador efetuar uma ação no botão "Começar";
	 * - Define os nomes de cada jogador (player1, player2);
	 * - Executa o método "startWeaponChoose" da classe "GameController" para 
	 * apresentar a próxima tela;
	 * 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		player1.setName(view.getFirstName());
		player2.setName(view.getSecondName());
		
		GameController.getInstance().startWeaponChoose();
		view.close();
	}
	
	/** 
	 * Método "dismissView"
	 * 
	 * Descrição: 
	 * - Torna a tela invisivel e remove os componentes gráficos da tela;
	 * 
	 */
	
	public void dismissView(){
		view.close();
	}
	
}
