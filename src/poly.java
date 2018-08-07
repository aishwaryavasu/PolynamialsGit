
public class poly {

	
	public static void print(int[] temp)
	{
		for(int i=0;i<temp.length;i++)
		{
			System.out.print(temp[i]+" ");
		}
	}
	
	public static int find_length(int[] a ,int[] b)
	{
		int len = b.length;
		if(len<a.length)
			len=a.length;
		return len;
	}
	
	public static  void add (int[] a, int[] b)
	{
		int len=find_length(a,b);
		int temp[] = new int[len];
		
		
		for(int i=len-1;i>=0;i--)
		{
			int temp_1 = a[i]+b[i];
			temp[i]=temp[i]+temp_1;//+(temp_1%10);
			//if(temp_1>9)
			//{
			//	temp_1 = temp_1/10;
		//		temp[i]=temp[i]+temp_1;
		//	}
		}
		print(temp);
		
		
		
	}
	
	public static void sub(int[] a,int[] b)
	{
		int len=find_length(a,b);
		int temp[] = new int[len];
		
		
		for(int i=len-1;i>=0;i--)
		{
			int temp_1 = a[i]-b[i];
			temp[i]=temp_1;
			
		}
		print(temp);
	}
	
	public static void multiply(int[] a,int[] b)
	{
		int len= find_length(a,b);
		int temp[] = new int[2*len-1];
		
		for(int i=len-1;i>=0;i--)
		{
			for(int j=len-1;j>=0;j--)
			{
				temp[i+j]=temp[i+j]+(a[i]*b[j]);
			}
		}
		print(temp);
	}
	
	
	/*public static void main(String[] args)
	{
		int[] a = {1,2,3,4};
		int[] b = {9,6,7,8};
		
		
		add(a,b);
		System.out.println();
		sub(a,b);
		System.out.println();
		multiply(a,b);
		
	}*/
	
	
	
	
	
}
