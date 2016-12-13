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
 * Descri��o:
 * - Barra de menu, essa classe cont�m os componentes gr�ficos a ser 
 * desenhados e os m�todos que os desenham;
 * 
 */

@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar {
	
	/** 
	 * Vari�veis de classe de "GameMenuBar":
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
	 * Descri��o: 
	 * - Inicializa vari�veis da classe;
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
	 * M�todo "setLoadActionEnabled"
	 * 
	 * Par�metros:
	 * - b: Par�metro do tipo "Boolean";
	 * 
	 * Descri��o: 
	 * - Este m�todo altera a visibilidade do item do menu "loadAction" com base no valor do par�metro "b";
	 * 
	 */
	
	public void setLoadActionEnabled(Boolean b){
		loadAction.setEnabled(b);
	}
	
	/** 
	 * M�todo "setSaveActionEnabled"
	 * 
	 * Par�metros:
	 * - b: Par�metro do tipo "Boolean";
	 * 
	 * Descri��o: 
	 * - Este m�todo altera a visibilidade do item do menu "saveAction" com base no valor do par�metro "b";
	 * 
	 */
	
	public void setSaveActionEnabled(Boolean b){
		saveAction.setEnabled(b);
	}
	
	/** 
	 * M�todo "addLoadActionListener"
	 * 
	 * Par�metros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descri��o: 
	 * - Adiciona o par�metro aL como o "Listener" de a��es do loadAction;
	 * 
	 */
	
	public void addLoadActionListener(ActionListener aL){
		loadAction.addActionListener(aL);
	}
	
	/** 
	 * M�todo "addSaveActionListener"
	 * 
	 * Par�metros:
	 * - aL: Parametro do tipo "ActionListener";
	 *
	 * Descri��o: 
	 * - Adiciona o par�metro aL como o "Listener" de a��es do saveAction;
	 * 
	 */
	
	public void addSaveActionListener(ActionListener aL){
		saveAction.addActionListener(aL);
	}
	
}
