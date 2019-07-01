package mine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Minesweeper {

	public static boolean uOpsegu(int i, int j, int[][] matrix) {
		if (i >= 0 && i < matrix.length)
			if (j >= 0 && j < matrix[i].length)
				return true;
		return false;
	}

	public static int brojMina(int[][] matrix, int i, int j) {
		int[][] pozicije = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
		int brojac = 0;
		for (int p = 0; p < pozicije.length; p++) {
			int i2 = i + pozicije[p][0];
			int j2 = j + pozicije[p][1];

			if (uOpsegu(i2, j2, matrix) && matrix[i2][j2] == 1)
				brojac++;
		}
		return brojac;
	}

	public static int[][] ucitajMapu() {
		int[][] mat = new int[100][100];
		try (BufferedReader r = new BufferedReader(
				new FileReader("C:\\Users\\Teona\\Favorites\\Documents\\minesweeper1.txt"))) {
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);

			int matrix[][] = new int[N][N];

			for (int i = 0; i < matrix.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			mat = matrix;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

	public static void main(String[] args) {
		int[][] kolikoMina = new int[100][100];
		int[][] mine = Minesweeper.ucitajMapu();
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine.length; j++) {
				kolikoMina[i][j] = brojMina(mine, i, j);

			}
		}
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine.length; j++) {
				System.out.print(kolikoMina[i][j]);
			}
			System.out.println();

		}

	}
}