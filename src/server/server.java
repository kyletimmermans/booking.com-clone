package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class server extends Application 
{
	// global variables
	public static TextArea textArea;
	public static TextArea textArea_1;
	public static TextArea textArea_2;
	public static TextArea textArea_3;
	public static TextArea textArea_4;
	TextArea               clock;
	
	@Override
	public void start (Stage stage) throws FileNotFoundException
	{
		InetAddress ipAddress = null;
		try
		{
			ipAddress = InetAddress.getLocalHost();
		}
		catch (UnknownHostException el)
		{
			el.printStackTrace();
		}
		
		stage.setTitle("Booking.com" + " IP : " + ipAddress.getHostAddress() + "     Port# : 3333");
		stage.setWidth(1400);
		stage.setHeight(800);
		
		
		//
		// text area for real time clock thread to display
		//
		clock = new TextArea();
		clock.setEditable(false);
		clock.setPrefHeight(30);
		clock.setPrefWidth(900);
        clock.setStyle("-fx-background-color: blue");

		
		
		// Log Window
		textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setPrefHeight(70);
		textArea_1.setPrefWidth(550);
		textArea_1.setMinHeight(400);
		textArea_1.setFont(Font.font("Verdana", 18));
  
        
        // Active Connections Window
        textArea_4 = new TextArea();
		textArea_4.setEditable(false);
		textArea_4.setPrefHeight(70);
		textArea_4.setPrefWidth(400);
		textArea_4.setMinHeight(400);
		textArea_4.setFont(Font.font("Verdana", 18));
        

		
		// main area for socket server to display messages
		textArea = new TextArea();
		textArea.setFont(Font.font("Verdana", 18));
		textArea.setEditable(false);
		textArea.setPrefHeight(80);
		textArea.setPrefWidth(300);
        textArea.setStyle("-fx-background-color: blue");

				
				
		// available text area
		textArea_3 = new TextArea();
		textArea_3.setEditable(false);
		textArea_3.setPrefHeight(80);
		textArea_3.setPrefWidth(300);
        textArea_3.setStyle("-fx-background-color: blue");

		
		
		// area for IP addresses of clients who connect to the socket server
		textArea_2 = new TextArea();
		textArea_2.setEditable(false);
		textArea_2.setPrefHeight(80);
		textArea_2.setPrefWidth(900);
		textArea_2.setText("Current Hottest Location: TBD"
							+ "				" 
							+ "Current Hottest Property: TBD"
							+ "				"
							+ "Current Hottest Property Type: TBD"
							+ "				"
							+ "Total Number of Hotels Booked: $0"
							+ "				"
							+ "Total Daily Revenue: 0");
        textArea_2.setStyle("-fx-background-color: blue");

        /*
        Text hottestLocation = new Text();
        hottestLocation.setText("This is a text sample");
		*/
		
        //
		// define all BUTTONS
		//
		Button exitButton = new Button("EXIT");
		exitButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
				           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				           
				           alert.setTitle("Confirmation Dialog");
				           alert.setHeaderText("EXIT confirmation dialog");
				           alert.setContentText("Are you sure you want to exit this Socket Server Program?");
				           
				           String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss").format(new Date());
				           textArea_1.appendText("WARNING: Attempted Shutdown at " + timeStamp + "\n");

				           Optional<ButtonType> result = alert.showAndWait();
				           
				           if (result.get() == ButtonType.OK)
				           {
					           System.exit(0);
				           }
				           else 
				           {
				               // ... user chose CANCEL or closed the dialog
				           }
				        }
				    });	
			}
		});
		
		Button addClient = new Button("Clear Active Connections");
		addClient.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
					           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					           
					           alert.setTitle("Confirmation Dialog");
					           alert.setHeaderText("CLEAR confirmation dialog");
					           alert.setContentText("Are you sure you want to clear the Active Connections Window?");

					           Optional<ButtonType> result = alert.showAndWait();
					           
					           if (result.get() == ButtonType.OK)
					           {
						           textArea_4.clear();
					           }
					           else 
					           {
					               // ... user chose CANCEL or closed the dialog
					           }
				        }
				    });	
			}
		});		 
		
		Button showLog = new Button("Show Log");
		showLog.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
					    String logString = "";
					    
				        public void run() 
				        {
				        	try
				            {
				        	      File f = new File("transactionLog.txt");
				        	      if (f.exists())
				        	      {
				                    FileReader reader = new FileReader("transactionLog.txt");
				                    BufferedReader br = new BufferedReader(reader);
				                  
				                    String line = br.readLine();
				                    while (line != null)
				                    {
				                    	logString = logString + line + "\r\n";
				                    	line = br.readLine();
				                    }
				                    
				                    br.close();
				        	      }
				        	      else
				        	      {
				        	    	  logString = "No log File Found!";
				        	      }
				        	 }
				             catch(Exception e2)
				             {   
				        	    e2.printStackTrace(); 
				             }		
				        	
				             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				             alert.setTitle("--- Ticket Kiosk ---");
				             alert.setHeaderText("Transaction Log File");
				          
				             alert.setContentText(logString);
				             alert.setWidth(300);
				             alert.setHeight(600);
				             alert.showAndWait();
				        }
				    });	
			}
		});
		
		
		Button addProperty = new Button("Clear Log");
		addProperty.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				 Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
					           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					           
					           alert.setTitle("Confirmation Dialog");
					           alert.setHeaderText("CLEAR confirmation dialog");
					           alert.setContentText("Are you sure you want to clear the Log Window?");

					           Optional<ButtonType> result = alert.showAndWait();
					           
					           if (result.get() == ButtonType.OK)
					           {
						           textArea_1.clear();
					           }
					           else 
					           {
					               // ... user chose CANCEL or closed the dialog
					           }
				        }
				    });
			}
		});
	
		Button helpButton = new Button("HELP");
		helpButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				 Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
				          Alert alert = new Alert(Alert.AlertType.INFORMATION);
				          alert.setTitle("Booking.com Help Window");
				          alert.setHeaderText("Help Screen");
				          
				          String hStr="- Click on   Clear Active Connections to clear the left window.\r\n" +
				        		      "- Click on   Show Log to display current transaction log file.\r\n" +
				        		      "- Click on   Clear Log to clear the right window.\r\n" +
				        		      "- Click on   EXIT button to quit the socket server.\r\n";				                    
				          
				          alert.setContentText(hStr);
				          alert.showAndWait();
				        }
				    });
			}
		});

	
		
		// all buttons go to horizontal view
		//
		HBox hb = new HBox();
		hb.setPadding(new Insets(15, 12, 15, 12));
		hb.setSpacing(15);
		hb.getChildren().addAll(      clock, 
				                 helpButton,
				                  addClient, 
				                    showLog, 
				                addProperty, 		      
				                exitButton);

		
		//
		// vertical has IP text area and buttons below
		//
		VBox vb = new VBox();
		vb.getChildren().addAll(textArea_2, hb);
		
		
	   // Logo
	   Image logo = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
       ImageView logoView   = new ImageView(logo);
       logoView.setFitWidth(400);
       logoView.setFitHeight(75);
				
		
		//
		// main BORDER PANE pane layout
		//
		BorderPane bp = new BorderPane();
		
		BorderPane.setAlignment(logoView, Pos.CENTER);	

		Label activeConnections = new Label("Active Connections");
		Label log = new Label("Log");
		activeConnections.setFont(new Font("Verdana", 18));
		log.setFont(new Font("Verdana", 18));
		activeConnections.setTextFill(Color.web("#FFFFFF"));
		log.setTextFill(Color.web("#FFFFFF"));
		
		
		VBox acWindow = new VBox(activeConnections, textArea_4);  // Left window
		VBox logWindow = new VBox(log, textArea_1);  // Right window
		
		acWindow.setPrefHeight(700);
		logWindow.setPrefHeight(700);

				
		HBox windowsAndLabels = new HBox(acWindow, logWindow);
		windowsAndLabels.setSpacing(100);
		windowsAndLabels.setAlignment(Pos.CENTER);
		
		Label spacer = new Label(" ");
		
		VBox finalSpacing = new VBox(spacer, windowsAndLabels);
		finalSpacing.setSpacing(50);
		
		bp.setTop(logoView);
		bp.setCenter(finalSpacing);
		bp.setBottom(vb);
        bp.setStyle("-fx-background-color: blue");

		
		// start all threads  for the GUI screen here
		startRealTimeClock();
		
		// start the socket server thread - will start to accept client connections
		startSockServer();
		
		//
		// lights, camera, action
		//
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}

	
  /*
   * Thread to update weather info for NYC and Boston    
   */     
  private void startSockServer()
  {	
	 Thread refreshWeatherThread = new Thread()
	 {
	    public void run()
		  { 	
			  sockServer.runSockServer();
	      }
	 };

    refreshWeatherThread.start();
  }
	
  
  /*
   * Thread to update weather info for NYC and Boston    
   */     
  private void startRealTimeClock()
  {	
	   Thread refreshClock = new Thread()
	   {
		  public void run()
		  {   
			 clock.setFont(Font.font("Verdana", 14));
			 
			 while (true)
			 {	 			      
				   Date date = new Date();
				   String str = String.format("    %tc", date);
					 
				   clock.setText("");
				   clock.setText(str);
				   
			    	try
				    {
					   sleep(1000L);
				    }
				    catch (InterruptedException e)
				   {
					   // TODO Auto-generated catch block
					  e.printStackTrace();
				   }
             } // end while true 
	     }
	  };
	  


    refreshClock.start();
   }
	
   //
   // main function starts here
   //
   public static void main(String[] args)
   {
		launch(args);
   }
}