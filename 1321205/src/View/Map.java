package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Map extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private char[][] map;
	
	/* Variáves para desenhar mapa na posição correta do mapa */
	
	private int marginX;
	private int marginY;
	
	/* Função para pegar dados necessários para o desenho do mapa. */
	
	public void draw(char map[][], int marginX, int marginY){
		this.map = new char[map.length][map[0].length];
		this.marginX = marginX;
		this.marginY = marginY;
		
		for(int linha=0; linha < map.length; linha++){
            for(int coluna=0; coluna < map[0].length; coluna++){
            	this.map[linha][coluna] = map[linha][coluna];
            }
	    }
	}
	
	public void paintComponent(Graphics graphics){
		Graphics2D g = (Graphics2D) graphics;
		char letra = 64;
		
		for(int linha=0; linha < map.length; linha++){
			letra++;
			g.drawString(""+letra+"",marginX - 15,marginY + 20 +(30*linha));
			for(int coluna=0; coluna < map[0].length; coluna++){
				g.drawString(Integer.toString(coluna+1),marginX + 10 +(30*coluna),marginY - 10);
				g.setColor(Color.WHITE);
				g.fillRect(marginX+(30*linha),marginY+(30*coluna),30,30);
				g.setColor(Color.BLACK);
				g.drawRect(marginX+(30*linha),marginY+(30*coluna),30,30);
			}
		}
	}
}
