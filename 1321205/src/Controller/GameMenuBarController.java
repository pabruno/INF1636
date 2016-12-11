package Controller;

import View.GameMenuBar;

public class GameMenuBarController {
	
	private GameMenuBar view;
	
	public GameMenuBarController(GameMenuBar menuBar){
		this.view = menuBar;
	}
	
	public GameMenuBar getView(){
		return view;
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
	
}
