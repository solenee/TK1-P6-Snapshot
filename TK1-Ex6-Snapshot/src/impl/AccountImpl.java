package impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;


public class AccountImpl {
	public final static int port = 2048;

	public static void main (String[] str) {
		System.out.println("New client");
		FIFOSlave c = new FIFOSlave(port);
		c.start();
	}
	// AccountImpl(int[] ports, int id)
	// sendMoney(int receiverId, double amount)
	// takeSnapshot()
	// start() ??
	// updateAccount(double amountToAdd) + mutex
}	

class ReceiverSlave extends Thread {

	int port;
	
	public ReceiverSlave(int port){
		this.port = port;
	}

	public void run() {
		System.out.println("[ReceiverSlave] Sending FIFO head...");
    	try {
			// TODO receive amount of money sent by an other account head
			Socket s = new Socket("localhost",port);
			
			BufferedReader d = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Answer from "+s.getRemoteSocketAddress()+":");
			String amount = d.readLine();
			System.out.println("Amount : "+amount+"\n----------");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class FIFOSlave extends Thread {

	int port;
	
	public FIFOSlave(int port){
		this.port = port;
	}

	public void run() {
		// While (true)
		// If (!fifo.isEmpty)
		// TODO Get the FIFO head
		// double amount = ...
		System.out.println("[FIFOSlave] Sending FIFO head...");// : "+amount
		// wait a random amount of time
		Random r = new Random();
    	try {
			sleep(r.nextInt(91) + 10); //random delay between 10 ms and 100 ms
			// TODO send FIFO head
			Socket s = new Socket("localhost",port);
			
			PrintStream p = new PrintStream(s.getOutputStream());
			//p.println(amount);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
		
}
