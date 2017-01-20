package impl;

import java.math.BigInteger;

/**
 * A class that contains solutions for all problem of the Strings part of level 3.
 * 
 * @author Mohamed Sherif
 *
 */
public class StringsSolver {

	/**
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * Read more details about roman numerals at Roman Numeric System
	 * 
	 * Example :
	 * 
	 * Input : "XIV" Return : 14 Input : "XX" Output : 20
	 * 
	 * @param a
	 * @return
	 */
	public static int romanToInt(String a) {
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = a.toUpperCase();
		/*
		 * operation to be performed on upper cases even if user enters roman
		 * values in lower case chars
		 */
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		return decimal;
	}

	public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

//	============================================================
	
	/**
	 * Given an integer, convert it to a roman numeral, and return a string
	 * corresponding to its roman numeral version
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * Example :
	 * 	- Input : 5 
	 * 	- Return : "V"
	 * 
	 * 	- Input : 14 
	 * 	- Return : "XIV"
	 * 
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    
		return sb.toString();
	}
	
//	===============================================
	
	
	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * Example:
	 * 
	 * "A man, a plan, a canal: Panama" is a palindrome.
	 * 
	 * "race a car" is not a palindrome.
	 * 
	 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
	 * 
	 * @param s
	 * @return
	 */
	public static int isPalindrome(String s) {
	    int isPalindrome = 1;
		
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			
		if (!actual.equalsIgnoreCase("")) {	
			for (int i = 0; i <= actual.length()/2; i++) {
				if(actual.charAt(i) != actual.charAt(actual.length()-1-i))
					return 0;
			}
		}
		
		return isPalindrome;
	}
	
//	=============================================
	
	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * Example:
	 * 
	 * Given s = "Hello World",
	 * 
	 * return 5 as length("World") = 5.
	 * 
	 * Please make sure you try to solve this problem without using library
	 * functions. Make sure you only traverse the string once.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(final String s) {
		
	    if(s.equalsIgnoreCase(""))
			return 0;
		
		String[] stArr = s.split(" ");
		
		if(stArr.length == 0)
			return 0;
		
		return stArr[stArr.length - 1].length();
	}
	
	
	
//	==========================
	
	/**
	 * Given an input string, reverse the string word by word.
	 * 
	 * Example:
	 * 
	 * Given s = "the sky is blue",
	 * 
	 * return "blue is sky the".
	 * 
	 * A sequence of non-space characters constitutes a word. Your reversed
	 * string should not contain leading or trailing spaces, even if it is
	 * present in the input string. If there are multiple spaces between words,
	 * reduce them to a single space in the reversed string
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
	    s = s.replaceAll("\\s+", " ");
	    String[] strArr = s.split(" ");
	    
	    for (int i = strArr.length-1; i >= 0; i--) {
	    	if(!strArr[i].equalsIgnoreCase(" ") && !strArr[i].equalsIgnoreCase("")){
	    		sb.append(strArr[i]);
		    	if (i != 0) {
		    		sb.append(" ");
				}
	    	}
    	}
		return sb.toString().trim();
	}
	
//	==========================
	
	/**
	 * 
	 * 
	 * 
	 * Compare two version numbers version1 and version2.
	 * 
	 * If version1 > version2 return 1, 
	 * If version1 < version2 return -1,
	 * otherwise return 0. 
	 * 
	 * You may assume that the version strings are non-empty and contain only digits and the '.' character. 
	 * The '.' character does not represent a decimal point and is used to separate number sequences. 
	 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision 
	 * of the second first-level revision.
	 * 
	 * Here is an example of version numbers ordering:
	 * 
	 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
	 * 
	 * The Correct answer.
	 * 
	 * BigInteger Class is used instead of Integer to handle the case of the
	 * very large Input Strings.
	 * 
	 * This Test Case not exist on LeetCode, I faced it on InterviewBit.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compareVersion(String a, String b) {
	    String[] v1 = a.split("\\.");
	    String[] v2 = b.split("\\.");
	    
	    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
	        BigInteger num1 = i < v1.length ? new BigInteger(v1[i]) : new BigInteger("0");
	        BigInteger num2 = i < v2.length ? new BigInteger(v2[i]) : new BigInteger("0");
	        
	        int compare = num1.compareTo(num2);
	    	if (compare != 0) {
	    		return compare;
	    	}

	    } 
	    
	    return 0;
	}

	
//	============================
	
	/**
	 * The normal Power-Of-2 Problem from LeetCode. No Special Cases.
	 * @param a
	 * @return
	 */
	public static int power2(String a) {
        int N = Integer.parseInt(a);
        if(N == 0)
            return 0;
        
        while(N >= 1){
            N = N/2;
            if(N % 2 != 0 && N != 1)
            	return 0;
        }
        return 1;
    }
	
	/**
	 * Find if Given number is power of 2 or not. More specifically, find if
	 * given number can be expressed as 2^k where k >= 1.
	 * 
	 * - Input: number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range) 
	 * - Output: return 1 if the number if a power of 2 else return 0
	 * 
	 * Example:
	 * 
	 * - Input : 128 
	 * - Output : 1
	 * 
	 * @param a
	 * @return
	 */
	public static int power(String a) {
        BigInteger n = new BigInteger(a);
        
        if(n.compareTo(java.math.BigInteger.ONE)==0 || n.compareTo(java.math.BigInteger.ZERO)==0)return 0;
        for(int i=0; i < n.bitLength()-1; i++){
            if(n.testBit(i))
            	return 0;
        }
        return n.testBit(n.bitLength()-1)?1:0;
    }
	
	/**
	 * This solution provided on the InterviewBit website.
	 * @param A
	 * @return
	 */
	public static int power_InterviewBitAnswer(String A) {
		String dividend = A;
		StringBuilder str;

		if (A == null || A.length() == 0)
			return 0;

		if (A.length() == 1 && A.charAt(0) == '0')
			return 0;

		while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
			str = new StringBuilder();
			int carry = 0;
			int n = dividend.length();

			if (n > 0) {
				int num = dividend.charAt(n - 1) - '0';
				if (num % 2 == 1)
					return 0;
			}

			for (int i = 0; i < n; i++) {
				char c = (char) (dividend.charAt(i) - '0');
				int res = c + 10 * carry;
				c = (char) (res / 2 + '0');
				carry = res % 2;
				str.append(c);
			}

			if (str.charAt(0) == '0')
				str.deleteCharAt(0);

			dividend = str.toString();
		}
		return 1;
	}
	
//	=======================================
	
	public static void main(String[] args) {
//		System.out.println(intToRoman(14));
//		
//		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//		
//		System.out.println(reverseWords(" ankrqzzcel  dyaiug y rkicv t"));
	
		System.out.println(power("1281"));
		System.out.println(power_InterviewBitAnswer("128"));
		
//		System.out.println(compareVersion("3", "4.12345"));
		
	}
}
