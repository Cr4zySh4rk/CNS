import java.util.*;
import java.net.*;
public class UDPServer
{
public static void main(String args[])
{
try{
DatagramSocket serversocket = new DatagramSocket();
byte OutData[]=new byte[1024];
InetAddress IPAddress = InetAddress.getByName("localhost");
System.out.println("Server is running!");
Scanner in =new Scanner(System.in);
System.out.print("Enter data : ");
String s2=in.nextLine();
s2=s2.toUpperCase();
OutData=s2.getBytes();
DatagramPacket sendpkt = new DatagramPacket(OutData,OutData.length,IPAddress,2222);
serversocket.send(sendpkt);
System.out.println("Packet Sent!");
serversocket.close();
}
catch(Exception ex)
{
System.out.print(ex.getMessage());
}
}
}
