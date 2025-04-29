package com.userservice.service;

import com.userservice.Entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Users user){

        String emailBody = "Dear " + user.getUserName() + ",\n\n" +
                "Thank you for choosing our pest control services!\n\n" +
                "We are pleased to inform you that your booking has been successfully confirmed. Below are the details of your service:\n\n" +
                " - Name: " + user.getUserName() + "\n" +
                " - Email: " + user.getEmail() + "\n" +
                " - Phone Number: " + user.getPhNo() + "\n" +
                " - Service Address: " + user.getAddress() + "\n\n" +
                "Our team will contact you shortly to confirm the exact date and time of the service. " +
                "Please ensure someone is available at the provided address during the scheduled visit.\n\n" +
                "If you have any questions or need to make changes to your booking, feel free to reply to this email or call our support team.\n\n" +
                "We look forward to serving you and making your home pest-free!\n\n" +
                "Warm regards,\n" +
                "BugBusters\n" +
                "Customer Support Team\n" +
                "📞 +91XXXXXXXXXX\n" +
                "📧 bugbusterscustomercare@gmail.com\n" +
                "🌐 https://calm-salmiakki-ef4ff1.netlify.app/";
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(user.getEmail());
            mail.setSubject("Conformation on Booking PestControl");
            mail.setText(emailBody);

            javaMailSender.send(mail);
        }
        catch (Exception e) {
            log.error("Error " + e);
        }
    }
}
