import java.util.*;
import java.io.*;
public class bellman
{
    static int max=999,n;
    static void shortest(int s, int a[][])
    {
        int d[]=new int[n+1];
        for(int i=1;i<=n;i++)
        d[i]=max;
        d[s]=0;
        for(int k=1;k<=n-1;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    if(a[i][j]!=max&&d[j]>d[i]+a[i][j]) 
                        d[j]=d[i]+a[i][j];
        
        for(int i=1;i<=n;i++)
        System.out.println("Distance of source "+s+" to "+i+" is "+d[i]);
    }
	public static void main(String[] args) 
	{
	    int s;
	    Scanner in = new Scanner(System.in);
	    System.out.print("Enter no. of values: ");
	    n=in.nextInt();
	    int a[][]=new int[n+1][n+1];
		System.out.println("Enter the weighted matrix(Do not enter negative edges):");
		for(int i=1;i<=n;i++)
        for(int j=1;j<=n;j++)
        {
            a[i][j]=in.nextInt();
            if(a[i][j]<0)
            {
                System.out.println("Negative edge entered. Exiting...");
                System.exit(0);
            }
        }
        System.out.print("Enter source vetrex: ");
        s=in.nextInt();
        shortest(s,a);
	}
}

