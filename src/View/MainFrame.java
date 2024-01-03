package View;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public ChessBoard board;

	public MainFrame() {
		init();
		LogicChess ab = new LogicChess();
		board = new ChessBoard(ab);
		getContentPane().add(board);
	}

	private void init() {
		setResizable(false);
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
