package telran.arrays;

public class MatricesInt {
public static int[][] multiplyConstant(int matrix[][], int constant){
	for (int i = 0; i < matrix.length; i++ ) {
		for (int j = 0; j < matrix[i].length; j++) {
			matrix[i][j] *= constant;
		}
	}
	return matrix;
}

public static int[] getColumn(int[][] matrix, int column) {
	//TODO
	return null;
}

public static int[][] transpMatrix(int[][] matrix){
	//TODO
	return null;
}
		
}
