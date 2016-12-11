package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Map.Entry;

import Model.Player;
import View.AttackView;

public class AttackController implements ActionListener, MouseListener {

	private Player p1;
	private Player p2;

	private boolean attacked = false;
	private boolean end = false;

	private int player = 1;
	private AttackView view;

	public AttackController(AttackView view, Player p1, Player p2) {
		this.view = view;
		this.p1 = p1;
		this.p2 = p2;
	}

	private boolean checkClickInAttackMap(int x, int y) {
		if (x > view.getMarginXAttack() && x < view.getMarginXAttack() + 450 && y > view.getMarginY()
				&& y < view.getMarginY() + 450) {
			return true;
		} else {
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		player++;
		if (!end) {
			if (player % 2 != 0) {
				attacked = false;
				view.setText2(p2.getName() + ", realize seu ataque.");
				view.player1Screen();
			} else {
				attacked = false;
				view.setText1(p1.getName() + ", realize seu ataque.");
				view.player2Screen();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		int x, y;
		boolean check = false;
		boolean destroyed = true;
		boolean won = true;

		x = e.getX();
		y = e.getY();

		if (checkClickInAttackMap(x, y) && !attacked) {
			x -= view.getMarginXAttack();
			y -= view.getMarginY();
			x /= 30;
			y /= 30;

			if (player % 2 != 0) {
				attacked = true;
				if (p2.getMyMap()[y][x] != 'V') {
					p1.getAttackMap()[y][x] = p2.getMyMap()[y][x];
					p2.getMyMap()[y][x] = 'V';

					for (Entry<LinkedList<int[]>, String> r : p2.getPosition().entrySet()) {
						for (int i = 0; i < r.getKey().size(); i++) {
							if (r.getKey().get(i)[0] == y && r.getKey().get(i)[1] == x) {
								r.getKey().get(i)[0] = -1;
								r.getKey().get(i)[1] = -1;
								check = true;
							}
						}

						if (check == true) {
							check = false;

							for (int j = 0; j < r.getKey().size(); j++) {
								if (r.getKey().get(j)[0] != -1 && r.getKey().get(j)[1] != -1) {
									destroyed = false;
								}
							}

							if (destroyed) {
								view.setText1("     Voce abateu o " + r.getValue());
							} else {
								view.setText1("  Voce abateu parte do " + r.getValue());
							}
						}
					}

					for (int i = 0; i < p2.getMyMap().length; i++) {
						for (int j = 0; j < p2.getMyMap()[0].length; j++) {
							if (p2.getMyMap()[i][j] != 'V') {
								won = false;
							}
						}
					}

					if (won) {
						view.setText1(p1.getName() + " VENCEU.");
						end = true;
					}
				} else {
					p1.getAttackMap()[y][x] = 'N';
					view.setText1("            ATIROU NA AGUA");
				}
				view.player1Screen();
			} else {
				attacked = true;
				if (p1.getMyMap()[y][x] != 'V') {
					p2.getAttackMap()[y][x] = p1.getMyMap()[y][x];
					p1.getMyMap()[y][x] = 'V';

					for (Entry<LinkedList<int[]>, String> r : p1.getPosition().entrySet()) {
						for (int i = 0; i < r.getKey().size(); i++) {
							if (r.getKey().get(i)[0] == y && r.getKey().get(i)[1] == x) {
								r.getKey().get(i)[0] = -1;
								r.getKey().get(i)[1] = -1;
								check = true;
							}
						}

						if (check == true) {
							check = false;

							for (int j = 0; j < r.getKey().size(); j++) {
								if (r.getKey().get(j)[0] != -1 && r.getKey().get(j)[1] != -1) {
									destroyed = false;
								}
							}

							if (destroyed) {
								view.setText2("Voce abateu o " + r.getValue());
							} else {
								view.setText2("Voce abateu parte do " + r.getValue());
							}
						}
					}

					for (int i = 0; i < p1.getMyMap().length; i++) {
						for (int j = 0; j < p1.getMyMap()[0].length; j++) {
							if (p1.getMyMap()[i][j] != 'V') {
								won = false;
							}
						}
					}

					if (won) {
						view.setText2(p2.getName() + " VENCEU.");
						end = true;
					}
				} else {
					p2.getAttackMap()[y][x] = 'N';
					view.setText2("            ATIROU NA AGUA");
				}

				view.player2Screen();
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
