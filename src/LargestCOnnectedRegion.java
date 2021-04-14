import java.util.Arrays;

public class LargestCOnnectedRegion {
	public static void main(String[] args)
	{
		int a[][]={{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
		int count=0,largest=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]==1)
				{
					count++;
					a[i][j]=0;
					count=findRegion(a,i,j,count);
					if(count>largest)
					{
						largest=count;
						count=0;
					}
				}
			}
		}
		System.out.println(largest);
	}
	public static int findRegion(int[][]a,int i, int j, int count)
	{
		if(j+1<a[i].length && a[i][j+1]==1)
		{
			count++;
			a[i][j+1]=0;
			count=findRegion(a, i, j+1, count);
			return count;
		}
		else if(j-1>=0 && a[i][j-1]==1)
		{
			count++;
			a[i][j-1]=0;
			count=findRegion(a, i, j-1, count);
			return count;
		}
		else if(i+1<a.length && a[i+1][j]==1)
		{
			count++;
			a[i+1][j]=0;
			count=findRegion(a, i+1, j, count);
			return count;
		}
		else if(i-1>=0 && a[i-1][j]==1)
		{
			count++;
			a[i-1][j]=0;
			count=findRegion(a, i-1, j, count);
			return count;
		}
		else if (j+1<a[i].length && i+1<a.length && a[i+1][j+1]==1)
		{
			count++;
			a[i+1][j+1]=0;
			count=findRegion(a, i+1, j+1, count);
			return count;
		}
		else if (j-1>=0 && i+1<a.length && a[i+1][j-1]==1)
		{
			count++;
			a[i+1][j-1]=0;
			count=findRegion(a, i+1, j-1, count);
			return count;
		}
		else if( i-1>=0 && j-1>=0 && a[i-1][j-1]==1)
		{
			count++;
			a[i-1][j-1]=0;
			count=findRegion(a, i-1, j-1, count);
			return count;
		}
		else if (i-1>=0 && j+1<a[i].length && a[i-1][j+1]==1)
		{
			count++;
			a[i-1][j+1]=0;
			count=findRegion(a, i-1, j+1, count);
			return count;
		}
		else
		{
			return count;
		}
	}
}