package testPkg;

import org.junit.Test;

import static org.junit.Assert.*;


import mainPkg.FindSumFromArray;

public class TestArray {
	
	int arr[]= {5,8,-2,0,-6,-1,12,9,20,-5};
	int arraySize=arr.length;
	//input
	int number=4;
	
	@Test
	public void verifySumFromArray()
	{
		
		boolean actualValue=FindSumFromArray.arrToFindSumOfNumbersFromList(arr, arraySize, number);
		boolean expectedValue=true;
		if(actualValue)
			System.out.println("Yes, the numbers resulting to sum="+number+" are present in the list");
		else
			System.out.println("There are no numbers in the list resulting to sum="+number);
		assertEquals(expectedValue, actualValue);
		
	}
	

}
