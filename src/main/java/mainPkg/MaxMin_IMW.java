package mainPkg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxMin_IMW  {

	private static int sum=0, count=0, index=0,key=0,tempListSum=0;
	private static int minKey=0,indexMin=0,listcount=0;
	private static float tempListAvg=0,avg=0;
	private static List<Integer> tempList;
	private static HashMap<Integer,List<Integer>> map;
	private static List<Integer> tempListMin;
	
	public static void main(String args[])
	{
	List<Object> mwList=new ArrayList<Object>(Arrays.asList(1,5,null,null,1,2,2,null,3));
	System.out.println("Monitoring Window: "+mwList);
	System.out.println("MaxSum for the given list is : "+maxSum(mwList));
	System.out.println("MinAvg for the given list is : "+minAvg(mwList));
	}
	
	/**<summary> 
	 * Takes Monitoring Window values (list of objects) as input and gives MaxSum from the selected IMW (List of integer) as output.
	 * Integer values are stored in a list (tempList) until a null value is received or until end of array is reached.
	 * Values from tempList are then stored to map (value) using addToMaxList()
	 * </summary>
	 * @param maxList takes list of Object (monitoring window values)
	 * @return List of integer (MaxSum value from IMW)
	 */

	public static List<Integer> maxSum(List<Object> maxList) {
		
		tempList=new ArrayList<Integer>();
		map= new HashMap<Integer,List<Integer>>();
		for(int i=0;i<maxList.size();i++)
		{
			if(maxList.get(i)!=null)
			{
				tempList.add((Integer)maxList.get(i));
				if(maxList.size()==i+1) {
					addToMaxList();
				}
			}		
			else
			{
				addToMaxList();
			}
		}
		
		if(map.size()==0)
		{	
				return Collections.emptyList();			
		}
		
	return map.get(index);
	}
	/** Adds Integer values to the Map. Each time the  tempList values are stored in map, the Key is incremented.
	 * Sum of the list tempList is taken and compared with previous sum and the key of the IMW with largest sum is stored.
	 */
	
	private static void addToMaxList()
	{
		if(tempList.size()>0)
		{
			map.put(key, new ArrayList<Integer>(tempList));
			key=key+1;
			tempListSum=sumOfList(tempList);

			if(tempListSum==sum)
			{
				if(tempList.size()>count)
				{
					findMax(tempList,key,tempListSum);
				}
			}
			else if(tempListSum>sum)
			{
				findMax(tempList,key,tempListSum);
			}
			tempListSum=0;
			tempList.clear();			
		}
	}
	/**
	 * This method is called if sum of current list is greater than or equal to previous sum. 
	 * if current and previous sum are equal, then this method is called if current list size is greater than previous one.
	 * @param list - current IMW values (one group of IMW)
	 * @param tempKey - key for the current IMW value(s) from the map where IMW value(s) are stored
	 * @param tempSum -sum of current IMW values (largest sum)
	 */

	private static void findMax(List<Integer> list, int tempKey, int tempSum)
	{
		sum=tempSum;
		count=list.size();
		index = (tempKey-1);
	}
	/**
	 * Calculates the sum of the values in the list
	 * @param list - current IMW values
	 * @return - returns sum of current IMW values
	 */
	
	private static int sumOfList(List<Integer> list)
	{
		int tempsum=0;
		for(int j=0;j<list.size();j++)
		{			
			tempsum+=list.get(j);
		}
		return tempsum;
	}
	
	/**<summary> 
	 * Takes Monitoring Window values (list of objects) as input and gives MinAvg from the selected IMW (List of integer) as output.
	 * Integer values are stored in a list (tempListMin) until a null value is received or until end of array is reached.
	 * Values from tempListMin are then stored to map (value) using addToMinList().
	 * </summary>
	 * @param minList takes list of Object (monitoring window values)
	 * @return List of integer (MinAvg value from IMW)
	 */
	public static List<Integer> minAvg(List<Object> minList)
	{
		
		tempListMin=new ArrayList<Integer>();
		map= new HashMap<Integer,List<Integer>>();
				
		for(int i=0;i<minList.size();i++)
		{
			if(minList.get(i)!=null)
			{
				tempListMin.add((Integer) minList.get(i));
				if(minList.size()==i+1) {
					addToMinList();
				}
			}		
			else
			{
				addToMinList();
				
	         }
	   }
		if(map.size()==0)
		{	
			return Collections.emptyList();			
		}
		
		return(map.get(indexMin));
	}
	/** Adds Integer values to the Map. Each time the  tempListMin values are stored in map, the minKey (key) is incremented.
	 * Average of the list tempListMin is taken and compared with previous average and the key of the IMW with lowest average is stored.
	 */
	
	private static void addToMinList()
	{
		if(tempListMin.size()>0)
		{

			map.put(minKey, new ArrayList<Integer>(tempListMin));
			minKey=minKey+1;
			listcount=sumOfList(tempListMin);
			tempListAvg=listcount/(float)tempListMin.size();
			
			if(map.size()==1)
			{
				avg=tempListAvg;
				indexMin=map.size()-1;
			}
			else if(tempListAvg<avg)
			{
				avg=tempListAvg;
				indexMin=map.size()-1;
			}
			
			listcount=0;
			tempListMin.clear();
		}
	}

}

