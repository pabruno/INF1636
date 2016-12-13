package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogBox {
	private JFrame frame = new JFrame();
	private int click;

	public void showDialog() {
		Object[] options = { "SIM", "NAO" };

		this.click = JOptionPane.showOptionDialog(frame, "Jogar novamente ?", "Batalha Naval",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
		        null, options, options[0]);
	}
	
	public int getClick(){
		return this.click;
	}
}
