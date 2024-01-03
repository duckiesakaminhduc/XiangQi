package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.CookieManager;
import java.util.HashMap;

import javax.swing.JPanel;

import Controller.PieceController;
import Model.LoadImage;

public class ChessBoard extends JPanel {

	public PieceController pc;
	public static int x, y;
	public HashMap<String, Image> mapImg;
	public int orgX = 40;
	public int orgY = 40;
	public int side = 62;
	public LogicChess ab;
	public Image img;
	public String move;

	public ChessBoard(LogicChess ab) {
		this.pc = new PieceController(this, ab);
		this.ab = ab;
		addEvent();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		mapImg = new LoadImage().mapImg;
		veBanCo(g);
		drawCo(g);
	}

	public void veBanCo(Graphics g) {
		for (int i = 0; i < 9; i++) {
			g.drawLine(orgX + i * side, orgY, orgX + i * side, orgY + 4 * side);
			g.drawLine(orgX + i * side, orgY + 5 * side, orgX + i * side, orgY + 9 * side);
		}
		for (int i = 0; i < 10; i++) {
			g.drawLine(orgX, orgY + i * side, orgX + 8 * side, orgY + i * side);
		}
		for (int i = 0; i < 2; i++) {
			g.drawLine(orgX + 3 * side, orgY + i * 7 * side, orgX + 5 * side, orgY + (2 + i * 7) * side);
			g.drawLine(orgX + 5 * side, orgY + i * 7 * side, orgX + 3 * side, orgY + (2 + i * 7) * side);
			g.drawLine(orgX + 8 * i * side, orgY + 4 * side, orgX + 8 * i * side, orgY + 5 * side);
		}
	}

	public void drawCo(Graphics g) {
		HashMap<String, Image> mapImg = new LoadImage().mapImg;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (ab.chessBoard[i][j]) {
				case "R":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "K":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "B":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "G":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "A":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "C":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "P":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "r":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "k":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "b":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "g":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "a":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "c":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				case "p":
					g.drawImage(mapImg.get(ab.chessBoard[i][j]), orgX + side * j - side / 2, orgY + side * i - side / 2,
							this);
					break;
				default:
					break;
				}
			}
		}
	}

	public void drawSquareSelect(Graphics g) {

	}

	public void addEvent() {
		this.addMouseListener(pc);
		this.addMouseMotionListener(pc);
	};

}
