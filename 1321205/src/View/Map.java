package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private char[][] map;

	/* Variaveis para desenhar mapa na posicao correta do mapa */

	private int marginX;
	private int marginY;

	/* Funcao para pegar dados necessarios para o desenho do mapa. */

	public void draw(char map[][], int marginX, int marginY) {
		addMouseListener(this);
		
		this.map = new char[map.length][map[0].length];
		this.marginX = marginX;
		this.marginY = marginY;

		for (int linha = 0; linha < map.length; linha++) {
			for (int coluna = 0; coluna < map[0].length; coluna++) {
				this.map[linha][coluna] = map[linha][coluna];
			}
		}
	}

	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		char letra = 64;
		Rectangle2D rect = new Rectangle2D.Float();
		
		/* PEÇAS - Primeira Seção */
		
		g.setColor(Color.RED);
		rect.setRect(60, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(90, 90, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(120, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		rect.setRect(180, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(210, 90, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(240, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		rect.setRect(300, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(330, 90, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(360, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		rect.setRect(420, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(450, 90, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(480, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		rect.setRect(540, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(570, 90, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(600, 120, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		/* PEÇAS - Segunda Seção */
		
		g.setColor(Color.GREEN);
		
		rect.setRect(60, 210, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(120, 210, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(180, 210, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(240, 210, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		/* PEÇAS - Terceira Seção */
		
		g.setColor(Color.YELLOW);
		
		rect.setRect(60, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(90, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(150, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(180, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(240, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(270, 300, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		/* PEÇAS - Quarta Seção */
		
		g.setColor(Color.ORANGE);
		
		rect.setRect(60, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(90, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(120, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(150, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		rect.setRect(210, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(240, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(270, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(300, 390, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		/* PEÇAS - Quinta Seção */
		
		g.setColor(Color.GRAY);
		
		rect.setRect(60, 480, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(90, 480, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(120, 480, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(150, 480, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(180, 480, 30, 30);
		g.draw(rect);
		g.fill(rect);

		g.setColor(Color.BLACK);

		for (int linha = 0; linha < map.length; linha++) {
			letra++;
			g.drawString("" + letra + "", marginX - 15, marginY + 20 + (30 * linha));
			for (int coluna = 0; coluna < map[0].length; coluna++) {
				g.drawString(Integer.toString(coluna + 1), marginX + 10 + (30 * coluna), marginY - 10);
				g.setColor(Color.WHITE);
				rect.setRect(marginX + (30 * linha), marginY + (30 * coluna), 30, 30);
				g.draw(rect);
				g.fill(rect);
				g.setColor(Color.BLACK);
				g.drawRect(marginX + (30 * linha), marginY + (30 * coluna), 30, 30);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		char letra = 64;
		
		if(x < marginX || x > marginX + 450 || y < marginY || y > marginY + 450){
			System.out.println("click fora do mapa");
		}
		else {
			x-=marginX;
			y-=marginY;
			x/=30;
			y/=30;
			x+=1;
			letra+=(y+1);
			System.out.println(letra + " ---- " + Integer.toString(x));
		}
	}
}
