package sorterSSN;

import java.util.ArrayList;

/**
 * Bucket Sort algorithm based off the pseudo code from "Introduction to Algorithms".
 * @author		Calvin Luong Copyright (2019)
 * @version		1.0
 */
public class bucketSort {

	public void bucketSort(int A[])
	{
		// Creates 5 buckets. 
		// Each area number has two unique first digits.
		// 5 different areas means 5 different buckets with their respective two unique first digits.
		ArrayList<Integer>[] b = new ArrayList[5];
		for (int i = 0; i < 5; i++)
		{
			b[i] = new ArrayList<Integer>();
		}

		// Sorts the elements into buckets depending on the first digit of the area number.
		for (int i = 0; i < A.length; i++)
		{
			// Grabs the first digit of the area number.
			int firstDigit = A[i] / 1000000000;

			// 0 - 1 : Northeast Coast 
			if (firstDigit >= 0 && firstDigit <= 1)
			{
				b[0].add(A[i]);
			}
			// 2 - 3 : South Coast
			if (firstDigit >= 2 && firstDigit <= 3)
			{
				b[1].add(A[i]);
			}
			// 4 - 5 : Middle States
			if (firstDigit >= 4 && firstDigit <= 5)
			{
				b[2].add(A[i]);
			}
			// 6 - 7 : Northwest Coast
			if (firstDigit >= 6 && firstDigit <= 7)
			{
				b[3].add(A[i]);
			}
			// 8 - 9 : West Coast
			if (firstDigit >= 8 && firstDigit <= 9)
			{
				b[4].add(A[i]);
			}
		}

		// Uses insertion sort to sort through each bucket.
		for (int i = 0; i < 5; i++)
		{
			insertionSort(b[i]);
		}

		// Concatenates all the elements in each bucket into the original Array.
		int counter = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < b[i].size(); j++)
			{
				A[counter] = b[i].get(j);
				counter++;
			}
		}
	}

	public void insertionSort(ArrayList<Integer> A)
	{
		for (int j = 1; j < A.size(); j++)
		{
			int key = A.get(j);
			int i = j - 1;

			while (i > -1 && A.get(i) > key)
			{
				A.set(i + 1, A.get(i));
				i--;
			}

			A.set(i + 1, key);
		}
	}
}
