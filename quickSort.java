package sorterSSN;

import java.util.Arrays;

/**
 * Quick Sort algorithm based off the pseudo code from "Introduction to Algorithms".
 * @author		Calvin Luong Copyright (2019)
 * @version		1.0
 */
public class quickSort {

	/*
	 * Splits the Array depending on the pivot point (last element).
	 * Everything on the left of the pivot point is less than or equal to.
	 * Everything on the right of the pivot point is greater than.
	 */
	public int partition(int A[], int p, int r)
	{
		int x = A[r];
		int i = p - 1;

		for (int j = p; j < r ; j++)
		{
			if (A[j] <= x)
			{
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

		int temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;

		i++;
		return i;
	}

	
	public void quickSort(int A[], int p, int r)
	{
		if (p < r)
		{
			// q is the pivot point of the Array.
			int q = partition(A, p, r);

			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

}
