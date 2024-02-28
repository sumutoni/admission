package Listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class LoginListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName() == "email"){
            String emailvalue = event.getValue().toString();
            String message = "We would like to inform you that your account was recently logged into.";
            EmailSender email = new EmailSender(emailvalue, "Account Login", message);
            email.sendEmail();
        }
        
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // Your implementation here
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // Your implementation here
    }
}