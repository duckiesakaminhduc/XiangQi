package View;

import javax.swing.JFrame;

import Model.Evaluate;

public class LogicChess {
	public String chessBoard[][] = { { "r", "k", "b", "g", "a", "g", "b", "k", "r" },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " " }, { " ", "c", " ", " ", " ", " ", " ", "c", " " },
			{ "p", " ", "p", " ", "p", " ", "p", " ", "p" }, { " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " ", " " }, { "P", " ", "P", " ", "P", " ", "P", " ", "P" },
			{ " ", "C", " ", " ", " ", " ", " ", "C", " " }, { " ", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "R", "K", "B", "G", "A", "G", "B", "K", "R" } };

	public int[] kingPositionC = new int[2];
	public int[] kingPositionL = new int[2];
	public Evaluate evaluate;

	public LogicChess() {
		this.chessBoard = chessBoard;
		this.evaluate = new Evaluate(this);
	}

	// get location kingpositionC
	public void getLocationKingpositionC() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (chessBoard[i][j].equals("A")) {
					kingPositionC[0] = i;
					kingPositionC[1] = j;
				}
			}
		}
	}

	public void getLocationKingpositionL() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (chessBoard[i][j].equals("a")) {
					kingPositionL[0] = i;
					kingPositionL[1] = j;
				}
			}
		}
	}

	public void printChess(String[][] chessBoard) {

		System.out.print("  ");
		for (int m = 0; m < 9; m++) {
			System.out.print(m + " ");
		}
		System.out.println();
		for (int n = 0; n < 10; n++) {
			System.out.print(n + " ");
			for (int j = 0; j < 9; j++) {
				System.out.print(chessBoard[n][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}

	public String posibleMoves(String[][] chessBoard) {
		String list = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (chessBoard[i][j]) {
				case "P":
					list += posibleP(i, j);
					break;
				case "R":
					list += posibleR(i, j);
					break;
				case "K":
					list += posibleK(i, j);
					break;
				case "B":
					list += posibleB(i, j);
					break;
				case "C":
					list += posibleC(i, j);
					break;
				case "G":
					list += posibleG(i, j);
					break;
				case "A":
					list += posibleA(i, j);
					break;
				}
			}
		}
		return list;
	}

	public String posibleMovesL(String[][] chessBoard) {
		String list = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				switch (chessBoard[i][j]) {
				case "p":
					list += posiblep(i, j);
					break;
				case "r":
					list += posibler(i, j);
					break;
				case "k":
					list += posiblek(i, j);
					break;
				case "b":
					list += posibleb(i, j);
					break;
				case "c":
					list += posiblec(i, j);
					break;
				case "g":
					list += posibleg(i, j);
					break;
				case "a":
					list += posiblea(i, j);
					break;
				}
			}
		}
		return list;
	}

	public String posibleR(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j)) {
					if ((Character.isLowerCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "R";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "R";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibler(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j)) {
					if ((Character.isUpperCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "r";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "r";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleK(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isKnight(x, y, i, j)) {
					if (Character.isLowerCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "K";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "K";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posiblek(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isKnight(x, y, i, j)) {
					if (Character.isUpperCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "k";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "k";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	// tuong.
	public String posibleB(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isDiagonal(x, y, i, j) && step(x, y, i, j) == 2 && selfSide(i)) {
					if (Character.isLowerCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "B";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "B";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleb(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isDiagonal(x, y, i, j) && step(x, y, i, j) == 2 && selfSideL(i)) {
					if (Character.isUpperCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "b";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "b";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleG(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isDiagonal(x, y, i, j) && inPlace(i, j) && step(x, y, i, j) == 1) {
					if (Character.isLowerCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "G";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "G";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleg(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isDiagonal(x, y, i, j) && inPlaceL(i, j) && step(x, y, i, j) == 1) {
					if (Character.isUpperCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "g";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "g";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleA(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j) && inPlace(i, j) && step(x, y, i, j) == 1) {
					if (Character.isLowerCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "A";
						int[] kingTemp = kingPositionC;
						kingPositionC[0] = i;
						kingPositionC[1] = j;
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "A";
						chessBoard[i][j] = oldPiece;
						kingPositionC = kingTemp;
					}
				}
			}
		}
		return list;
	}

	public String posiblea(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j) && inPlaceL(i, j) && step(x, y, i, j) == 1) {
					if (Character.isUpperCase(chessBoard[i][j].charAt(0)) || " ".equals(chessBoard[i][j])) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "a";
						int[] kingTemp = kingPositionL;
						kingPositionL[0] = i;
						kingPositionL[1] = j;
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "a";
						chessBoard[i][j] = oldPiece;
						kingPositionL = kingTemp;
					}
				}
			}
		}
		return list;
	}

	public String posibleC(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j)) {
					if ((Character.isLowerCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 1)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "C";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "C";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posiblec(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (isStraight(x, y, i, j)) {
					if ((Character.isUpperCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 1)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "c";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "c";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posibleP(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (i <= 5 && isStraight(x, y, i, j) && step(x, y, i, j) == 1 && i < x) {
					if ((Character.isLowerCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "P";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "P";
						chessBoard[i][j] = oldPiece;
					}
				}

				if (i <= 4 && isStraight(x, y, i, j) && step(x, y, i, j) == 1 && i <= x) {
					if ((Character.isLowerCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "P";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "P";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public String posiblep(int x, int y) {
		String list = "";
		String oldPiece = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (i <= 5 && isStraight(x, y, i, j) && step(x, y, i, j) == 1 && i > x) {
					if ((Character.isUpperCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "p";
						if (kingSafeL()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "p";
						chessBoard[i][j] = oldPiece;
					}
				}

				if (i >= 5 && isStraight(x, y, i, j) && step(x, y, i, j) == 1 && i >= x) {
					if ((Character.isUpperCase(chessBoard[i][j].charAt(0)) && numQuanCoBetween(x, y, i, j) == 0)
							|| (" ".equals(chessBoard[i][j]) && numQuanCoBetween(x, y, i, j) == 0)) {
						// gia dinh vua di chuyen
						oldPiece = chessBoard[i][j];
						chessBoard[x][y] = " ";
						chessBoard[i][j] = "p";
						if (kingSafe()) {
							list += "" + x + y + i + j + oldPiece;
						}
						// phuc hoi trang thai ban dau
						chessBoard[x][y] = "p";
						chessBoard[i][j] = oldPiece;
					}
				}
			}
		}
		return list;
	}

	public boolean selfSide(int row) {
		if (row >= 5) {
			return true;
		}
		return false;
	}

	public boolean selfSideL(int row) {
		if (row <= 4) {
			return true;
		}
		return false;
	}

	public boolean isStraight(int x1, int y1, int x2, int y2) {
		return x1 == x2 || y1 == y2;
	}

	public boolean inPlace(int x, int y) {
		return (x >= 7 && x <= 9) && (y >= 3 && y <= 5);
	}

	public boolean inPlaceL(int x, int y) {
		return (x >= 0 && x <= 2) && (y >= 3 && y <= 5);
	}

	public boolean isDiagonal(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) == Math.abs(y1 - y2);
	}

	public boolean isKnight(int x1, int y1, int x2, int y2) {
		if (Math.abs(y2 - y1) == 2 && Math.abs(x1 - x2) == 1) {
			if (chessBoard[x1][(y1 + y2) / 2].equals(" ")) {
				return true;

			}
		}
		if (Math.abs(y2 - y1) == 1 && Math.abs(x1 - x2) == 2) {
			if (chessBoard[(x1 + x2) / 2][y1].equals(" ")) {
				return true;
			}
		}
		return false;
	}

	public int step(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			return Math.abs(y2 - y1);
		} else if (y1 == y2) {
			return Math.abs(x2 - x1);
		} else if (isDiagonal(x1, y1, x2, y2)) {
			return Math.abs(x1 - x2);
		}
		return 0;
	}

	public int numQuanCoBetween(int x1, int y1, int x2, int y2) {
		if (!isStraight(x1, y1, x2, y2)) {
			return 0;
		}

		if (x1 == x2) {
			int count = 0;
			int head = Math.min(y1, y2);
			int tail = Math.max(y1, y2);
			for (int i = head + 1; i < tail; i++) {
				if (!chessBoard[x1][i].equals(" ")) {
					count++;
				}
			}
			return count;
		} else if (y1 == y2) {
			int count = 0;
			int head = Math.min(x1, x2);
			int tail = Math.max(x1, x2);
			for (int i = head + 1; i < tail; i++) {
				if (!chessBoard[i][y1].equals(" ")) {
					count++;
				}
			}
			return count;
		} else
			return 0;

	}

	public boolean kingSafe() {
		getLocationKingpositionC();
		int row = kingPositionC[0];// row cua vua
		int col = kingPositionC[1];// col cua vua
		for (int j = 0; j < 9; j++) {
			if (chessBoard[row][j].equals("r") && numQuanCoBetween(row, col, row, j) == 0) {
				return false;
			}
		}
		// check hang doc , xe cung cot voi vua
		for (int i = 0; i < 10; i++) {
			if (chessBoard[i][col].equals("r") && numQuanCoBetween(row, col, i, col) == 0) {
				return false;
			}
		}

		// knight check
		for (int i = row - 1; i <= row + 1; i += 2) {
			for (int j = col - 2; j <= col + 2; j += 4) {
				try {
					if (chessBoard[i][j].equals("k") && chessBoard[i][(j + col) / 2].equals(" ")) {
						return false;
					}
				} catch (Exception e) {
				}
			}
		}
		for (int i = row - 2; i <= row + 2; i += 4) {
			for (int j = col - 1; j <= col + 1; j += 2) {
				try {
					if (chessBoard[i][j].equals("k") && chessBoard[(i + row) / 2][j].equals(" ")) {
						return false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		// cannon check
		// check hang ngang , phao cung hang voi vua
		for (int j = 0; j < 9; j++) {
			if (chessBoard[row][j].equals("c") && numQuanCoBetween(row, col, row, j) == 1) {
				return false;
			}
		}
		// check hang doc , phao cung cot voi vua
		for (int i = 0; i < 10; i++) {
			if (chessBoard[i][col].equals("c") && numQuanCoBetween(row, col, i, col) == 1) {
				return false;
			}
		}

		// pawn check
		// check hang ngang , chot cung hang voi vua
		if (chessBoard[row - 1][col].equals("p")) {
			return false;
		}

		// check hang doc , chot cung cot voi vua
		if (chessBoard[row][col + 1].equals("p") || chessBoard[row][col - 1].equals("p")) {
			return false;

		}
		return true;
	}

	public boolean kingSafeL() {
		getLocationKingpositionL();
		int row = kingPositionL[0];// row cua vua
		int col = kingPositionL[1];// col cua vua
		for (int j = 0; j < 9; j++) {
			if (chessBoard[row][j].equals("R") && numQuanCoBetween(row, col, row, j) == 0) {
				return false;
			}
		}
		// check hang doc , xe cung cot voi vua
		for (int i = 0; i < 10; i++) {
			if (chessBoard[i][col].equals("R") && numQuanCoBetween(row, col, i, col) == 0) {
				return false;
			}
		}

		// knight check
		for (int i = row - 1; i <= row + 1; i += 2) {
			for (int j = col - 2; j <= col + 2; j += 4) {
				try {
					if (chessBoard[i][j].equals("K") && chessBoard[i][(j + col) / 2].equals(" ")) {
						return false;
					}
				} catch (Exception e) {
				}
			}
		}
		for (int i = row - 2; i <= row + 2; i += 4) {
			for (int j = col - 1; j <= col + 1; j += 2) {
				try {
					if (chessBoard[i][j].equals("K") && chessBoard[(i + row) / 2][j].equals(" ")) {
						return false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		// cannon check
		// check hang ngang , phao cung hang voi vua
		for (int j = 0; j < 9; j++) {
			if (chessBoard[row][j].equals("C") && numQuanCoBetween(row, col, row, j) == 1) {
				return false;
			}
		}
		// check hang doc , phao cung cot voi vua
		for (int i = 0; i < 10; i++) {
			if (chessBoard[i][col].equals("C") && numQuanCoBetween(row, col, i, col) == 1) {
				return false;
			}
		}

		// pawn check
		// check hang ngang , chot cung hang voi vua
		if (chessBoard[row + 1][col].equals("P")) {
			return false;
		}

		// check hang doc , chot cung cot voi vua
		if (chessBoard[row][col + 1].equals("P") || chessBoard[row][col - 1].equals("P")) {
			return false;

		}
		return true;
	}

	public void makeMove(String[][] chessBoard, String move) {
		try {
			int x1 = Character.getNumericValue(move.charAt(0));
			int y1 = Character.getNumericValue(move.charAt(1));
			int x2 = Character.getNumericValue(move.charAt(2));
			int y2 = Character.getNumericValue(move.charAt(3));

			chessBoard[x2][y2] = chessBoard[x1][y1];
			chessBoard[x1][y1] = " ";
		} catch (Exception e) {
			System.out.println("Error during move: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void undoMove(String[][] chessBoard, String move) {
		try {
			int x1 = Character.getNumericValue(move.charAt(0));
			int y1 = Character.getNumericValue(move.charAt(1));
			int x2 = Character.getNumericValue(move.charAt(2));
			int y2 = Character.getNumericValue(move.charAt(3));
			String target = String.valueOf(move.charAt(4));
			String movedPiece = chessBoard[x2][y2];
			chessBoard[x2][y2] = target;
			chessBoard[x1][y1] = movedPiece;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void flipBoard(String[][] chessBoard) {
		String temp = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (Character.isUpperCase(chessBoard[i][j].charAt(0))) {
					chessBoard[i][j] = chessBoard[i][j].toLowerCase();
				} else {
					chessBoard[i][j] = chessBoard[i][j].toUpperCase();
				}

				if (Character.isUpperCase(chessBoard[9 - i][8 - j].charAt(0))) {
					chessBoard[9 - i][8 - j] = chessBoard[9 - i][8 - j].toLowerCase();
				} else {
					chessBoard[9 - i][8 - j] = chessBoard[9 - i][8 - j].toUpperCase();
				}
				temp = chessBoard[i][j];
				chessBoard[i][j] = chessBoard[9 - i][8 - j];
				chessBoard[9 - i][8 - j] = temp;
			}
		}
	}

	public String sortMoves(String[][] chessBoard, String listMoves) {
		int[] score = new int[listMoves.length() / 5];
		for (int i = 0; i < listMoves.length(); i += 5) {
			makeMove(chessBoard, listMoves.substring(i, i + 5));
			score[i / 5] = -evaluate.rate(chessBoard, 0);
			undoMove(chessBoard, listMoves.substring(i, i + 5));
		}
		String newA = "";
		String newB = listMoves;
		for (int j = 0; j < Math.min(10, listMoves.length() / 5); j++) {
			int max = -100000000;
			int maxLocation = 0;
			if (score[j] > max) {
				max = score[j];
				maxLocation = j;
			}
			score[maxLocation] = -100000000;
			newA += listMoves.substring(maxLocation * 5, maxLocation * 5 + 5);
			newB = newB.replaceAll(listMoves.substring(maxLocation * 5, maxLocation * 5 + 5), "");
		}
		return newA + newB;
	}

	public int alphabeta(String[][] chessBoard, int depth, int a, int b, boolean isMax) {
		String listPosibleMovesC = posibleMoves(chessBoard);
		String listPosibleMovesL = posibleMovesL(chessBoard);
		String listPosibleMoves = isMax ? listPosibleMovesC : listPosibleMovesL;
		if (depth == 0) {

			return evaluate.rate(chessBoard, depth);
		}
		listPosibleMoves = sortMoves(chessBoard, listPosibleMoves);
		if (isMax) {
			int best = -Integer.MAX_VALUE;
			for (int i = 0; i < listPosibleMoves.length(); i += 5) {
				System.out.println(listPosibleMoves.substring(i, i + 5));
				makeMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				printChess(chessBoard);
				int val = alphabeta(chessBoard, depth - 1, a, b, !isMax);
				undoMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				best = Math.max(val, best);
				a = Math.max(a, best);
				if (a >= b) {
					break;
				}
			}
			return best;
		}
		if (!isMax) {
			int best = Integer.MAX_VALUE;
			for (int i = 0; i < listPosibleMoves.length(); i += 5) {
				System.out.println(listPosibleMoves.substring(i, i + 5));
				makeMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				printChess(chessBoard);
				int val = alphabeta(chessBoard, depth - 1, a, b, !isMax);
				undoMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				best = Math.min(val, best);
				b = Math.min(b, best);
				if (a >= b) {
					break;
				}
			}
			return best;
		}
		return -1;
	}

	public String findBestMove(String[][] chessBoard, boolean isMax) {
		String bestMove = "";
		int best = -Integer.MAX_VALUE;
		String listPosibleMoves = posibleMoves(chessBoard);
		for (int i = 0; i < listPosibleMoves.length() - 4; i += 5) {
			String temp = listPosibleMoves.substring(i, i + 5);
			makeMove(chessBoard, temp);
			int val = alphabeta(chessBoard, 2, -100000000, 100000000, !isMax);
			undoMove(chessBoard, temp);
			if (val > best) {
				best = val;
				bestMove = temp;
			}
		}
		return bestMove;
	}
//===========================================

	public int minimax(String[][] chessBoard, int depth, boolean isMax) {
		String listPosibleMovesC = posibleMoves(chessBoard);
		String listPosibleMovesL = posibleMovesL(chessBoard);
		String listPosibleMoves = isMax ? listPosibleMovesC : listPosibleMovesL;
		
		if (depth == 0) {
			return evaluate.rate(chessBoard, depth);
		}
		listPosibleMoves = sortMoves(chessBoard, listPosibleMoves);
		if (isMax) {
			int best = -Integer.MAX_VALUE;
			for (int i = 0; i < listPosibleMoves.length(); i += 5) {
				System.out.println(listPosibleMoves.substring(i, i + 5));
				makeMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				printChess(chessBoard);
				int val = minimax(chessBoard, depth - 1, !isMax);
				undoMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				best = Math.max(val, best);
			}
			return best;
		}
		if (!isMax) {
			int best = Integer.MAX_VALUE;
			for (int i = 0; i < listPosibleMoves.length(); i += 5) {
				System.out.println(listPosibleMoves.substring(i, i + 5));
				makeMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				printChess(chessBoard);
				int val = minimax(chessBoard, depth - 1, !isMax);
				undoMove(chessBoard, listPosibleMoves.substring(i, i + 5));
				best = Math.min(val, best);
			}
			return best;
		}
		return -1;
	}

	public String findBestMoveMiniMax(String[][] chessBoard, boolean isMax) {
		String bestMove = "";
		int best = -Integer.MAX_VALUE;
		String listPosibleMoves = posibleMoves(chessBoard);
		for (int i = 0; i < listPosibleMoves.length() - 4; i += 5) {
			String temp = listPosibleMoves.substring(i, i + 5);
			makeMove(chessBoard, temp);
			int val = minimax(chessBoard, 2, !isMax);
			undoMove(chessBoard, temp);
			if (val > best) {
				best = val;
				bestMove = temp;
			}
		}
		return bestMove;
	}

	public static void main(String[] args) {

		LogicChess ab = new LogicChess();
//		ab.flipBoard();
//		ab.makeMove(ab.chessBoard,2191 + "K");
//		ab.undoMove(ab.chessBoard,2191 + "K");

//		ab.makeMove(7172+" ");
//		ab.undoMove(7172+" ");
//		System.out.println(ab.posibleMovesL(ab.chessBoard));

//-------------------------IN RA BAN CO--------------------------
		System.out.print("  ");
		for (int i = 0; i < 9; i++) {
			System.out.print(i + " ");
		}
//		=====
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < 9; j++) {
				System.out.print(ab.chessBoard[i][j] + " ");
			}
			System.out.println();
		}

		JFrame f = new JFrame();
		ChessBoard board = new ChessBoard(ab);
		f.getContentPane().add(board);
		f.setResizable(false);
		f.setSize(700, 700);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

//		System.out.println(ab.alphabeta(ab.chessBoard, 2, -100000000, 100000000, true));
//		System.out.println(ab.findBestMove(ab.chessBoard, true));

	}
}
