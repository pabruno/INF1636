package view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/** 
 * Classe "GameMenuBar"
 * 
 * Extende de:
 * - JMenuBar;
 * 
 * Descrição:
 * - Barra de menu, essa classe contém os componentes gráficos a ser 
 * desenhados e os métodos que os desenham;
 * 
 */

@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar {
	
	/** 
	 * Variáveis de classe de "GameMenuBar":
	 * 
	 * - gameMenu: componente JMenu com o texto "Batalha Naval";
	 * - saveAction: componente JMenuItem com o texto "Salvar Jogo";
	 * - loadAction: componente JMenuItem com o texto "Carregar Jogo";
	 * 
	 */
	
	private JMenu gameMenu;
	private JMenuItem saveAction;
    private JMenuItem loadAction;
	

	/** 
	 * Construtor de "GameMenuBar"
	 * 
	 * Descrição: 
	 * - Inicializa variáveis da classe;
	 * - Adiciona menu a GameMenuBar e adiciona os itens ao menu;
	 * 
	 */
	
	public GameMenuBar() {
		
        gameMenu = new JMenu("Batalha Naval");
        saveAction = new JMenuItem("Salvar Jogo");
        loadAction = new JMenuItem("Carregar Jogo");
        
        this.add(gameMenu);
        gameMenu.add(saveAction);
        gameMenu.add(loadAction);

	}
	
	
	/** 
	 * Método "setLoadActionEnabled"
	 * 
	 * Parâmetros:
	 * - b: Parâmetro do tipo "Boolean";
	 * 
	 * Descrição: 
	 * - Este método altera a visibilidade do item do menu "loadAction" com base no valor do parâmetro "b";
	 * 
	 */
	
	public void setLoadActionEnabled(Boolean b){
		loadAction.setEnabled(b);
	}
	
	/** 
	 * Método "setSaveActionEnabled"
	 * 
	 * Parâmetros:
	 * - b: Parâmetro do tipo "Boolean";
	 * 
	 * Descrição: 
	 * - Este método altera a visibilidade do item do menu "saveAction" com base no valor do parâmetro "b";
	 * 
	 */
	
	public void setSaveActionEnabled(Boolean b){
		saveAction.setEnabled(b);
	}
	
	/** 
	 * Método "addLoadActionListener"
	 * 
	 * Parâmetros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descrição: 
	 * - Adiciona o parâmetro aL como o "Listener" de ações do loadAction;
	 * 
	 */
	
	public void addLoadActionListener(ActionListener aL){
		loadAction.addActionListener(aL);
	}
	
	/** 
	 * Método "addSaveActionListener"
	 * 
	 * Parâmetros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descrição: 
	 * - Adiciona o parâmetro aL como o "Listener" de ações do saveAction;
	 * 
	 */
	
	public void addSaveActionListener(ActionListener aL){
		saveAction.addActionListener(aL);
	}
	
}
