import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class NQueens {
	//1  means queen
	//0  means safe

	private static int[][] board;
	private static int size;
	private static int solutions = 0;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter size of board: ");
		size = keyboard.nextInt();
		board = new int[size][size];

		solve();
	}

	static void solve() {
		solve(0);

		System.out.println(solutions);
	}

	static void solve(int x) {
		for(int i = 0; i < size; i++) {
			if(checkY(i) && checkDiag(x, i)) {
				if(x < size - 1) {
					board[x][i] = 1;
					solve(x + 1);
					board[x][i] = 0;
				}
				else {
					solutions++;
				}		
			}
		}
	}

	static boolean checkY(int y) {
		for(int i = 0; i < size; i++) {
			if(board[i][y] != 0) {
				return false;
			}
		}

		return true;
	}

	static boolean checkDiag(int x, int y) {
		for(int i = x, j = y; i < size && j < size; i++, j++) {
			if(board[i][j] != 0) {
				return false;
			}
		}
		for(int i = x, j = y; i >= 0 && j < size; i--, j++) {
			if(board[i][j] != 0) {
				return false;
			}
		}
		for(int i = x, j = y; i < size && j >= 0; i++, j--) {
			if(board[i][j] != 0) {
				return false;
			}
		}
		for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] != 0) {
				return false;
			}
		}

		return true;
	}
}