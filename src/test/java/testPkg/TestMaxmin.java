package testPkg;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import mainPkg.MaxMin_IMW;

public class TestMaxmin {
	//input
	List<Object> mwList=new ArrayList<Object>(Arrays.asList(1,5,null,null,1,2,2,null,3));
	
	@Test  
    public void testMax() {
		
		System.out.println("Monitoring Window: "+mwList);
//		Arrange
		
		List<Integer> ExpectedMaxlist = new ArrayList<Integer>(Arrays.asList(1,5));
		List<Integer> NotExpectedMaxlist = new ArrayList<Integer>(Arrays.asList(1,2,2));
		
//		Act
		List<Integer> ResultMaxlist=MaxMin_IMW.maxSum(mwList);
		System.out.println("MaxSum for the given list is :" +ResultMaxlist);
		
//		Assert
		Assert.assertNotNull(ResultMaxlist);
		Assert.assertEquals(ExpectedMaxlist, ResultMaxlist);
		Assert.assertNotEquals(NotExpectedMaxlist, ResultMaxlist);
    }  
	

	@Test  
    public void testMin() {

//		Arrange
		List<Integer> ExpectedMinlist = new ArrayList<Integer>(Arrays.asList(1,2,2));
		List<Integer> NotExpectedMinlist = new ArrayList<Integer>(Arrays.asList(3));
		
//		Act
		List<Integer> ResultMinlist=MaxMin_IMW.minAvg(mwList);
		
		System.out.println("MinAvg for the given list is :" +ResultMinlist);
//		Assert
		Assert.assertNotNull(ResultMinlist);
		Assert.assertEquals(ExpectedMinlist, ResultMinlist);
		Assert.assertNotEquals(NotExpectedMinlist, ResultMinlist);
		  
    }  

}
