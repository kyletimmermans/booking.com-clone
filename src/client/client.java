package application;

import java.util.Date;
import java.util.Optional;
import java.io.FileReader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;


public class client extends Application
{

   Scene scene1, scene2N, scene2A, scene2O, scene2L, scene2M, scene2LV, scene3;
   TextArea clock, clock2;
   Text location;
   String propertySelected;

   @Override
   public void start(Stage primaryStage) 
   {   
	   
	 fileIO    trans    = new  fileIO();
	 socketUtils mySocket = new socketUtils();
	 sendEmail emailSender = new sendEmail();
	      
	 primaryStage.setTitle("Booking.com");
     primaryStage.setWidth(1000);
     primaryStage.setHeight(1000);
     
     TextArea ta = new TextArea();
     ta.setEditable(false);
     ta.setPrefWidth(300);
     ta.setPrefHeight(400);
     
     TextArea ta2= new TextArea();
     ta2.setEditable(false);   
     ta2.setStyle("-fx-font-weight: bold");
     
     clock = new TextArea();
     clock.setEditable(false);
     clock.setPrefHeight(30);   
     clock.setPrefWidth(900);
     
     clock2 = new TextArea();
     clock2.setEditable(false);
     clock2.setPrefHeight(30);   
     clock2.setPrefWidth(900);
     
     Image pic1		  = new Image("https://media.timeout.com/images/105661613/630/472/image.jpg");     
     ImageView image1 = new ImageView(pic1);
     image1.setFitWidth(400);
     image1.setFitHeight(200);
     Button button1    = new Button("New York City", image1);
     button1.setOnAction(new EventHandler<ActionEvent>()
     {
         @Override public void handle(ActionEvent e)
         {   
        	 primaryStage.setScene(scene2N);
        	 trans.wrTransactionData("New York City selected as destination");
         }
     });
          
     Image pic2         = new Image("https://patch.com/img/cdn20/shutterstock/22865905/20190610/105408/styles/patch_image/public/shutterstock-106518758-1___10105205832.jpg?width=695");
     ImageView image2 = new ImageView(pic2);
     image2.setFitWidth(400);
     image2.setFitHeight(200);
     Button button2    = new Button("Atlanta", image2);
     button2.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene2A);
        	 trans.wrTransactionData("Atlanta selected as destination");
         }
     });
               
     Image pic3         = new Image("https://www.outfrontmedia.com/-/media/images/ofm/markets/orlando/hero/orlando-hero-image.jpg");
     ImageView image3 = new ImageView(pic3);
     image3.setFitWidth(400);
     image3.setFitHeight(200);
     Button button3    = new Button("Orlando", image3);
     button3.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene2O);
        	 trans.wrTransactionData("Orlando selected as destination");
         }
     });
          
     Image pic4         = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/20190616154621%21Echo_Park_Lake_with_Downtown_Los_Angeles_Skyline.jpg/560px-20190616154621%21Echo_Park_Lake_with_Downtown_Los_Angeles_Skyline.jpg");
     ImageView image4 = new ImageView(pic4);
     image4.setFitWidth(400);
     image4.setFitHeight(200);
     Button button4    = new Button("Los Angeles", image4);
     button4.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene2L); 
        	 trans.wrTransactionData("Los Angeles selected as destination");
         }
     });
          
     Image pic5         = new Image("https://media.timeout.com/images/105617718/1372/772/image.jpg");
     ImageView image5 = new ImageView(pic5);
     image5.setFitWidth(400);
     image5.setFitHeight(200);
     Button button5    = new Button("Miami", image5);
     button5.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene2M);
        	 trans.wrTransactionData("Miami selected as destination");
         }
     });
     
     Image pic6         = new Image("https://www.fodors.com/wp-content/uploads/2019/10/ThingstoKnowLasVegas__HERO_shutterstock_708501844.jpg");
     ImageView image6 = new ImageView(pic6);
     image6.setFitWidth(400);
     image6.setFitHeight(200);
     Button button6    = new Button("Las Vegas", image6);
     button6.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene2LV);
        	 trans.wrTransactionData("Las Vegas selected as destination");
         }
     });
          
     Image logo		  = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView logo1  = new ImageView(logo);
     logo1.setFitWidth(1000);
     logo1.setFitHeight(150);

            

     TilePane tilePane = new TilePane();
     tilePane.getChildren().add(button1);
     tilePane.getChildren().add(button2);
     tilePane.getChildren().add(button3);
     tilePane.getChildren().add(button4);
     tilePane.getChildren().add(button5);
     tilePane.getChildren().add(button6);
     
     BorderPane bp = new BorderPane();
     bp.setTop(logo1);
     bp.setBottom(clock);
     bp.setCenter(tilePane);
     
     refreshClock();
     
     Scene scene1 = new Scene(bp, 1000, 1000);

  
     //Scene 2
     Button button7= new Button("Go Back");
     button7.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButton = new Button("Exit");
     exitButton.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     Button helpButton = new Button("Help");
     helpButton.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3 = new TextArea();
     ta3.setEditable(false);
     ta3.setPrefWidth(300);
     ta3.setPrefHeight(400);
     
     TextArea ta4= new TextArea();
     ta4.setEditable(false);   
     ta4.setStyle("-fx-font-weight: bold");
     
     location = new Text();
     location.setText("Current Location: New York City");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     Image logo2        = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView logo3   = new ImageView(logo2);
     logo3.setFitWidth(1000);
     logo3.setFitHeight(150);
     
     BorderPane bp2 = new BorderPane();
     bp2.setTop(logo3);
     bp2.setBottom(clock2);

     //beginning of NYC properties
     Image picture1        = new Image("https://heintges.com/wp-content/uploads/2016/11/Heintges_standardHotel_1.jpg");     
     ImageView pictureOne   = new ImageView(picture1);
     pictureOne.setFitWidth(100);
     pictureOne.setFitHeight(50);
     
     cities NYCone = new cities("The Standard", "Hotel", 4, 103);
     Text text1 = new Text(NYCone.getName() + "				" + NYCone.getType() + "				" + NYCone.getRating() + " star				" + "$"+ NYCone.getPrice() + " per night");
     Text space5 = new Text(" ");
     
     
     Stage stage2 = new Stage();
     stage2.setTitle("New Window");
     stage2.setWidth(400);
     stage2.setHeight(400);

     HBox hbox1 = new HBox(space5, pictureOne, text1);
     hbox1.setSpacing(20);
     Button property1Button    = new Button("",hbox1);
     property1Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City");
         }
     });

     cities NYCtwo = new cities("Four Seasons NY", "Hotel", 5, 315);
     Image picture2        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/944/94476155.jpg");     
     ImageView pictureTwo    = new ImageView(picture2);
     pictureTwo.setFitWidth(100);
     pictureTwo.setFitHeight(50);
     
     Text text2 = new Text(NYCtwo.getName() + "				" + NYCtwo.getType() + "				" + NYCtwo.getRating() + " star				" + "$"+ NYCtwo.getPrice() + " per night");

     Text space6 = new Text(" ");
     
     HBox hbox2 = new HBox(space6, pictureTwo, text2);
     hbox2.setSpacing(20);
     Button property2Button    = new Button("",hbox2);
     property2Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City");
         }
     });

     cities NYCthree = new cities("Pod 51", "Hotel", 3, 98);
     Image picture3        = new Image("https://www.thepodhotel.com/uploads/1/0/6/8/106825145/edited/pod-51-roof-4.jpeg?1520359833");     
     ImageView pictureThree   = new ImageView(picture3);
     pictureThree.setFitWidth(100);
     pictureThree.setFitHeight(50);
     
     Text text3 = new Text(NYCthree.getName() + "				" + NYCthree.getType() + "				" + NYCthree.getRating() + " star				" + "$"+ NYCthree.getPrice() + " per night");
     Text space7 = new Text(" ");

     HBox hbox3 = new HBox(space7, pictureThree, text3);
     hbox3.setSpacing(20);
     Button property3Button    = new Button("",hbox3);
     property3Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City"); 
         }
     });

     
     cities NYCfour = new cities("Jazz on the Park", "Hostel", 2, 115);
     Image picture4        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/958/95821148.jpg");     
     ImageView pictureFour   = new ImageView(picture4);
     pictureFour.setFitWidth(100);
     pictureFour.setFitHeight(50);
     
     Text text4 = new Text(NYCfour.getName() + "				" + NYCfour.getType() + "				" + NYCfour.getRating() + " star				" + "$"+ NYCfour.getPrice() + " per night");
     Text space8 = new Text(" ");

     HBox hbox4 = new HBox(space8, pictureFour, text4);
     hbox4.setSpacing(20);
     Button property4Button    = new Button("",hbox4);
     property4Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City");
         }
     });
     

     cities NYCfive = new cities("Morris Guest Home", "Hostel", 1, 87);
     Image picture5        = new Image("https://res.cloudinary.com/wego/image/upload/w_420,h_420,c_fill,f_auto,fl_lossy,q_80/v1488303400/Partner/hotels/951584/86191846.jpg");     
     ImageView pictureFive   = new ImageView(picture5);
     pictureFive.setFitWidth(100);
     pictureFive.setFitHeight(50);
     
     Text text5 = new Text(NYCfive.getName() + "				" + NYCfive.getType() + "				" + NYCfive.getRating() + " star				" + "$"+ NYCfive.getPrice() + " per night");

     Text space9 = new Text(" ");

     HBox hbox5 = new HBox(space9, pictureFive, text5);
     hbox5.setSpacing(20);
     Button property5Button    = new Button("",hbox5);
     property5Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City");
         }
     });
     
     cities NYCsix = new cities("Flushing Motel", "Motel", 2, 98);
     Image picture6        = new Image("https://cf.bstatic.com/images/hotel/max1280x900/821/82156550.jpg");     
     ImageView pictureSix   = new ImageView(picture6);
     pictureSix.setFitWidth(100);
     pictureSix.setFitHeight(50);
     
     Text text6 = new Text(NYCsix.getName() + "				" + NYCsix.getType() + "				" + NYCsix.getRating() + " star				" + "$"+ NYCsix.getPrice() + " per night");
     Text space10 = new Text(" ");


     HBox hbox6 = new HBox(space10, pictureSix, text6);
     hbox6.setSpacing(20);
     Button property6Button    = new Button("",hbox6);
     property6Button.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2.setScene(scene3);
        	 stage2.show();
        	 location.setText("Current Location: New York City");
         }
     });
     

     HBox hbox7 = new HBox(button7, helpButton, exitButton);
     hbox7.setSpacing(25);
     VBox vbox2 = new VBox(hbox7, location, property1Button, property2Button, property3Button, property4Button, property5Button, property6Button);
     vbox2.setSpacing(30);

     
     bp2.setCenter(vbox2);
     
     Text space = new Text(" ");
     Text title = new Text("Filters:");
     title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtra = new Text(" ");
     
     Text space1 = new Text(" ");
     Text datesStayed = new Text("Dates Stayed");
     Text spaceExtra = new Text(" "); 
     Text startDateTitle = new Text("Start Date");
     TextField startDateEntry = new TextField();
     Text spaceExtra2 = new Text(" ");
     Text endDateTitle = new Text("End Date");
     TextField endDateEntry = new TextField(); 
     
     Text space2 = new Text(" ");
     Text ratings = new Text("Ratings");
     
   //Create toggle groups for ratings and property types
     ToggleGroup groupRN = new ToggleGroup();
     ToggleGroup groupPN = new ToggleGroup();
     
     RadioButton rb1RN = new RadioButton("1 Star");
     rb1RN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(true);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(true);
        	 property6Button.setManaged(false);
        	 
        	 groupPN.selectToggle(null);
         }
     });
     RadioButton rb2RN = new RadioButton("2 Stars");
     rb2RN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(true);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(true);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(true);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(true);
        	 
        	 groupPN.selectToggle(null);
         }
     });
     RadioButton rb3RN = new RadioButton("3 Stars");
     rb3RN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(true);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(true);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(false);
        	 
        	 groupPN.selectToggle(null);
         }
     });
     RadioButton rb4RN = new RadioButton("4 Stars");
     rb4RN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(true);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(true);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(false);
        	 
        	 groupPN.selectToggle(null);
         }
     });
     RadioButton rb5RN = new RadioButton("5 Stars");
     rb5RN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(true);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(true);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(false);
        	 
        	 groupPN.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RN.setToggleGroup(groupRN);
     rb2RN.setToggleGroup(groupRN);
     rb3RN.setToggleGroup(groupRN);
     rb4RN.setToggleGroup(groupRN);
     rb5RN.setToggleGroup(groupRN);
     
     Text space3N = new Text(" ");
     Text propertyTypeN = new Text("Property Type");
     
     RadioButton rb1PN = new RadioButton("Hotel");
     rb1PN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(true);
        	 property2Button.setVisible(true);
        	 property3Button.setVisible(true);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(true);
        	 property2Button.setManaged(true);
        	 property3Button.setManaged(true);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(false);
        	 
        	 groupRN.selectToggle(null);
         }
     });
     RadioButton rb2PN = new RadioButton("Motel");
     rb2PN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(false);
        	 property5Button.setVisible(false);
        	 property6Button.setVisible(true);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(false);
        	 property5Button.setManaged(false);
        	 property6Button.setManaged(true);
        	 
        	 groupRN.selectToggle(null);
         }
     });
     RadioButton rb3PN = new RadioButton("Hostel");
     rb3PN.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1Button.setVisible(false);
        	 property2Button.setVisible(false);
        	 property3Button.setVisible(false);
        	 property4Button.setVisible(true);
        	 property5Button.setVisible(true);
        	 property6Button.setVisible(false);
        	 
        	 property1Button.setManaged(false);
        	 property2Button.setManaged(false);
        	 property3Button.setManaged(false);
        	 property4Button.setManaged(true);
        	 property5Button.setManaged(true);
        	 property6Button.setManaged(false);
        	 
        	 groupRN.selectToggle(null);
         }
     });
     
     rb1PN.setToggleGroup(groupPN);
     rb2PN.setToggleGroup(groupPN);
     rb3PN.setToggleGroup(groupPN);    
     
     Text space4N = new Text(" "); 
     
     Button clearFiltersN = new Button("Clear Filters");
     clearFiltersN.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRN.selectToggle(null);
			groupPN.selectToggle(null);
			
			property1Button.setVisible(true);
			property2Button.setVisible(true);
			property3Button.setVisible(true);
			property4Button.setVisible(true);
			property5Button.setVisible(true);
			property6Button.setVisible(true);
			
			property1Button.setManaged(true);
			property2Button.setManaged(true);
			property3Button.setManaged(true);
			property4Button.setManaged(true);
			property5Button.setManaged(true);
			property6Button.setManaged(true);
		}
     });
     
     VBox vbox = new VBox(space, title, spaceTitleExtra,
             space1, datesStayed, spaceExtra, startDateTitle, startDateEntry, spaceExtra2, endDateTitle, endDateEntry, 
             space2, ratings, rb1RN, rb2RN, rb3RN, rb4RN, rb5RN,
             space3N, propertyTypeN, rb1PN, rb2PN, rb3PN, space4N, clearFiltersN); 

     bp2.setLeft(vbox);

     scene2N = new Scene(bp2,300,250);
     
     //Scene 2 for ATL
     Button button7A= new Button("Go Back");
     button7A.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButtonA = new Button("Exit");
     exitButtonA.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     
     
     Button helpButtonA = new Button("Help");
     helpButtonA.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3A = new TextArea();
     ta3A.setEditable(false);
     ta3A.setPrefWidth(300);
     ta3A.setPrefHeight(400);
     
     TextArea ta4A= new TextArea();
     ta4A.setEditable(false);   
     ta4A.setStyle("-fx-font-weight: bold");
     
     location = new Text();
     location.setText("Current Location: Atlanta");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     Image logo2A        = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView logo3A   = new ImageView(logo2A);
     logo3A.setFitWidth(1000);
     logo3A.setFitHeight(150);
          
     BorderPane bp2A = new BorderPane();
     bp2A.setTop(logo3A);
     bp2A.setBottom(clock2);
      
     cities ATone = new cities("Hilton Atlanta", "Hotel", 4, 208);
     Image picture1A        = new Image("https://thumbnails.trvl-media.com/AUflVT-WfYHUIMdQxiSIKAFNJZo=/773x530/smart/filters:quality(60)/images.trvl-media.com/hotels/1000000/10000/8000/7909/6e53653c_z.jpg");     
     ImageView pictureOneA   = new ImageView(picture1A);
     pictureOneA.setFitWidth(100);
     pictureOneA.setFitHeight(50);
     
     Text text1A = new Text(ATone.getName() + "				" + ATone.getType() + "				" + ATone.getRating() + " star				" + "$"+ ATone.getPrice() + " per night");
     Text space5A = new Text(" ");
     
     Stage stage2A = new Stage();
     stage2A.setTitle("New Window");
     stage2A.setWidth(400);
     stage2A.setHeight(400);

     HBox hbox1A = new HBox(space5A, pictureOneA, text1A);
     hbox1A.setSpacing(20);
     Button property1ButtonA    = new Button("",hbox1A);
     property1ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });

     cities ATtwo = new cities("Glenn Hotel", "Hotel", 3, 97);
     Image picture2A        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/291/291294159.jpg");     
     ImageView pictureTwoA    = new ImageView(picture2A);
     pictureTwoA.setFitWidth(100);
     pictureTwoA.setFitHeight(50);
     
     Text text2A = new Text(ATtwo.getName() + "				" + ATtwo.getType() + "				" + ATtwo.getRating() + " star				" + "$"+ ATtwo.getPrice() + " per night");
     Text space6A = new Text(" ");
     
     HBox hbox2A = new HBox(space6A, pictureTwoA, text2A);
     hbox2A.setSpacing(20);
     Button property2ButtonA    = new Button("",hbox2A);
     property2ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });

     
     cities ATthree = new cities("The St. Regis Atlanta", "Hotel", 5, 490);
     Image picture3A        = new Image("https://content.r9cdn.net/rimg/himg/f6/fa/23/leonardo-1156338-atlxr-exterior-2642-hor-clsc_O-683103.jpg?width=500&height=350");     
     ImageView pictureThreeA   = new ImageView(picture3A);
     pictureThreeA.setFitWidth(100);
     pictureThreeA.setFitHeight(50);
     
     Text text3A = new Text(ATthree.getName() + "				" + ATthree.getType() + "				" + ATthree.getRating() + " star				" + "$"+ ATthree.getPrice() + " per night");
     Text space7A = new Text(" ");

     HBox hbox3A = new HBox(space7A, pictureThreeA, text3A);
     hbox3A.setSpacing(20);
     Button property3ButtonA    = new Button("",hbox3A);
     property3ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });

     
     cities ATfour = new cities("Econo Lodge", "Motel", 2, 80);
     Image picture4A        = new Image("https://www.choicehotels.com/hotelmedia/US/GA/forest-park/GA167/320/GA167Exterior3_1.jpg");     
     ImageView pictureFourA   = new ImageView(picture4A);
     pictureFourA.setFitWidth(100);
     pictureFourA.setFitHeight(50);
     
     Text text4A = new Text(ATfour.getName() + "				" + ATfour.getType() + "				" + ATfour.getRating() + " star				" + "$"+ ATfour.getPrice() + " per night");
     Text space8A = new Text(" ");

     HBox hbox4A = new HBox(space8A, pictureFourA, text4A);
     hbox4A.setSpacing(20);
     Button property4ButtonA    = new Button("",hbox4A);
     property4ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });

     
     cities ATfive = new cities("Atlanta Midtown", "Hostel", 1, 49);
     Image picture5A        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/264/264340489.jpg");     
     ImageView pictureFiveA   = new ImageView(picture5A);
     pictureFiveA.setFitWidth(100);
     pictureFiveA.setFitHeight(50);
     
     Text text5A = new Text(ATfive.getName() + "				" + ATfive.getType() + "				" + ATfive.getRating() + " star				" + "$"+ ATfive.getPrice() + " per night");
     Text space9A = new Text(" ");

     HBox hbox5A = new HBox(space9A, pictureFiveA, text5A);
     hbox5A.setSpacing(20);
     Button property5ButtonA    = new Button("",hbox5A);
     property5ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });
     
     
     cities ATsix = new cities("Residence", "Hostel", 2, 75);
     Image picture6A        = new Image("https://www.ticati.com/img/hotel/1251899s.jpg");     
     ImageView pictureSixA   = new ImageView(picture6A);
     pictureSixA.setFitWidth(100);
     pictureSixA.setFitHeight(50);
     
     Text text6A = new Text(ATsix.getName() + "				" + ATsix.getType() + "				" + ATsix.getRating() + " star				" + "$"+ ATsix.getPrice() + " per night");

     Text space10A = new Text(" ");


     HBox hbox6A = new HBox(space10A, pictureSixA, text6A);
     hbox6A.setSpacing(20);
     Button property6ButtonA    = new Button("",hbox6A);
     property6ButtonA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2A.setScene(scene3);
        	 stage2A.show();
        	 location.setText("Current Location: Atlanta");
         }
     });
     

     HBox hbox7A = new HBox(button7A, helpButtonA, exitButtonA);
     hbox7A.setSpacing(25);
     VBox vbox2A = new VBox(hbox7A, location, property1ButtonA, property2ButtonA, property3ButtonA, property4ButtonA, property5ButtonA, property6ButtonA);
     vbox2A.setSpacing(30);
     
     bp2A.setCenter(vbox2A);

     Text spaceA = new Text(" ");
     Text titleA = new Text("Filters:");
     titleA.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtraA = new Text(" ");
     
     Text space1A = new Text(" ");
     Text datesStayedA = new Text("Dates Stayed");
     Text spaceExtraA = new Text(" "); 
     Text startDateTitleA = new Text("Start Date");
     TextField startDateEntryA = new TextField();
     Text spaceExtra2A = new Text(" ");
     Text endDateTitleA = new Text("End Date");
     TextField endDateEntryA = new TextField(); 
     
     Text space2A = new Text(" ");
     Text ratingsA = new Text("Ratings");
     
     //Create toggle groups for ratings and property types
     ToggleGroup groupRA = new ToggleGroup();
     ToggleGroup groupPA = new ToggleGroup();
     
     RadioButton rb1RA = new RadioButton("1 Star");
     rb1RA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(true);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(true);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupPA.selectToggle(null);
         }
     });
     RadioButton rb2RA = new RadioButton("2 Stars");
     rb2RA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(true);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(true);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(true);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(true);
        	 
        	 groupPA.selectToggle(null);
         }
     });
     RadioButton rb3RA = new RadioButton("3 Stars");
     rb3RA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(true);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(true);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupPA.selectToggle(null);
         }
     });
     RadioButton rb4RA = new RadioButton("4 Stars");
     rb4RA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(true);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(true);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupPA.selectToggle(null);
         }
     });
     RadioButton rb5RA = new RadioButton("5 Stars");
     rb5RA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(true);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(true);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupPA.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RA.setToggleGroup(groupRA);
     rb2RA.setToggleGroup(groupRA);
     rb3RA.setToggleGroup(groupRA);
     rb4RA.setToggleGroup(groupRA);
     rb5RA.setToggleGroup(groupRA);
     
     Text space3A = new Text(" ");
     Text propertyTypeA = new Text("Property Type");
     
     RadioButton rb1PA = new RadioButton("Hotel");
     rb1PA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(true);
        	 property2ButtonA.setVisible(true);
        	 property3ButtonA.setVisible(true);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(true);
        	 property2ButtonA.setManaged(true);
        	 property3ButtonA.setManaged(true);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupRA.selectToggle(null);
         }
     });
     RadioButton rb2PA = new RadioButton("Motel");
     rb2PA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(true);
        	 property5ButtonA.setVisible(false);
        	 property6ButtonA.setVisible(false);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(true);
        	 property5ButtonA.setManaged(false);
        	 property6ButtonA.setManaged(false);
        	 
        	 groupRA.selectToggle(null);
         }
     });
     RadioButton rb3PA = new RadioButton("Hostel");
     rb3PA.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonA.setVisible(false);
        	 property2ButtonA.setVisible(false);
        	 property3ButtonA.setVisible(false);
        	 property4ButtonA.setVisible(false);
        	 property5ButtonA.setVisible(true);
        	 property6ButtonA.setVisible(true);
        	 
        	 property1ButtonA.setManaged(false);
        	 property2ButtonA.setManaged(false);
        	 property3ButtonA.setManaged(false);
        	 property4ButtonA.setManaged(false);
        	 property5ButtonA.setManaged(true);
        	 property6ButtonA.setManaged(true);
        	 
        	 groupRA.selectToggle(null);
         }
     });
     
     rb1PA.setToggleGroup(groupPA);
     rb2PA.setToggleGroup(groupPA);
     rb3PA.setToggleGroup(groupPA);    
     
     Text space4A = new Text(" "); 
     
     Button clearFiltersA = new Button("Clear Filters");
     clearFiltersA.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRA.selectToggle(null);
			groupPA.selectToggle(null);
			
			property1ButtonA.setVisible(true);
			property2ButtonA.setVisible(true);
			property3ButtonA.setVisible(true);
			property4ButtonA.setVisible(true);
			property5ButtonA.setVisible(true);
			property6ButtonA.setVisible(true);
       	 
			property1ButtonA.setManaged(true);
			property2ButtonA.setManaged(true);
			property3ButtonA.setManaged(true);
			property4ButtonA.setManaged(true);
			property5ButtonA.setManaged(true);
			property6ButtonA.setManaged(true);
		}
     });
     
     
     VBox vboxA = new VBox(spaceA, titleA, spaceTitleExtraA,
                          space1A, datesStayedA, spaceExtraA, startDateTitleA, startDateEntryA, spaceExtra2A, endDateTitleA, endDateEntryA, 
                          space2A, ratingsA, rb1RA, rb2RA, rb3RA, rb4RA, rb5RA,
                          space3A, propertyTypeA, rb1PA, rb2PA, rb3PA, space4A, clearFiltersA);
 
     bp2A.setLeft(vboxA);
          
     scene2A = new Scene(bp2A,300,250);
     
     //Scene 2 for Orlando
     Button button7O = new Button("Go Back");
     button7O.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButtonO = new Button("Exit");
     exitButtonO.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     Button helpButtonO = new Button("Help");
     helpButtonO.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3O = new TextArea();
     ta3O.setEditable(false);
     ta3O.setPrefWidth(300);
     ta3O.setPrefHeight(400);
     
     TextArea ta4O= new TextArea();
     ta4O.setEditable(false);   
     ta4O.setStyle("-fx-font-weight: bold");

     location = new Text();
     location.setText("Current Location: Orlando");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     Image logo2O        = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView logo3O   = new ImageView(logo2O);
     logo3O.setFitWidth(1000);
     logo3O.setFitHeight(150);
     
     BorderPane bp2O = new BorderPane();
     bp2O.setTop(logo3O);
     bp2O.setBottom(clock2);
     
     
     cities ORone = new cities("Residence", "Hostel", 2, 75);
     Image picture1O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/237278931.jpg?k=a90761b77a39565f0ef5ff1a368ea39b95bb05373aeb492e13d05479d53085b0&o=");     
     ImageView pictureOneO   = new ImageView(picture1O);
     pictureOneO.setFitWidth(100);
     pictureOneO.setFitHeight(50);
     
     
     //Text spaceExtra1 = new Text(" ");
     Text text1O = new Text(ORone.getName() + "				" + ORone.getType() + "				" + ORone.getRating() + " star				" + "$"+ ORone.getPrice() + " per night");
     Text space5O = new Text(" ");
     
     Stage stage2O = new Stage();
     stage2O.setTitle("New Window");
     stage2O.setWidth(400);
     stage2O.setHeight(400);

     HBox hbox1O = new HBox(space5O, pictureOneO, text1O);
     hbox1O.setSpacing(20);
     Button property1ButtonO    = new Button("",hbox1O);
     property1ButtonO.setPrefWidth(400);
     property1ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });

     
     cities ORtwo = new cities("Staybridge Suites", "Hotel", 3, 168);
     Image picture2O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/248036736.jpg?k=31c29ade4bbf089b029739f64a2060b0677d8b0c86f841d406dc7ae0bcb7dea5&o=");     
     ImageView pictureTwoO    = new ImageView(picture2O);
     pictureTwoO.setFitWidth(100);
     pictureTwoO.setFitHeight(50);
     
     Text text11 = new Text(ORtwo.getName() + "				" + ORtwo.getType() + "				" + ORtwo.getRating() + " star				" + "$"+ ORtwo.getPrice() + " per night");
     Text space6O = new Text(" ");
     
     HBox hbox2O = new HBox(space6O, pictureTwoO, text11);
     hbox2O.setSpacing(20);
     Button property2ButtonO    = new Button("",hbox2O);
     property2ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });

     
     cities ORthree = new cities("Ramada", "Hotel", 4, 189);
     Image picture3O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/156641803.jpg?k=eb237855f5f945f99524b718eaa0fbcc51595810ca8cdd6720a260641bb946b8&o=");     
     ImageView pictureThreeO   = new ImageView(picture3O);
     pictureThreeO.setFitWidth(100);
     pictureThreeO.setFitHeight(50);
     
     Text text12 = new Text(ORthree.getName() + "				" + ORthree.getType() + "				" + ORthree.getRating() + " star				" + "$"+ ORthree.getPrice() + " per night"); 
     Text space7O = new Text(" ");

     HBox hbox3O = new HBox(space7O, pictureThreeO, text12);
     hbox3O.setSpacing(20);
     Button property3ButtonO    = new Button("",hbox3O);
     property3ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });

     cities ORfour = new cities("Hyatt Regency", "Hotel", 5, 350);
     Image picture4O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/154181523.jpg?k=944be268b4506b3f502193d4c14057af4ab1576ac5ce21adfdeb9cf4303c464e&o=");     
     ImageView pictureFourO   = new ImageView(picture4O);
     pictureFourO.setFitWidth(100);
     pictureFourO.setFitHeight(50);
     
     Text text13 = new Text(ORfour.getName() + "				" + ORfour.getType() + "				" + ORfour.getRating() + " star				" + "$"+ ORfour.getPrice() + " per night"); 
     Text space8O = new Text(" ");

     HBox hbox4O = new HBox(space8O, pictureFourO, text13);
     hbox4O.setSpacing(20);
     Button property4ButtonO    = new Button("",hbox4O);
     property4ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });

     
     cities ORfive = new cities("InTown Suites", "Motel", 1, 85);
     Image picture5O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/135467435.jpg?k=30dfc46cb0cd8d70d9301328054c7e6463409baac97b876fcf58ed1e3a9d8e15&o=");     
     ImageView pictureFiveO   = new ImageView(picture5O);
     pictureFiveO.setFitWidth(100);
     pictureFiveO.setFitHeight(50);
     
     Text text14 = new Text(ORfive.getName() + "				" + ORfive.getType() + "				" + ORfive.getRating() + " star				" + "$"+ ORfive.getPrice() + " per night"); 
     Text space9O = new Text(" ");

     HBox hbox5O = new HBox(space9O, pictureFiveO, text14);
     hbox5O.setSpacing(20);
     Button property5ButtonO    = new Button("",hbox5O);
     property5ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });
     
     cities ORsix = new cities("Rodeway Inn", "Motel", 2, 104);
     Image picture6O        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/264596684.jpg?k=f0c7520f35eea34dc06f321b49af432a6085ace2d5773b2dabb4a904efe2b94e&o=");     
     ImageView pictureSixO   = new ImageView(picture6O);
     pictureSixO.setFitWidth(100);
     pictureSixO.setFitHeight(50);
     
     Text text15 = new Text(ORsix.getName() + "				" + ORsix.getType() + "				" + ORsix.getRating() + " star				" + "$"+ ORsix.getPrice() + " per night"); 
     Text space10O = new Text(" ");


     HBox hbox6O = new HBox(space10O, pictureSixO, text15);
     hbox6O.setSpacing(20);
     Button property6ButtonO    = new Button("",hbox6O);
     property6ButtonO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2O.setScene(scene3);
        	 stage2O.show();
        	 location.setText("Current Location: Orlando");
         }
     });
     

     HBox hbox7O = new HBox(button7O, helpButtonO, exitButtonO);
     hbox7O.setSpacing(25);
     VBox vbox2O = new VBox(hbox7O, location, property1ButtonO, property2ButtonO, property3ButtonO, property4ButtonO, property5ButtonO, property6ButtonO);
     vbox2O.setSpacing(30);

     bp2O.setCenter(vbox2O);
     
     Text spaceO = new Text(" ");
     Text titleO = new Text("Filters:");
     titleO.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtraO = new Text(" ");
     
     Text space1O = new Text(" ");
     Text datesStayedO = new Text("Dates Stayed");
     Text spaceExtraO = new Text(" "); 
     Text startDateTitleO = new Text("Start Date");
     TextField startDateEntryO = new TextField();
     Text spaceExtra2O = new Text(" ");
     Text endDateTitleO = new Text("End Date");
     TextField endDateEntryO = new TextField(); 
     
     Text space2O = new Text(" ");
     Text ratingsO = new Text("Ratings");
     
     //Create toggle groups for ratings and property types
     ToggleGroup groupRO = new ToggleGroup();
     ToggleGroup groupPO = new ToggleGroup();
     
     RadioButton rb1RO = new RadioButton("1 Star");
     rb1RO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(true);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(true);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupPO.selectToggle(null);
         }
     });
     RadioButton rb2RO = new RadioButton("2 Stars");
     rb2RO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(true);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(true);
        	 
        	 property1ButtonO.setManaged(true);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(true);
        	 
        	 groupPO.selectToggle(null);
         }
     });
     RadioButton rb3RO = new RadioButton("3 Stars");
     rb3RO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(true);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(true);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupPO.selectToggle(null);
         }
     });
     RadioButton rb4RO = new RadioButton("4 Stars");
     rb4RO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(true);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(true);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupPO.selectToggle(null);
         }
     });
     RadioButton rb5RO = new RadioButton("5 Stars");
     rb5RO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(true);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(true);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupPO.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RO.setToggleGroup(groupRO);
     rb2RO.setToggleGroup(groupRO);
     rb3RO.setToggleGroup(groupRO);
     rb4RO.setToggleGroup(groupRO);
     rb5RO.setToggleGroup(groupRO);
     
     Text space3O = new Text(" ");
     Text propertyTypeO = new Text("Property Type");
     
     RadioButton rb1PO = new RadioButton("Hotel");
     rb1PO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(true);
        	 property3ButtonO.setVisible(true);
        	 property4ButtonO.setVisible(true);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(true);
        	 property3ButtonO.setManaged(true);
        	 property4ButtonO.setManaged(true);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupRO.selectToggle(null);
         }
     });
     RadioButton rb2PO = new RadioButton("Motel");
     rb2PO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(false);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(true);
        	 property6ButtonO.setVisible(true);
        	 
        	 property1ButtonO.setManaged(false);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(true);
        	 property6ButtonO.setManaged(true);
        	 
        	 groupRO.selectToggle(null);
         }
     });
     RadioButton rb3PO = new RadioButton("Hostel");
     rb3PO.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonO.setVisible(true);
        	 property2ButtonO.setVisible(false);
        	 property3ButtonO.setVisible(false);
        	 property4ButtonO.setVisible(false);
        	 property5ButtonO.setVisible(false);
        	 property6ButtonO.setVisible(false);
        	 
        	 property1ButtonO.setManaged(true);
        	 property2ButtonO.setManaged(false);
        	 property3ButtonO.setManaged(false);
        	 property4ButtonO.setManaged(false);
        	 property5ButtonO.setManaged(false);
        	 property6ButtonO.setManaged(false);
        	 
        	 groupRO.selectToggle(null);
         }
     });
     
     rb1PO.setToggleGroup(groupPO);
     rb2PO.setToggleGroup(groupPO);
     rb3PO.setToggleGroup(groupPO);    
     
     Text space4O = new Text(" "); 
     
     Button clearFiltersO = new Button("Clear Filters");
     clearFiltersO.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRO.selectToggle(null);
			groupPO.selectToggle(null);
			
			property1ButtonO.setVisible(true);
			property2ButtonO.setVisible(true);
			property3ButtonO.setVisible(true);
			property4ButtonO.setVisible(true);
			property5ButtonO.setVisible(true);
			property6ButtonO.setVisible(true);
       	 
			property1ButtonO.setManaged(true);
			property2ButtonO.setManaged(true);
			property3ButtonO.setManaged(true);
			property4ButtonO.setManaged(true);
			property5ButtonO.setManaged(true);
			property6ButtonO.setManaged(true);
		}
     });
     
     VBox vboxO = new VBox(spaceO, titleO, spaceTitleExtraO,
                          space1O, datesStayedO, spaceExtraO, startDateTitleO, startDateEntryO, spaceExtra2O, endDateTitleO, endDateEntryO, 
                          space2O, ratingsO, rb1RO, rb2RO, rb3RO, rb4RO, rb5RO,
                          space3O, propertyTypeO, rb1PO, rb2PO, rb3PO, 
                          space4O, clearFiltersO);
  
     bp2O.setLeft(vboxO);
     
     scene2O = new Scene(bp2O,300,250);
     
     //Scene 2 for Los angeles
     Button button7L= new Button("Go Back");
     button7L.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButtonL = new Button("Exit");
     exitButtonL.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     
     
     Button helpButtonL = new Button("Help");
     helpButtonL.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3L = new TextArea();
     ta3L.setEditable(false);
     ta3L.setPrefWidth(300);
     ta3L.setPrefHeight(400);
     
     TextArea ta4L= new TextArea();
     ta4L.setEditable(false);   
     ta4L.setStyle("-fx-font-weight: bold");
     
     location = new Text();
     location.setText("Current Location: Los Angeles");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     Image logo2L        = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView logo3L   = new ImageView(logo2L);
     logo3L.setFitWidth(1000);
     logo3L.setFitHeight(150);

     BorderPane bp2L = new BorderPane();
     bp2L.setTop(logo3L);
     bp2L.setBottom(clock2);

     cities LAone = new cities("Hotel Indigo", "Hotel", 5, 289);
     Image picture1L        = new Image("https://digital.ihg.com/is/image/ihg/hotel-indigo-los-angeles-4973010422-2x1?fit=fit,1&wid=2400&hei=1200&qlt=85,0&resMode=sharp2&op_usm=1.75,0.9,2,0");     
     ImageView pictureOneL   = new ImageView(picture1L);
     pictureOneL.setFitWidth(100);
     pictureOneL.setFitHeight(50);
     
     
     Text text1L = new Text(LAone.getName() + "				" + LAone.getType() + "				" + LAone.getRating() + " star				" + "$"+ LAone.getPrice() + " per night"); 
     Text space5L = new Text(" ");
     
     Stage stage2L = new Stage();
     stage2L.setTitle("New Window");
     stage2L.setWidth(400);
     stage2L.setHeight(400);

     HBox hbox1L = new HBox(space5L, pictureOneL, text1L);
     hbox1L.setSpacing(20);
     Button property1ButtonL    = new Button("",hbox1L);
     property1ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });

     cities LAtwo = new cities("Intercontinential", "Hotel", 4, 195);
     Image picture2L        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/208/208898135.jpg?hp=1 ");     
     ImageView pictureTwoL    = new ImageView(picture2L);
     pictureTwoL.setFitWidth(100);
     pictureTwoL.setFitHeight(50);
     
     Text text2L = new Text(LAtwo.getName() + "				" + LAtwo.getType() + "				" + LAtwo.getRating() + " star				" + "$"+ LAtwo.getPrice() + " per night"); 
     Text space6L = new Text(" ");
     
     HBox hbox2L = new HBox(space6L, pictureTwoL, text2L);
     hbox2L.setSpacing(20);
     Button property2ButtonL    = new Button("",hbox2L);
     property2ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });

     
     cities LAthree = new cities("Hollywood Inn", "Hotel", 3, 167);
     Image picture3L        = new Image("https://pix10.agoda.net/hotelImages/628/6281177/6281177_18121319030070373632.jpg?s=1200x800");     
     ImageView pictureThreeL   = new ImageView(picture3L);
     pictureThreeL.setFitWidth(100);
     pictureThreeL.setFitHeight(50);
     
     Text text3L = new Text(LAthree.getName() + "				" + LAthree.getType() + "				" + LAthree.getRating() + " star				" + "$"+ LAthree.getPrice() + " per night"); 
     Text space7L = new Text(" ");

     HBox hbox3L = new HBox(space7L, pictureThreeL, text3L);
     hbox3L.setSpacing(20);
     Button property3ButtonL    = new Button("",hbox3L);
     property3ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });

     
     cities LAfour = new cities("Freehand", "Hostel", 3, 194);
     Image picture4L        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/112819619.jpg?k=3cc40af97fd161f9cb6c1cb6eceb51a082ad21ee97fd7c1d070c77cc3dcaa0ac&o=");     
     ImageView pictureFourL   = new ImageView(picture4L);
     pictureFourL.setFitWidth(100);
     pictureFourL.setFitHeight(50);
     
     Text text4L = new Text(LAfour.getName() + "				" + LAfour.getType() + "				" + LAfour.getRating() + " star				" + "$"+ LAfour.getPrice() + " per night"); 
     Text space8L = new Text(" ");

     HBox hbox4L = new HBox(space8L, pictureFourL, text4L);
     hbox4L.setSpacing(20);
     Button property4ButtonL    = new Button("",hbox4L);
     property4ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });

     
     cities LAfive = new cities("Samesun", "Hostel", 2, 140);
     Image picture5L        = new Image("https://cf.bstatic.com/xdata/images/hotel/square200/294459585.jpg?k=4c8a71b8366b92d572327ab81007704eb9136b83ec4cb9093c2222ca714c1400&o=");     
     ImageView pictureFiveL   = new ImageView(picture5L);
     pictureFiveL.setFitWidth(100);
     pictureFiveL.setFitHeight(50);
     
     Text text5L = new Text(LAfive.getName() + "				" + LAfive.getType() + "				" + LAfive.getRating() + " star				" + "$"+ LAfive.getPrice() + " per night"); 
     Text space9L = new Text(" ");

     HBox hbox5L = new HBox(space9L, pictureFiveL, text5L);
     hbox5L.setSpacing(20);
     Button property5ButtonL    = new Button("",hbox5L);
     property5ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });
     
     
     cities LAsix = new cities("Outsider Inn", "Motel", 1, 130);
     Image picture6L        = new Image("https://pix10.agoda.net/hotelImages/501749/-1/721623544641192a456fd9fe87c8763f.jpg?s=1024x768");     
     ImageView pictureSixL   = new ImageView(picture6L);
     pictureSixL.setFitWidth(100);
     pictureSixL.setFitHeight(50);
     
     Text text6L = new Text(LAsix.getName() + "				" + LAsix.getType() + "				" + LAsix.getRating() + " star				" + "$"+ LAsix.getPrice() + " per night"); 
     Text space10L = new Text(" ");


     HBox hbox6L = new HBox(space10L, pictureSixL, text6L);
     hbox6L.setSpacing(20);
     Button property6ButtonL    = new Button("",hbox6L);
     property6ButtonL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2L.setScene(scene3);
        	 stage2L.show();
        	 location.setText("Current Location: Los Angeles");
         }
     });
     

     HBox hbox7L = new HBox(button7L, helpButtonL, exitButtonL);
     hbox7L.setSpacing(25);
     VBox vbox2L = new VBox(hbox7L, location, property1ButtonL, property2ButtonL, property3ButtonL, property4ButtonL, property5ButtonL, property6ButtonL);
     vbox2L.setSpacing(30);

     
     bp2L.setCenter(vbox2L);
     
     Text spaceL = new Text(" ");
     Text titleL = new Text("Filters:");
     titleL.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtraL = new Text(" ");
     
     Text space1L = new Text(" ");
     Text datesStayedL = new Text("Dates Stayed");
     Text spaceExtraL = new Text(" "); 
     Text startDateTitleL = new Text("Start Date");
     TextField startDateEntryL = new TextField();
     Text spaceExtra2L = new Text(" ");
     Text endDateTitleL = new Text("End Date");
     TextField endDateEntryL = new TextField(); 
     
     Text space2L = new Text(" ");
     Text ratingsL = new Text("Ratings");
     
     //Create toggle groups for ratings and property types
     ToggleGroup groupRL = new ToggleGroup();
     ToggleGroup groupPL = new ToggleGroup();
     
     RadioButton rb1RL = new RadioButton("1 Star");
     rb1RL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(true);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(true);
        	 
        	 groupPL.selectToggle(null);
         }
     });
     RadioButton rb2RL = new RadioButton("2 Stars");
     rb2RL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(true);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(true);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupPL.selectToggle(null);
         }
     });
     RadioButton rb3RL = new RadioButton("3 Stars");
     rb3RL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(true);
        	 property4ButtonL.setVisible(true);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(true);
        	 property4ButtonL.setManaged(true);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupPL.selectToggle(null);
         }
     });
     RadioButton rb4RL = new RadioButton("4 Stars");
     rb4RL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(true);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(true);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupPL.selectToggle(null);
         }
     });
     RadioButton rb5RL = new RadioButton("5 Stars");
     rb5RL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(true);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(true);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupPL.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RL.setToggleGroup(groupRL);
     rb2RL.setToggleGroup(groupRL);
     rb3RL.setToggleGroup(groupRL);
     rb4RL.setToggleGroup(groupRL);
     rb5RL.setToggleGroup(groupRL);
     
     Text space3L = new Text(" ");
     Text propertyTypeL = new Text("Property Type");
     
     RadioButton rb1PL = new RadioButton("Hotel");
     rb1PL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(true);
        	 property2ButtonL.setVisible(true);
        	 property3ButtonL.setVisible(true);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(true);
        	 property2ButtonL.setManaged(true);
        	 property3ButtonL.setManaged(true);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupRL.selectToggle(null);
         }
     });
     RadioButton rb2PL = new RadioButton("Motel");
     rb2PL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(false);
        	 property5ButtonL.setVisible(false);
        	 property6ButtonL.setVisible(true);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(false);
        	 property5ButtonL.setManaged(false);
        	 property6ButtonL.setManaged(true);
        	 
        	 groupRL.selectToggle(null);
         }
     });
     RadioButton rb3PL = new RadioButton("Hostel");
     rb3PL.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonL.setVisible(false);
        	 property2ButtonL.setVisible(false);
        	 property3ButtonL.setVisible(false);
        	 property4ButtonL.setVisible(true);
        	 property5ButtonL.setVisible(true);
        	 property6ButtonL.setVisible(false);
        	 
        	 property1ButtonL.setManaged(false);
        	 property2ButtonL.setManaged(false);
        	 property3ButtonL.setManaged(false);
        	 property4ButtonL.setManaged(true);
        	 property5ButtonL.setManaged(true);
        	 property6ButtonL.setManaged(false);
        	 
        	 groupRL.selectToggle(null);
         }
     });
     
     rb1PL.setToggleGroup(groupPL);
     rb2PL.setToggleGroup(groupPL);
     rb3PL.setToggleGroup(groupPL);    
     
     Text space4L = new Text(" "); 
     
     Button clearFiltersL = new Button("Clear Filters");
     clearFiltersL.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRL.selectToggle(null);
			groupPL.selectToggle(null);
			
			property1ButtonL.setVisible(true);
			property2ButtonL.setVisible(true);
			property3ButtonL.setVisible(true);
			property4ButtonL.setVisible(true);
			property5ButtonL.setVisible(true);
			property6ButtonL.setVisible(true);
       	 
			property1ButtonL.setManaged(true);
			property2ButtonL.setManaged(true);
			property3ButtonL.setManaged(true);
			property4ButtonL.setManaged(true);
			property5ButtonL.setManaged(true);
			property6ButtonL.setManaged(true);
		}
     });
     
     VBox vboxL = new VBox(spaceL, titleL, spaceTitleExtraL,
                          space1L, datesStayedL, spaceExtraL, startDateTitleL, startDateEntryL, spaceExtra2L, endDateTitleL, endDateEntryL, 
                          space2L, ratingsL, rb1RL, rb2RL, rb3RL, rb4RL, rb5RL,
                          space3L, propertyTypeL, rb1PL, rb2PL, rb3PL, 
                          space4L, clearFiltersL);
     
     bp2L.setLeft(vboxL);
          
     scene2L = new Scene(bp2L,300,250);
     
     //Scene 2 for Miami
     Button button7M= new Button("Go Back");
     button7M.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButtonM = new Button("Exit");
     exitButtonM.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     
     
     Button helpButtonM = new Button("Help");
     helpButtonM.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3M = new TextArea();
     ta3M.setEditable(false);
     ta3M.setPrefWidth(300);
     ta3M.setPrefHeight(400);
     
     TextArea ta4M= new TextArea();
     ta4M.setEditable(false);   
     ta4M.setStyle("-fx-font-weight: bold");
     
     location = new Text();
     location.setText("Current Location: Miami");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     ImageView logo3M   = new ImageView(logo2A);
     logo3M.setFitWidth(1000);
     logo3M.setFitHeight(150);
     
     cities Mone = new cities("Kimpton", "Hotel", 5, 348);
     Image picture1M        = new Image("https://www.epichotel.com/images/1700-960/view-01-a7369e32.jpg");     
     ImageView pictureOneM   = new ImageView(picture1M);
     pictureOneM.setFitWidth(100);
     pictureOneM.setFitHeight(50);
     
     Text text1M = new Text(Mone.getName() + "				" + Mone.getType() + "				" + Mone.getRating() + " star				" + "$"+ Mone.getPrice() + " per night");
     Text space5M = new Text(" ");
     
     Stage stage2M = new Stage();
     stage2M.setTitle("New Window");
     stage2M.setWidth(400);
     stage2M.setHeight(400);

     HBox hbox1M = new HBox(space5M, pictureOneM, text1M);
     hbox1M.setSpacing(20);
     Button property1ButtonM    = new Button("",hbox1M);
     property1ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     

     cities Mtwo = new cities("Hilton Miami", "Hotel", 4, 294);
     Image picture2M        = new Image("https://cf.bstatic.com/images/hotel/max1024x768/263/263285088.jpg");     
     ImageView pictureTwoM    = new ImageView(picture2M);
     pictureTwoM.setFitWidth(100);
     pictureTwoM.setFitHeight(50);
     
     Text text2M = new Text(Mtwo.getName() + "				" + Mtwo.getType() + "				" + Mtwo.getRating() + " star				" + "$"+ Mtwo.getPrice() + " per night"); 
     Text space6M = new Text(" ");
     
     HBox hbox2M = new HBox(space6M, pictureTwoM, text2M);
     hbox2M.setSpacing(20);
     Button property2ButtonM    = new Button("",hbox2M);
     property2ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     
     cities Mthree = new cities("Provident Dural", "Hotel", 5, 291);
     Image picture3M        = new Image("https://d3h1pvo2weh65e.cloudfront.net/providentresorts.com-4231748460/cms/cache/v2/5dbfc15e8871e.jpg/707x471/fit/80/fc3c57e8b5031d43dfaaf657e782bd45.jpg");     
     ImageView pictureThreeM    = new ImageView(picture3M);
     pictureThreeM.setFitWidth(100);
     pictureThreeM.setFitHeight(50);
     
     Text text3M = new Text(Mthree.getName() + "				" + Mthree.getType() + "				" + Mthree.getRating() + " star				" + "$"+ Mthree.getPrice() + " per night"); 
     Text space7M = new Text(" ");
     
     HBox hbox3M = new HBox(space7M, pictureThreeM, text3M);
     hbox3M.setSpacing(20);
     Button property3ButtonM    = new Button("",hbox3M);
     property3ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     
     cities Mfour = new cities("Gary Motel", "Motel", 3, 284);
     Image picture4M        = new Image("https://images.trvl-media.com/hotels/38000000/37040000/37033800/37033755/712e51bd.jpg?impolicy=fcrop&w=1200&h=800&p=1&q=medium");     
     ImageView pictureFourM    = new ImageView(picture4M);
     pictureFourM.setFitWidth(100);
     pictureFourM.setFitHeight(50);
     
     Text text4M = new Text(Mfour.getName() + "				" + Mfour.getType() + "				" + Mfour.getRating() + " star				" + "$"+ Mfour.getPrice() + " per night"); 
     Text space8M = new Text(" ");
     
     HBox hbox4M = new HBox(space8M, pictureFourM, text4M);
     hbox4M.setSpacing(20);
     Button property4ButtonM    = new Button("",hbox4M);
     property4ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     
     cities Mfive = new cities("The Hideaway", "Hostel", 1, 142);
     Image picture5M        = new Image("https://miro.medium.com/max/10424/1*3nupGXQ7QhJdN6UHgFcwoA.jpeg");     
     ImageView pictureFiveM    = new ImageView(picture5M);
     pictureFiveM.setFitWidth(100);
     pictureFiveM.setFitHeight(50);
     
     Text text5M = new Text(Mfive.getName() + "				" + Mfive.getType() + "				" + Mfive.getRating() + " star				" + "$"+ Mfive.getPrice() + " per night"); 
     Text space9M = new Text(" ");
     
     HBox hbox5M = new HBox(space9M, pictureFiveM, text5M);
     hbox5M.setSpacing(20);
     Button property5ButtonM    = new Button("",hbox5M);
     property5ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     
     cities Msix = new cities("Group", "Hostel", 2, 124);
     Image picture6M        = new Image("https://www.tripsavvy.com/thmb/NLNutuAoWs8iI9H67AK3h0WgIks=/1881x1411/smart/filters:no_upscale()/Dorm-room-in-a-hostel-5786ab2b3df78c1e1f9ceac5.jpg");     
     ImageView pictureSixM    = new ImageView(picture6M);
     pictureSixM.setFitWidth(100);
     pictureSixM.setFitHeight(50);
     
     Text text6M = new Text(Msix.getName() + "				" + Msix.getType() + "				" + Msix.getRating() + " star				" + "$"+ Msix.getPrice() + " per night"); 
     Text space10M = new Text(" ");
     
     HBox hbox6M = new HBox(space10M, pictureSixM, text6M);
     hbox6M.setSpacing(20);
     Button property6ButtonM    = new Button("",hbox6M);
     property6ButtonM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2M.setScene(scene3);
        	 stage2M.show();
        	 location.setText("Current Location: Miami");
         }
     });
     

     HBox hbox7M = new HBox(button7M, helpButtonM, exitButtonM);
     hbox7M.setSpacing(25);
     VBox vbox2M = new VBox(hbox7M, location, property1ButtonM, property2ButtonM, property3ButtonM, property4ButtonM, property5ButtonM, property6ButtonM);
     vbox2M.setSpacing(30);

     BorderPane bp2M = new BorderPane();
     bp2M.setCenter(vbox2M);

     
     Text spaceM = new Text(" ");
     Text titleM = new Text("Filters:");
     titleM.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtraM = new Text(" ");
     
     Text space1M = new Text(" ");
     Text datesStayedM = new Text("Dates Stayed");
     Text spaceExtraM = new Text(" "); 
     Text startDateTitleM = new Text("Start Date");
     TextField startDateEntryM = new TextField();
     Text spaceExtra2M = new Text(" ");
     Text endDateTitleM = new Text("End Date");
     TextField endDateEntryM = new TextField(); 
     
     Text space2M = new Text(" ");
     Text ratingsM = new Text("Ratings");
     
     //Create toggle groups for ratings and property types
     ToggleGroup groupRM = new ToggleGroup();
     ToggleGroup groupPM = new ToggleGroup();
     
     RadioButton rb1RM = new RadioButton("1 Star");
     rb1RM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(true);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(true);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupPM.selectToggle(null);
         }
     });
     RadioButton rb2RM = new RadioButton("2 Stars");
     rb2RM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(true);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(true);
        	 
        	 groupPM.selectToggle(null);
         }
     });
     RadioButton rb3RM = new RadioButton("3 Stars");
     rb3RM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(true);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(true);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupPM.selectToggle(null);
         }
     });
     RadioButton rb4RM = new RadioButton("4 Stars");
     rb4RM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(true);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(true);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupPM.selectToggle(null);
         }
     });
     RadioButton rb5RM = new RadioButton("5 Stars");
     rb5RM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(true);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(true);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(true);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(true);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupPM.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RM.setToggleGroup(groupRM);
     rb2RM.setToggleGroup(groupRM);
     rb3RM.setToggleGroup(groupRM);
     rb4RM.setToggleGroup(groupRM);
     rb5RM.setToggleGroup(groupRM);
     
     Text space3M = new Text(" ");
     Text propertyTypeM = new Text("Property Type");
     
     RadioButton rb1PM = new RadioButton("Hotel");
     rb1PM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(true);
        	 property2ButtonM.setVisible(true);
        	 property3ButtonM.setVisible(true);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(true);
        	 property2ButtonM.setManaged(true);
        	 property3ButtonM.setManaged(true);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupRM.selectToggle(null);
         }
     });
     RadioButton rb2PM = new RadioButton("Motel");
     rb2PM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(true);
        	 property5ButtonM.setVisible(false);
        	 property6ButtonM.setVisible(false);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(true);
        	 property5ButtonM.setManaged(false);
        	 property6ButtonM.setManaged(false);
        	 
        	 groupRM.selectToggle(null);
         }
     });
     RadioButton rb3PM = new RadioButton("Hostel");
     rb3PM.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonM.setVisible(false);
        	 property2ButtonM.setVisible(false);
        	 property3ButtonM.setVisible(false);
        	 property4ButtonM.setVisible(false);
        	 property5ButtonM.setVisible(true);
        	 property6ButtonM.setVisible(true);
        	 
        	 property1ButtonM.setManaged(false);
        	 property2ButtonM.setManaged(false);
        	 property3ButtonM.setManaged(false);
        	 property4ButtonM.setManaged(false);
        	 property5ButtonM.setManaged(true);
        	 property6ButtonM.setManaged(true);
        	 
        	 groupRM.selectToggle(null);
         }
     });
     
     rb1PM.setToggleGroup(groupPM);
     rb2PM.setToggleGroup(groupPM);
     rb3PM.setToggleGroup(groupPM);    
     
     Text space4M = new Text(" "); 
     
     Button clearFiltersM = new Button("Clear Filters");
     clearFiltersM.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRM.selectToggle(null);
			groupPM.selectToggle(null);
			
			property1ButtonM.setVisible(true);
			property2ButtonM.setVisible(true);
			property3ButtonM.setVisible(true);
			property4ButtonM.setVisible(true);
			property5ButtonM.setVisible(true);
			property6ButtonM.setVisible(true);
       	 
			property1ButtonM.setManaged(true);
			property2ButtonM.setManaged(true);
			property3ButtonM.setManaged(true);
			property4ButtonM.setManaged(true);
			property5ButtonM.setManaged(true);
			property6ButtonM.setManaged(true);
		}
     });
     
     VBox vboxM = new VBox(spaceM, titleM, spaceTitleExtraM,
                          space1M, datesStayedM, spaceExtraM, startDateTitleM, startDateEntryM, spaceExtra2M, endDateTitleM, endDateEntryM, 
                          space2M, ratingsM, rb1RM, rb2RM, rb3RM, rb4RM, rb5RM,
                          space3M, propertyTypeM, rb1PM, rb2PM, rb3PM, space4M, clearFiltersM);
     
     bp2M.setTop(logo3M);
     bp2M.setBottom(clock2);
     bp2M.setLeft(vboxM);
      
     scene2M = new Scene(bp2M,300,250);
     
    
     //Scene 2 for Las Vegas
     Button button7LV= new Button("Go Back");
     button7LV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 primaryStage.setScene(scene1);
        	 trans.wrTransactionData("Back Button Clicked from Property Screen");

         }
     });
     
     Button exitButtonLV = new Button("Exit");
     exitButtonLV.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Platform.runLater(new Runnable()
			{
				public void run()
				{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Exit Confirmation Dialog");
					alert.setContentText("Are you sure you want to exit?");
					
					Optional<ButtonType> result = alert.showAndWait();
					
					if(result.get() == ButtonType.OK)
					{
						System.exit(0);
					}
				}
						
			});
		}
     });
     
     Button helpButtonLV = new Button("Help");
     helpButtonLV.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Bookings.com Help Window");
			
			String helpString = "For additional assistance, please call our help line at +1-800-BOOKING or email us at help@bookings.com.";
			
			alert.setHeaderText("Help Screen");
			alert.setContentText(helpString);
			
			alert.showAndWait();
			
		}
     });
     
          
     TextArea ta3LV = new TextArea();
     ta3LV.setEditable(false);
     ta3LV.setPrefWidth(300);
     ta3LV.setPrefHeight(400);
     
     TextArea ta4LV= new TextArea();
     ta4LV.setEditable(false);   
     ta4LV.setStyle("-fx-font-weight: bold");
     
     location = new Text();
     location.setText("Current Location: Las Vegas");
     location.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

     ImageView logo3LV   = new ImageView(logo2A);
     logo3LV.setFitWidth(1000);
     logo3LV.setFitHeight(150);

     BorderPane bp2LV = new BorderPane();
     bp2LV.setTop(logo3LV);
     bp2LV.setBottom(clock2);
     
     cities LVone = new cities("Bellagio", "Hotel", 4, 299);
     Image picture1LV        = new Image("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/8a/e0/b9/bellagio-las-vegas.jpg?w=900&h=-1&s=1");     
     ImageView pictureOneLV  = new ImageView(picture1LV);
     pictureOneLV.setFitWidth(100);
     pictureOneLV.setFitHeight(50);
     
     Text text1LV = new Text(LVone.getName() + "				" + LVone.getType() + "				" + LVone.getRating() + " star				" + "$"+ LVone.getPrice() + " per night");
     Text space5LV = new Text(" ");
     
     Stage stage2LV = new Stage();
     stage2LV.setTitle("New Window");
     stage2LV.setWidth(400);
     stage2LV.setHeight(400);

     HBox hbox1LV = new HBox(space5LV, pictureOneLV, text1LV);
     hbox1LV.setSpacing(20);
     Button property1ButtonLV    = new Button("",hbox1LV);
     property1ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "1";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     

     cities LVtwo = new cities("MGM Grand", "Hotel", 5, 358);
     Image picture2LV        = new Image("https://www.fivestaralliance.com/files/fivestaralliance.com/field/image/nodes/2010/13926/13926_0_mgmgrandhotelandcasino_fsa-g.jpg");     
     ImageView pictureTwoLV    = new ImageView(picture2LV);
     pictureTwoLV.setFitWidth(100);
     pictureTwoLV.setFitHeight(50);
     
     Text text2LV = new Text(LVtwo.getName() + "				" + LVtwo.getType() + "				" + LVtwo.getRating() + " star				" + "$"+ LVtwo.getPrice() + " per night"); 
     Text space6LV = new Text(" ");
     
     HBox hbox2LV = new HBox(space6LV, pictureTwoLV, text2LV);
     hbox2LV.setSpacing(20);
     Button property2ButtonLV    = new Button("",hbox2LV);
     property2ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "2";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     
     cities LVthree = new cities("Mandalay Bay", "Hotel", 4, 300);
     Image picture3LV        = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Mandalay_Bay_Hotel_Las_Vegas_%28July_15_2008%29.jpg/1200px-Mandalay_Bay_Hotel_Las_Vegas_%28July_15_2008%29.jpg");     
     ImageView pictureThreeLV    = new ImageView(picture3LV);
     pictureThreeLV.setFitWidth(100);
     pictureThreeLV.setFitHeight(50);
     
     Text text3LV = new Text(LVthree.getName() + "				" + LVthree.getType() + "				" + LVthree.getRating() + " star				" + "$"+ LVthree.getPrice() + " per night"); 
     Text space7LV = new Text(" ");
     
     HBox hbox3LV = new HBox(space7LV, pictureThreeLV, text3LV);
     hbox3LV.setSpacing(20);
     Button property3ButtonLV    = new Button("",hbox3LV);
     property3ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "3";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     
     cities LVfour = new cities("Quality Inn", "Motel", 2, 195);
     Image picture4LV        = new Image("https://content.skyscnr.com/m/4bb6095d0dbb56fd/original/Motel-Nacht.jpg?resize=1800px:1800px&quality=100");     
     ImageView pictureFourLV    = new ImageView(picture4LV);
     pictureFourLV.setFitWidth(100);
     pictureFourLV.setFitHeight(50);
     
     Text text4LV = new Text(LVfour.getName() + "				" + LVfour.getType() + "				" + LVfour.getRating() + " star				" + "$"+ LVfour.getPrice() + " per night"); 
     Text space8LV = new Text(" ");
     
     HBox hbox4LV = new HBox(space8LV, pictureFourLV, text4LV);
     hbox4LV.setSpacing(20);
     Button property4ButtonLV    = new Button("",hbox4LV);
     property4ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "4";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     
     
     cities LVfive = new cities("Blue Swallow", "Motel", 3, 200);
     Image picture5LV        = new Image("https://media-cdn.tripadvisor.com/media/photo-s/18/fc/74/35/the-classic-neon-sign.jpg");     
     ImageView pictureFiveLV    = new ImageView(picture5LV);
     pictureFiveLV.setFitWidth(100);
     pictureFiveLV.setFitHeight(50);
     
     Text text5LV = new Text(LVfive.getName() + "				" + LVfive.getType() + "				" + LVfive.getRating() + " star				" + "$"+ LVfive.getPrice() + " per night"); 
     Text space9LV = new Text(" ");
     
     HBox hbox5LV = new HBox(space9LV, pictureFiveLV, text5LV);
     hbox5LV.setSpacing(20);
     Button property5ButtonLV    = new Button("",hbox5LV);
     property5ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "5";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     
     cities LVsix = new cities("Ocean Sky", "Hostel", 1, 144);
     Image picture6LV        = new Image("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/ff/75/c1/sanat-hostel.jpg?w=900&h=-1&s=1");     
     ImageView pictureSixLV    = new ImageView(picture6LV);
     pictureSixLV.setFitWidth(100);
     pictureSixLV.setFitHeight(50);
     
     Text text6LV = new Text(LVsix.getName() + "				" + LVsix.getType() + "				" + LVsix.getRating() + " star				" + "$"+ LVsix.getPrice() + " per night"); 
     Text space10LV = new Text(" ");
     
     HBox hbox6LV = new HBox(space10LV, pictureSixLV, text6LV);
     hbox6LV.setSpacing(20);
     Button property6ButtonLV    = new Button("",hbox6LV);
     property6ButtonLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 propertySelected = "6";
        	 stage2LV.setScene(scene3);
        	 stage2LV.show();
        	 location.setText("Current Location: Las Vegas");
         }
     });
     

     HBox hbox7LV = new HBox(button7LV, helpButtonLV, exitButtonLV);
     hbox7LV.setSpacing(25);
     VBox vbox2LV = new VBox(hbox7LV, location, property1ButtonLV, property2ButtonLV, property3ButtonLV, property4ButtonLV, property5ButtonLV, property6ButtonLV);
     vbox2LV.setSpacing(30);

     bp2LV.setCenter(vbox2LV);
     
     Text spaceLV = new Text(" ");
     Text titleLV = new Text("Filters:");
     titleLV.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text spaceTitleExtraLV = new Text(" ");
     
     Text space1LV = new Text(" ");
     Text datesStayedLV = new Text("Dates Stayed");
     Text spaceExtraLV = new Text(" "); 
     Text startDateTitleLV = new Text("Start Date");
     TextField startDateEntryLV = new TextField();
     Text spaceExtra2LV = new Text(" ");
     Text endDateTitleLV = new Text("End Date");
     TextField endDateEntryLV = new TextField(); 
     
     Text space2LV = new Text(" ");
     Text ratingsLV = new Text("Ratings");
     
     //Create toggle groups for ratings and property types
     ToggleGroup groupRLV = new ToggleGroup();
     ToggleGroup groupPLV = new ToggleGroup();
     
     RadioButton rb1RLV = new RadioButton("1 Star");
     rb1RLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(true);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(true);
        	 
        	 groupPLV.selectToggle(null);
         }
     });
     RadioButton rb2RLV = new RadioButton("2 Stars");
     rb2RLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(true);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(true);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupPLV.selectToggle(null);
         }
     });
     RadioButton rb3RLV = new RadioButton("3 Stars");
     rb3RLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(true);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(true);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupPLV.selectToggle(null);
         }
     });
     RadioButton rb4RLV = new RadioButton("4 Stars");
     rb4RLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(true);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(true);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(true);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(true);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupPLV.selectToggle(null);
         }
     });
     RadioButton rb5RLV = new RadioButton("5 Stars");
     rb5RLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(true);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(true);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupPLV.selectToggle(null);
         }
     });
     
     //Add radio buttons to a ToggleGroup so that only one button can be selected at a time
     rb1RLV.setToggleGroup(groupRLV);
     rb2RLV.setToggleGroup(groupRLV);
     rb3RLV.setToggleGroup(groupRLV);
     rb4RLV.setToggleGroup(groupRLV);
     rb5RLV.setToggleGroup(groupRLV);
     
     Text space3LV = new Text(" ");
     Text propertyTypeLV = new Text("Property Type");
     
     RadioButton rb1PLV = new RadioButton("Hotel");
     rb1PLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(true);
        	 property2ButtonLV.setVisible(true);
        	 property3ButtonLV.setVisible(true);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(true);
        	 property2ButtonLV.setManaged(true);
        	 property3ButtonLV.setManaged(true);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupRLV.selectToggle(null);
         }
     });
     RadioButton rb2PLV = new RadioButton("Motel");
     rb2PLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(true);
        	 property5ButtonLV.setVisible(true);
        	 property6ButtonLV.setVisible(false);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(true);
        	 property5ButtonLV.setManaged(true);
        	 property6ButtonLV.setManaged(false);
        	 
        	 groupRLV.selectToggle(null);
         }
     });
     RadioButton rb3PLV = new RadioButton("Hostel");
     rb3PLV.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 property1ButtonLV.setVisible(false);
        	 property2ButtonLV.setVisible(false);
        	 property3ButtonLV.setVisible(false);
        	 property4ButtonLV.setVisible(false);
        	 property5ButtonLV.setVisible(false);
        	 property6ButtonLV.setVisible(true);
        	 
        	 property1ButtonLV.setManaged(false);
        	 property2ButtonLV.setManaged(false);
        	 property3ButtonLV.setManaged(false);
        	 property4ButtonLV.setManaged(false);
        	 property5ButtonLV.setManaged(false);
        	 property6ButtonLV.setManaged(true);
        	 
        	 groupRLV.selectToggle(null);
         }
     });
     
     rb1PLV.setToggleGroup(groupPLV);
     rb2PLV.setToggleGroup(groupPLV);
     rb3PLV.setToggleGroup(groupPLV);    
     
     Text space4LV = new Text(" "); 
     
     Button clearFiltersLV = new Button("Clear Filters");
     clearFiltersLV.setOnAction(new EventHandler<ActionEvent>()
     {
		@Override public void handle(ActionEvent e) 
		{
			groupRLV.selectToggle(null);
			groupPLV.selectToggle(null);
			
			property1ButtonLV.setVisible(true);
			property2ButtonLV.setVisible(true);
			property3ButtonLV.setVisible(true);
			property4ButtonLV.setVisible(true);
			property5ButtonLV.setVisible(true);
			property6ButtonLV.setVisible(true);
       	 
			property1ButtonLV.setManaged(true);
			property2ButtonLV.setManaged(true);
			property3ButtonLV.setManaged(true);
			property4ButtonLV.setManaged(true);
			property5ButtonLV.setManaged(true);
			property6ButtonLV.setManaged(true);
		}
     });
     
     VBox vboxLV = new VBox(spaceLV, titleLV, spaceTitleExtraLV,
                          space1LV, datesStayedLV, spaceExtraLV, startDateTitleLV, startDateEntryLV, spaceExtra2LV, endDateTitleLV, endDateEntryLV, 
                          space2LV, ratingsLV, rb1RLV, rb2RLV, rb3RLV, rb4RLV, rb5RLV,
                          space3LV, propertyTypeLV, rb1PLV, rb2PLV, rb3PLV, space4LV, clearFiltersLV);
    
     bp2LV.setLeft(vboxLV);
     
     scene2LV = new Scene(bp2LV,300,250);
     
     /*
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      */
     
     //Scene 3
     Image screen3Logo        = new Image("https://gocheepnow.com/wp-content/uploads/2020/06/BOOKING.COM-LOGO.jpg");     
     ImageView screen3Logo2   = new ImageView(screen3Logo);
     screen3Logo2.setFitWidth(400);
     screen3Logo2.setFitHeight(50);
     
     BorderPane screen3bp = new BorderPane();
     screen3bp.setTop(screen3Logo2);
     
	 //create labels and text fields for data entry screen
	 Label fname               = new Label("   First Name:");
	 TextField fname2          = new TextField();
	 Label lname               = new Label("   Last Name:");
	 TextField lname2          = new TextField();
	 Label email               = new Label("   Email:");
	 TextField email2          = new TextField();
	 Label phone               = new Label("   Phone Number:");
	 TextField phone2          = new TextField();	
	 Label billingAddress      = new Label("   Billing Address:");
	 TextField billingAddress2 = new TextField();
	 Label cardNum             = new Label("   Card Number:");
	 TextField cardNum2        = new TextField();
	 Label expDate             = new Label("   Expiration Date:       ");
	 TextField expDate2        = new TextField();
	 Label blankLine           = new Label( "           ");
	 Label blankLine2          = new Label( "           ");
		
		
	 // code to add save button which writes text field information to a text file
	 Button save = new Button("Save");
	 save.setOnAction(new EventHandler<ActionEvent>()
     {
         @Override public void handle(ActionEvent e)
         {
        	 
        	// Start with good, if we hit errors, we mark it as false
        	boolean allGood = true;
         	
        	// If all fields are filled in, send over, otherwise, give error
        	if ((fname2.getText() != null && fname2.getText().trim() != "") && 
        		(lname2.getText() != null && lname2.getText().trim() != "") &&
        		(email2.getText() != null && email2.getText().trim() != "") && 
        		(phone2.getText() != null && phone2.getText().trim() != "") &&
        		(billingAddress2.getText() != null && billingAddress2.getText().trim() != "") && 
        		(cardNum2.getText() != null && cardNum2.getText().trim() != "") &&
        		(expDate2.getText() != null && expDate2.getText().trim() != "")) 
        	{
        		// if first name contains a number or special character
        		if (!fname2.getText().matches("[A-Za-z ]*")) {
        			Alert error1 = new Alert(Alert.AlertType.WARNING);
            		error1.setTitle("First name cannot contain a digit or special characters");
        			error1.setHeaderText("Warning");
        			error1.setContentText("First name cannot contain a digit or special characters.");
        			error1.showAndWait();
        			allGood = false;
        		}
        		
        		if (!lname2.getText().matches("[A-Za-z ]*")) {
        			Alert error2 = new Alert(Alert.AlertType.WARNING);
            		error2.setTitle("Last name cannot contain a digit or special characters");
        			error2.setHeaderText("Warning");
        			error2.setContentText("Last name cannot contain a digit or special characters.");
        			error2.showAndWait();
        			allGood = false;
        		}
        		
        		if (!email2.getText().matches("[A-Za-z0-9.@ ]*")) {
        			Alert error3 = new Alert(Alert.AlertType.WARNING);
            		error3.setTitle("Please enter a valid email address");
        			error3.setHeaderText("Warning");
        			error3.setContentText("Please enter a valid email address.");
        			error3.showAndWait();
        			allGood = false;
        		}
        		
        		if (!phone2.getText().matches("[0-9 ]*")) {
        			Alert error4 = new Alert(Alert.AlertType.WARNING);
            		error4.setTitle("Please do not include symbols or letters when entering phone number");
        			error4.setHeaderText("Warning");
        			error4.setContentText("Please do not include symbols or letters when entering phone number.");
        			error4.showAndWait();
        			allGood = false;
        		}
        		
        		if (!billingAddress2.getText().matches("[A-Za-z0-9 ]*")) {
        			Alert error5 = new Alert(Alert.AlertType.WARNING);
            		error5.setTitle("Please do not include symbols when entering address");
        			error5.setHeaderText("Warning");
        			error5.setContentText("Please do not include symbols when entering address.");
        			error5.showAndWait();
        			allGood = false;
        		}
        		
        		if (!cardNum2.getText().matches("[0-9 ]*")) {
        			Alert error6 = new Alert(Alert.AlertType.WARNING);
            		error6.setTitle("Please do not include symbols or letters when entering credit card number");
        			error6.setHeaderText("Warning");
        			error6.setContentText("Please do not include symbols when entering credit card number.");
        			error6.showAndWait();
        			allGood = false;
        		}
	        	
        		if (!expDate2.getText().matches("[0-9/ ]*")) {
        			Alert error7 = new Alert(Alert.AlertType.WARNING);
            		error7.setTitle("Please do not include symbols or letters when entering expiration date");
        			error7.setHeaderText("Warning");
        			error7.setContentText("Please do not include symbols or letters when entering experation date.");
        			error7.showAndWait();
        			allGood = false;
        		}
        		
        		// Check lengths
        		if (email2.getText().length() < 5) {
        			Alert error8 = new Alert(Alert.AlertType.WARNING);
            		error8.setTitle("Please enter a valid email");
        			error8.setHeaderText("Warning");
        			error8.setContentText("Please enter a valid email.");
        			error8.showAndWait();
        			allGood = false;
        		}
        		
        		if (phone2.getText().length() < 9) {
        			Alert error9 = new Alert(Alert.AlertType.WARNING);
            		error9.setTitle("Please enter a valid phone number");
        			error9.setHeaderText("Warning");
        			error9.setContentText("Please enter a valid phone number.");
        			error9.showAndWait();
        			allGood = false;
        		}
        		
        		if (billingAddress2.getText().length() < 5) {
        			Alert error10 = new Alert(Alert.AlertType.WARNING);
            		error10.setTitle("Please enter a valid billing address");
        			error10.setHeaderText("Warning");
        			error10.setContentText("Please enter a valid billing address.");
        			error10.showAndWait();
        			allGood = false;
        		}
        		
        		if (cardNum2.getText().length() < 9) {
        			Alert error11 = new Alert(Alert.AlertType.WARNING);
            		error11.setTitle("Please enter a valid card number");
        			error11.setHeaderText("Warning");
        			error11.setContentText("Please enter a valid card number.");
        			error11.showAndWait();
        			allGood = false;
        		}
        		
        		if (expDate2.getText().length() < 4) {
        			Alert error12 = new Alert(Alert.AlertType.WARNING);
            		error12.setTitle("Please enter a valid exp date");
        			error12.setHeaderText("Warning");
        			error12.setContentText("Please enter a valid exp date.");
        			error12.showAndWait();
        			allGood = false;
        		}
        		
        		
        		// If one error above, this will not run
        		if (allGood) {  // if allGood == true
	        		// If we passed all if conditions
		        	//write employee information to a text file once save button is clicked
		         	trans.wrTransactionData("First Name: " + fname2.getText());
		     		trans.wrTransactionData("Last Name: " + lname2.getText());
		     		trans.wrTransactionData("Email: " + email2.getText());
		     		trans.wrTransactionData("Phone: " + phone2.getText());
		     		trans.wrTransactionData("Billing Address: " + billingAddress2.getText());
		     		trans.wrTransactionData("Card Number: " + cardNum2.getText());
		     		trans.wrTransactionData("Expiration Date: " + expDate2.getText());
		     		
		     		mySocket.socketConnect();
					// The '!' signifies where the server will replace with newline
					mySocket.sendMessage("Desired Location: "+location.getText().replace("Current Location: ", "")
										  +"!"+"Desired Property: "+propertySelected+"!"+
										 "First Name: "+fname2.getText()+"!"+"Last Name: "+lname2.getText()+"!"+
										 "Email: "+email2.getText()+"!"+"Phone Number: "+phone2.getText()+"!"+
										 "Address: "+billingAddress2.getText()+"!"+"CC Number: "+cardNum2.getText()+"!"+
										 "Exp Date: "+expDate2.getText()+"!");
					
					
					emailSender.emailSendFunc(fname2.getText(), lname2.getText(), email2.getText(), location.getText().replace("Current Location: ", ""),
							                 propertySelected, cardNum2.getText(), billingAddress2.getText());
					
					
        		}
        	} else {
        		Alert notFilledAlert = new Alert(Alert.AlertType.WARNING);
        		notFilledAlert.setTitle("Information not filled out completely");
    			notFilledAlert.setHeaderText("Warning");
    			notFilledAlert.setContentText("Please fill in all information fields before hitting save.");
    			notFilledAlert.showAndWait();
        	}
         }
     });

	 // code to add a clear button which clears all text fields
	 Button clear = new Button("Clear");
	 clear.setOnAction(new EventHandler<ActionEvent>()
	 {
		 @Override public void handle(ActionEvent e)
         {
				fname2.setText("");
			    lname2.setText("");
			    email2.setText("");
			    phone2.setText("");
			    billingAddress2.setText("");
			    cardNum2.setText("");
			    expDate2.setText("");
         }
	 });
	 
	 // code to add a cancel button that closes pop-up window
	 Button cancel = new Button("Cancel");
     cancel.setOnAction(new EventHandler<ActionEvent>() 
     {
         @Override public void handle(ActionEvent e)
         {
        	 
        	Platform.runLater(new Runnable()
 			{
 				public void run()
 				{
 					Alert alert = new Alert(Alert.AlertType.INFORMATION);
 					alert.setTitle("Confirmation Dialog");
 					alert.setHeaderText("Exit Confirmation Dialog");
 					alert.setContentText("Are you sure you want to cancel?");
 					
 					Optional<ButtonType> result = alert.showAndWait();
 					
 					if(result.get() == ButtonType.OK)
 					{
 						// It has to be one of these lol
 						stage2.close(); // closes nyc
 						stage2O.close();
 						stage2A.close();
 						stage2L.close();
 						stage2M.close();
 						stage2LV.close();
 					}
 				}
 				
 			});					
         }       	 
     });
		
	 // hbox with save, clear, cancel buttons
	 HBox screen3hbox = new HBox(save, clear, cancel);
	 screen3hbox.setSpacing(10);
		
	 // display labels, text fields, and buttons using a grid pane
	 GridPane custInfo = new GridPane();
	 custInfo.add(blankLine,      0, 1);
	 custInfo.add(fname,          0, 2);
	 custInfo.add(fname2,         1, 2);
	 custInfo.add(lname,          0, 3);
	 custInfo.add(lname2,         1, 3);
	 custInfo.add(email,          0, 4);
	 custInfo.add(email2,         1, 4);
	 custInfo.add(phone,          0, 5);
	 custInfo.add(phone2,         1, 5);
	 custInfo.add(billingAddress, 0, 6);
	 custInfo.add(billingAddress2,1, 6);
	 custInfo.add(cardNum,        0, 7);
	 custInfo.add(cardNum2,       1, 7);
	 custInfo.add(expDate,        0, 8);
	 custInfo.add(expDate2,       1, 8);
	 custInfo.add(blankLine2,     1, 10);   
	 custInfo.add(screen3hbox,    1, 11);
     
     screen3bp.setCenter(custInfo);
     
     scene3 = new Scene(screen3bp, 400, 400);	 
    		 
     primaryStage.setScene(scene1);
     primaryStage.show();
   } 
   
// Clock - thread code
private void refreshClock()
{
 	 Thread refreshClock = new Thread()
		   {  
			  public void run()
			  {	 
				while (true)
				{
					Date dte = new Date();
		
					String topMenuStr = "       " + dte.toString();					      
				    
					clock.setText(topMenuStr);
					clock2.setText(topMenuStr);
			               
				    try
				    {
					   sleep(1000L);
				    }
				    catch (InterruptedException e) 
				    {
					   // TODO Auto-generated catch block
					   e.printStackTrace();
				    }
				  
	            }  // end while ( true )
				 
		    } // end run thread
		 };

	     refreshClock.start();
 } 
 
 public class fileIO 
 {
 		public void wrTransactionData(String dataStr)
 		{
 	        FileWriter fwg = null;
 	        try 
 	        {
 	        	// open the file in append write mode
 	        	fwg = new FileWriter("transactionLog.txt", true);
 	        }
 	        catch (IOException e)
 	        {
 	        	// TODO Auto-generated catch block
 	        	e.printStackTrace();
 	        }
 	   	    
 	        BufferedWriter bwg = new BufferedWriter(fwg);
 	        PrintWriter outg   = new PrintWriter(bwg);
 			
 	        String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss").format(new Date());
 	        
 	        outg.println(timeStamp + " : " + dataStr);
 	        
 	        outg.close();
 		}
 }
 
 public class socketUtils
 {
 	Socket clientSocket=null;
 	DataOutputStream outToServer=null;
 	BufferedReader inFromServer=null;

 	public boolean socketConnect()
 	{
 		String ipAddress, portString;
 		int portNumber;
 		boolean rc=false;

 		try
 		{
 			File file = new File("config .txt");
 				if (file.exists())
 				{
 					BufferedReader br = new BufferedReader(new FileReader("config.txt"));
 					
 					ipAddress = br.readLine();
 					portString = br.readLine();

 					portNumber = Integer.parseInt(portString);
 					br.close();
 				}
 				else
 				{	
 					 InetAddress myIpAddress = null;
 					 try
 				     {
 						myIpAddress = InetAddress.getLocalHost();
 				     }
 					 catch (UnknownHostException el)
 					 {
 					    el.printStackTrace();
 					 }
 					 
 					ipAddress = myIpAddress.getHostAddress();  // 127.0.0.1 and "localhost" aren't working
 					portNumber = 3333;
 				}

 				clientSocket = new Socket(ipAddress,portNumber);

 				outToServer = new DataOutputStream(clientSocket.getOutputStream());
 				inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 				rc= true;
 		}

 		catch (ConnectException ex)
 		{
 			ex.printStackTrace();
 		}
 		catch (UnknownHostException ex)
 		{
 			ex.printStackTrace();
 		}
 		catch (IOException ex)
 		{
 			ex.printStackTrace();
 		}
 		return rc;
 	}

 	public boolean sendMessage(String msg)
 	{
 		boolean rc=false;
 			
 		try
 		{
 			outToServer.writeBytes(msg + "\r\n");
 			outToServer.flush();
 			rc = true;
 		}
 		catch (IOException e)
 		{
 			e.printStackTrace();
 		}
 	
  		return rc;
 	}

 	public String recvMessage()
 	{
 		String msg=null;

 		try
 		{
 			msg = inFromServer.readLine();
 		}

 		catch (IOException e)
 		{
 			e.printStackTrace();
 		}
 		
 		return msg;
 	}

 	public boolean closeSocket()
 	{
 		boolean rc=false;

 		try
 		{
 			clientSocket.close();
 			rc=true;
 		}

 		catch (IOException e)
 		{
 			e.printStackTrace();
 		}
 		return rc;
 	}
 }
  
public static void main(String[] args)
{
      launch(args); 
}  

} // End of class