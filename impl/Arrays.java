package impl;

public class Arrays {

	public int firstMissingPositive(int[] A) {
	
		int n = A.length;
		
		for (int i = 0; i < n; i++) {
			while(A[i] != i){
				if(A[i] <= 0 || A[i] < n)
					break;
				
				if(A[i] == A[A[i]])
					break;
				
				int temp = A[i];
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if(A[i] != i){
				return i;
			}
		}
		
		return n;
	}
	
	
	public static int[][] setMatrixZeroes(int[][] matrix){
		
		boolean zeroesInFirstRow = false;
		boolean zeroesInFirstCol = false; 
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		//Loop on the first Column 
		for (int i = 0; i < m; i++) {
			if(matrix[i][0] == 0){
				zeroesInFirstCol = true;
				break;
			}
		}
		
		//Loop over the first Row
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				zeroesInFirstRow = true;
				break;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			if(matrix[i][0] == 0){
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < n; i++) {
			if(matrix[0][i] == 0){
				for (int j = 1; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		
		if(zeroesInFirstCol){
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		
		if(zeroesInFirstRow){
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		
		return matrix;
	}
	
	
	
	public static void main(String[] args) {
		int[][] a = {{0, 1},
				  {1, 1}};
		
		
		setMatrixZeroes(a);
		
	}
}
