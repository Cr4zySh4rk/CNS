import java.io.*;
import java.net.*;
public class TCPClient
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Socket sock=new Socket("127.0.0.1",5555);
		System.out.println("Client running\nInput file name");
		String fname=br.readLine();
		InputStream istream = sock.getInputStream();
		BufferedReader read= new BufferedReader(new InputStreamReader(istream));		
		OutputStream ostream =sock.getOutputStream();
		PrintWriter pr = new PrintWriter(ostream,true);
		pr.println(fname);		
		
		String str;
		while((str=read.readLine())!=null)
		System.out.println(str);	
		
		br.close();
		sock.close();
		pr.close();
	}
}
