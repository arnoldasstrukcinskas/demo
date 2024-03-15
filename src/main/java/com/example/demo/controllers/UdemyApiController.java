package com.example.demo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Controller
public class UdemyApiController {

    @PostMapping(value = "/getCourseInfo")
    @ResponseBody
    public void getCourseInfo(){

        final String uri = "https://www.udemy.com/api-2.0/courses/java-the-complete-java-developer-course/?fields[course]=@min,headline,num_lectures,num_reviews,avg_rating,description,completion_ratio";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
    }

    @PostMapping(value = "/getCompletionRatio")
    @ResponseBody
    public ResponseEntity<String> getCompletionRatio(){

        String clientId = "";
        String clientSecret = "";
        String encodedCredentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

        final String uri = "https://www.udemy.com/api-2.0/courses/java-the-complete-java-developer-course/?fields[course]=@all";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedCredentials);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Void> entity = new HttpEntity<>(headers);


        return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
    }
}
