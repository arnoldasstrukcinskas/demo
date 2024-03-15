package com.example.demo.services.email_services;


import com.example.demo.repository.entity.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails emailDetails);
}
