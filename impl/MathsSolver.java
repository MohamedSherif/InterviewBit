package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MathsSolver {

	public static boolean[] isPrime;

	/**
	 * Given an even number ( greater than 2 ), return two prime numbers whose
	 * sum will be equal to given number.
	 * 
	 * NOTE A solution will always exist. read Goldbach’s conjecture
	 * 
	 * Example: Input : 4 Output: 2 + 2 = 4
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
	// ============================================================

	/**
	 * Given a positive integer which fits in a 32 bit signed integer, find if
	 * it can be expressed as A^P where P > 1 and A > 0. A and P both should be
	 * integers.
	 * 
	 * Example
	 * 
	 * Input : 4 Output : True as 2^2 = 4.
	 * 
	 * @param A
	 * @return
	 */
	public boolean isPower1(int A) {

		double x = 2;
		double i;
		if (A == 1)
			return true;

		// largest number as power for 32 bit integer 2^32
		// 2^16 can have one power (2^16)^2 = 2^32
		for (i = 2; (i < 33) && (x <= (double) (Math.pow(2, 16))); i++) {
			if (Math.pow(x, i) == (double) A)
				return true;

			if (Math.pow(x, i) >= Math.pow(2, 32)) {
				i = 1;
				x++;
			}
		}
		return false;
	}

	public boolean isPower2(int A) {

		if (A == 1)
			return true;
		for (double x = 2; x <= Math.pow(2, 16); x++) {
			for (double i = 2; i < 33; i++) {
				if (Math.pow(x, i) == A)
					return true;
				if (Math.pow(x, i) >= Math.pow(2, 32))
					break;
			}
		}
		return false;
	}

	/**
	 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1)
	 * extra space.
	 * 
	 * Example:
	 * 
	 * Input : [1, 0] Return : [0, 1]
	 * 
	 * @param a
	 */
	public void arrange(ArrayList<Integer> a) {
		if (a == null || a.size() == 0)
			return;

		int n = a.size();

		/*
		 * the array contains elements from 0-n-1, a total of n elements, if we
		 * do a[i]%n, it will always return a[i] as the maximum the array can
		 * hold is n-1. Now, if we do a[a[i]]*n+a[i], then this will hold both
		 * the old value and new value if we do not (a[a[i]]*n+a[i])/n we get
		 * the new val for i, (a[a[i]]*n+a[i])%n we get back the old val
		 */

		for (int i = 0; i < a.size(); i++) {
			int nextVal = (a.get(a.get(i)) % n) * n + a.get(i);
			// %n is necessary because the values are getting change
			// if we want to retrieve the prev value do (mod n)
			a.set(i, nextVal);
		}

		for (int i = 0; i < a.size(); i++) {
			int nVal = a.get(i) / n;
			a.set(i, nVal);
		}
	}

	public static int getGcd(int a, int b) {
		int gcd = 1;

		for (int i = 1; (i < a) && (i < b); i++) {
			if (a % i == 0 && b % i == 0) {
				if (gcd < i) {
					gcd = i;
				}
			}
		}

		return gcd;
	}

	/**
	 * A recursive method would be:
	 * 
	 * @param a
	 * @param b
	 * @return
	 */

	static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return a + b; // base case
		return gcd(b, a % b);
	}

	/**
	 * Using a while loop:
	 * 
	 * @param a
	 * @param b
	 * @return
	 */

	static int gcd2(int a, int b) {
		while (a != 0 && b != 0) // until either one of them is 0
		{
			int c = b;
			b = a % b;
			a = c;
		}
		return a + b; // either one is 0, so return the non-zero value
	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 * 
	 * A palindrome integer is an integer x for which reverse(x) = x where
	 * reverse(x) is x with its digit reversed. Negative numbers are not
	 * palindromic.
	 * 
	 * Example :
	 * 
	 * 	Input : 12121 
	 * Output : True
	 * 
	 * 	Input : 123 
	 * Output : False See Expected Output
	 * 
	 * @param a
	 * @return
	 */

	public static boolean isPalindromeNum(int a) {
		int rev = 0;
		int num = a;

		while (num > 0) {
			int dig = num % 10;

			rev = (rev * 10) + dig;

			num = num / 10;
		}

		if (rev == a)
			return true;

		return false;
	}

	/**
	 * InterviewBit Answer.
	 * 
	 * @param A
	 * @return
	 */
	public int isPalindrome(int A) {
		String str = String.valueOf(A);
		boolean pal = palindrome(str);
		return pal ? 1 : 0;
	}

	public boolean palindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}
	// ******************************************************************

	public static void main(String[] args) {
		// fillPrimes(25);
		// for (int i = 0; i < isPrime.length; i++) {
		// if (isPrime[i] == true) {
		// System.out.println(i + " - " + isPrime[i]);
		// }
		// }
		// System.out.println(System.currentTimeMillis());
		// System.out.println(getGcd(54, 24));
		// System.out.println(System.currentTimeMillis());

		System.out.println(isPalindromeNum(2147447412));
	}

}
