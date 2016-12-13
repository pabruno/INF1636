package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFileChooser;

import model.Player;
import view.GameMenuBar;

/** 
 * Classe "GameMenuBarControllerr"
 * 
 * Implementa:
 * - ActionListener;
 * 
 * Descrição:
 * - Controller da barra de menu, onde o jogador pode salvar um jogo corrente ou carregar um jogo
 *  previamente salvo;
 * 
 */

public class GameMenuBarController implements ActionListener {
	
	/** 
	 * Variáveis de classe de "GameMenuBarController":
	 * 
	 * - view: interface gráfica da barra de menu;
	 * - player1: modelo onde os dados do primeiro jogador são guardados;
	 * - player2: modelo onde os dados do segundo jogador são guardados;
	 * - round: inteiro representando o turno da fase de ataques;
	 * 
	 */
	
	private GameMenuBar view;
	private Player player1;
	private Player player2;
	private int round;
	
	/** 
	 * Construtor de "GameMenuBarController"
	 * 
	 * Parâmetros:
	 * - menuBar: interface gráfica da barra de menu;
	 * 
	 * Descrição: 
	 * - Inicializa as variáveis da classe;
	 * - Chama o método "setListeners" para adicionar os listeners nos botões da view;
	 * 
	 */
	
	public GameMenuBarController(GameMenuBar menuBar){
		this.player1 = new Player();
		this.player2 = new Player();
		this.view = menuBar;
		setListeners();
	}
	
	/** 
	 * Método "getView"
	 * 
	 * Descrição: 
	 * - Retorna a view da classe corrente que é do tipo "GameMenuBar";
	 * 
	 */
	
	public GameMenuBar getView(){
		return view;
	}
	
	/** 
	 * Método "setListeners"
	 * 
	 * Descrição: 
	 * - Define na view que a Classe corrente quer receber as ações do item "Salvar Jogo" e "Carregar Jogo";
	 * 
	 */
	
	public void setListeners(){
		view.addSaveActionListener(this);
		view.addLoadActionListener(this);
	}
	
	/** 
	 * Método "setChooserEnabled"
	 * 
	 * Descrição: 
	 * - Este método altera a visibilidade do itens do menu para o que é esperado na tela de início e de posicionamento;
	 * 
	 */
	
	public void setChooserEnabled(){
		view.setSaveActionEnabled(false);
		view.setLoadActionEnabled(true);
	}
	
	
	/** 
	 * Método "setAttackEnabled"
	 * 
	 * Descrição: 
	 * - Este método altera a visibilidade do itens do menu para o que é esperado na tela da fase de ataques;
	 * 
	 */
	
	public void setAttackEnabled(){
		view.setSaveActionEnabled(true);
		view.setLoadActionEnabled(false);
	}
	
	/** 
	 * Método "setFirstPlayerToSave"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player1" da classe a partir do parâmetro "p";
	 * 
	 */
	
	public void setFirstPlayerToSave(Player p){
		player1 = p;
	}
	
	/** 
	 * Método "setSecondPlayerToSave"
	 * 
	 * Parâmetros:
	 * - p: Parâmetro do tipo "Player";
	 * 
	 * Descrição: 
	 * - Define a variável "player2" da classe a partir do parâmetro "p";
	 * 
	 */
	
	public void setSecondPlayerToSave(Player p){
		player2 = p;
	}

	/** 
	 * Método "getFirstPlayerLoaded"
	 * 
	 * Descrição: 
	 * - Retorna o primeiro jogador que foi carregado;
	 * 
	 */
	
	public Player getFirstPlayerLoaded(){
		return player1;
	}
	
	/** 
	 * Método "getSecondPlayerLoaded"
	 * 
	 * Descrição: 
	 * - Retorna o segundo jogador que foi carregado;
	 * 
	 */
	
	public Player getSecondPlayerLoaded(){
		return player2;
	}
	
	/** 
	 * Método "setRound"
	 * 
	 * Parâmetros:
	 * - r: Parâmetro do tipo inteiro;
	 * 
	 * Descrição: 
	 * - Define a variável "round" da classe a partir do parâmetro "r";
	 * 
	 */
	
	public void setRound(int r){
		round = r;
	}
	
	/** 
	 * Método "getRound"
	 * 
	 * Descrição: 
	 * - Retorna a variável round que contém o turno no qual o jogo parou;
	 * 
	 */
	
	public int getRound(){
		return round;
	}
	
	
	/** 
	 * Método "getStringFromMatrix"
	 * 
	 * Parâmetros:
	 * - c: Parâmetro do tipo matriz de caracteres representando o que deve ser convertido;
	 *
	 * Descrição: 
	 * - Converte e retorna o parâmetro para o tipo "String";
	 * 
	 */
	
	private String getStringFromMatrix (char[][] c){
		String str = "";
		for(int i=0; i < c.length; i++){
			for(int j=0; j < c[0].length; j++){
				str += c[i][j];
			}
		}
		
		return str;
	}
	
	/** 
	 * Método "getMatrixFromString"
	 * 
	 * Parâmetros:
	 * - s: Parâmetro do tipo "String" representando o que deve ser convertido;
	 *
	 * Descrição: 
	 * - Converte e retorna o parâmetro para o tipo matriz de caracteres;
	 * 
	 */
	
	private char[][] getMatrixFromString(String s){
		int i = 0;
		char[][] matrix = new char[15][15];
		
		for(int j=0; j < 15; j++){
			for (int k=0; k < 15; k++, i++){			
				matrix[j][k] = s.charAt(i);
			}
		}
				
		return matrix;
	}
	
	/** 
	 * Método "getStringFromHashMap"
	 * 
	 * Parâmetros:
	 * - position: Parâmetro do tipo "LinkedHashMap<LinkedList<int[]>, String>" representando o que deve ser convertido;
	 *
	 * Descrição: 
	 * - Converte e retorna o parâmetro para o tipo "String";
	 * 
	 */
	
	private String getStringFromHashMap (String name, LinkedHashMap<LinkedList<int[]>, String> position){
		String str = "";
		
		str += name + position.size();
		str += "\n";
		 
		for (Entry<LinkedList<int[]>, String> entry : position.entrySet()) {
	
			 LinkedList<int[]> key = entry.getKey();
			 String value = entry.getValue();
			 
			 for (int i = 0; i < key.size(); i++) {
				 str += name + Integer.toString(key.get(i).length);
				 str += "\n";
				 for (int j = 0; j < key.get(i).length; j++){
					 str += name + Integer.toString(key.get(i)[j]);
					 str += "\n";
				 }
			 }
			 
			 str += name + "str: "+ value;
			 str += "\n";
			 
		}
		
		return str;
	}
	
	/** 
	 * Método "getHashMapFromString"
	 * 
	 * Parâmetros:
	 * - s: Parâmetro do tipo "String" representando o que deve ser convertido;
	 *
	 * Descrição: 
	 * - Converte e retorna o parâmetro para o tipo "LinkedHashMap<LinkedList<int[]>, String>"
	 * 
	 */
	
	private LinkedHashMap<LinkedList<int[]>, String> getHashMapFromString(String s){
		LinkedHashMap<LinkedList<int[]>, String> pos = new LinkedHashMap<LinkedList<int[]>, String>();
		List<String> items = Arrays.asList(s.split("\\s*,\\s*"));
		int j = 1;
		int size = Integer.parseInt(items.get(0));
		
		for (int i = 0; i < size; i++){
			String str = "";
			LinkedList<int[]> list = new LinkedList<int[]>();

			while (items.get(j).contains("str: ") == false){

				int[] vector = new int[Integer.parseInt(items.get(j))];
				int vectorSize = Integer.parseInt(items.get(j));
				
				for (int k = 0; k < vectorSize; k++, j++){
					vector[k] = Integer.parseInt(items.get(j+1));
				}

				list.add(vector);

				j++;
			}
			
			str = items.get(j).substring(5);
			pos.put(list, str);
			j++;
		}
		
		return pos;
	}
	
	/** 
	 * Método "loadFirstPlayerFromFile"
	 * 
	 * Parâmetros:
	 * - name: Parâmetro do tipo "String" representando o nome do jogador;
	 * - map: Parâmetro do tipo "String" representando o mapa de armas do jogador;
	 * - attackMap: Parâmetro do tipo "String" representando o mapa de ataque do jogador;
	 * - position: Parâmetro do tipo "String" representando a posição de cada peça e seu tipo no mapa;
	 *
	 * Descrição: 
	 * - Define em "player1" as informações necessárias para a criação jogador;
	 * - Métodos de conversão são chamados para converter os parâmetros para os tipos corretos;
	 * 
	 */
	
	private void loadFirstPlayerFromFile(String name, String map, String attackMap, String position){
		
		char[][] m = getMatrixFromString(map);
		char[][] a = getMatrixFromString(attackMap);
		LinkedHashMap<LinkedList<int[]>, String> pos = getHashMapFromString(position);

		player1.setName(name);
		player1.setMap(m);
		player1.setAttackMap(a);
		player1.setPosition(pos);
		
	}
	
	/** 
	 * Método "loadSecondPlayerFromFile"
	 * 
	 * Parâmetros:
	 * - name: Parâmetro do tipo "String" representando o nome do jogador;
	 * - map: Parâmetro do tipo "String" representando o mapa de armas do jogador;
	 * - attackMap: Parâmetro do tipo "String" representando o mapa de ataque do jogador;
	 * - position: Parâmetro do tipo "String" representando a posição de cada peça e seu tipo no mapa;
	 *
	 * Descrição: 
	 * - Define em "player2" as informações necessárias para a criação jogador;
	 * - Métodos de conversão são chamados para converter os parâmetros para os tipos corretos;
	 * 
	 */
	
	private void loadSecondPlayerFromFile(String name, String map, String attackMap, String position){
		
		char[][] m = getMatrixFromString(map);
		char[][] a = getMatrixFromString(attackMap);
		LinkedHashMap<LinkedList<int[]>, String> pos = getHashMapFromString(position);
		
		player2.setName(name);
		player2.setMap(m);
		player2.setAttackMap(a);
		player2.setPosition(pos);
		
	}
	
	/** 
	 * Método "openFile"
	 * 
	 * Descrição: 
	 * - Carrega o estado do jogo de um arquivo de texto;
	 * 
	 */
	
	public void openFile(){
		
		String count = "";
		
		String name1 = "";
		String map1 = "";
		String attack1 = "";
		String position1 = "";
		
		String name2 = "";
		String map2 = "";
		String attack2 = "";
		String position2 = "";
		
		JFileChooser fileChooser = new JFileChooser(new File(""));
		fileChooser.setDialogTitle("Carregar Jogo");
		int result = fileChooser.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION){
			
			File file = fileChooser.getSelectedFile();
			
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
				String line = "";
				
				while((line = bufferedReader.readLine()) != null) {
					
					if (line.contains("count: ")){
						count = line.substring(7);
					} else if (line.contains("name1: ")){
						name1 = line.substring(7);
					} else if (line.contains("map1: ")){
						map1 = line.substring(6);
					} else if (line.contains("attack1: ")){
						attack1 = line.substring(9);
					} else if (line.contains("position1: ")){
						position1 += line.substring(11) + ",";
					} else if (line.contains("name2: ")){
						name2 = line.substring(7);
					} else if (line.contains("map2: ")){
						map2 = line.substring(6);
					} else if (line.contains("attack2: ")){
						attack2 = line.substring(9);
					} else if (line.contains("position2: ")){
						position2 += line.substring(11) + ",";
					}

				}
				
				int c = Integer.parseInt(count);
				
				this.setRound(c);
				loadFirstPlayerFromFile(name1, map1, attack1, position1);
				loadSecondPlayerFromFile(name2, map2, attack2, position2);
				bufferedReader.close();
				GameController.getInstance().loadGame();
				
			} catch (Exception e){
				System.out.println("Error: " + e.toString());
			}
		}
	
	}
	
	/** 
	 * Método "saveFile"
	 * 
	 * Descrição: 
	 * - Salva o estado do jogo em arquivo de texto;
	 * 
	 */
	
	public void saveFile(){
		
		String player = "count: " + AttackController.getRound();
		
		String name1 = "name1: " + player1.getName();
		String map1 = "map1: " + getStringFromMatrix(player1.getMyMap());
		String attack1 = "attack1: " + getStringFromMatrix(player1.getAttackMap());
		String position1 = getStringFromHashMap("position1: ", player1.getPosition());
		
		String name2 = "name2: " +  player2.getName();
		String map2 = "map2: " + getStringFromMatrix(player2.getMyMap());
		String attack2 = "attack2: " + getStringFromMatrix(player2.getAttackMap());
		String position2 = getStringFromHashMap("position2: ", player2.getPosition());
		
		JFileChooser fileChooser = new JFileChooser(new File("Documents"));
		fileChooser.setDialogTitle("Salvar Jogo");
		int result = fileChooser.showSaveDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION){
			
			File file = fileChooser.getSelectedFile();
			
			try {
				FileWriter fileWriter = new FileWriter(file.getPath());
				fileWriter.write(player + "\n" + name1 + "\n" + map1 + "\n" + attack1 + "\n" + position1 + "\n" + name2 + "\n" + map2 + "\n" + attack2 + "\n" + position2 + "\n");
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	/** 
	 * Método "actionPerformed"
	 * 
	 * Parâmetros:
	 * - e: Parâmetro do tipo "ActionEvent";
	 * 
	 * Descrição: 
	 * - Este método e executado após o jogador clicar em algum item do menu;
	 * - Caso o item "Salvar Jogo" é clicado o método "saveFile" é chamado;
	 * - Caso o item "Carregar Jogo" é clicado o método "loadFile" é chamado;
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Salvar Jogo")){
			saveFile();
		} else {
			openFile();
		}
	}
	
}
