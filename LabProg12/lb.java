import java.util.*;
import java.io.*;
public class lb
{
static int min(int x,int y)
{
if(x<y)
return x;
return y;
}
public static void main(String args[])
{
Scanner in = new Scanner(System.in);
System.out.print("Enter the buckit size : ");
int cap=in.nextInt();
System.out.print("Enter rate : ");
int rate=in.nextInt();
int inp[]=new int[25];
System.out.print("Enter number of seconds to simulate : ");
int count=0,drop=0;
int n=in.nextInt();
for(int i=0;i<n;i++)
{
System.out.print("Enter size of packet at "+(i+1)+"s : ");
inp[i]=in.nextInt();
}
int mini;
System.out.println("Second\tRecvd\tSent\tRemaining\tDropped");
System.out.println("-----------------------------------------");
for(int i=0;i<n;i++)
{
count+=inp[i];
if(count>cap)
{
drop=count-cap;
count=cap;
}
mini=min(count,cap);
System.out.println((i+1)+"\t"+inp[i]+"\t"+mini+"\t"+(cap-count)+"\t\t"+drop);
}
}
}
