package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationService {
    Properties props;

    public NotificationService(String smtpHost, int smtpPort) {
        props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
    }

    void sendMessage(String sender, String subject, String body, String recipient) throws AddressException, MessagingException {
        // Create a mail session


        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);

        // Send the message
        Transport.send(msg);
    }
}