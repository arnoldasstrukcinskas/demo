package com.example.demo.controllers;

import com.example.demo.repository.entity.EmailDetails;
import com.example.demo.services.email_services.EmailServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {
    private EmailDetails emailDetails;
    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping(value = "/sendMail")
    @ResponseBody
    public String sendMail(){
        return emailService.sendSimpleMail(this.emailDetails);
    }

    @PostMapping(value = "/getDetails")
    @ResponseBody
    public EmailDetails getDetails(Model model, @RequestBody ObjectNode json, HttpSession session){
        this.emailDetails = new EmailDetails();
        emailDetails.setName(emailService.getName(json));
        emailDetails.setEmail(emailService.getMail(json));
        emailDetails.setNumber(emailService.getNumber(json));
        emailDetails.setMessage(emailService.getMessage(json));
        emailDetails.updateMessageBody();
        return emailDetails;
    }
}
