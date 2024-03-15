package com.example.demo.services.email_services;

import com.example.demo.repository.entity.EmailDetails;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            emailDetails.updateMessageBody();
            simpleMailMessage.setText(emailDetails.getMessageBody());
            simpleMailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(simpleMailMessage);
            return "Mail Sent successfully!";
        } catch (Exception e){
            return "Error while Sending Mail";
        }
    }

    public String getName(JsonNode json){
        JsonNode name = json.at("/name");
        return name.asText();
    }
    public String getMail(JsonNode json){
        JsonNode email = json.at("/email");
        return email.asText();
    }
    public String getNumber(JsonNode json){
        JsonNode number = json.at("/number");
        return (number.asText() == null) ? "There i no phone number" : number.asText();
    }
    public String getMessage(JsonNode json){
        JsonNode msg = json.at("/message");
        return msg.asText();
    }
}
