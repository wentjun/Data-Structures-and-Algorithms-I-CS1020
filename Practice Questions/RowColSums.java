// RowColSums.java
// To compute the row and column sums of a 2D array.
import java.util.*;

public class RowColSums {
	
	//compute the sum of values in respective rows
	public static int[] computeRowSums(int[][] array2D){
		int[] rowArr = new int[array2D.length];
		int sum = 0;
		
		for(int i = 0;i < array2D.length;i++){
			for(int j=0;j < array2D[i].length;j++){
				sum += array2D[i][j];                
			}
			rowArr[i] = sum;
			sum = 0;
		}        
		return rowArr;
	}

	//compute sum of values in respective columns
	public static int[] computeColSums(int[][] array2D){
		int[] colArr = new int[array2D[0].length];
		int sum = 0;

		for(int i = 0; i < array2D[0].length; i++){
			for(int j=0; j < array2D.length; j++){
				sum += array2D[j][i];          
			}
			colArr[i] = sum;
			sum = 0;
		}
		return colArr;
	}


	public static void main(String[] args) {
		int[][] array2D;

		// code to read values into 2D array called 'array2D'
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rows and columns: ");
		int numberOfRows = sc.nextInt();
		int numberOfColumns = sc.nextInt();

		System.out.println("Enter values for 2D array:");

		array2D = new int[numberOfRows][numberOfColumns];

		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				array2D[i][j] = sc.nextInt();
			}
		} 
		
		int[] rowSums = computeRowSums(array2D);
		System.out.print("Row sums: ");
		System.out.println(Arrays.toString(rowSums));

		int[] colSums = computeColSums(array2D);
		System.out.print("Column sums: ");
		System.out.println(Arrays.toString(colSums));

	}
}
