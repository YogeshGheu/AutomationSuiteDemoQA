package utilities;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class EmailSendUtility extends BaseUtility {

    public static void sendReportOnEmails(String[] emailsList, String subject, String body, String attachmentPath) {
        final String senderEmail = System.getenv("EMAIL");
        final String senderEmailPassword = System.getenv("PASSWORD");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderEmailPassword);
                    }
                });

        try {
            // convert the email String[] to Address[]
            InternetAddress[] addresses = new InternetAddress[emailsList.length];
            for (int i = 0; i < emailsList.length; i++) {
                addresses[i] = new InternetAddress(emailsList[i]);
            }


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(subject);

            // Body + Attachment
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (attachmentPath != null && new File(attachmentPath).exists()) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(new File(attachmentPath));
                multipart.addBodyPart(attachmentPart);
            }

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Report email sent successfully to recipients.");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
