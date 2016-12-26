package impl;

import java.util.ArrayList;
import java.util.Arrays;

public class MathsSolver {

	public static boolean[] isPrime;

	/**
	 * Given an even number ( greater than 2 ), return two prime numbers whose
	 * sum will be equal to given number.
	 * 
	 * NOTE A solution will always exist. read Goldbach’s conjecture
	 * 
	 * Example:
	 * 	Input : 4 
	 * 	Output: 2 + 2 = 4
	 * 
	 * If there are more than one solutions possible, return the
	 * lexicographically smaller solution.
	 * 
	 * If [a, b] is one solution with a <= b, and [c,d] is another solution with
	 * c <= d, then
	 * 
	 * [a, b] < [c, d]
	 * 
	 * If a < c OR a==c AND b < d. See Expected Output
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList<Integer> primeSum(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (a <= 1)
			return result;

		isPrime = new boolean[a];
		fillPrimes(a);

		int first = 2;
		int second = a - 2;
		while (first <= second) {
			if (isPrime[first] && isPrime[second]) {
				result.add(first);
				result.add(second);
				return result;
			} else {
				first++;
				second = a - first;
			}
		}
		return result;
	}

	public static void fillPrimes(int n) {
		isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = 2; i * j < n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
	}

	public ArrayList<Integer> primesum(int A) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 2; i < A; i++) {
			if (isPrime(i) && isPrime(A - i)) {
				arr.add(i);
				arr.add(A - i);
				return arr;
			}
		}
		return arr;
	}

	public boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		fillPrimes(25);
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i] == true) {
				System.out.println(i + " - " + isPrime[i]);
			}
		}
	}

}
