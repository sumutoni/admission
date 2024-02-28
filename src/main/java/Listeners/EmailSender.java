package Listeners;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {
    private String toEmail;
    private String password="wdbx pvkp oqgj swnr";
    private String fromEmail = "steumutoni66@gmail.com";
    private String subject;
    private String mess;
    
    
    
    public EmailSender(String toEmail, String subject, String mess) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.mess = mess;
    }



    public String getSubject() {
        return subject;
    }



    public void setSubject(String subject) {
        this.subject = subject;
    }



    public String getMess() {
        return mess;
    }



    public void setMess(String mess) {
        this.mess = mess;
    }



    public String getToEmail() {
        return toEmail;
    }



    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }



    public boolean sendEmail(){
        boolean sent = false;

        try{
            Properties properties = new Properties();
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.port", "587");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            // properties.put("mail.smtp.socketFactory.port", "587");
            // properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");


            Session session = Session.getInstance(properties, new Authenticator() {
               @Override
               protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, password);
               }
            });

            Message message = new MimeMessage(session);

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setFrom(new InternetAddress(fromEmail));
            message.setSubject(subject);
            message.setText(mess);

            Transport.send(message);

            sent = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return sent;
    }

}

