package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
		private Socket socket=null;
		private OutputStreamWriter out=null;
		private InputStreamReader input=null;

		public Client1(String address,int port) throws Exception
		{
			socket=new Socket(address,port);
			
			String line = ""; 
			  
		    // keep reading until "Over" is input 
		    while (!line.equals("exit")) 
		    {
		    	System.out.print("Enter the massage : ");
				Scanner sc  = new Scanner(System.in);
		    	line=sc.nextLine();
		    	out = new OutputStreamWriter(socket.getOutputStream());
		    	PrintWriter pw=new PrintWriter(out);
				pw.println(line);
				pw.flush();
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    		line=br.readLine();
	    		if(line==null)
	    			break;
	    		System.out.println("massage :"+line);
		    } 
		    try
	        { 
	            input.close(); 
	            out.close(); 
	            socket.close(); 
	        } 
	        catch(Exception i) 
	        { 
	            System.out.println("chat stop"); 
	        } 	
		}
	public static void main(String[] args) throws Exception {
		 Client1 client = new Client1("localhost", 5000);
		/*String ip="localhost";
		int port=9999;
		Socket s=new Socket(ip,port);
		String str="Molay  Halder";
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw=new PrintWriter(os);
		pw.println(str);
		pw.flush();
		//System.out.println(str);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String re=br.readLine();
		System.out.println(re);*/

	}

}
