package sorterSSN;

/**
 * Radix Sort algorithm based off the pseudo code from "Introduction to Algorithms".
 * @author		Calvin Luong Copyright (2019)
 * @version		1.0
 */
public class radixSort {
	
	public void countingSort(int A[], int[] B, int d)
	{
		int k = 9;
		
		int[] C = new int[k + 1];
		
		for (int i = 0; i < k; i++)
		{
			C[i] = 0;
		}
		
		for (int j = 0; j < A.length; j++)
		{
			C[(A[j] / d) % 10] = C[(A[j] / d) % 10] + 1;
		}
		
		for (int i = 1; i <= k; i++)
		{
			C[i] = C[i] + C[i - 1];
		}
		
		for (int j = A.length - 1; j >= 0; j--)
		{
			B[C[(A[j] / d) % 10] - 1] = A[j];
			C[(A[j] / d) % 10] = C[(A[j] / d) % 10] - 1;
		}
	}

	public void radixSort(int A[], int d)
	{
		int[] B = new int[A.length];
		for (int i = 1; i <= d; i = i * 10)
		{
			countingSort(A, B, i);
			
			for (int j = 0; j < A.length; j++)
			{
				A[j] = B[j];
			}
			
			B = new int [A.length];
		}
	}
}
