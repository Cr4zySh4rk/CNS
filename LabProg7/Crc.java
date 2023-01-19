import java.util.*;
public class Crc
{
	void div(int a[],int gp[],int k)
	{
	int count=0;
	for(int i=0;i<k;i++)
	{
	if(a[i]==gp[0])
	{
	for(int j=i;j<17+i;j++)
	a[j]=a[j]^gp[count++];
	count=0;
	}
	}
	}
	public static void main (String args[])
	{
	int a[]=new int[100];
	int b[]=new int[100];
	int gp[]=new int[100];
	int len,k=0,flag=0;
	Crc ob= new Crc();
	System.out.print("Enter the length of data frame: ");
	Scanner in=new Scanner (System.in);
	len=in.nextInt();
	System.out.print("Enter the message: ");
	for(int i=0;i<len;i++)
	a[i]=in.nextInt();
	System.out.print("Enter the generator polynomial: ");
	for(int i=0;i<17;i++)
	gp[i]=in.nextInt();
	for(int i=0;i<16;i++)
	a[len++]=0;
	k=len-16;
	for(int i=0;i<16;i++)
	b[i]=a[i];
	ob.div(a,gp,k);
	for(int i=0;i<len;i++)
	a[i]=a[i]^b[i];
	System.out.print("\nData to be transmitted: ");
	for(int i=0;i<len;i++)
	System.out.print(a[i]+" ");
	System.out.print("\nEnter the received data: ");
	for(int i=0;i<len;i++)
	a[i]=in.nextInt();
	ob.div(a,gp,k);
	for(int i=0;i<len;i++)
	{
	if(a[i]!=0)
	{
	flag=1;
	break;
	}
	}
	if (flag==1)
	System.out.println("\nError in data");
	else
	System.out.println("\nNo error");
	}
}