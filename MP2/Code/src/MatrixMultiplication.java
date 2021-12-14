public class MatrixMultiplication {

	// Declares Arrays A,B,R, and an Array of WorkerThreads 
	static Matrix mA = new Matrix(); // matrix 1 created populated with rand #s
	static Matrix mB = new Matrix(); // matrix 2 created populated with rand #s
	static Matrix mR = new Matrix(0); // result matrix created populated with 0s
	public static WorkerThread[] Threads = new WorkerThread[5];

	public static void main(String[] args) {      
		// create 5 Worker threads and initialize them!
		for (int i = 0; i < Threads.length; i++)
		{
			Threads[i] = new WorkerThread(i, mA.matrix[i].length,mA,mB,mR);
			System.out.println("Thread " + i + " starting...");
			Threads[i].start();
		}

		// Wait until all threads are finished
		System.out.println("\n");
		for (int i = 0; i < Threads.length; i++)
		{
			try 
			{
				Threads[i].join();
				System.out.println("Thread " + i + " finished!");
			} 
			catch (InterruptedException ie) 
			{
				ie.printStackTrace();
			}
		}

		// Printing the first matrix
		System.out.println("\nThis is the first matrix:");
		mA.printMatrix();

		// Printing the second matrix
		System.out.println("\nThis is the second matrix:");
		mB.printMatrix();

		//Outputs the Values of Matrix C
		System.out.println("\nMatrix 1 * Matrix 2 = ");
		mR.printMatrix();
	}
}
class WorkerThread extends Thread{
	private Matrix A;
	private Matrix B;
	private Matrix C;

	public WorkerThread(int row, int col, Matrix mA,
			Matrix mB, Matrix mR) {
		this.A = mA;
		this.B = mB;
		this.C = mR;
	}

	// Row multiplication function (outputs a vector containing the values that correspond to row = "row" in matrix m1*m2
	public static int[] rowMult(Matrix mA, Matrix mB, int row)
	{
		// Check if multiplication is Possible
		if (mA.matrix.length != mB.matrix[row].length) {

			System.out.println(
					"\nMultiplication Not Possible");
			return null;
		}

		int sum = 0;
		int[] rowVect = new int[mB.matrix[row].length]; // initialize empty array of size = # of cols in matrix 2

		// Matrix multiplication (usually this would be a triple for-loop, but since we are only concerned with saving one specific row's values we can use a double one instead
		for (int i = 0; i < mB.matrix[row].length; i ++) // outer loop will parse thru columns of matrix 2
		{
			for (int j = 0; j < mB.matrix.length; j++) // inner loop will parse thru rows of matrix 2 = columns of matrix 1
			{
				sum += mA.matrix[row][j] * mB.matrix[j][i];
			}
			rowVect[i] = sum;
			sum = 0;
		}

		return rowVect;
	};

	public void run() {
		for(int r = 0; r < A.matrix.length; r ++)
		{
			C.appendToMatrix(rowMult(A,B,r), r);
		}
	}   
}