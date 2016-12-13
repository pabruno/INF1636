package view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/** 
 * Classe "GameMenuBar"
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
public class GameMenuBar extends JMenuBar {
	
	private JMenu gameMenu;
	private JMenuItem saveAction;
    private JMenuItem loadAction;
	
	public GameMenuBar() {
		
        gameMenu = new JMenu("Batalha Naval");
        saveAction = new JMenuItem("Salvar Jogo");
        loadAction = new JMenuItem("Carregar Jogo");
        
        this.add(gameMenu);
        gameMenu.add(saveAction);
        gameMenu.add(loadAction);

	}
	
	public void setLoadActionEnabled(Boolean b){
		loadAction.setEnabled(b);
	}
	
	public void setSaveActionEnabled(Boolean b){
		saveAction.setEnabled(b);
	}
	
	public void setLoadActionListener(ActionListener aL){
		loadAction.addActionListener(aL);
	}
	
	public void setSaveActionListener(ActionListener aL){
		saveAction.addActionListener(aL);
	}
	
}
