package impl;

public class CodilityTestSolution {

	public static int solution(int A, int B) {
		// write your code in Java SE 8
		int ret = 0;
		double sqrt = 0;
		int x = 0;
		
		for (int i = A; i <= B; i++) {
			sqrt = Math.sqrt(i);
			x = (int) sqrt;
			
			if(Math.pow(sqrt, 2) == Math.pow(x, 2))
				ret++;
			
//			if(x*x == i)
//				ret ++;
		}
		
		return ret;
	}
	
	
	public static int maxDiff(int [] A){
		int ans = 0;
		int n = A.length; 
	    
	    int max1 = Integer.MIN_VALUE;
	    int max2 = Integer.MIN_VALUE;
	    
	    int min1 = Integer.MAX_VALUE;
	    int min2 = Integer.MAX_VALUE; 
	    
	    for(int i = 0; i < n; i++){
	        max1 = Math.max(max1, A[i] - i);
	        max2 = Math.max(max2, A[i] - i);
	        min1 = Math.min(min1, A[i] + i);
	        min2 = Math.min(min2, A[i] - i);
	    }   
	    ans = Math.max(ans, max2 - min2);
	    ans = Math.max(ans, max1 - min1);
	    return ans;
	}
	
	public static int maxDiff2(int[] A){

		int maxDif = 0;
		
		for (int i = 0; i < A.length-1; i++) {
			for (int j = i; j < A.length; j++) {
				maxDif = Math.max(maxDif, (A[i] + A[j]) + (j - i));
			}
		}
		
		return maxDif;
	}
	
	public static int maxDiff3(int[] A){
		int N = A.length;
	
		int[] sumJ = new int[N];
		for (int j =0; j < N; j++)
		{
		      sumJ[j] = A[j] + j;
		}
		
		int maxJ = Integer.MIN_VALUE;
		int maxJIndex = -1;
		
		for (int j =0; j < N; j++)
		{
		     if (sumJ[j] > maxJ)
		     {
		           maxJ = sumJ[j];
		           maxJIndex = j;
		     }
		}
		
		int[] sumI = new int[N];
		for (int i =0; i < N; i++)
		{
		      sumI[i] = A[i] - i;
		}
		 
		int maxI = Integer.MIN_VALUE;
		int maxIIndex = -1;
		for (int i =0; i < N; i++)
		{
		     if (sumI[i] > maxI)
		     {
		          maxI = sumI[i];
		          maxIIndex = i;
		     }
		}
		
		return maxI + maxJ;
	}
	
	
	public static void main(String[] args) {
//		System.out.println(solution(4, 17));
//		System.out.println(solution(5, 2147483647));
		
		int[] nume =  {1, 3, -3} ; //{-8, 4, 0, 5, -3, 6};
		System.out.println(maxDiff3(nume));
	}
}
