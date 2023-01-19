import java.util.*;
import java.net.*;
public class UDPClient
{
public static void main(String args[])
{
try{
DatagramSocket clientobj = new DatagramSocket(2222);
byte InData[]=new byte[1024];
System.out.println("Client is running!");
while(true)
{

DatagramPacket receivedpkt = new DatagramPacket(InData,InData.length);
clientobj.receive(receivedpkt);
String s1=new String(receivedpkt.getData());
System.out.println("The received data is : "+s1);
}
}
catch (Exception ex)
{
System.out.print(ex.getMessage());
}
}
}
