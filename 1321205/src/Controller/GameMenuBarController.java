package Controller;

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

import Model.Player;
import View.GameMenuBar;

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
	
	private GameMenuBar view;
	private Player player1;
	private Player player2;
	private int round;
	
	public GameMenuBarController(GameMenuBar menuBar){
		this.player1 = new Player();
		this.player2 = new Player();
		this.view = menuBar;
		setListeners();
	}
	
	public GameMenuBar getView(){
		return view;
	}
	
	public void setListeners(){
		view.setSaveActionListener(this);
		view.setLoadActionListener(this);
	}
	
	public void setChooserEnabled(){
		view.setSaveActionEnabled(false);
		view.setLoadActionEnabled(true);
	}
	
	public void setChooserDisabled(){
		view.setSaveActionEnabled(false);
		view.setLoadActionEnabled(false);
	}
	
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
	
	private String getStringFromMatrix (char[][] c){
		String str = "";
		for(int i=0; i < c.length; i++){
			for(int j=0; j < c[0].length; j++){
				str += c[i][j];
			}
		}
		
		return str;
	}
	
	private char[][] getMatrixFromString(String s){
		int i = 0;
		char[][] matrix = new char[15][15];
		
		System.out.println("Size: " + s.length());	
		
		for(int j=0; j < 15; j++){
			for (int k=0; k < 15; k++, i++){
				System.out.print(s.charAt(i));					
				matrix[j][k] = s.charAt(i);
			}
		}
		
		System.out.println("i: " + i);
		
		
		return matrix;
	}
	
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
		System.out.println(str);
		return str;
	}
	
	private LinkedHashMap<LinkedList<int[]>, String> getHashMapFromString(String s){
		LinkedHashMap<LinkedList<int[]>, String> pos = new LinkedHashMap<LinkedList<int[]>, String>();
		List<String> items = Arrays.asList(s.split("\\s*,\\s*"));
		int j = 1;
		int size = Integer.parseInt(items.get(0));

		System.out.println("size = " + size);
		
		for (int i = 0; i < size; i++){
			String str = "";
			LinkedList<int[]> list = new LinkedList<int[]>();

			while (items.get(j).contains("str: ") == false){

				int[] vector = new int[Integer.parseInt(items.get(j))];
				int vectorSize = Integer.parseInt(items.get(j));
				System.out.println("vectorSize = " + vectorSize);
				
				for (int k = 0; k < vectorSize; k++, j++){

					System.out.println("k = " + k);
					System.out.println("j = " + j);
					
					vector[k] = Integer.parseInt(items.get(j+1));
					System.out.println("vector[k] = " + Integer.parseInt(items.get(j+1)));
				}

				list.add(vector);

				j++;
			}
			
			System.out.println("j = " + j);
			
			System.out.println("list = " + list.toString());
			System.out.println("str = " + items.get(j).substring(5));
			str = items.get(j).substring(5);
			pos.put(list, str);
			j++;
		}
		
		return pos;
	}
	
	
	
	private void loadFirstPlayerFromFile(String name, String map, String attackMap, String position){
		
		System.out.println("1");
		char[][] m = getMatrixFromString(map);
		System.out.println("2");
		char[][] a = getMatrixFromString(attackMap);
		System.out.println("3");
		LinkedHashMap<LinkedList<int[]>, String> pos = getHashMapFromString(position);
		System.out.println("4");
		
		player1.setName(name);
		player1.setMap(m);
		player1.setAttackMap(a);
		player1.setPosition(pos);
		
		String teste = getStringFromHashMap("position1: ", pos);
		String teste2 = getStringFromMatrix(m);
		String teste22 = getStringFromMatrix(a);
		System.out.println("Teste: " + teste);
		System.out.println("Teste2: " + teste2);
		System.out.println("Teste2: " + teste22);
		
		System.out.println(name);
		
	}
	
	private void loadSecondPlayerFromFile(String name, String map, String attackMap, String position){
		
		System.out.println("1");
		char[][] m = getMatrixFromString(map);
		System.out.println("2");
		char[][] a = getMatrixFromString(attackMap);
		System.out.println("3");
		LinkedHashMap<LinkedList<int[]>, String> pos = getHashMapFromString(position);
		System.out.println("4");
		
		player2.setName(name);
		player2.setMap(m);
		player2.setAttackMap(a);
		player2.setPosition(pos);
		
		System.out.println(name);
		
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Salvar Jogo")){
			System.out.println("actionPerformed:Save Game");
			saveFile();
			
		} else {
			System.out.println("actionPerformed:Load Game");
			openFile();
		}
	}
	
}
