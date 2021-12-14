// Matrix constructor and helper functions
import java.util.Random;

public class Matrix {

	public int[][] matrix; // the matrix itself (content)
	
	// Constructor (generates 20x20 matrix and populates it with random numbers)
	public Matrix()
	{
		matrix = new int[20][20]; // generates matrix
		Random rand = new Random(); // generates random number
		
		// fills matrix with random numbers
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = rand.nextInt(10);
			}
		}
	}; 
	
	// Constructor Overload (generates 20x20 matrix and populates it with the input value)
	public Matrix(int input)
	{
		matrix = new int[20][20]; // generates 20x20 matrix

		// fills matrix with input value
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = input;
			}
		}
	};
	
	// Print function (prints a matrix)
	public void printMatrix()
	{
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	};
	
	// Appends the appropriate values to the specified row in the final matrix 
	public void appendToMatrix (int[] rowValues, int row)
	{
		for (int col = 0; col < rowValues.length; col++)
		{
			this.matrix[row][col] = rowValues[col]; 
		}
	};
	
}//End Class