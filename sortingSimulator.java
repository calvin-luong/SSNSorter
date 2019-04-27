package sorterSSN;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Simulates the creation of 300 unique Social Security Numbers (SSN) 
 * and sorts them with quick sort, bucket sort, and radix sort.
 * 
 * @author		Calvin Luong Copyright (2019)
 * @version		1.0
 */
public class sortingSimulator {

	/** quickSortSSN holds: the Array of SSN that is going to be sorted using quick sort. */
	private static int[] quickSortSSN;
	
	/** bucketSortSSN holds: the Array of SSN that is going to be sorted using bucket sort. */
	private static int[] bucketSortSSN;
	
	/** radixSortSSN holds: the Array of SSN that is going to be sorted using radix sort. */
	private static int[] radixSortSSN;
	
	/** ssnList holds: the Array of SSN. */
	private static int[] ssnList;


	public static void main (String args[])
	{	
		/*
		 * Creates 300 random SSN and adds it into a text file.
		 * Copies this Array into quickSortSSN, bucketSortSSN, and radixSortSSN.
		 */
		sortingSimulator simulator = new sortingSimulator();
		simulator.createSSNList();
		simulator.toTXT(ssnList, "Random_SSN.txt");

		/*
		 * Uses the quick sort algorithm to sort the Array.
		 */
		quickSort quickSort = new quickSort();
		quickSort.quickSort(quickSortSSN, 0, quickSortSSN.length - 1);
		System.out.println(Arrays.toString(quickSortSSN));
		simulator.toTXT(quickSortSSN, "Quick_SSN.txt");

		/*
		 * Uses the bucket sort algorithm to sort the Array.
		 */
		bucketSort bucketSort = new bucketSort();
		bucketSort.bucketSort(bucketSortSSN);
		System.out.println(Arrays.toString(bucketSortSSN));
		simulator.toTXT(bucketSortSSN, "Bucket_SSN.txt");

		/*
		 * Uses the radix sort algorithm to sort the Array.
		 */
		radixSort radixSort = new radixSort();
		radixSort.radixSort(radixSortSSN, 1000000000);
		System.out.println(Arrays.toString(radixSortSSN));
		simulator.toTXT(radixSortSSN, "Radix_SSN.txt.");

		/*
		 * Counts the number of people from the same area.
		 */
		simulator.areaCounter(radixSortSSN);

	}

	/*
	 * Creates an Array size of 300 containing SSNs.
	 * Copies the Array to quickSortSSN, bucketSortSSN, and radixSortSSN.
	 */
	public void createSSNList()
	{
		int n = 300;
		ssnList = new int[n];

		for (int i = 0; i < n; i++)
		{
			ssnGenerator ssn = new ssnGenerator();
			ssnList[i] = ssn.getSSN();
		}

		quickSortSSN = ssnList;
		bucketSortSSN = ssnList;
		radixSortSSN = ssnList;
	}

	/*
	 * Counts the number of people with the same area numbers for
	 * Northeast Coast, South Coast, Middle States, Northwest Coast, and West Coast.
	 */
	public void areaCounter(int A[])
	{
		int NortheastCoast = 0;
		int SouthCoast = 0;
		int MiddleStates = 0;
		int NorthwestCoast = 0;
		int WestCoast = 0;

		for (int i = 0; i < A.length; i++)
		{
			// Grabs the most significant digit of the number.
			int firstDigit = A[i] / 100000000;
			
			// Adds to each of the area counter according to the area number.
			// 0 - 1 : Northeast Coast
			if (firstDigit >= 0 && firstDigit <= 1)
			{
				NortheastCoast++;
			}
			// 2 - 3 : South Coast
			if (firstDigit >= 2 && firstDigit <= 3)
			{
				SouthCoast++;
			}
			// 4 - 5 : Middle States
			if (firstDigit >= 4 && firstDigit <= 5)
			{
				MiddleStates++;
			}
			// 6 - 7 : Northwest Coast
			if (firstDigit >= 6 && firstDigit <= 7)
			{
				NorthwestCoast++;
			}
			// 8 - 9 : West Coast
			if (firstDigit >= 8 && firstDigit <= 9)
			{
				WestCoast++;
			}
		}

		// Prints out the result
		System.out.println("Northeast Coast States: " + NortheastCoast + " people");
		System.out.println("SouthCoast States: " + SouthCoast + " people");
		System.out.println("Middle States: " + MiddleStates + " people");
		System.out.println("Northwest Coast States: " + NorthwestCoast + " people");
		System.out.println("West Coast States: " + WestCoast + " people");
	}

	/*
	 * Adds the elements in the Array into a designated .txt file.
	 * Also creates a .txt file with the designated name.
	 * 
	 * @param A[] The Array being added into the .txt file.
	 * @param fileName the name of the file the elements are being added into.
	 */
	public void toTXT(int A[], String fileName) 
	{
		String input = "";
		try
		{
			// The writer that adds elements to a .txt file.
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < 300; i++)
			{
				int firstDigit = A[i] / 100000000;
				int secondDigit = A[i] / 10000000;
				
				// Adds two 0s to the front if the digit length is 7 digits long.
				if (firstDigit == 0 && secondDigit == 0)
				{
					input = "00" + String.valueOf(A[i]);
					
				}
				// Adds one 0 to the front if the digit length is 7 digits long.
				else if (firstDigit == 0 && secondDigit != 0)
				{
					input = "0" + String.valueOf(A[i]);
				}
				else
				{
					input = String.valueOf(A[i]);
				}
				
				// Adds the integer into the .txt file in the format: XXX-XX-XXXX
				input = input.substring(0, 3) + "-" + input.substring(3, 5) + "-" + input.substring(5, 9);
				writer.write(input);
				writer.newLine();
			}

			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("No elements in the Array");
		}
	}
}
