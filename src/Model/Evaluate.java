package Model;

import View.LogicChess;
import View.ChessBoard;

public class Evaluate {
	public LogicChess ab;

	int[][] PawnBoard = { 
			{ 0, 3, 6, 9, 12, 9, 6, 3, 0 }, // pawn
			{ 18, 36, 56, 80, 120, 80, 56, 36, 18 }, 
			{ 14, 26, 42, 60, 80, 60, 42, 26, 14 },
			{ 10, 20, 30, 34, 40, 34, 30, 20, 10 }, 
			{ 6, 12, 18, 18, 20, 18, 18, 12, 6 },
			{ 2, 0, 8, 0, 8, 0, 8, 0, 2 },
			{ 0, 0, -2, 0, 4, 0, -2, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	int[][] KnightBoard = {
			{ 4, 8, 16, 12, 4, 12, 16, 8, 4 }, // knight
			{ 4, 10, 28, 16, 8, 16, 28, 10, 4 }, 
			{ 12, 14, 16, 20, 18, 20, 16, 14, 12 },
			{ 8, 24, 18, 24, 20, 24, 18, 24, 8 },
			{ 6, 16, 14, 18, 16, 18, 14, 16, 6 },
			{ 4, 12, 16, 14, 12, 14, 16, 12, 4 },
			{ 2, 6, 8, 6, 10, 6, 8, 6, 2 },
			{ 4, 2, 8, 8, 4, 8, 8, 2, 4 },
			{ 0, 2, 4, 4, -2, 4, 4, 2, 0 }, 
			{ 0, -4, 0, 0, 0, 0, 0, -4, 0 } };

	int[][] RookBoard = { 
			{ 14, 14, 12, 18, 16, 18, 12, 14, 14 }, // rook
			{ 16, 20, 18, 24, 26, 24, 18, 20, 16 }, 
			{ 12, 12, 12, 18, 18, 18, 12, 12, 12 },
			{ 12, 18, 16, 22, 22, 22, 16, 18, 12 },
			{ 12, 14, 12, 18, 18, 18, 12, 14, 12 },
			{ 12, 16, 14, 20, 20, 20, 14, 16, 12 }, 
			{ 6, 10, 8, 14, 14, 14, 8, 10, 06 },
			{ 4, 8, 6, 14, 12, 14, 6, 8, 4 }, 
			{ 8, 4, 8, 16, 8, 16, 8, 4, 8 }, 
			{ -2, 10, 6, 14, 12, 14, 6, 10, -2 } };

	int[][] CannonBoard = { 
			{ 6, 4, 0, -10, -12, -10, 0, 4, 6 }, // cannon
			{ 2, 2, 0, -4, -14, -4, 0, 2, 2 }, 
			{ 2, 2, 0, -10, -8, -10, 0, 2, 2 }, 
			{ 0, 0, -2, 4, 10, 4, -2, 0, 0 },
			{ 0, 0, 0, 2, 8, 2, 0, 0, 0 }, 
			{ -2, 0, 4, 2, 6, 2, 4, 0, -2 },
			{ 0, 0, 0, 2, 4, 2, 0, 0, 0 },
			{ 4, 0, 8, 6, 10, 6, 8, 0, 4 }, 
			{ 0, 2, 4, 6, 6, 6, 4, 2, 0 }, 
			{ 0, 0, 2, 6, 6, 6, 2, 0, 0 } };

	int[][] PawnBoardL = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, -2, 0, 4, 0, -2, 0, 0 }, 
			{ 2, 0, 8, 0, 8, 0, 8, 0, 2 }, 
			{ 6, 12, 18, 18, 20, 18, 18, 12, 6 },
			{ 10, 20, 30, 34, 40, 34, 30, 20, 10 }, 
			{ 14, 26, 42, 60, 80, 60, 42, 26, 14 },
			{ 18, 36, 56, 80, 120, 80, 56, 36, 18 }, 
			{ 0, 3, 6, 9, 12, 9, 6, 3, 0 } };

	int[][] KnightBoardL = { 
			{ 0, -4, 0, 0, 0, 0, 0, -4, 0 }, 
			{ 0, 2, 4, 4, -2, 4, 4, 2, 0 },
			{ 4, 2, 8, 8, 4, 8, 8, 2, 4 }, 
			{ 2, 6, 8, 6, 10, 6, 8, 6, 2 }, 
			{ 4, 12, 16, 14, 12, 14, 16, 12, 4 },
			{ 6, 16, 14, 18, 16, 18, 14, 16, 6 }, 
			{ 8, 24, 18, 24, 20, 24, 18, 24, 8 },
			{ 12, 14, 16, 20, 18, 20, 16, 14, 12 },
			{ 4, 10, 28, 16, 8, 16, 28, 10, 4 },
			{ 4, 8, 16, 12, 4, 12, 16, 8, 4 } };

	int[][] RookBoardL = { 
			{ -2, 10, 6, 14, 12, 14, 6, 10, -2 }, 
			{ 8, 4, 8, 16, 8, 16, 8, 4, 8 },
			{ 4, 8, 6, 14, 12, 14, 6, 8, 4 }, 
			{ 6, 10, 8, 14, 14, 14, 8, 10, 6 },
			{ 12, 16, 14, 20, 20, 20, 14, 16, 12 }, 
			{ 12, 14, 12, 18, 18, 18, 12, 14, 12 },
			{ 12, 18, 16, 22, 22, 22, 16, 18, 12 }, 
			{ 12, 12, 12, 18, 18, 18, 12, 12, 12 },
			{ 16, 20, 18, 24, 26, 24, 18, 20, 16 },
			{ 14, 14, 12, 18, 16, 18, 12, 14, 14 } };

	int[][] CannonBoardL = {
			{ 0, 0, 2, 6, 6, 6, 2, 0, 0 }, 
			{ 0, 2, 4, 6, 6, 6, 4, 2, 0 },
			{ 4, 0, 8, 6, 10, 6, 8, 0, 4 },
			{ 0, 0, 0, 2, 4, 2, 0, 0, 0 }, 
			{ -2, 0, 4, 2, 6, 2, 4, 0, -2 },
			{ 0, 0, 0, 2, 8, 2, 0, 0, 0 }, 
			{ 0, 0, -2, 4, 10, 4, -2, 0, 0 }, 
			{ 2, 2, 0, -10, -8, -10, 0, 2, 2 },
			{ 2, 2, 0, -4, -14, -4, 0, 2, 2 }, 
			{ 6, 4, 0, -10, -12, -10, 0, 4, 6 } };

	int[] pieceValue = new int[] { 1000000, 110, 110, 300, 600, 300, 70 };
	// vua si tuong ma xe phao chot

	public Evaluate(LogicChess ab) {
		this.ab = ab;
	}

	public int rate(String[][] chessBoard, int depth) {
		int counter = 0;
		int counterL = 0;
		counter += rateMaterial();// xet diem tren so quan co con lai
//		counter += rateMoving(list, depth);// xet diem dua tren su an toan cua vua
		counter += ratePosition();// xet diem dua tren vi tri mac dinh
		counterL -= rateMaterialL();// xet diem tren so quan co con lai
		counterL -= ratePositionL();// xet diem dua tren vi tri mac dinh
//		return (-1) *s (counter + depth * 50);
		return counter + counterL;
	}

	public int ratePosition() {
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (ab.chessBoard[i][j]) {
				case "P":
					counter += pieceValue[6];
					break;
				case "C":
					counter += pieceValue[5];
					break;
				case "K":
					counter += pieceValue[3];
					break;
				case "R":
					counter += pieceValue[4];
					break;
				case "B":
					counter += pieceValue[1];
					break;
				case "G":
					counter += pieceValue[2];
					break;
				case "A":
					counter += pieceValue[0];
					break;
				default:
					break;
				}
			}
		}
		return counter;
	}

	public int ratePositionL() {
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (ab.chessBoard[i][j]) {
				case "p":
					counter += pieceValue[6];
					break;
				case "c":
					counter += pieceValue[5];
					break;
				case "k":
					counter += pieceValue[3];
					break;
				case "r":
					counter += pieceValue[4];
					break;
				case "b":
					counter += pieceValue[1];
					break;
				case "g":
					counter += pieceValue[2];
					break;
				case "a":
					counter += pieceValue[0];
					break;
				default:
					break;
				}
			}
		}
		return counter;
	}

//	public  int rateMoving(String[][] list, int depth) {
//		int counter = 0;
//		counter += list.Al;
//		if (list.length == 0) {
//			if (!AlphabetaChess.kingSafe()) {
//				counter -= 20000 * depth;
//			} else {
//				counter -= 15000 * depth;
//			}
//		}
//		return counter;
//	}

	public int rateMaterial() {
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (ab.chessBoard[i][j]) {
				case "P":
					counter += PawnBoard[i][j];
					break;
				case "C":
					counter += CannonBoard[i][j];
					break;
				case "K":
					counter += KnightBoard[i][j];
					break;
				case "R":
					counter += RookBoard[i][j];
					break;
				default:
					break;
				}
			}
		}
		return counter;
	}

	public int rateMaterialL() {
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (ab.chessBoard[i][j]) {
				case "p":
					counter += PawnBoardL[i][j];
					break;
				case "c":
					counter += CannonBoardL[i][j];
					break;
				case "k":
					counter += KnightBoardL[i][j];
					break;
				case "r":
					counter += RookBoardL[i][j];
					break;
				default:
					break;
				}
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		String chessBoard[][] = { 
				{ "r", "k", "b", "g", "a", "g", "b", "k", "r" },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "c", " ", " ", "c", " " },
				{ "p", " ", "p", " ", "p", " ", "p", " ", "p" }, 
				{ " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ "P", " ", "P", " ", "P", " ", "P", " ", "P" },
				{ " ", "C", " ", " ", " ", " ", " ", "C", " " }, 
				{ "R", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", "K", "B", "G", "A", "G", "B", "K", "R" } };
		LogicChess ab = new LogicChess();
		Evaluate e = new Evaluate(ab);
		System.out.println(e.rate(chessBoard, 2));
	}
}
