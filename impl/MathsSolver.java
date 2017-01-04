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
	 * Input : 12121 Output : True
	 * 
	 * Input : 123 Output : False See Expected Output
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

	/**
	 * Excel Column Number: Given a column title as appears in an Excel sheet,
	 * return its corresponding column number.
	 * 
	 * Example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 * 
	 * @param A
	 * @return
	 */
	public static int excelColumnNumber(String A) {
		int n = A.length();

		int value = 0;
		for (int i = 0; i < n; i++) {
			value += Math.pow(26, i) * (A.charAt(n - (i + 1)) - 'A' + 1);
		}
		return value;
	}

	public int titleToNumber(String A) {
		int[] val;

		val = new int[26];

		for (int i = 0; i < 26; i++) {
			val[i] = i + 1;
		}

		int ten = 1;
		int value = 0;

		for (int i = A.length() - 1; i >= 0; i--) {
			char c = A.charAt(i);
			value += (ten * val[c - 'A']);
			ten *= 26;
		}

		return value;
	}

	public static String numberToTitle(int a) {
		String result = "";

		char[] alphabet = new char[26];

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			alphabet[ch - 'A'] = ch;
		}

		if (a < 26) {
			result += alphabet[a - 1];
			return result;
		}

		while (a > 0) {
			int index = a;
			if (a % 26 == 0) {
				index = 26;
				a = a - 26;
			} else {
				index = a % 26;
			}
			result = alphabet[index - 1] + result;

			a = a / 26;
		}

		return result;
	}

	public static String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			n--;
			result.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}

		return result.toString();
	}

	// **************************************************************

	/**
	 * Reverse digits of an integer.
	 * 
	 * Example1:
	 * 
	 * x = 123,
	 * 
	 * return 321 Example2:
	 * 
	 * x = -123,
	 * 
	 * return -321
	 * 
	 * Return 0 if the result overflows and does not fit in a 32 bit signed
	 * integer
	 * 
	 * @param num
	 * @return
	 */
	public static int reverseInteger(int num) {
		long rev = 0;

		int sign = (num < 0) ? -1 : 1;

		int temp = Math.abs(num);

		while (temp > 0) {
			rev = rev * 10 + temp % 10;
			if (rev > Integer.MAX_VALUE) {
				return 0;
			}
			temp = temp / 10;
		}

		rev = rev * sign;

		return (int) rev;
	}

	/**
	 * Another correct answer.
	 * 
	 * @param A
	 * @return
	 */
	public static int reverse(int A) {
		// use long to monitor Stack Overflow
		long result = 0;
		while (A != 0) {
			result = result * 10 + (A % 10);
			A = A / 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) result;
		}
	}

	/**
	 * This was firstly submitted and failed in the case of integer overflow
	 * 
	 * -1146467285
	 * 
	 * @param num
	 * @return
	 */
	public int reverseIntegerWrong(int num) {
		// use long to monitor Stack Overflow
		int rev = 0;
		int dig = 0;

		boolean isNigative = false;

		if (num < 0) {
			isNigative = true;
		}

		int temp = Math.abs(num);

		while (temp > 0) {
			dig = temp % 10;

			rev = rev * 10 + dig;

			temp = temp / 10;
		}

		if (isNigative) {
			rev = rev * -1;
		}
		if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
			return 0;
		}
		return rev;
	}

	/**
	 * Website Complete Solution after submit
	 * 
	 * @param args
	 */

	public int reverse2(int A) {
		int reverse = A;
		int sign = 1;

		if (A < 0) {
			A *= -1;
			sign = -1;
		}

		reverse = reverseOf(A);

		if (reverse == Integer.MIN_VALUE)
			return 0;

		reverse *= sign;

		return reverse;

	}

	public int reverseOf(int num) {

		int newNum = 0;

		while (num > 0) {
			int digit = num % 10;

			if (newNum > Integer.MAX_VALUE / 10
					|| ((newNum == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10)) {
				return Integer.MIN_VALUE;
			}

			newNum = newNum * 10 + digit;
			num /= 10;
		}

		return (int) newNum;

	}
	// ******************************************************************

	public static int num(int i) {
		int j = 1;
		int num = 1;
		while (j <= i) {
			num = num * 5;
			j++;
		}
		return num;
	}

	public static int trailingZeroes(int A) {
		int count = 0;
		int i = 1;
		while (num(i) <= A) {
			count = count + (A / num(i));
			i++;
		}
		return count;
	}
	// ***********************************************************

	/**
	 * A robot is located at the top-left corner of an A x B grid (marked
	 * ‘Start’ in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * ‘Finish’ in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * Note: A and B will be such that the resulting answer fits in a 32 bit
	 * signed integer.
	 * 
	 * Example :
	 * 
	 * Input : A = 2, B = 2 Output : 2
	 * 
	 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1) OR : (0, 0) -> (1, 0) ->
	 * (1, 1)
	 * 
	 * @param r
	 * @param c
	 * @param m
	 * @param n
	 * @return
	 */

	public static int topDown(int m, int n) {
		int mat[][] = new int[m + 2][n + 2];
		for (int i = 0; i < m + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				mat[i][j] = -1;
			}
		}
		return backtrack(1, 1, m, n, mat);
	}

	public static int backtrack(int r, int c, int m, int n, int mat[][]) {
		if (r == m && c == n)
			return 1;
		if (r > m || c > n)
			return 0;

		if (mat[r + 1][c] == -1)
			mat[r + 1][c] = backtrack(r + 1, c, m, n, mat);
		if (mat[r][c + 1] == -1)
			mat[r][c + 1] = backtrack(r, c + 1, m, n, mat);

		return mat[r + 1][c] + mat[r][c + 1];
	}

	public static int dp_BottomUp(int m, int n) {
		int mat[][] = new int[m + 2][n + 2];

		for (int i = 0; i < m + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				mat[i][j] = 0;
			}
		}

		mat[m][n + 1] = 1;

		for (int r = m; r >= 1; r--) {
			for (int c = n; c >= 1; c--) {
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[1][1];
	}

	// ********************************************************
	/**
	 * You are given two positive numbers A and B. You need to find the maximum
	 * valued integer X such that:
	 * 
	 * X divides A i.e. A % X = 0 X and B are co-prime i.e. gcd(X, B) = 1 For
	 * example,
	 * 
	 * A = 30 B = 12 We return X = 5
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int coprimeDivisor(int a, int b) {
		/*
		 * Correct Answer but it takes long time to run (it failed in the Time Limit Exceeded) 
		 */
		fillPrimes(Math.min(a, b));

		int maxCoprime = 0;

		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i] == true) {
				if ((a % i == 0) && (b % i == 0)) {
					if (maxCoprime < i)
						maxCoprime = i;
				}
			}
		}

		return maxCoprime;
	}

	public static int coprimeDivisor2(int a, int b) {
		/*
		 * Correct Answer but it takes long time to run (it failed in the Time Limit Exceeded) 
		 */
		int maxCoprime = 0;

		for (int x = 1; x <= a; x++) {
			if (a % x == 0) {
				if (gcd(x, b) == 1) {
					if (maxCoprime < x)
						maxCoprime = x;
				} 
			}
		}

		return maxCoprime;
	}

	
	public static int cpFact(int a, int b) {
		/*
		 * The Correct Answer.
		 */
		if (gcd(a, b) == 1) {
			return a;
		}

		while (gcd(a, b) != 1) {
			a = a / gcd(a, b);
		}

		return a;
	}

	//****************************************
	
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

		// System.out.println(isPalindromeNum(2147447412));

		// System.out.println(excelColumnNumber("AB"));

		// System.out.println(reverseInteger(-1146467285));

		// System.out.println(reverse(-1146467285));

		// System.out.println(numberToTitle(300));
		// System.out.println(convertToTitle(300));

		// System.out.println(backtrack(0, 0, 23, 12));

		// System.out.println(td(23, 12));
		// System.out.println(dp(23, 12));

		System.out.println(cpFact(30, 12));
	}

}
