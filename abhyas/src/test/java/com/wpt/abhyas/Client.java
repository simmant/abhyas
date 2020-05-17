package com.wpt.abhyas;
// A Java program for a Client 
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.KeyStore;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory; 

public class Client 
{ 
	// initialize socket and input output streams 
	private SSLSocket socket		 = null; 
	private DataInputStream input = null,inputServer = null; 
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public Client(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			SSLSocketFactory factory =
	                getServerSocketFactory();
			
				socket =
	                (SSLSocket)factory.createSocket(address, port);
				
			System.out.println("Connected"); 

			inputServer = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			// sends output to the socket 
			System.out.println(inputServer.readUTF());
			// takes input from terminal 
			input = new DataInputStream(System.in); 

			
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 

		// keep reading until "Over" is input 
		while (!line.equals("Over")) 
		{ 
			try
			{ 
				Thread.sleep(5000);
				line = input.readLine(); 
				out.writeUTF(line); 
			} 
			catch(Exception i) 
			{ 
				System.out.println(i); 
			} 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	 private static SSLSocketFactory getServerSocketFactory() {
         SSLSocketFactory factory = null;
         try {
             SSLContext ctx;
             KeyManagerFactory kmf;
             KeyStore ks;
             char[] passphrase = "changeit".toCharArray();

             ctx = SSLContext.getInstance("TLS");
             kmf = KeyManagerFactory.getInstance("SunX509");
             ks = KeyStore.getInstance("JKS");

             ks.load(new FileInputStream("ssl-server.jks"), passphrase);

             kmf.init(ks, passphrase);
             ctx.init(kmf.getKeyManagers(), null, null);

             factory = ctx.getSocketFactory();
         } catch (Exception e) {
        	 e.printStackTrace();
             return null;
         }	    
     return factory;    
	 }

	
	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 5000); 
	} 
} 
