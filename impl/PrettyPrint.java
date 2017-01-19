package impl;

import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix. Let us show you some
 * examples to clarify what we mean.
 * 
 * Example 1:
 * 	- Input: A = 4. 
 * 	- Output:
 * 			4 4 4 4 4 4 4 
 *			4 3 3 3 3 3 4 
 *			4 3 2 2 2 3 4 
 *			4 3 2 1 2 3 4 
 *			4 3 2 2 2 3 4 
 *			4 3 3 3 3 3 4 
 *			4 4 4 4 4 4 4
 *			
 * 
 * Example 2: 
 *	- Input: A = 3.
 *	- Output:
 *			3 3 3 3 3 
 *			3 2 2 2 3 
 *			3 2 1 2 3 
 *			3 2 2 2 3 
 *			3 3 3 3 3
 *  
 * @author Mohamed Sherif
 *
 */
public class PrettyPrint {

//	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
//	
//	}
	
	public static int[][] prettyPrint1(int a) {
		int n = (a*2)-1;
		int[][] arr = new int [n][n];
		
		for(int i = 0; i<= n/2; i++){
			for (int j = i; j <= n/2; j++) {
				arr[i][j] = a-i;
				arr[j][i] = a-i;
				
				arr[i][n-1-j] = a-i;
				arr[n-1-j][i] = a-i;
				
				arr[n-1-i][j] = a-i;
				arr[j][n-1-i] = a-i;
				
				arr[n-1-i][n-1-j] = a-i;
				arr[n-1-j][n-1-i] = a-i;
			}
		}
		
		return arr;
	}
	
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		int n = (a*2) - 1;
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> newArr = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				newArr.add(0);
			}
			arr.add(newArr);
		}
		
		for(int i = 0; i<= n/2; i++){
			for (int j = i; j <= n/2; j++) {
				arr.get(i).set(j, a-i);
				arr.get(j).set(i, a-i);

				arr.get(i).set(n-1-j, a-i);
				arr.get(n-1-j).set(i, a-i);
				
				arr.get(n-1-i).set(j, a-i);
				arr.get(j).set(n-1-i, a-i);
				
				arr.get(n-1-i).set(n-1-j, a-i);
				arr.get(n-1-j).set(n-1-i, a-i);
			}
		}
		
		return arr;
	}
		
	
	public static void main(String[] args) {
		int[][] arr = prettyPrint1(4);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		ArrayList<ArrayList<Integer>> list = prettyPrint(4);
		System.out.println("----------------");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
