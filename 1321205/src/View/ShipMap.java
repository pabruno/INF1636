package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipMap extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private char[][] map;
	private Map<Rectangle2D, String> weapons;
	private Graphics2D g;

	/* Variaveis para desenhar mapa na posicao correta do mapa */

	private int marginX;
	private int marginY;

	private int x;
	private int y;
	
	/* Funcao para pegar dados necessarios para o desenho do mapa. */

	public void draw(char map[][], int marginX, int marginY) {
		addMouseMotionListener(this);
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
	
	private Rectangle2D Hydroplane(Graphics2D g, int x, int y){
		
		Rectangle2D rect = new Rectangle2D.Float();
		
		/* Container */
		g.setColor(Color.WHITE);
		rect.setRect(x, y, 90, 60);
		g.draw(rect);
		g.fill(rect);
		
		g.setColor(Color.RED);
		rect.setRect(x, y+30, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+60, y+30, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		return rect;
	}
	
    private Rectangle2D Submarine(Graphics2D g, int x, int y){
		
		Rectangle2D rect = new Rectangle2D.Float();
		
        g.setColor(Color.GREEN);
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		return rect;
		
	}
    
    private Rectangle2D Destroyer(Graphics2D g, int x, int y){
		
		Rectangle2D rect = new Rectangle2D.Float();
		
		g.setColor(Color.YELLOW);
		
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		return rect;
	}
    
    private Rectangle2D Cruiser(Graphics2D g, int x, int y){
		
		Rectangle2D rect = new Rectangle2D.Float();
		
		g.setColor(Color.ORANGE);
		
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+60, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+90, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		return rect;
		
	}
    
    private Rectangle2D Battleship(Graphics2D g, int x, int y){
		
 		Rectangle2D rect = new Rectangle2D.Float();
 		
 		g.setColor(Color.GRAY);
		
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+60, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+90, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		rect.setRect(x+120, y, 30, 30);
		g.draw(rect);
		g.fill(rect);
		
		return rect;
 		
 	}
    

	public void paintComponent(Graphics graphics) {
		
		weapons = new HashMap<Rectangle2D, String>();
		g = (Graphics2D) graphics;
		
		/* PEÇAS - Primeira Seção */
		
		weapons.put(Hydroplane(g, 60, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 180, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 300, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 420, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 540, 90), "Hydroplane");
		
		/* PEÇAS - Segunda Seção */
		
		weapons.put(Submarine(g, 60, 210), "Submarine");
		weapons.put(Submarine(g, 120, 210), "Submarine");
		weapons.put(Submarine(g, 180, 210), "Submarine");
		weapons.put(Submarine(g, 240, 210), "Submarine");
		
		/* PEÇAS - Terceira Seção */
		
		weapons.put(Destroyer(g, 60, 300), "Destroyer");
		weapons.put(Destroyer(g, 150, 300), "Destroyer");
		weapons.put(Destroyer(g, 240, 300), "Destroyer");
		
		/* PEÇAS - Quarta Seção */

		weapons.put(Cruiser(g, 60, 390), "Cruiser");
		weapons.put(Cruiser(g, 210, 390), "Cruiser");
		
		/* PEÇAS - Quinta Seção */
		
		weapons.put(Battleship(g, 60, 480),"Battleship");

		/* MAPA */
		
		g.setColor(Color.BLACK);
		char letra = 64;
		Rectangle2D rect = new Rectangle2D.Float();

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
		System.out.println("Mouse Pressed");
		x = e.getX();
		y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseDragged(MouseEvent e){
		System.out.println("Mouse Dragged");
		
		int dx = e.getX() - x;
	    int dy = e.getY() - y;
	      
	    for (Entry<Rectangle2D, String> r : weapons.entrySet()){
	    	//System.out.println("Mouse Dragged" + r.getBounds2D().toString() + "x:" + x + "y:" + y);
	    	
	   	  	if (r.getKey().getBounds2D().contains(x, y)){
	   	  		System.out.println("Mouse Dragged - Move & Repaint" + r.getValue());
	   	  		
	   	  		switch (r.getValue()){
	   	  		
	   	  			case "Hydroplane": 
	   	  				Hydroplane(g, dx, dy);
	   	  				
	   	  			case "Submarine": 
	   	  				Submarine(g, dx, dy);
	   	  				
	   	  			case "Destroyer": 
	   	  				Destroyer(g, dx, dy);
	   	  				
	   	  		    case "Cruiser": 
	   	  		    	Cruiser(g, dx, dy);
	   	  		    	
	   	  			case "Battleship": 
	   	  				Battleship(g, dx, dy);
	   	  		}
	   	  }
	    }
	    
	    x += dx;
	    y += dy;
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

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
