
public class CheckSortedRecursion {
	public static void main(String[] args)
	{
		int[] array={1,2,30,4,5};
		int result=checkSorted(array, 5);
		if(result==1)
			System.out.println("Success. Array is sorted");
		else
			System.out.println("Failure. Array is not sorted");
	}
	public static int checkSorted(int[] array, int n)
	{
		if(n==1)
			return 1;
		return array[n-1]>array[n-2]?checkSorted(array, n-1):0;
	}
}
