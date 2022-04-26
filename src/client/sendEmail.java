package application;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
import javax.mail.*;

public class sendEmail {

	public static String price;
    public static String propertyFinal;
    
    public void emailSendFunc(String fname, String lname, String email, String location, String property, String ccNumber, String address) {
    	
	// Email account to autmatically send confirmation email to customer
        final String username = "";
        final String password = "";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
        });
    	
        char propertyChar = property.charAt(0); // For  of location
        
        
        // Get exact names and prices based on each location
        if (location.equals("New York City")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "The Standard";
		   			price = "$103.00";
		   			break;
		   		case '2':
		   			propertyFinal = "Four Seasons NY";
		   			price = "$315.00";
		   			break;
		   		case '3':
		   			propertyFinal = "Pod 51";
		   			price = "98.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Jazz on the Park";
		   			price = "$115.00";
		   			break;
		   		case '5':
		   			propertyFinal = "Morris Guest Home";
		   			price = "$87.00";
		   			break;
		   		case '6':
		   			propertyFinal = "Flushing Motel";
		   			price = "$98.00";
		   			break;
        	}
        }
        
        if (location.equals("Orlando")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "Residence";
		   			price = "$75.00";
		   			break;
		   		case '2':
		   			propertyFinal = "Staybridge Suites";
		   			price = "$168.00";
		   			break;
		   		case '3':
		   			propertyFinal = "Ramada";
		   			price = "189.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Hyatt Regency";
		   			price = "$350.00";
		   			break;
		   		case '5':
		   			propertyFinal = "InTown Suites";
		   			price = "$85.00";
		   			break;
		   		case '6':
		   			propertyFinal = "Roadway Inn";
		   			price = "$104.00";
		   			break;
        	}
        }
        
        if (location.equals("Miami")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "Kimpton";
		   			price = "$348.00";
		   			break;
		   		case '2':
		   			propertyFinal = "Hilton Miami";
		   			price = "$294.00";
		   			break;
		   		case '3':
		   			propertyFinal = "Provident Dural";
		   			price = "$291.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Gary Motel";
		   			price = "$284.00";
		   			break;
		   		case '5':
		   			propertyFinal = "The Hideaway";
		   			price = "$142.00";
		   			break;
		   		case '6':
		   			propertyFinal= "Group";
		   			price = "$124.00";
		   			break;
        	}
        }
        
        if (location.equals("Atlanta")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "Hilton Atlanta";
		   			price = "$208.00";
		   			break;
		   		case '2':
		   			propertyFinal = "Glenn Hotel";
		   			price = "$97.00";
		   			break;
		   		case '3':
		   			propertyFinal = "The St. Regis Atlanta";
		   			price = "$490.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Econo Lodge";
		   			price = "$80.00";
		   			break;
		   		case '5':
		   			propertyFinal= "Atlanta Midtown";
		   			price = "$49.00";
		   			break;
		   		case '6':
		   			propertyFinal = "Residence";
		   			price = "$75.00";
		   			break;
        	}
        }
        
        if (location.equals("Los Angeles")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "Hotel Indigo";
		   			price = "$289.00";
		   			break;
		   		case '2':
		   			propertyFinal = "Intercontinental";
		   			price = "$195.00";
		   			break;
		   		case '3':
		   			propertyFinal = "Hollywood Inn";
		   			price = "$167.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Freehand";
		   			price = "$194.00";
		   			break;
		   		case '5':
		   			propertyFinal = "Samesun";
		   			price = "$140.00";
		   			break;
		   		case '6':
		   			propertyFinal = "Outsider Inn";
		   			price = "$130.00";
		   			break;
        	}
        }
        
        if (location.equals("Las Vegas")) {
        	switch(propertyChar) {
		   		case '1':
		   			propertyFinal = "Bellagio";
		   			price = "$299.00";
		   			break;
		   		case '2':
		   			propertyFinal = "MGM Grand";
		   			price = "$358.00";
		   			break;
		   		case '3':
		   			propertyFinal = "Mandalay Bay";
		   			price = "$300.00";
		   			break;
		   		case '4':
		   			propertyFinal = "Quality Inn";
		   			price = "$195.00";
		   			break;
		   		case '5':
		   			propertyFinal = "Blue Swallow";
		   			price = "$200.00";
		   			break;
		   		case '6':
		   			propertyFinal = "Ocean Sky";
		   			price = "$144.00";
		   			break;
        	}
        }

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email) );
            message.setSubject("Booking.com Reservation Details");
            message.setText("Dear " + fname + " " + lname + ": " + "\n\n" +
                    		"Your reservation for: " + propertyFinal + " in " + location + " is ready!" + "\n" + 
            				"You paid: " + price + " with a card ending in: " + ccNumber.substring(ccNumber.length() - 4) + " to billing address: " 
                    		+ address + "\n\n" + "Sincerely," + "\n" + "The Booking.com Team");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
      
    }
}
