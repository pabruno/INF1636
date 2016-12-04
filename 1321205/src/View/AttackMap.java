package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class AttackMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private char[][] shipMap;
	private char[][] attackMap;
	
	private int marginXattack;
	private int marginYattack;
	private int marginXship;
	private int marginYship;

	private Graphics2D g;

	public void draw(char shipMap[][], char attackMap[][], int marginX, int marginY) {
		this.setFocusable(true);
		this.requestFocusInWindow();

		this.shipMap = shipMap;
		this.attackMap = attackMap;
		this.marginXattack = marginX + 70;
		this.marginYattack = marginY;

		this.marginXship = 30;
		this.marginYship = marginY;
	}

	public void paintComponent(Graphics graphics) {
		g = (Graphics2D) graphics;

		g.setColor(Color.BLACK);
		char letra = 64;

		Rectangle2D rect = new Rectangle2D.Float();

		for (int linha = 0; linha < attackMap.length; linha++) {
			letra++;
			g.drawString("" + letra + "", marginXattack - 15, marginYattack + 20 + (30 * linha));
			for (int coluna = 0; coluna < attackMap[0].length; coluna++) {
				g.drawString(Integer.toString(coluna + 1), marginXattack + 10 + (30 * coluna), marginYattack - 10);

				if (attackMap[coluna][linha] == 'V') {
					g.setColor(Color.WHITE);
				} else {
					g.setColor(Color.RED);
				}
				rect.setRect(marginXattack + (30 * linha), marginYattack + (30 * coluna), 30, 30);
				g.draw(rect);
				g.fill(rect);
				g.setColor(Color.BLACK);
				g.drawRect(marginXattack + (30 * linha), marginYattack + (30 * coluna), 30, 30);
			}
		}

		letra = 64;

		for (int linha = 0; linha < shipMap.length; linha++) {
			letra++;
			g.drawString("" + letra + "", marginXship - 15, marginYship + 20 + (30 * linha));
			for (int coluna = 0; coluna < shipMap[0].length; coluna++) {
				g.drawString(Integer.toString(coluna + 1), marginXship + 10 + (30 * coluna), marginYship - 10);

				switch (shipMap[coluna][linha]) {
				case 'H':
					g.setColor(Color.BLUE);
					break;

				case 'S':
					g.setColor(Color.GREEN);
					break;

				case 'D':
					g.setColor(Color.YELLOW);
					break;

				case 'C':
					g.setColor(Color.ORANGE);
					break;

				case 'B':
					g.setColor(Color.GRAY);
					break;
					
				case 'V':
					g.setColor(Color.WHITE);
					break;
				}

				rect.setRect(marginXship + (30 * linha), marginYship + (30 * coluna), 30, 30);
				g.draw(rect);
				g.fill(rect);
				g.setColor(Color.BLACK);
				g.drawRect(marginXship + (30 * linha), marginYship + (30 * coluna), 30, 30);
			}
		}
	}
}
