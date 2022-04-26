package application;

import java.io.IOException;
import java.io.BufferedReader;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.InputStreamReader;
import java.util.stream.*;

public class sockServer implements Runnable
{
	   Socket csocket;
	   String ipString;
	   char threadType;
	   
	   
	   // public static makes them global and accessible by all on all passes
	   // Analytic counters
	   public static int totalDailyRevenue = 0;  // Counters for analytics

	   public static int nyHottest = 0;
	   public static int orlandoHottest = 0;
	   public static int miamiHottest = 0;
	   public static int atlantaHottest = 0;
	   public static int laHottest = 0;
	   public static int lvHottest = 0;
	  
	   
	   public static String hottestLocation;
	   
	   public static String hottestProperty;
	   
	   public static int motelHottest = 0;
	   public static int hotelHottest = 0;
	   public static int hostelHottest = 0;
	   
	   public static String hottestType;
	   
	   public static char myNum;  // property switch value
	   
	   public static int counts[] = new int [36];
	   
	   
	   public int getIndexOfLargest(int[] array)
	   {
	     if ( array == null || array.length == 0 ) return -1; // null or empty

	     int largest = 0;
	     for ( int i = 1; i < array.length; i++ )
	     {
	         if ( array[i] > array[largest] ) largest = i;
	     }
	     return largest;
	   }
	   
	   static final String newline = "\n";

	   static int port_num = 3333;
	             
	   sockServer(Socket csocket, String ip)
	   {
	      this.csocket  = csocket;
	      this.ipString = ip;
	   } 

	   public static void runSockServer()   // throws Exception
	   {
	     boolean sessionDone = false;
	  
	     ServerSocket ssock = null;
	   
	     try
	     {
		   ssock = new ServerSocket(port_num);
	     }
	     catch (BindException e)
	     {
		    e.printStackTrace();
	     }
	     catch (IOException e)
	     {
		    e.printStackTrace();
	     }
	 
	     // update the status text area to show progress of program
	     try 
	     {
		     InetAddress ipAddress = InetAddress.getLocalHost();
		     server.textArea.appendText("IP Address : " + ipAddress.getHostAddress() + newline);
	     }
	     catch (UnknownHostException e1)
	     {
		    e1.printStackTrace();
	     }
	 		
	     
	     sessionDone = false;
	     while (sessionDone == false)
	     {
	        Socket sock = null;
		    try
		    {
		       //	
  	     	   // blocking system call
		       //	
			   sock = ssock.accept();
		    }
		    catch (IOException e)
		    {
			   e.printStackTrace();
		    }
		 
	        // start a NEW THREAD process
	        new Thread(new sockServer(sock, sock.getInetAddress().toString())).start();
	     }
	 
	     try 
	     {
		    ssock.close();
	     }
	     catch (IOException e) 
	     {
		    e.printStackTrace();
	     }
	}	  

	
	//
	// CLIENT THREAD CODE - This is the thread code that ALL clients will run()
	//
	public void run()
	{
	   try
	   {  
	      //
	      // Read Client Message from SendMessage() 
	      //
		  BufferedReader inFromClient = null; 
	      inFromClient = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
	      String msg = inFromClient.readLine();
	      msg = msg.replace('!', '\n');
	      server.textArea_4.appendText(msg + "\n");
	      
	      String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss").format(new Date());
	      server.textArea_1.appendText("INFO: Connection established at " + timeStamp + "\n");
	      //
	      //
	      //
	
	      // Creating array of string length
	      char[] ch = new char[msg.length()];
	  
	      // Copy character by character into array
	      for (int i = 0; i < msg.length(); i++) {
	    	  ch[i] = msg.charAt(i);
	      }
	  
	      
	      // Find the int in the beginning of the string which is the property number
	      for (int i = 0; i < 60; i++) {
	    	  if (Character.isDigit(ch[i])) {
	    		  myNum = ch[i];
	    		  break;
	    	  }
	      }
	      
	      // arr['property', numOfBuys]
	      // Each first character is individual per city besides LV and LA
	      // count array 1-36, each index correlates to property
	      switch(ch[18]) {
	      	case 'N':
	      		++nyHottest;
	      		switch(myNum) {
	      			case '1':
	      				++counts[0];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 103;
	      				break;
	      			case '2':
	      				++counts[1];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 315;
	      				break;
	      			case '3':
	      				++counts[2];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 98;
	      				break;
	      			case '4':
	      				++counts[3];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 115;
	      				break;
	      			case '5':
	      				++counts[4];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 87;
	      				break;
	      			case '6':
	      				++counts[5];
	      				++motelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 98;
	      				break;
	      		}
	      		break;
	      	case 'O':
	      		++orlandoHottest;
	      		switch(myNum) {
	      			case '1':
	      				++counts[6];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 75;
	      				break;
	      			case '2':
	      				++counts[7];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 168;
	      				break;
	      			case '3':
	      				++counts[8];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 189;
	      				break;
	      			case '4':
	      				++counts[9];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 350;
	      				break;
	      			case '5':
	      				++counts[10];
	      				++motelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 85;
	      				break;
	      			case '6':
	      				++counts[11];
	      				++motelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 104;
	      				break;
	      		}
	      		break;
	      	case 'M':
	      		++miamiHottest;
	      		switch(myNum) {
	      			case '1':
	      				++counts[12];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 348;
	      				break;
	      			case '2':
	      				++counts[13];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 294;
	      				break;
	      			case '3':
	      				++counts[14];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 291;
	      				break;
	      			case '4':
	      				++counts[15];
	      				++motelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 284;
	      				break;
	      			case '5':
	      				++counts[16];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 142;
	      				break;
	      			case '6':
	      				++counts[17];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 124;
	      				break;
	      		}
	      		break;
	      	case 'A':
	      		++atlantaHottest;
	      		switch(myNum) {
	      			case '1':
	      				++counts[18];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 208;
	      				break;
	      			case '2':
	      				++counts[19];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 97;
	      				break;
	      			case '3':
	      				++counts[20];
	      				++hotelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 490;
	      				break;
	      			case '4':
	      				++counts[21];
	      				++motelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 80;
	      				break;
	      			case '5':
	      				++counts[22];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 49;
	      				break;
	      			case '6':
	      				++counts[23];
	      				++hostelHottest;
	      				totalDailyRevenue = totalDailyRevenue + 75;
	      				break;
	      		}
	      		break;
	      	case 'L':
	      		if (ch[19] == 'o') {  // If "Lo" must be Los Angeles
		      		++laHottest;
	      			switch(myNum) {
		      			case '1':
		      				++counts[24];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 289;
		      				break;
		      			case '2':
		      				++counts[25];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 195;
		      				break;
		      			case '3':
		      				++counts[26];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 167;
		      				break;
		      			case '4':
		      				++counts[27];
		      				++hostelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 194;
		      				break;
		      			case '5':
		      				++counts[28];
		      				++hostelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 140;
		      				break;
		      			case '6':
		      				++counts[29];
		      				++motelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 130;
		      				break;
		      		}	
	      		}
	      		else {  // If begins with 'L' and next char is not 'o' it must be Las Vegas
		      		++lvHottest;
	      			switch(myNum) {
		      			case '1':
		      				++counts[30];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 299;
		      				break;
		      			case '2':
		      				++counts[31];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 358;
		      				break;
		      			case '3':
		      				++counts[32];
		      				++hotelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 300;
		      				break;
		      			case '4':
		      				++counts[33];
		      				++motelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 195;
		      				break;
		      			case '5':
		      				++counts[34];
		      				++motelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 200;
		      				break;
		      			case '6':
		      				++counts[35];
		      				++hostelHottest;
		      				totalDailyRevenue = totalDailyRevenue + 144;
		      				break;
		      		}
	      		}
	      }
	     
	      getAnalytics();
		  
	      Thread.sleep(500);
	           
	      // close client socket
	      csocket.close();
	   
	     } // end try  
	 
	     catch (SocketException e)
	     {
		  // update the status text area to show progress of program
	      server.textArea.appendText("ERROR : Socket Exception!" + newline);
	     }
	     catch (InterruptedException e)
	     {
		  // update the status text area to show progress of program
	      server.textArea.appendText("ERROR : Interrupted Exception!" + newline);
	     }
	     catch (UnknownHostException e)
	     {
		  // update the status text area to show progress of program
	      server.textArea.appendText("ERROR : Unkonw Host Exception" + newline);
	     }
	     catch (IOException e) 
	     {
	     // update the status text area to show progress of program
	      server.textArea.appendText("ERROR : IO Exception!" + newline);
	     }     
	     catch (Exception e)
	     { 
		  // update the status text area to show progress of program
	      server.textArea.appendText("ERROR : Generic Exception!" + newline);
	     }
	   
	  }  // end run() thread method
	

	private void getAnalytics()
	{	
	   Thread getAnalytics = new Thread()
	   {
		  public void run()
		  {   
			 while (true)
			 {
				 // Get hottest property name, get index, each index has a property
				 switch(getIndexOfLargest(counts)) {
				 	case 0:
				 		hottestProperty = "The Standard";
				 		break;
				 	case 1:
				 		hottestProperty = "Four Seasons NY";
				 		break;
				 	case 2:
				 		hottestProperty = "Pod 51";
				 		break;
				 	case 3:
				 		hottestProperty = "Jazz on the Park";
				 		break;
				 	case 4:
				 		hottestProperty = "Morris Guest Home";
				 		break;
				 	case 5:
				 		hottestProperty = "Flushing Motel";
				 		break;
				 	case 6:
				 		hottestProperty = "Residence";
				 		break;
				 	case 7:
				 		hottestProperty = "Staybridge Suites";
				 		break;
				 	case 8:
				 		hottestProperty = "Ramada";
				 		break;
				 	case 9:
				 		hottestProperty = "Hyatt Regency";
				 		break;
				 	case 10:
				 		hottestProperty = "InTown Suites";
				 		break;
				 	case 11:
				 		hottestProperty = "Rodeway Inn";
				 		break;
				 	case 12:
				 		hottestProperty = "Kimpton";
				 		break;
				 	case 13:
				 		hottestProperty = "Hilton Miami";
				 		break;
				 	case 14:
				 		hottestProperty = "Provident Dural";
				 		break;
				 	case 15:
				 		hottestProperty = "Gary Motel";
				 		break;
				 	case 16:
				 		hottestProperty = "The Hideaway";
				 		break;
				 	case 17:
				 		hottestProperty = "Group";
				 		break;
				 	case 18:
				 		hottestProperty = "Hilton Atlanta";
				 		break;
				 	case 19:
				 		hottestProperty = "Glenn Hotel";
				 		break;
				 	case 20:
				 		hottestProperty = "The St. Regis Atlanta";
				 		break;
				 	case 21:
				 		hottestProperty = "Econo Lodge";
				 		break;
				 	case 22:
				 		hottestProperty = "Atlanta Midtown";
				 		break;
				 	case 23:
				 		hottestProperty = "Residence";
				 		break;
				 	case 24:
				 		hottestProperty = "Hotel Indigo";
				 		break;
				 	case 25:
				 		hottestProperty = "Intercontinental";
				 		break;
				 	case 26:
				 		hottestProperty = "Hollywood Inn";
				 		break;
				 	case 27:
				 		hottestProperty = "Freehand";
				 		break;
				 	case 28:
				 		hottestProperty = "Samesun";
				 		break;
				 	case 29:
				 		hottestProperty = "Outsider Inn";
				 		break;
				 	case 30:
				 		hottestProperty = "Bellagio";
				 		break;
				 	case 31:
				 		hottestProperty = "MGM Grand";
				 		break;
				 	case 32:
				 		hottestProperty = "Mandalay Bay";
				 		break;
				 	case 33:
				 		hottestProperty = "Quality Inn";
				 		break;
				 	case 34:
				 		hottestProperty = "Blue Swallow";
				 		break;
				 	case 35:
				 		hottestProperty = "Ocean Sky";
				 		break;
				 	default:
				 		hottestProperty = "TBD";
				 }
				 
				 if (motelHottest > hotelHottest && motelHottest > hostelHottest) {  // motel hottest
					 hottestType = "Motel";
				 } else if (hotelHottest > motelHottest && hotelHottest > hostelHottest) { // hotel hottest
					 hottestType = "Hotel";
				 } else if (hostelHottest > motelHottest && hostelHottest > hotelHottest) {  // hostel hottest
					 hottestType = "Hostel";
				 }  else {
					 hottestType = "TBD";
				 }
				 
				 
				 // How do i get the highest value of the hottest locations? e.g. lvHottest, nyHottest
				 int types[] = new int [6];
				 types[0] = nyHottest;
				 types[1] = orlandoHottest;
				 types[2] = miamiHottest;
				 types[3] = atlantaHottest;
				 types[4] = laHottest;
				 types[5] = lvHottest;
				 
				 switch(getIndexOfLargest(types)) {
					 case 0:
						 hottestLocation = "New York City";
						 break;
					 case 1:
						 hottestLocation = "Orlando";
						 break;
					 case 2:
						 hottestLocation = "Miami";
						 break;
					 case 3:
						 hottestLocation = "Atlanta";
						 break;
					 case 4:
						 hottestLocation = "Los Angeles";
						 break;
					 case 5:
						 hottestLocation = "Las Vegas";
						 break;
					 default:
						 hottestLocation = "TBD";
				 }
				 
				 
				 String time = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss").format(new Date());
					
			     char[] ch = new char[time.length()];
			  
			     for (int i = 0; i < time.length(); i++) {
			    	  ch[i] = time.charAt(i);
			     }
			     
			     if ((ch[11] == '0' && ch[12] == '0') && (ch[14] == '0' && ch[15] == '0')) {  // if midnight, reset the daily profit to 0
			    	 totalDailyRevenue = 0;
			     }
			     
			     
			     String tdRevStr = String.valueOf(totalDailyRevenue);
			     
			     String hotelCount = String.valueOf(IntStream.of(counts).sum());			    
			     
				 server.textArea_2.setText("Current Hottest Location: " + hottestLocation
							+ "				" 
							+ "Current Hottest Property: " + hottestProperty
							+ "				"
							+ "Current Hottest Property Type: " + hottestType
							+ "				"
							+ "Total Number of Hotels Booked: " + hotelCount  // Add up all value of counts = hotels bought
							+ "				"
							+ "Total Daily Revenue: $" + tdRevStr);	
				 
				 
				 
			    	try
				    {
					   sleep(1000L);
				    }
				    catch (InterruptedException e)
				   {
					   
					  e.printStackTrace();
				   }
            } 
	     }
	  };
	 
	  getAnalytics.start();
	  
	}
	
}