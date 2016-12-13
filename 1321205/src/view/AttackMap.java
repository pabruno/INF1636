package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import controller.AttackController;

/** 
 * Classe "AttackMap"
 * 
 * Descrição:
 * - Mapa de ataques desenhado por componentes gráficos;
 * 
 */

public class AttackMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AttackController controller;
	
	private char[][] shipMap;
	private char[][] attackMap;
	
	private int marginXattack;
	private int marginXship;
	private int marginY;

	private Graphics2D g;
	
	public AttackMap(AttackController controller){
		this.controller = controller;
		addMouseListener(this.controller);
	}

	public void draw(char shipMap[][], char attackMap[][], int marginXShip, int marginXAttack, int marginY) {
		this.setFocusable(true);
		this.requestFocusInWindow();

		this.shipMap = shipMap;
		this.attackMap = attackMap;
		this.marginXattack = marginXAttack;
		this.marginY = marginY;

		this.marginXship = marginXShip;
	}
	
	public char[][] getShipMap(){
		return shipMap;
	}
	
	public char[][] getAttackMap(){
		return attackMap;
	}

	public void paintComponent(Graphics graphics) {
		g = (Graphics2D) graphics;

		g.setColor(Color.BLACK);
		char letra = 64;

		Rectangle2D rect = new Rectangle2D.Float();

		for (int linha = 0; linha < attackMap.length; linha++) {
			letra++;
			g.drawString("" + letra + "", marginXattack - 15, marginY + 20 + (30 * linha));
			for (int coluna = 0; coluna < attackMap[0].length; coluna++) {
				g.drawString(Integer.toString(coluna + 1), marginXattack + 10 + (30 * coluna), marginY - 10);

				switch (attackMap[coluna][linha]) {
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
					
				case 'N':
					g.setColor(Color.RED);
					break;
				}
				
				rect.setRect(marginXattack + (30 * linha), marginY + (30 * coluna), 30, 30);
				g.draw(rect);
				g.fill(rect);
				g.setColor(Color.BLACK);
				g.drawRect(marginXattack + (30 * linha), marginY + (30 * coluna), 30, 30);
			}
		}

		letra = 64;

		for (int linha = 0; linha < shipMap.length; linha++) {
			letra++;
			g.drawString("" + letra + "", marginXship - 15, marginY + 20 + (30 * linha));
			for (int coluna = 0; coluna < shipMap[0].length; coluna++) {
				g.drawString(Integer.toString(coluna + 1), marginXship + 10 + (30 * coluna), marginY - 10);

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

				rect.setRect(marginXship + (30 * linha), marginY + (30 * coluna), 30, 30);
				g.draw(rect);
				g.fill(rect);
				g.setColor(Color.BLACK);
				g.drawRect(marginXship + (30 * linha), marginY + (30 * coluna), 30, 30);
			}
		}
	}
}
