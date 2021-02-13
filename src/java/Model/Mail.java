/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Raaid
 */
public class Mail {

    public static void sendMail(String recipient,String offer) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myEmail = "THE EMAIL SHOULD BE HERE";
        String password = "THE PASSWORD SHOULD BE HERE";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        Message message = prepareMessage(session,myEmail,recipient,offer);
        Transport.send(message);
        System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session,String myEmail,String recipient,String offer) throws AddressException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myEmail));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        message.setSubject("Offer available in Adventure Pilot");
        message.setText("Dear Customer\n"+offer);
        return message;
    }
}
