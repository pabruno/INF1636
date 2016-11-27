package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

public class ShipMap extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private char[][] map;
	private LinkedHashMap<LinkedList<Rectangle2D>, String> weapons;
	private Graphics2D g;

	/* Vari�veis para movimento de peca */

	private String type = null;
	private LinkedList<Rectangle2D> initialPosition;
	private LinkedList<Rectangle2D> finalPosition;

	/* Variaveis para desenhar mapa na posicao correta do mapa */

	private int marginX;
	private int marginY;

	private int x;
	private int y;
	
	private int xy[][];
	private int i;
	private int j;
	private Boolean firstDraw = true;
	private int currentWeapon;
	private int degrees[];

	/* Funcao para pegar dados necessarios para o desenho do mapa. */
	
	public void draw(char map[][], int marginX, int marginY) {
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		
		this.setFocusable(true);
        this.requestFocusInWindow();

		this.map = new char[map.length][map[0].length];
		this.marginX = marginX;
		this.marginY = marginY;

		for (int linha = 0; linha < map.length; linha++) {
			for (int coluna = 0; coluna < map[0].length; coluna++) {
				this.map[linha][coluna] = map[linha][coluna];
			}
		}
	}
	
	private void initWeapons(){
		
		/* POSICAO - Primeira Secao - X e Y */
		
		xy = new int[10][5];
		xy[0][0] = 60;
		xy[0][1] = 180;
		xy[0][2] = 300;
		xy[0][3] = 420;
		xy[0][4] = 540;
		
		xy[1][0] = 90;
		xy[1][1] = 90;
		xy[1][2] = 90;
		xy[1][3] = 90;
		xy[1][4] = 90;
		
		/* POSICAO - Segunda Secao - X e Y */
		
		xy[2][0] = 60;
		xy[2][1] = 120;
		xy[2][2] = 180;
		xy[2][3] = 240;
		
		xy[3][0] = 210;
		xy[3][1] = 210;
		xy[3][2] = 210;
		xy[3][3] = 210;
		
		/* POSICAO - Terceira Secao - X e Y */
		
		xy[4][0] = 60;
		xy[4][1] = 150;
		xy[4][2] = 240;
		
		xy[5][0] = 300;
		xy[5][1] = 300;
		xy[5][2] = 300;
		
		/* POSICAO - Quarta Secao - X e Y */
		
		xy[6][0] = 60;
		xy[6][1] = 210;
		
		xy[7][0] = 390;
		xy[7][1] = 390;
		
		/* POSICAO - Quinta Secao - X e Y */
		
		xy[8][0] = 60;
		
		xy[9][0] = 480;
		
		degrees = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		firstDraw = false;
		
	}
	
	private void paintWeapons (Graphics graphics){
		
		weapons = new LinkedHashMap<LinkedList<Rectangle2D>, String>();
		g = (Graphics2D) graphics;
		
		if (firstDraw){
			initWeapons();
		}
		
		/* PECAS - Primeira Secao */

		weapons.put(Hydroplane(g, xy[0][0], xy[1][0]), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][1], xy[1][1]), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][2], xy[1][2]), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][3], xy[1][3]), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][4], xy[1][4]), "Hydroplane");

		/* PECAS - Segunda Secao */

		weapons.put(Submarine(g, xy[2][0], xy[3][0]), "Submarine");
		weapons.put(Submarine(g, xy[2][1], xy[3][1]), "Submarine");
		weapons.put(Submarine(g, xy[2][2], xy[3][2]), "Submarine");
		weapons.put(Submarine(g, xy[2][3], xy[3][3]), "Submarine");

		/* PECAS - Terceira Secao */

		weapons.put(Destroyer(g, xy[4][0], xy[5][0]), "Destroyer");
		weapons.put(Destroyer(g, xy[4][1], xy[5][1]), "Destroyer");
		weapons.put(Destroyer(g, xy[4][2], xy[5][2]), "Destroyer");

		/* PECAS - Quarta Secao */

		weapons.put(Cruiser(g, xy[6][0], xy[7][0]), "Cruiser");
		weapons.put(Cruiser(g, xy[6][1], xy[7][1]), "Cruiser");

		/* PECAS - Quinta Secao */

		weapons.put(Battleship(g, xy[8][0], xy[9][0]), "Battleship");
	}

	public void paintComponent(Graphics graphics) {

		System.out.println("Repaint");
		g = (Graphics2D) graphics;

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
		
		paintWeapons(graphics);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
		
		System.out.println(type);

		if (type != null) {
			System.out.println("posicao: " + x + " --- " + y);
			System.out.println(type);
			
			for (int i = 0; i < finalPosition.size(); i++) {
				System.out.println("finalPosition: " + finalPosition.get(i).getX()+ " --- " + finalPosition.get(i).getY());
			}
			
			for (int j = 0; j < initialPosition.size(); j++){
				System.out.println("initialPosition: " + initialPosition.get(j).getX()+ " --- " + initialPosition.get(j).getY());
			}

			switch (type) {
			case "Hydroplane":
				finalPosition = Hydroplane(g, x, y);
				xy[0][i] = x;
				xy[1][j] = y;
				break;

			case "Submarine":
				finalPosition = Submarine(g, x, y);
				
				xy[2][i] = x;
				xy[3][j] = y;
				break;

			case "Destroyer":
				finalPosition = Destroyer(g, x, y);
				xy[4][i] = x;
				xy[5][j] = y;
				break;

			case "Cruiser":
				finalPosition = Cruiser(g, x, y);
				xy[6][i] = x;
				xy[7][j] = y;
				break;

			case "Battleship":
				finalPosition = Battleship(g, x, y);
				xy[8][i] = x;
				xy[9][j] = y;
				break;
			}
			
			repaint();
			System.out.println("################");
		}
	}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		
		if (e.getButton() == 3){
			degrees[currentWeapon] =+ 90;
			repaint();
		} else {

		char letra = 64;

		if (x > marginX && x < marginX + 450 && y > marginY && y < marginY + 450) {
			x -= marginX;
			y -= marginY;
			x /= 30;
			y /= 30;
			x += 1;
			letra += (y + 1);
			System.out.println(letra + " ---- " + Integer.toString(x));
		} else {
			int index = 0;
			for (Entry<LinkedList<Rectangle2D>, String> r : weapons.entrySet()) {

				for (int i = 0; i < r.getKey().size(); i++) {
					if (r.getKey().get(i).getBounds2D().contains(x, y)) {
						
						System.out.println(index);
						currentWeapon = index;
						
						/* TODO: Refactor */
						
						switch (index){
							case 0: case 1: case 2: case 3: case 4:
								i = index;
								j = index;
								break;
							case 5: case 6: case 7: case 8:
								i = index - 5;
								j = index - 5;
								break;
							case 9: case 10: case 11:
								i = index - 9;
								j = index - 9;
								break;
							case 12: case 13:
								i = index - 12;
								j = index - 12;
								break;
							case 14:
								i = index - 14;
								j = index - 14;
								break;
						}
						
						switch (r.getValue()) {
						case "Hydroplane":
							type = "Hydroplane";
							break;

						case "Submarine":
							type = "Submarine";
							break;

						case "Destroyer":
							type = "Destroyer";
							break;

						case "Cruiser":
							type = "Cruiser";
							break;

						case "Battleship":
							type = "Battleship";
							break;
						}
						
						initialPosition = r.getKey();
						finalPosition = r.getKey();
						
						
						if (type != null)
							break;
					}
				}
				index++;
			}
		  }
		}
	}

	public void mouseEntered(MouseEvent e) {

	}
	
	private LinkedList<Rectangle2D> Hydroplane(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		System.out.println("novo: " + x + " -- " + y);

		g.setColor(Color.RED);
		rect.setRect(x, y + 30, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y + 30, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);

		return rects;
	}

	private LinkedList<Rectangle2D> Submarine(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.GREEN);
		rect.setRect(x, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);

		return rects;

	}

	private LinkedList<Rectangle2D> Destroyer(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.YELLOW);

		rect.setRect(x, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);

		return rects;
	}

	private LinkedList<Rectangle2D> Cruiser(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.ORANGE);

		rect.setRect(x, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 90, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);

		return rects;

	}

	private LinkedList<Rectangle2D> Battleship(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.GRAY);

		rect.setRect(x, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 90, y, 30, 30);
		g.rotate(Math.toRadians(degrees[weapons.size()-1]));
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 120, y, 30, 30);
		
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);

		return rects;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE)
	    {
			System.out.println("ESC");
	        type = null;
	    }
	}

}