package chat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	private Socket socket = null; 
	private ServerSocket server = null;
	private DataInputStream in=null;
	
	public Client2(int port) throws Exception
	{
		server=new ServerSocket(port);
		//System.out.println("Server started"); 
		  
        //System.out.println("Waiting for a client ..."); 

        socket = server.accept(); 
        //System.out.println("Client accepted");
        
        String line="";
        while(!line.equals("exit"))
        {
        	BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		line=br.readLine();
    		System.out.println("massage :"+line);
    		OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
    		PrintWriter pw=new PrintWriter(os);
    		Scanner sc=new Scanner(System.in);
    		if(!line.equals("exit"))
    		{	
    			System.out.println("Enter the massage : ");
    			line=sc.nextLine();
    			pw.println(line);
    			pw.flush();
    		}
        }
        //System.out.println("Closing connection"); 
        
        // close connection 
        try
        {
        	socket.close(); 
        	in.close();
        }
        catch(Exception i)
        {
        	System.out.println("chat stop");
        }
  
	}
	public static void main(String[] args) throws Exception {
        Client2 client = new Client2(5000); 

		/*System.out.println("Server connected");
		ServerSocket ss=new ServerSocket(9999);
		System.out.println("Server waiting for client");
		Socket s =ss.accept();
		System.out.println("Server accept client");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str=br.readLine();
		System.out.println("Client Data : "+ str);
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw=new PrintWriter(os);
		pw.println("Hello, "+str+" Welcome to server");
		pw.flush();*/

	}

}
