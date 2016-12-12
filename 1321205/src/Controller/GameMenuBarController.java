package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.swing.JFileChooser;

import Model.Player;
import View.GameMenuBar;

public class GameMenuBarController implements ActionListener {
	
	private GameMenuBar view;
	private Player player1;
	private Player player2;
	private int round;
	
	public GameMenuBarController(GameMenuBar menuBar){
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
	
	public void setFirstPlayerToSave(Player p){
		player1 = p;
	}
	
	public void setSecondPlayerToSave(Player p){
		player2 = p;
	}
	
	public void setRound(int r){
		round = r;
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
	
	private String getStringFromHashMap (LinkedHashMap<LinkedList<int[]>, String> position){
		String str = "";
		for (Entry<LinkedList<int[]>, String> entry : position.entrySet()) {
	
			 LinkedList<int[]> key = entry.getKey();
			 String keyCount = Integer.toString(key.size());
			 String value = entry.getValue();
			 
			 str += keyCount;
			 str += "\n";
			 
			 for (int i = 0; i < key.size(); i++) {
				 str += Integer.toString(key.get(i).length);
				 str += "\n";
				 for (int j = 0; j < key.get(i).length; j++){
					 str += Integer.toString(key.get(i)[j]);
					 str += "\n";
				 }
			 }
			 
			 str += value;
			 
		}
		System.out.println(str);
		return str;
	}
	
	private Player createPlayer(String name, String map, String attackMap, String position){
		return new Player();
	}
	public void openFile(){
		
		String player = "";
		
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
				int lineCount = 0;
				String line = "";
				
				while((line = bufferedReader.readLine()) != null) {
					switch (lineCount){
						case 0:
							player = line;
							break;
						case 1:
							map1 = line;
							break;
						case 2: 
							attack1 = line;
							break;
						case 3:
							map2 = line;
							break;
						case 4:
							attack2 = line;
							break;
					}
					
					lineCount++;
				}
				
				System.out.println(player + "\n" + map1 + "\n" + attack1 + "\n" + map2 + "\n" + attack2);
				bufferedReader.close();
				
			}catch (Exception e){
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public void saveFile(){
		
		String player = AttackController.getPlayer();
		
		String name1 = player1.getName();
		String map1 = getStringFromMatrix(player1.getMyMap());
		String attack1 = getStringFromMatrix(player1.getAttackMap());
		String position1 = getStringFromHashMap(player1.getPosition());
		
		String name2 = player2.getName();
		String map2 = getStringFromMatrix(player2.getMyMap());
		String attack2 = getStringFromMatrix(player2.getAttackMap());
		String position2 = getStringFromHashMap(player2.getPosition());
		
		JFileChooser fileChooser = new JFileChooser(new File("Documents"));
		fileChooser.setDialogTitle("Salvar Jogo");
		int result = fileChooser.showSaveDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION){
			
			File file = fileChooser.getSelectedFile();
			
			try {
				FileWriter fileWriter = new FileWriter(file.getPath());
				fileWriter.write(player + "\n" + name1 + "\n" + map1 + "\n" + attack1 + "\n" + position1 + "\n" + name2 + "\n" + map2 + "\n" + attack2 + "\n" + position2);
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
