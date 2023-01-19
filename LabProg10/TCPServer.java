import java.io.*;
import java.net.*;
public class TCPServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket server = new ServerSocket(5555);
		System.out.println("Server is running");
		Socket sock = server.accept();
		System.out.println("Waiting for chat..."); 
		InputStream istream = sock.getInputStream();
		BufferedReader br= new BufferedReader(new InputStreamReader(istream));
		String fname = br.readLine();
		BufferedReader f= new BufferedReader(new FileReader(fname));
		OutputStream ostream =sock.getOutputStream();
		PrintWriter pr = new PrintWriter(ostream,true);
		String str;
		while((str=f.readLine())!=null)
		pr.println(str);
		server.close();
		sock.close();
		br.close();		
		f.close();
		pr.close();
	}
}
