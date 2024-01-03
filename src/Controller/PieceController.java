package Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.print.attribute.standard.Sides;

import View.LogicChess;
import View.ChessBoard;

public class PieceController implements MouseListener, MouseMotionListener {

	public ChessBoard board;
	public static int x1, y1, x2, y2;
	public LogicChess ab;
	public static Point p1, p2;
	public String move;

	public PieceController(ChessBoard board, LogicChess ab) {
		this.board = board;
		this.ab = ab;
	}

	public Point PointToColRow(Point point) {
		return new Point((point.y - board.orgY + board.side / 2) / board.side,
				(point.x - board.orgX + board.side / 2) / board.side);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point re = PointToColRow(e.getPoint());
		if (e.getY() <= 10 * board.side && e.getX() <= 10 * board.side) {
			x1 = re.x;
			y1 = re.y;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point re = PointToColRow(e.getPoint());
		if (e.getY() <= 10 * board.side && e.getX() <= 10 * board.side) {
			x2 = re.x;
			y2 = re.y;
			String target = ab.chessBoard[x2][y2];
			if (!ab.chessBoard[x1][y1].equals(" ")) {
				move = "" + x1 + y1 + x2 + y2 + target;
			}
			ab.makeMove(ab.chessBoard, move);
			board.repaint();

			String AIMove = ab.findBestMove(ab.chessBoard, true);
//			String AIMove = ab.findBestMoveMiniMax(ab.chessBoard, true);

			ab.makeMove(ab.chessBoard, AIMove);
			board.repaint();
			

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
