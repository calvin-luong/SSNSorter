package sorterSSN;

/**
 * Creates a Social Security Number (SSN).
 * @author		Calvin Luong Copyright (2019)
 * @version		1.0
 */

public class ssnGenerator {
	
	/** areaNumber holds: the area number portion of the social security number and is 3 digits long. */
	private int[] areaNumber;
	
	/** groupNumber holds: the group number portion of the social security number and is 2 digits long. */
	private int[] groupNumber;
	
	/** serialNumber holds: the serial number portion of the social security number and is 4 digits long. */
	private int[] serialNumber;
	
	/** SSN holds: the entire 9 digit long SSN.*/
	private int SSN;

	/*
	 * Creates a ssnGenerator for the ssnGenerator class. This
	 * constructor makes a random social security number.
	 */
	public ssnGenerator()
	{
		/*
		 * Sets the sizes of each array according to the SSN layout.
		 */
		areaNumber = new int[3];
		groupNumber = new int[2];
		serialNumber = new int [4];

		/*
		 * Creates the area number.
		 * Ranges from 001 to 999.
		 */
		areaNumber[0] = (int) (Math.random() * 10);
		areaNumber[1] = (int) (Math.random() * 10);
		areaNumber[2] = (int) ((Math.random() * 9) + 1);

		/*
		 * Creates the group number.
		 * Ranges from 01 to 99.
		 */
		groupNumber[0] = (int) (Math.random() * 10);
		groupNumber[1] = (int) ((Math.random() * 9) + 1);
		
		/*
		 * Creates the serial number.
		 * Ranges from 0001 to 9999.
		 */
		serialNumber[0] = (int) (Math.random() * 10);
		serialNumber[1] = (int) (Math.random() * 10);
		serialNumber[2] = (int) (Math.random() * 10);
		serialNumber[3] = (int) ((Math.random() * 9) + 1);

		/*
		 * Combines all three groups in the order: 
		 * area number, group number, and serial number.
		 */
		setSSN();
	}

	/*
	 * Combines all three parts of the social security into
	 * one whole number.
	 */
	public void setSSN()
	{
		SSN = (SSN * 10) + arrayToInt(areaNumber);
		SSN = (SSN * 100) + arrayToInt(groupNumber);
		SSN = (SSN * 10000) + arrayToInt(serialNumber);
	}

	/*
	 * Converts an integer Array into a whole number.
	 * 
	 * @param A[] The Array that is being converted into a whole number in integer form.
	 * 
	 * @return the whole number created.
	 */
	public int arrayToInt(int A[])
	{
		int result = 0;
		for (int i = 0; i < A.length; i++)
		{
			result = (result * 10) + A[i];

		}
		return result;
	}

	/*
	 * Returns the entire social security number.
	 * 
	 * @return the social security number.
	 */
	public int getSSN()
	{
		return SSN;
	}
}
