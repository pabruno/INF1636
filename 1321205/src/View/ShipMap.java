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
	private Cont cont = new Cont();

	/* Variaveis para movimento de peca */

	private String type = null;
	private LinkedList<Rectangle2D> initialPosition;
	private LinkedList<Rectangle2D> finalPosition;

	/* Posicao dos navios que foram colocados no mapa */

	private LinkedHashMap<LinkedList<int[]>, String> position = new LinkedHashMap<LinkedList<int[]>, String>();

	/* Variaveis para desenhar mapa na posicao correta do mapa */

	private int marginX;
	private int marginY;

	private int x;
	private int y;

	private int xy[][];
	private int i;
	private int j;
	
	private Boolean isFirst = true;
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

	public char[][] getMap() {
		return map;
	}

	public LinkedHashMap<LinkedList<int[]>, String> getPosition() {
		return position;
	}

	private void initWeapons() {

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

		degrees = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		firstDraw = false;

	}

	private void paintWeapons(Graphics graphics) {

		weapons = new LinkedHashMap<LinkedList<Rectangle2D>, String>();
		g = (Graphics2D) graphics;
		isFirst = true;

		if (firstDraw) {
			initWeapons();
		}

		/* PECAS - Primeira Secao */

		weapons.put(Hydroplane(g, xy[0][0], xy[1][0], 0), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][1], xy[1][1], 1), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][2], xy[1][2], 2), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][3], xy[1][3], 3), "Hydroplane");
		weapons.put(Hydroplane(g, xy[0][4], xy[1][4], 4), "Hydroplane");

		/* PECAS - Segunda Secao */

		weapons.put(Submarine(g, xy[2][0], xy[3][0], 5), "Submarine");
		weapons.put(Submarine(g, xy[2][1], xy[3][1], 6), "Submarine");
		weapons.put(Submarine(g, xy[2][2], xy[3][2], 7), "Submarine");
		weapons.put(Submarine(g, xy[2][3], xy[3][3], 8), "Submarine");

		/* PECAS - Terceira Secao */

		weapons.put(Destroyer(g, xy[4][0], xy[5][0], 9), "Destroyer");
		weapons.put(Destroyer(g, xy[4][1], xy[5][1], 10), "Destroyer");
		weapons.put(Destroyer(g, xy[4][2], xy[5][2], 11), "Destroyer");

		/* PECAS - Quarta Secao */

		weapons.put(Cruiser(g, xy[6][0], xy[7][0], 12), "Cruiser");
		weapons.put(Cruiser(g, xy[6][1], xy[7][1], 13), "Cruiser");

		/* PECAS - Quinta Secao */

		weapons.put(Battleship(g, xy[8][0], xy[9][0], 14), "Battleship");

	}

	public void paintComponent(Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		super.paintComponent(graphics);

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

		x = e.getX();
		y = e.getY();

		if (type != null) {

			switch (type) {
			case "Hydroplane":

				finalPosition = Hydroplane(g, x+15, y+45, currentWeapon);

				xy[0][i] = x - 15;
				xy[1][j] = y - 45;
				break;

			case "Submarine":

				finalPosition = Submarine(g, x+15, y+15, currentWeapon);

				xy[2][i] = x - 15;
				xy[3][j] = y - 15;
				break;

			case "Destroyer":

				finalPosition = Destroyer(g, x+15, y+15, currentWeapon);

				xy[4][i] = x - 15;
				xy[5][j] = y - 15;
				break;

			case "Cruiser":

				finalPosition = Cruiser(g, x+15, y+15, currentWeapon);

				xy[6][i] = x - 15;
				xy[7][j] = y - 15;
				break;

			case "Battleship":

				finalPosition = Battleship(g, x+15, y+15, currentWeapon);
				xy[8][i] = x - 15;
				xy[9][j] = y - 15;
				break;
			}
			System.out.println("Final - Moved:" + finalPosition);
			repaint();
			System.out.println("Final - Moved:" + finalPosition);
			System.out.println("################");
		}
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getButton() == 3) {
			
			if (type != null){
				
				System.out.println(degrees);


			if (type != null) {

				if (type == "Hydroplane") {
					if (degrees[currentWeapon] == 0) {
						degrees[currentWeapon] = 1;
					} else if (degrees[currentWeapon] == 1) {
						degrees[currentWeapon] = 2;
					} else if (degrees[currentWeapon] == 2) {
						degrees[currentWeapon] = 3;
					} else {
						degrees[currentWeapon] = 0;
					}
				} else if (degrees[currentWeapon] == 1) {
					degrees[currentWeapon] = 0;
				} else {
					degrees[currentWeapon] = 1;
				}

			} else if (degrees[currentWeapon] == 1){
				degrees[currentWeapon] = 0;
			} else {
				degrees[currentWeapon] = 1;
			}
			repaint();
			
			switch (type) {
			case "Hydroplane":
				finalPosition = Hydroplane(g, x+15, y+45, currentWeapon);
				break;

			case "Submarine":
				finalPosition = Submarine(g, x+15, y+15, currentWeapon);
				break;

			case "Destroyer":
				finalPosition = Destroyer(g, x+15, y+15, currentWeapon);
				break;

			case "Cruiser":
				finalPosition = Cruiser(g, x+15, y+15, currentWeapon);
				break;

			case "Battleship":
				finalPosition = Battleship(g, x+15, y+15, currentWeapon);
				break;
			}
			
			System.out.println("Final - Rotated:" + finalPosition);

			}

		} else {
			int index = 0;
			for (Entry<LinkedList<Rectangle2D>, String> r : weapons.entrySet()) {

				for (int cont = 0; cont < r.getKey().size(); cont++) {
					if (r.getKey().get(cont).getBounds2D().contains(x, y)) {

						currentWeapon = index;


						/* TODO: Refactor */

						switch (index) {
						case 0:
						case 1:
						case 2:
						case 3:
						case 4:
							i = index;
							j = index;
							break;
						case 5:
						case 6:
						case 7:
						case 8:
							i = index - 5;
							j = index - 5;
							break;
						case 9:
						case 10:
						case 11:
							i = index - 9;
							j = index - 9;
							break;
						case 12:
						case 13:
							i = index - 12;
							j = index - 12;
							break;
						case 14:
							i = index - 14;
							j = index - 14;
							break;
						}

						type = r.getValue();

						initialPosition = r.getKey();

						if (type != null)
							break;
					}
				}
				index++;
			}
			
			if (this.x > marginX && this.x < marginX + 450 && this.y > marginY && this.y < marginY + 450) {
				int x, y;
				boolean removeFromMap = false;
				
				y = (this.x - marginX)/30;
				x = (this.y - marginY)/30;
				
				for (Entry<LinkedList<int[]>, String> r : position.entrySet()) {
					for (int i = 0; i < r.getKey().size(); i++) {
						if(r.getKey().get(i)[0] == x && r.getKey().get(i)[1] == y){
							removeFromMap = true;
							break;
						}
					}
					
					if(removeFromMap){
						removeFromMap = false;
						
						for (int j = 0; j < r.getKey().size(); j++) {
							this.map[r.getKey().get(j)[0]][r.getKey().get(j)[1]] = 'V';
						}
						
						position.remove(r);
						break;
					}
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	private LinkedList<Rectangle2D> Hydroplane(Graphics2D g, int x, int y, int currentIndex) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		// System.out.println("novo: " + x + " -- " + y);

		g.setColor(Color.BLUE);
		
		if (isFirst){
			if (degrees[0] == 0){
			
				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);

			} else if (degrees[0] == 1){

				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			} else if (degrees[0] == 2) {

				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			} else {
				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			}
			isFirst = false;
		} else {
			if (degrees[currentIndex] == 0){
		
				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				
			} else if (degrees[currentIndex] == 1){
				System.out.println("1");
				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			} else if (degrees[currentIndex] == 2){

				rect.setRect(x, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			} else {
				rect.setRect(x + 30, y, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 60, y + 30, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
				rect = new Rectangle2D.Float();

				rect.setRect(x + 30, y + 60, 30, 30);
				g.draw(rect);
				g.fill(rect);

				rects.add(rect);
			}
		}
		
		if (currentIndex == currentWeapon){

			finalPosition = rects;
		}

		return rects;
	}

	private LinkedList<Rectangle2D> Submarine(Graphics2D g, int x, int y, int currentIndex) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.GREEN);
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		rects.add(rect);
		
		if (currentIndex == currentWeapon){
			finalPosition = rects;
		}

		return rects;

	}

	private LinkedList<Rectangle2D> Destroyer(Graphics2D g, int x, int y, int currentIndex) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.YELLOW);

		if (degrees[currentIndex] == 0){

			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 30, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
		} else {
			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 30, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
		}
		
		if (currentIndex == currentWeapon){

			finalPosition = rects;
		}

		return rects;
	}

	private LinkedList<Rectangle2D> Cruiser(Graphics2D g, int x, int y, int currentIndex) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.ORANGE);
		
		if (degrees[currentIndex] == 0){

			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 30, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 60, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 90, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);

		} else {
			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);
			System.out.println("FINAL: " + rect.getX() + " --- " + rect.getY());
			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 30, 30, 30);
			g.draw(rect);
			g.fill(rect);
			System.out.println("FINAL: " + rect.getX() + " --- " + rect.getY());
			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 60, 30, 30);
			g.draw(rect);
			g.fill(rect);
			System.out.println("FINAL: " + rect.getX() + " --- " + rect.getY());
			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 90, 30, 30);
			g.draw(rect);
			g.fill(rect);
			System.out.println("FINAL: " + rect.getX() + " --- " + rect.getY());
			rects.add(rect);
		}

		if (currentIndex == currentWeapon){
			finalPosition = rects;
		}

		return rects;

	}

	private LinkedList<Rectangle2D> Battleship(Graphics2D g, int x, int y, int currentIndex) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> rects = new LinkedList<Rectangle2D>();

		g.setColor(Color.GRAY);

		if (degrees[currentIndex] == 0){

			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 30, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 60, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 90, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x + 120, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);

		} else {

			rect.setRect(x, y, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 30, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 60, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 90, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
			rect = new Rectangle2D.Float();

			rect.setRect(x, y + 120, 30, 30);
			g.draw(rect);
			g.fill(rect);

			rects.add(rect);
		}
		
		if (currentIndex == currentWeapon){

			finalPosition = rects;
		}

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
		int[] shipPosition;
		boolean shipSet;
		LinkedList<int[]> weaponPosition;

		if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("ESC");
			if (type != null) {
				shipSet = putShipInMap();
				repaint();

				if (shipSet == true) {
					if(cont.getCont() == 0) {
						cont.sumCont();
					}
					
					weaponPosition = new LinkedList<int[]>();
					for (int i = 0; i < finalPosition.size(); i++) {

						System.out.println("Final - Esc:" + finalPosition);
						shipPosition = new int[2];

						shipPosition[1] = (((int) finalPosition.get(i).getX() + 15) - marginX) / 30;
						shipPosition[0] = (((int) finalPosition.get(i).getY() + 15) - marginY) / 30;

						weaponPosition.add(shipPosition);
						
						this.map[shipPosition[0]][shipPosition[1]] = type.charAt(0);
					}
					position.put(weaponPosition, type);
				}
				for (Entry<LinkedList<int[]>, String> r : position.entrySet()) {
					System.out.println("POSITION:" + r.getValue());
					for (int i = 0; i < r.getKey().size(); i++) {
						System.out.println(r.getKey().get(i)[0] + " --- " + r.getKey().get(i)[1]);
					}
				}
				type = null;
			}
		}
	}

	private boolean putShipInMap() {
		int x = this.x;
		int y = this.y;
		boolean put = true;

		if (this.x > marginX && this.x < marginX + 450 && this.y > marginY && this.y < marginY + 450) {
			x -= marginX;
			y -= marginY;
			x /= 30;
			y /= 30;

			put = checkShip(y, x);
			if (put) {
				switch (type) {
				case "Hydroplane":
					if ((degrees[currentWeapon] == 0 && y - 1 >= 0 && x + 2 <= 14)
							|| (degrees[currentWeapon] == 1 && y - 1 >= 0 && y + 1 <= 14)
							|| (degrees[currentWeapon] == 2 && y + 1 <= 14 && x + 2 <= 14)
							|| (degrees[currentWeapon] == 3 && y + 1 <= 14 && y - 1 >= 0 && x + 2 <= 14)) {
						xy[0][i] = marginX + (30 * x);
						xy[1][j] = marginY + (30 * (y - 1));
						put = true;
					}
					break;

				case "Submarine":
					xy[2][i] = marginX + (30 * x);
					xy[3][j] = marginY + (30 * y);
					put = true;
					break;

				case "Destroyer":
					if ((degrees[currentWeapon] == 0 && x + 1 <= 14) || (degrees[currentWeapon] == 1 && y + 1 <= 14)) {
						xy[4][i] = marginX + (30 * x);
						xy[5][j] = marginY + (30 * y);
						put = true;
					}
					break;

				case "Cruiser":
					if ((degrees[currentWeapon] == 0 && x + 3 <= 14) || (degrees[currentWeapon] == 1 && y + 3 <= 14)) {
						xy[6][i] = marginX + (30 * x);
						xy[7][j] = marginY + (30 * y);
						put = true;
					}
					break;

				case "Battleship":
					if ((degrees[currentWeapon] == 0 && x + 4 <= 14) || (degrees[currentWeapon] == 1 && y + 4 <= 14)) {
						xy[8][i] = marginX + (30 * x);
						xy[9][j] = marginY + (30 * y);
						put = true;
					}
					break;
				}
			}
		} else {
			put = false;
		}
		return put;
	}

	private boolean checkShip(int x, int y) {
		boolean position = true;

		switch (type) {
		case "Hydroplane":
			if (degrees[currentWeapon] == 0) {
				if (!checkPosition(x, y) || !checkPosition(x - 1, y + 1) || !checkPosition(x, y + 2)) {
					position = false;
				}
			} else if (degrees[currentWeapon] == 1) {
				if (!checkPosition(x, y) || !checkPosition(x - 1, y + 1) || !checkPosition(x + 1, y + 1)) {
					position = false;
				}
			} else if (degrees[currentWeapon] == 2) {
				if (!checkPosition(x, y) || !checkPosition(x, y + 2) || !checkPosition(x + 1, y + 1)) {
					position = false;
				}
			} else {
				if (!checkPosition(x, y + 2) || !checkPosition(x - 1, y + 1) || !checkPosition(x + 1, y + 1)) {
					position = false;
				}
			}
			break;

		case "Submarine":
			position = checkPosition(x, y);
			break;

		case "Destroyer":
			if (degrees[currentWeapon] == 1) {
				if (!checkPosition(x, y) || !checkPosition(x + 1, y)) {
					position = false;
				}
			} else {
				if (!checkPosition(x, y) || !checkPosition(x, y + 1)) {
					position = false;
				}
			}
			break;

		case "Cruiser":
			if (degrees[currentWeapon] == 1) {
				if (!checkPosition(x, y) || !checkPosition(x + 1, y) || !checkPosition(x + 2, y)
						|| !checkPosition(x + 3, y)) {
					position = false;
				}
			} else {
				if (!checkPosition(x, y) || !checkPosition(x, y + 1) || !checkPosition(x, y + 2)
						|| !checkPosition(x, y + 3)) {
					position = false;
				}
			}
			break;

		case "Battleship":
			position = checkPosition(x, y);
			if (degrees[currentWeapon] == 1) {
				if (!checkPosition(x, y) || !checkPosition(x + 1, y) || !checkPosition(x + 2, y)
						|| !checkPosition(x + 3, y) || !checkPosition(x + 4, y)) {
					position = false;
				}
			} else {
				if (!checkPosition(x, y) || !checkPosition(x, y + 1) || !checkPosition(x, y + 2)
						|| !checkPosition(x, y + 3) || !checkPosition(x, y + 4)) {
					position = false;
				}
			}
			break;
		}

		return position;
	}

	private boolean checkPosition(int x, int y) {
		boolean position = true;

		if (this.map[x][y] != 'V' || (x - 1 >= 0 && this.map[x - 1][y] != 'V')
				|| (x + 1 <= 14 && this.map[x + 1][y] != 'V') || (y - 1 >= 0 && this.map[x][y - 1] != 'V')
				|| (y + 1 <= 14 && this.map[x][y + 1] != 'V')) {
			position = false;
		}

		return position;
	}

	public Cont getCont(){
		return this.cont;
	}
}