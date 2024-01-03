package View;

public class test {
	public static void main(String[] args) {
		int[][] originalArray =  { { 6, 4, 0, -10, -12, -10, 0, 4, 6 }, // cannon
				{ 2, 2, 0, -4, -14, -4, 0, 2, 2 }, { 2, 2, 0, -10, -8, -10, 0, 2, 2 }, { 0, 0, -2, 4, 10, 4, -2, 0, 0 },
				{ 0, 0, 0, 2, 8, 2, 0, 0, 0 }, { -2, 0, 4, 2, 6, 2, 4, 0, -2 }, { 0, 0, 0, 2, 4, 2, 0, 0, 0 },
				{ 4, 0, 8, 6, 10, 6, 8, 0, 4 }, { 0, 2, 4, 6, 6, 6, 4, 2, 0 }, { 0, 0, 2, 6, 6, 6, 2, 0, 0 } };

		int[] pieceValue = new int[] { 1000000, 110, 110, 300, 600, 300, 70 };
		int[][] reversedArray = reverse2DArray(originalArray);

		// In mảng đã lật ngược
		for (int[] row : reversedArray) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	// Hàm để lật ngược mảng hai chiều
	private static int[][] reverse2DArray(int[][] a) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				int temp = a[i][j];
				a[i][j] = a[9 - i][8 - j];
				a[9 - i][8 - j] = temp;
			}
		}

		return a;
	}
}
