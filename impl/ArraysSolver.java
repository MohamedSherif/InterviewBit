package impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;

import javax.print.attribute.IntegerSyntax;

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

	public ArrayList<Integer> findPerm(final String A, int B) {

		if (A.length() != B - 1)
			return null;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != 'I' && A.charAt(i) != 'D') {
				return null;
			}
		}

		ArrayList<Integer> res = new ArrayList<Integer>(B);
		int start = 1;
		int upto = B;

		for (int i = 0; i < B - 1 && start < upto; i++) {

			if (A.charAt(i) == 'D') {
				res.add(upto--);
			} else {
				res.add(start++);
			}
		}

		if (start == upto)
			res.add(start);

		return res;
	}

	public static List<Integer> getMaxAbsDiff(int[] nums) {

		int maxDiff = 0;
		ArrayList<Integer> differents = new ArrayList<Integer>();

		if (nums.length == 1) {
			differents.add(nums[0]);
			return differents;
		}

		for (int i = 0; i < nums.length - 1; i++) {

			int leftSum = 0;
			int rightSum = 0;

			// Sum Left SubArray
			for (int j = 0; j <= i; j++) {
				leftSum += nums[j];
			}

			// Sum Right SubArray
			for (int j = i + 1; j < nums.length; j++) {
				rightSum += nums[j];
			}

			differents.add(Math.abs(rightSum - leftSum));
		}

		Collections.sort(differents);

		return differents;
	}

	public static int maxDifSubArr(int[] a) {
		int n = a.length;

		if (n < 2)
			return 0;

		int[] leftMax = new int[a.length], leftMin = new int[a.length], rightMax = new int[a.length],
				rightMin = new int[a.length];

		leftMax[0] = leftMin[0] = a[0];

		int sumMax = a[0];
		int sumMin = a[0];

		for (int i = 1; i < a.length; i++) {
			if (sumMin > 0)
				sumMin = 0;

			sumMax += a[i];
			sumMin += a[i];

			leftMax[i] = Math.max(sumMax, leftMax[i - 1]);
			leftMin[i] = Math.min(sumMin, leftMin[i - 1]);

			if (sumMax < 0)
				sumMax = 0;

		}

		sumMax = sumMin = a[a.length - 1];
		rightMax[rightMin.length - 1] = rightMin[rightMin.length - 1] = a[a.length - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (sumMin > 0)
				sumMin = 0;

			sumMax += a[i];
			sumMin += a[i];

			rightMax[i] = Math.max(sumMax, rightMax[i + 1]);
			rightMin[i] = Math.min(sumMin, rightMin[i + 1]);

			if (sumMax < 0)
				sumMax = 0;
		}

		int res = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			res = Math.max(res, Math.abs(leftMax[i - 1] - rightMax[i]));
		}

		for (int i = n - 2; i >= 0; i--) {
			res = Math.max(res, Math.abs(rightMax[i + 1] - leftMin[i]));
		}

		return res;
	}

	public static int MaxAbsDif(int[] a) {
		int maxDif = 0;

		ArrayList<Integer> difs = new ArrayList<Integer>();

		for (int i = 1; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				maxDif = Math.max(maxDif, Math.abs(a[i] - a[j]) + Math.abs(i - j));
			}
			difs.set(i, Math.max(maxDif, difs.get(i - 1)));
		}

		Collections.sort(difs);

		return difs.get(0);
	}

	public int maxArr(ArrayList<Integer> A) {
		int maxDif = 0;

		ArrayList<Integer> difs = new ArrayList<Integer>();

		for (int i = 0; i < A.size() - 1; i++) {
			for (int j = i + 1; j < A.size(); j++) {
				maxDif = Math.max(maxDif, Math.abs(A.get(i) - A.get(j)) + Math.abs((i) - (j)));
			}
			difs.add(maxDif);
		}

		int ret = difs.get(0);
		for (int i : difs) {
			if (ret < i) {
				ret = i;
			}
		}

		return ret;

	}

	/**
	 * Find out the maximum sub-array of non negative numbers from an array. The
	 * sub-array should be continuous. That is, a sub-array created by choosing
	 * the second and fourth element and skipping the third element is invalid.
	 * 
	 * Maximum sub-array is defined in terms of the sum of the elements in the
	 * sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
	 * 
	 * Example:
	 * 
	 * A : [1, 2, 5, -7, 2, 3] The two sub-arrays are [1, 2, 5] [2, 3]. The
	 * answer is [1, 2, 5] as its sum is larger than [2, 3] NOTE: If there is a
	 * tie, then compare with segment's length and return segment which has
	 * maximum length NOTE 2: If there is still a tie, then return the segment
	 * with minimum starting index
	 * 
	 * See Expected Output
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		long maxSum = 0;
		long newSum = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (Integer i : a) {
			if (i >= 0) {
				newSum += i;
				newArray.add(i);
			} else {
				newSum = 0;
				newArray = new ArrayList<Integer>();
			}
			if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
				maxSum = newSum;
				maxArray = newArray;
			}
		}
		return maxArray;
	}

	public static int maximumGap(ArrayList<Integer> nums) {
		int n = nums.size();

		if (n <= 1)
			return 0;

		Collections.sort(nums);

		ArrayList<Integer> gaps = new ArrayList<Integer>();

		for (int i = n - 1; i > 0; i--) {
			gaps.add(nums.get(i) - nums.get(i - 1));
		}

		Collections.sort(gaps);

		return gaps.get(gaps.size() - 1);
	}

	/**
	 * This is a demo task.
	 * 
	 * A zero-indexed array A consisting of N integers is given. An equilibrium
	 * index of this array is any integer P such that 0 ≤ P < N and the sum of
	 * elements of lower indices is equal to the sum of elements of higher
	 * indices, i.e. A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] +
	 * A[N−1]. Sum of zero elements is assumed to be equal to 0. This can happen
	 * if P = 0 or if P = N−1.
	 * 
	 * For example, consider the following array A consisting of N = 8 elements:
	 * 
	 * A[0] = -1 
	 * A[1] = 3 
	 * A[2] = -4 
	 * A[3] = 5 
	 * A[4] = 1 
	 * A[5] = -6 
	 * A[6] = 2 
	 * A[7] = 1
	 *  
	 * P = 1 is an equilibrium index of this array, because:
	 * 
	 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7] 
	 * 
	 * P = 3 is an equilibrium index of this array, because:
	 * 
	 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7] 
	 * 
	 * P = 7 is also an equilibrium index, because:
	 * 
	 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0 
	 * and there are no elements with indices greater than 7.
	 * 
	 * P = 8 is not an equilibrium index, because it does not fulfill the
	 * condition 0 ≤ P < N.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); } that, given a
	 * zero-indexed array A consisting of N integers, returns any of its
	 * equilibrium indices. The function should return −1 if no equilibrium
	 * index exists.
	 * 
	 * For example, given array A shown above, the function may return 1, 3 or
	 * 7, as explained above.
	 * 
	 * Assume that:
	 * 
	 * N is an integer within the range [0..100,000]; each element of array A is
	 * an integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
	 * 
	 * expected worst-case time complexity is O(N); expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 * Copyright 2009–2016 by Codility Limited. All Rights Reserved.
	 * Unauthorized copying, publication or disclosure prohibited.
	 * 
	 * @param A
	 * @return
	 */
	public int equilibriumIndex(int[] A) {
		// write your code in Java SE 8

		int ret = -1;
		long rightSum = 0;
		long leftSum = 0;

		for (int i = 0; i < A.length; i++) {
			rightSum += A[i];
		}

		for (int i = 0; i < A.length; i++) {
			long tempSum = rightSum - A[i];
			if (leftSum == tempSum)
				return i;

			leftSum += A[i];
			rightSum = tempSum;
		}

		return ret;
	}

	public static void rotateMatrix(int[][] nums) {
		int n = nums.length;
		int m = nums[0].length;

		int[][] temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[j][(n - 1 - i)] = nums[i][j];
			}
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (j == 0) {
					System.out.print("[" + temp[i][j] + ",");
				} else if (j == n - 1) {
					System.out.print(temp[i][j] + "]");
				} else {
					System.out.print(temp[i][j] + ",");
				}
			}
			System.out.println();
		}
	}

	// An Inplace function to rotate a N x N matrix
	// by 90 degrees in anti-clockwise direction
	public static void rotateMatrix2(int mat[][]) {
		int n = mat.length;

		// Consider all squares one by one
		for (int i = 0; i < n / 2; i++) {
			// Consider elements in group of 4 in
			// current square
			for (int j = i; j < n - i - 1; j++) {
				// store current cell in temp variable
				int temp = mat[i][j];

				// move values from top to right
				mat[i][j] = mat[n - 1 - j][i];

				// move values from right to bottom
				mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];

				// move values from bottom to left
				mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];

				// assign temp to bottom
				mat[j][n - 1 - i] = temp;
			}
		}
	}

	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();

		// Consider all squares one by one
		for (int i = 0; i < n / 2; i++) {
			// Consider elements in group of 4 in
			// current square
			for (int j = i; j < n - i - 1; j++) {
				// store current cell in temp variable
				int temp = a.get(i).get(j);

				// move values from top to right
				a.get(i).set(j, a.get(n - 1 - j).get(i)); // mat[n-1-j][i];

				// move values from right to bottom
				a.get(n - 1 - j).set(i, a.get(n - 1 - i).get(n - 1 - j)); // mat[n-1-i][n-1-j];

				// move values from bottom to left
				a.get(n - 1 - i).set(n - 1 - j, a.get(j).get(n - 1 - i)); // [n-1-j]
																			// =
																			// mat[j][n-1-i];

				// assign temp to bottom
				a.get(j).set(n - 1 - i, temp);// [j][n-1-i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// int[][] a = { { 0, 1 }, { 1, 1 } };
		//
		// setMatrixZeroes(a);

		// int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
		//
		// List<Integer> res = getMaxAbsDiff(nums);
		// for(int i : res){
		// System.out.println(i);
		// }

		// int[] a = { 2, -1, -2, 1, -4, 2, 8 };
		// System.out.println(maxDifSubArr(a));

		// ArrayList<Integer> nums = new ArrayList<Integer>();
		//
		// nums.add(1);
		// nums.add(2);
		// nums.add(5);
		// nums.add(-7);
		// nums.add(2);
		// nums.add(3);

		// ArrayList<Integer> res = maxset(nums);
		// for (int i : res) {
		// System.out.println(i);
		// }
		//
		// ArrayList<Integer> nums = new ArrayList<Integer>();
		// nums.add(1);
		// nums.add(10);
		// nums.add(15);
		// nums.add(12);
		// nums.add(11);
		// nums.add(18);
		// nums.add(20);
		//
		// System.out.println(maximumGap(nums));

		int[][] nums = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		rotateMatrix2(nums);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (j == 0) {
					System.out.print("[" + nums[i][j] + ",");
				} else if (j == nums.length - 1) {
					System.out.print(nums[i][j] + "]");
				} else {
					System.out.print(nums[i][j] + ",");
				}
			}
			System.out.println();
		}
	}
}
