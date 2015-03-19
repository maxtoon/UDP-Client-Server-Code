/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclientlp;

/**
 *
 * @author Max Mattoon
 * Networking UDP Client Looping and Prompting
 */
import java.net.*;
import java.io.*;
public class UDPClientLP{
    	public static void main(String args[]){ 
            
                           
// args give message contents and destination hostname
	DatagramSocket aSocket = null;
	try {
          aSocket = new DatagramSocket();
          
          while (true){    
             String s = getInput("Enter Input : ");
             
	     byte [] m = s.getBytes();
	     InetAddress aHost = InetAddress.getByName(args[1]);
	     int serverPort = 6789;	
                            
               //sends request to server
               
		DatagramPacket request =new DatagramPacket(m,  s.length(), aHost, serverPort);
	        aSocket.send(request);			                        
		byte[] buffer = new byte[1000];
                
               //client gets response from server        
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
		aSocket.receive(reply);
		System.out.println("Reply: " + new String(reply.getData()));     }                
             
}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
}catch (IOException e){System.out.println("IO: " + e.getMessage());
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
