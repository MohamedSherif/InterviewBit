package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraysSolver {

	public int firstMissingPositive(int[] A) {

		int n = A.length;

		for (int i = 0; i < n; i++) {
			while (A[i] != i) {
				if (A[i] <= 0 || A[i] < n)
					break;

				if (A[i] == A[A[i]])
					break;

				int temp = A[i];
				A[i] = A[temp];
				A[temp] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i) {
				return i;
			}
		}

		return n;
	}

	public static int[][] setMatrixZeroes(int[][] matrix) {

		boolean zeroesInFirstRow = false;
		boolean zeroesInFirstCol = false;

		int m = matrix.length;
		int n = matrix[0].length;

		// Loop on the first Column
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				zeroesInFirstCol = true;
				break;
			}
		}

		// Loop over the first Row
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				zeroesInFirstRow = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// i=1
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				// j=1
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// i=1
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				// j=1
				for (int j = 0; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		if (zeroesInFirstCol) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

		if (zeroesInFirstRow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}

		return matrix;
	}

	
	/**
	 * Largest NumberBookmark Suggest Edit Given a list of non negative
	 * integers, arrange them such that they form the largest number.
	 * 
	 * For example:
	 * 
	 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 * 
	 * See Expected Output
	 * 
	 * @param a
	 * @return
	 */
	public String largestNumber(final List<Integer> a) {

		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 0; i < a.size(); i++) {
			arr.add(String.valueOf(a.get(i)));
		}

		Collections.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder sb = new StringBuilder();

		for (String s : arr) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		int[][] a = { { 0, 1 }, { 1, 1 } };

		setMatrixZeroes(a);

	}
}
