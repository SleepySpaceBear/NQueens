import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class NQueens {
	private static boolean[][] board;
	private static int size;
	private static int solutions = 0;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter size of board: ");
		size = keyboard.nextInt();
		board = new boolean[size][size];
		
		solve(0);

		System.out.println(solutions);

		keyboard.close();
	}

	static void solve(int x) {
		for(int i = 0; i < size; i++) {
			if(isSafe(x, i)) {
				if(x < size - 1) {
					board[x][i] = true;
					solve(x + 1);
					board[x][i] = false;
				}
				else {
					solutions++;
				}		
			}
		}
	}

	static boolean isSafe(int x, int y) {
		for(int i = 0; i < size; i++) {
			if(board[i][y]) {
				return false;
			}
		}

		for(int i = x, j = y; i < size && j < size; i++, j++) {
			if(board[i][j]) {
				return false;
			}
		}
		for(int i = x, j = y; i >= 0 && j < size; i--, j++) {
			if(board[i][j]) {
				return false;
			}
		}
		for(int i = x, j = y; i < size && j >= 0; i++, j--) {
			if(board[i][j]) {
				return false;
			}
		}
		for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j]) {
				return false;
			}
		}

		return true;
	}
}
