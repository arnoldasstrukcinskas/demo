package com.example.demo.repository.entity;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmailDetails {

    private String recipient = "arnoldasstrukcinskas@gmail.com";
    private String subject = "Letter from my Web";
    private String number;
    private String name;
    private String email;
    private String message;

    private String messageBody;

    public void updateMessageBody(){
        this.messageBody = String.format("""
                %s
                %s
                %s
                %s
                """, this.name, this.email, this.number, this.message);
    }
}
