/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserverlp;

/**
 *
 * @author Max Mattoon
 * Networking   UDP Server Looping and Prompting
 */
import java.net.*;
import java.io.*;
public class UDPServerLP{
    	public static void main(String args[]){ 
            
                 
    		DatagramSocket aSocket = null;
		try{
	    	aSocket = new DatagramSocket(6789);
		// create socket at agreed port
                	
                        
 			while(true){
                            byte[] buffer = new byte[1000];
                            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                            aSocket.receive(request);
                            System.out.println("Reply: " + new String(request.getData()));
                            String s = getInput("Enter Message : ");
                            DatagramPacket reply = new DatagramPacket(s.getBytes(), s.length(), 
                            request.getAddress(), request.getPort());
                            aSocket.send(reply);
    		}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
    	}
      public static String getInput(String prompt){ 
		System.out.print(prompt); 
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); 
		String response = null; 
		try{ 
			response = console.readLine(); 
		}  catch (IOException e){ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
			System.exit(1); 
		} 
		return response; 
} 
 
}
