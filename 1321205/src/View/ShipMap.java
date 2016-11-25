package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

public class ShipMap extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private char[][] map;
	private Map<LinkedList<Rectangle2D>, String> weapons;
	private Graphics2D g;

	/* Variáveis para movimento de peca */

	private String type = null;
	private LinkedList<Rectangle2D> inicial;
	private LinkedList<Rectangle2D> atual;

	/* Variaveis para desenhar mapa na posicao correta do mapa */

	private int marginX;
	private int marginY;

	//private int x;
	//private int y;

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

	private LinkedList<Rectangle2D> Hydroplane(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> iniciais = new LinkedList<Rectangle2D>();

		// /* Container */
		// g.setColor(Color.WHITE);
		// rect.setRect(x, y, 90, 60);
		// g.draw(rect);
		// g.fill(rect);
		
		System.out.println("novo: " + x + " -- " + y);

		g.setColor(Color.RED);
		rect.setRect(x, y + 30, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y + 30, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);

		return iniciais;
	}

	private LinkedList<Rectangle2D> Submarine(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> inicial = new LinkedList<Rectangle2D>();

		g.setColor(Color.GREEN);
		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		inicial.add(rect);

		return inicial;

	}

	private LinkedList<Rectangle2D> Destroyer(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> iniciais = new LinkedList<Rectangle2D>();

		g.setColor(Color.YELLOW);

		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);

		return iniciais;
	}

	private LinkedList<Rectangle2D> Cruiser(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> iniciais = new LinkedList<Rectangle2D>();

		g.setColor(Color.ORANGE);

		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 90, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);

		return iniciais;

	}

	private LinkedList<Rectangle2D> Battleship(Graphics2D g, int x, int y) {

		Rectangle2D rect = new Rectangle2D.Float();
		LinkedList<Rectangle2D> iniciais = new LinkedList<Rectangle2D>();

		g.setColor(Color.GRAY);

		rect.setRect(x, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 30, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 60, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 90, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);
		rect = new Rectangle2D.Float();

		rect.setRect(x + 120, y, 30, 30);
		g.draw(rect);
		g.fill(rect);

		iniciais.add(rect);

		return iniciais;

	}

	public void paintComponent(Graphics graphics) {

		weapons = new HashMap<LinkedList<Rectangle2D>, String>();
		g = (Graphics2D) graphics;

		/* PECAS - Primeira Secao */

		weapons.put(Hydroplane(g, 60, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 180, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 300, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 420, 90), "Hydroplane");
		weapons.put(Hydroplane(g, 540, 90), "Hydroplane");

		/* PECAS - Segunda Secao */

		weapons.put(Submarine(g, 60, 210), "Submarine");
		weapons.put(Submarine(g, 120, 210), "Submarine");
		weapons.put(Submarine(g, 180, 210), "Submarine");
		weapons.put(Submarine(g, 240, 210), "Submarine");

		/* PECAS - Terceira Secao */

		weapons.put(Destroyer(g, 60, 300), "Destroyer");
		weapons.put(Destroyer(g, 150, 300), "Destroyer");
		weapons.put(Destroyer(g, 240, 300), "Destroyer");

		/* PECAS - Quarta Secao */

		weapons.put(Cruiser(g, 60, 390), "Cruiser");
		weapons.put(Cruiser(g, 210, 390), "Cruiser");

		/* PECAS - Quinta Secao */

		weapons.put(Battleship(g, 60, 480), "Battleship");

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
		/*
		 * System.out.println("Mouse Pressed"); x = e.getX(); y = e.getY();
		 */
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (type != null) {
			System.out.println("posicao: " + x + " --- " + y);
			System.out.println(type);
			for (int i = 0; i < atual.size(); i++) {
				System.out.println("atual: " + atual.get(i).getX()+ " --- " + atual.get(i).getY());
				g.setColor(getBackground());
				//g.drawRect((int)atual.get(i).getX(),(int)atual.get(i).getY(),(int)atual.get(i).getWidth(),(int)atual.get(i).getHeight());
				//g.fillRect((int)atual.get(i).getX(),(int)atual.get(i).getY(),(int)atual.get(i).getWidth(),(int)atual.get(i).getHeight());
				repaint((int)atual.get(i).getX(),(int)atual.get(i).getY(),(int)atual.get(i).getWidth(),(int)atual.get(i).getHeight());
			}
			
			for (int j = 0; j < inicial.size(); j++){
				System.out.println("inicial: " + inicial.get(j).getX()+ " --- " + inicial.get(j).getY());
			}

			switch (type) {
			case "Hydroplane":
				atual = Hydroplane(g, x, y);
				break;

			case "Submarine":
				atual = Submarine(g, x, y);
				break;

			case "Destroyer":
				atual = Destroyer(g, x, y);
				break;

			case "Cruiser":
				atual = Cruiser(g, x, y);
				break;

			case "Battleship":
				atual = Battleship(g, x, y);
				break;
			}
			System.out.println("################");
		}
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		// System.out.println("Mouse Dragged");
		//
		// int dx = e.getX() - x;
		// int dy = e.getY() - y;
		//
		// for (Entry<Rectangle2D, String> r : weapons.entrySet()){
		// //System.out.println("Mouse Dragged" + r.getBounds2D().toString() +
		// "x:" + x + "y:" + y);
		//
		// if (r.getKey().getBounds2D().contains(x, y)){
		// System.out.println("Mouse Dragged - Move & Repaint" + r.getValue());
		//
		// switch (r.getValue()){
		//
		// case "Hydroplane":
		// Hydroplane(g, dx, dy);
		//
		// case "Submarine":
		// Submarine(g, dx, dy);
		//
		// case "Destroyer":
		// Destroyer(g, dx, dy);
		//
		// case "Cruiser":
		// Cruiser(g, dx, dy);
		//
		// case "Battleship":
		// Battleship(g, dx, dy);
		// }
		// }
		// }
		//
		// x += dx;
		// y += dy;
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

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
			for (Entry<LinkedList<Rectangle2D>, String> r : weapons.entrySet()) {
				for (int i = 0; i < r.getKey().size(); i++) {
					if (r.getKey().get(i).getBounds2D().contains(x, y)) {
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
						
						inicial = r.getKey();
						atual = r.getKey();
						
						if (type != null)
							break;
					}
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {

	}
}