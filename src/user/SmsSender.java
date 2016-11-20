package user;

// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URISyntaxException;

public class SmsSender {

    // set your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACfcd29cd96ab281360d0325945d14c33f";
    public static final String AUTH_TOKEN = "03130b7220620d818d8d0ac3af1e7300";
    
    public static void txtTrans(String transactionstring, String client){
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    	if(client == "Parent"){
    		Message message = Message
                    .creator(new PhoneNumber("+16477710927"),  // to
                             new PhoneNumber("+12048176708"),  // from
                             transactionstring)
                    .create();
    	}else{
    		Message message = Message
                    .creator(new PhoneNumber("+16477736241"),  // to
                             new PhoneNumber("+12048176708"),  // from
                             transactionstring)
                    .create();
    	}
        
    }
}