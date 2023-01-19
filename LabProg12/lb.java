import java.util.*;
public class lb
{ 
    static int min(int x,int y) 
    { 
        if(x<y) 
        return x; 
        else 
        return y; 
    } 
    public static void main(String[] args) 
    { 
        int drop=0,mini,nsec,cap,count=0,i,process; 
        int inp[]=new int[25]; 
        Scanner in=new Scanner(System.in); 
        System.out.print("Enter The Bucket Size: "); 
        cap= in.nextInt(); 
        System.out.print("Enter The Operation Rate: "); 
        process= in.nextInt(); 
        System.out.print("Enter The No. Of Seconds You Want To Stimulate: "); 
        nsec=in.nextInt(); 
        for(i=0;i<nsec;i++) 
        { 
            System.out.print("Enter The Size Of The Packet Entering At "+ (i+1)+" sec: "); 
            inp[i] = in.nextInt(); 
        } 
        System.out.println("\nSecond | Packet Recieved | Packet Sent | Packet Left | Packet Dropped|\n"); 
        for(i=0;i<nsec;i++) 
        { 
            count+=inp[i]; 
            if(count>cap) 
            { 
                drop=count-cap; 
                count=cap; 
            } 
            System.out.print(i+1); 
            System.out.print("\t\t"+inp[i]); 
            mini=min(count,process); 
            System.out.print("\t\t"+mini); 
            count=count-mini; 
            System.out.print("\t\t"+count); 
            System.out.print("\t\t"+drop);
            drop=0; 
            System.out.println(); 
        } 
        for(;count!=0;i++) 
        { 
            if(count>cap) 
            { 
                drop=count-cap; 
                count=cap; 
            }    
            System.out.print(i+1); 
            System.out.print("\t\t0"); 
            mini=min(count,process); 
            System.out.print("\t\t"+mini); 
            count=count-mini; 
            System.out.print("\t\t"+count); 
            System.out.print("\t\t"+drop); 
            System.out.println(); 
        } 
    } 
}   


