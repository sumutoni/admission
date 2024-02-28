package Listeners;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class SubmissionListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent sre){
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println(request.getServletPath().toString());
        if (request.getServletPath().equals("/admission")  && request.getAttribute("hasErrors").toString() == "false"){
            String emailvalue = request.getSession(false).getAttribute("email").toString();
            String message = "We are pleased to inform you that we have received your admission form. Thank you for choosing to apply to our institution.\n";
            message = message + "Your application is now under review by our admissions committee. Please note that the processing time may vary depending on the volume of applications received and the specific requirements of your chosen program.\n";
            message = message + "Once again, thank you for your interest in our Institution. We look forward to reviewing your application and hopefully welcoming you to our community soon. \n\nBest regards,";
            EmailSender email = new EmailSender(emailvalue, "Confirmation of Admission Form Submission", message);
            email.sendEmail();
        }
    }
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent sre){
        
    }
   
}

